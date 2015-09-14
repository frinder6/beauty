/**
 * frinder_liu
 * 
 * @date 2015-08-11 21:33
 */
(function($) {
	'use strict';

	var defaults = {
		url : '',
		pid : '',
		init : false,
		sid : ''
	};

	$.fn.select = function(options) {
		var settings = $.extend({}, defaults, options);

		var select = $(this).select2({
			width : '100%',
			placeholder : '请选择...',
			allowClear : true,
			ajax : {
				url : _PATH(settings.url),
				dataType : 'json',
				delay : 100,
				data : function(params) {
					return {
						search : params.term,
						pid : ''
					};
				},
				processResults : function(data, params) {
					return {
						results : data
					};
				},
				cache : true
			},
			escapeMarkup : function(markup) {
				return markup;
			},
			minimumInputLength : 1,
			initSelection : function(e, callback) {
				if (settings.init) {
					$.ajax({
						'type' : 'post',
						'url' : _PATH(settings.url),
						'data' : {
							pid : settings.pid,
							search : ''
						},
						'dataType' : 'json',
						'async' : false,
						'success' : function(data) {
							if (data && data.length > 0) {
								//
								var opt = '<option value="{0}" selected="selected">{1}</option>';
								$(settings.sid).html(opt.format(data[0].id, data[0].text));
								//
								callback({
									id : data[0].id,
									text : data[0].text
								});
							}
						},
						'error' : function(msg) {
							layer.msg(msg);
						}
					});
				} else {
					//
					callback({id : e.val(), text : e.text()});
				}
			},
		});

		return select;
	};

})(jQuery);