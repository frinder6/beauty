/**
 * frinder_liu
 * 
 * @date 2015-08-11 21:33
 */
(function($) {
	'use strict';

	var defaults = {
		tableName : '',
		selected : false,
		url : '',
		tools : '',
		data : {},
		columnDefs : [],
		columns : [],
		x : true,
		// title : '',
		select : {
			style : 'single'
		},
		pagingType : 'full',
		toolid : '#my-tool',
		dom : "<'row'<'#my-tool.col-xs-6'><'col-xs-6'f>r>t<'row'<'col-xs-3'l><'col-xs-3'i><'col-xs-6'p>>",
		buttons : [],
		fnRowCallback : function(nRow, aData, iDisplayIndex) {
			return nRow;
		}
	};

	$.fn.datatable = function(options) {
		var settings = $.extend({}, defaults, options);
		var columnUrl = _PATH('/table/load/table/config.action');
		var stop = false;
		// 获取表列
		$.ajax({
			type : "POST",
			url : columnUrl,
			async : false,
			data : {
				tableName : settings.tableName
			},
			dataType : "json",
			success : function(datas) {
				var len = datas.length;
				if (len == 0) {
					stop = true;
					return;
				}
				settings.columns = datas;
				// settings.columns = $.extend(true, [], datas);
			}
		});

		// alert(JSON.stringify(settings.columns));
		
		if (stop)
			return;

		var selected = settings.selected;
		if (selected) {
			settings.columns.unshift({
				orderable : false,
				data : null,
				defaultContent : '',
				title : settings.title,
				className : 'select-checkbox',
				// title : '<input type="checkbox" onclick="checkbox(this)" />',
				width : 10
			});
			settings.columnDefs.unshift({
				orderable : false,
				className : 'select-checkbox',
				width : 10,
				targets : 0
			});
		}
		;

		// alert(JSON.stringify(settings.columns));

		var table = $(this).DataTable({
			processing : true,
			serverSide : true,
			stateSave : true,
			scrollX : settings.x,
			// scrollY : 500,
			select : settings.select,
			// fixedColumns : true,
			ajax : {
				url : _PATH(settings.url),
				data : settings.data
			},
			pagingType : settings.pagingType,
			columns : settings.columns,
			columnDefs : settings.columnDefs,
			order : [ [ 1, 'desc' ] ],
			// dom :
			// "<'row'<'#my-tool.col-xs-6'><'col-xs-6'f>r>t<'row'<'col-xs-3'l><'col-xs-3'i><'col-xs-6'p>>",
			dom : settings.dom,
			language : {
				url : _PATH('/pages/Chinese.json')
			},
			initComplete : function() {
				$(settings.toolid).append(settings.tools);
			},
			buttons : settings.buttons,
			fnRowCallback : settings.fnRowCallback
		});

		return table;

	};

})(jQuery);