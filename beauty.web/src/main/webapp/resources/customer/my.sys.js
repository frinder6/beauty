!(function($, window, document, undefined) {

	var defaults = {};

	var Sys = function(element, options) {
		this.$this = element;
		this.$opts = options;
	};

	Sys.prototype = {
		constructor : Sys,
		setHeight : function() {
			var div = $('div.table-responsive');
			if (!div) {
				return;
			}
			var defHeight = $(window.parent.document).find('div.mainpanel').height();
			var otherHeight = 122;
			var height = defHeight - otherHeight;
			var sheight = div.height();
			var frame = $(window.parent.document).find("#iframe-main");
			var panel = $(window.parent.document).find('div.contentpanel');
			var result = height;
			if (height < sheight) {
				result = sheight;
			}
			frame.height(result);
			panel.height(result);
		},
		init : function() {

		}
	};

	$.fn.Sys = function(options) {
		var sys = new Sys(this, options);
		sys.setHeight();
		return sys;
	};

	$(this).Sys();

	$.fn.Sys.Constructor = Sys;

})(jQuery, window, document);