/**
 * frinder_liu
 * 
 * @date 2015-08-11 21:33
 */
(function($) {
	'use strict';

	var defaults = {
		tableName : '',
		url : '',
		tools : '',
		data : {},
		columnDefs : []
	};

	$.fn.datatable = function(options) {
		var settings = $.extend({}, defaults, options);

		var columnUrl = _PATH('/table/load/table/config.action');

		// 获取表列
		$.ajax({
			type : "POST",
			url : columnUrl,
			async : false,
			data : {
				tableName : settings.tableName
			},
			dataType : "json",
			success : function(data) {
				settings.columns = data;
			}
		});
		
		//alert(JSON.stringify(settings.columns));
		
		$(this).DataTable({
			processing : true,
			serverSide : true,
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
		
	};

})(jQuery);