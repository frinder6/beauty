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
		tools : ''
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

		$(this).DataTable({
			processing : true,
			serverSide : true,
			ajax : _PATH(settings.url),
			pagingType : 'full',
			columns : settings.columns,
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