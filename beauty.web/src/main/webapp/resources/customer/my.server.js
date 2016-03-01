!(function($, window, document, undefined) {

	'use strict';

	var defaults = {};

	var ServerMessage = function(element, options) {
		this.$this = element;
		this.$opts = options;
	};

	ServerMessage.prototype = {
		constructor : ServerMessage,
		init : function() {
			dwr.engine.setActiveReverseAjax(true);
			dwr.engine.setNotifyServerOnPageUnload(true);
			PushMessageController.init(this.$opts.userId);
		},
		sendClientMessage : function(message){
			PushMessageController.sendServerMessage(this.$opts.userId, message);
		}
	};

	$.fn.ServerMessage = function(options) {
		var smg = new ServerMessage(this, options);
		smg.init();
		return smg;
	};
	

	$.fn.ServerMessage.Constructor = ServerMessage;

})(jQuery, window, document);