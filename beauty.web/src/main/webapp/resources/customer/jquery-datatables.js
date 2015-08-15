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
		select : {
			style : 'single'
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
				if (len == 0){
					stop = true;
					return;
				}
				settings.columns = datas;
			}
		});
		
		if (stop) return;
		
		var selected = settings.selected;
		if (selected){
			settings.columns.unshift({
				orderable : false,
				data : null,
				defaultContent : '',
				width : 20
			});
			settings.columnDefs.unshift({
				orderable : false,
	            className: 'select-checkbox',
	            targets:   0
			});
		};
		
		//alert(JSON.stringify(settings));
		
		var table = $(this).DataTable({
			processing : true,
			serverSide : true,
			select : settings.select,
			ajax : {
				url : _PATH(settings.url),
				data : settings.data
			},
			pagingType : 'full',
			columns : settings.columns,
			columnDefs : settings.columnDefs,
			order : [ [ 1, 'desc' ] ],
			dom : "<'row'<'#my-tool.col-xs-6'><'col-xs-6'f>r>t<'row'<'col-xs-3'l><'col-xs-3'i><'col-xs-6'p>>",
			language : {
				url : _PATH('/pages/Chinese.json')
			},
			initComplete : function() {
				$('#my-tool').append(settings.tools);
			}
		});
		
		return table;
		
	};

})(jQuery);