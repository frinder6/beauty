/**
 * frinder_liu
 * 
 * @date 2015-08-11 21:33
 */
(function($) {
	'use strict';

	var defaults = {
		url : '',
		init : function(e, callback){
			callback({id : e.val(), text : e.text()});
		},
		pid : ''
	};

	$.fn.select = function(options) {
		var settings = $.extend({}, defaults, options);

		var select = $(this).select2({
			width : '100%',
			ajax : {
				url : _PATH(settings.url),
				dataType : 'json',
				delay : 100,
				data : function(params) {
					return {
						search : params.term,
						pid : settings.pid
					};
				},
				processResults : function(data, params) {
					data.unshift({
						id : 0,
						text : '/'
					});
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
			initSelection : settings.init,
		});
		
		return select;
	};

})(jQuery);