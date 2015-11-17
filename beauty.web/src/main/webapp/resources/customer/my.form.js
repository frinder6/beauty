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
		},
		form2Json : function() {
			var $this = this.$this;
			var serializeObj = {};
			var array = $this.serializeArray();
			var str = $this.serialize();
			$(array).each(function() {
				if (serializeObj[this.name]) {
					if ($.isArray(serializeObj[this.name])) {
						serializeObj[this.name].push(this.value);
					} else {
						serializeObj[this.name] = [ serializeObj[this.name], this.value ];
					}
				} else {
					serializeObj[this.name] = this.value;
				}
			});
			return serializeObj;
		}
	};

	$.fn.Form = function(options) {
		var opts = $.extend(true, {}, defaults, options);
		var form = new Form(this, opts);
		form.validateAndSubmit();
		form.modifyInit();
		return form;
	};

	$.fn.form2Json = function() {
		var form = new Form(this, {});
		return form.form2Json();
	};

	$.fn.Form.Constructor = Form;

})(jQuery, window, document);