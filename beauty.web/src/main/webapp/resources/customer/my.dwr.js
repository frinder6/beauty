!(function($, window, document, undefined) {

	'use strict';

	var DwrMessage = function(element, options) {
		this.$this = element;
		this.$opts = options;
		this.init();
	};

	DwrMessage.prototype = {
		constructor : DwrMessage,
		init : function() {
			dwr.engine.setActiveReverseAjax(true);
			dwr.engine.setNotifyServerOnPageUnload(true);
			PushMessageController.init(this.$opts.userId);
		},
		sendMsg : function(){
			PushMessageController.sendDwrMessage('scott', 'hello world...');
		}
	};

	$.fn.DwrMessage = function(options) {
		var dm = new DwrMessage(this, options);
		return dm;
	};
	

	$.fn.DwrMessage.Constructor = DwrMessage;

})(jQuery, window, document);
