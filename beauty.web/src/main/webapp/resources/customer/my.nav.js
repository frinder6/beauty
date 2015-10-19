!(function($, window, document, undefined) {

	var defaults = {};

	var Nav = function(element, options) {
		this.$this = element;
		this.$opts = options;
		this.$navs = {};
	};

	Nav.prototype = {
		constructor : Nav,
		pClick : function() {
			// parent node click
			var $this = this.$this;
			var e = this;
			$this.children('li').click(function() {
				// 二级菜单样式
				$this.children('li').removeClass('active');
				$(this).addClass('active');
			});
		},
		sClick : function() {
			// son node click
			var $this = this.$this;
			var e = this;
			$this.find('ul').find('li').click(function() {
				e.fillData(this);
				e.setSonPageNav();
				var url = $(this).children('a').attr('data-href');
				_REDIRECT(url);
			});
		},
		fillData : function(e) {
			this.$navs.stitle = $(e).children('a').text();
			var panode = $(e).parent('ul').parent('li').children('a');
			this.$navs.title = panode.find('span').text();
			this.$navs.icon = panode.find('i').attr('class');
		},
		setSonPageNav : function() {
			var nav = '\
				<h2>\
					<i class="{0}"></i> {1} <span>{2}</span>\
				</h2>\
			';
			var data = this.$navs;
			$(window.parent.document).find('div.pageheader').html(nav.format(data.icon, data.title, data.stitle));
		}
	};

	$.fn.Nav = function(options) {
		var nav = new Nav(this, options);
		nav.pClick();
		nav.sClick();
		return nav;
	};

	$.fn.Nav.Constructor = Nav;

})(jQuery, window, document);