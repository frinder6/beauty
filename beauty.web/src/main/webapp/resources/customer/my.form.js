!(function($, window, document, undefined) {

	var defaults = {
	// listUrl : '',
	// idUrl : '',
	// id : '',
	// callback : function() {
	// },
	// select : function() {
	// }
	};

	var Form = function(element, options) {
		this.$this = element;
		this.$opts = options;
	};

	Form.prototype = {
		constructor : Form,
		validateAndSubmit : function() {
			var $this = this.$this;
			var $opts = this.$opts;
			$this.validate({
				highlight : function(element) {
					jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				success : function(element) {
					jQuery(element).closest('.form-group').removeClass('has-error');
				},
				submitHandler : function(form) {
					// 提交
					$this.ajaxSubmit({
						success : function(data) {
							layer.msg(data.value);
							//
							if ($opts.callback) {
								$opts.callback();
							}
							//
							setTimeout(function() {
								_S_URL_REDIRECT($opts.listUrl);
							}, 1000);
						},
						error : function(msg) {
							layer.msg(msg);
						}
					});
					return false;
				}
			});
		},
		modifyInit : function() {
			var $this = this.$this;
			var $opts = this.$opts;
			if ($opts.idUrl) {
				$.ajax({
					type : 'POST',
					url : _PATH($opts.idUrl),
					data : {
						id : $opts.id
					},
					dataType : 'JSON',
					success : function(data) {
						$this.fill(data);
						if ($opts.select) {
							$opts.select(data);
						}
					},
					error : function(msg) {
						layer.msg(msg);
					}
				});
			}
		}
	};

	$.fn.Form = function(options) {
		var opts = $.extend(true, {}, defaults, options);
		var form = new Form(this, opts);
		form.validateAndSubmit();
		form.modifyInit();
		return form;
	};

	$.fn.Form.Constructor = Form;

})(jQuery, window, document);