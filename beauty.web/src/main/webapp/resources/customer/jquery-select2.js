/**
 * frinder_liu
 * 
 * @date 2015-08-11 21:33
 */
(function($) {
	'use strict';

	var defaults = {
		url : ''
	};

	$.fn.select = function(options) {
		var settings = $.extend({}, defaults, options);

		$(this).select2({
			width : '100%',
			ajax : {
				url : _PATH(settings.url),
				dataType : 'json',
				delay : 100,
				data :  function(params) {
					return {
						search : params
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
			minimumInputLength : 1
		});
	};

})(jQuery);