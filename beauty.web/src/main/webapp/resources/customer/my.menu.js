!(function($, window, document, undefined) {

	var defaults = {};

	var Menu = function(element, options) {
		this.$this = element;
		this.$opts = options;
	};

	Menu.prototype = {
		constructor : Menu,
		init : function() {
			var e = this;
			var url = (_BASE + '/menu/load/main.action');
			$.ajax({
				type : 'POST',
				url : url,
				dataType : 'JSON',
				async : false,
				success : function(data) {
					e._MENUS = data;
				},
				error : function(msg) {
					layer.msg(msg);
				}
			});
		},
		mainMenu : function() {
			var e = this;
			e.init();
			var title = '<h5 class="sidebartitle">导航栏</h5>'
			// out ul/li
			var _UL_1 = '<ul id="main-nav" class="nav nav-pills nav-stacked nav-bracket">{0}</ul>';
			var _LI_1 = '<li class="{0}"><a href="javascript:void(0)"><i class="fa {1}"></i> <span>{2}</span></a>{3}</li>';
			// class
			var def_class = "active";
			var p_class = " nav-parent";
			//
			if (e._MENUS) {
				var li1s = '';
				var menus = e._MENUS;
				$.each(menus, function(i, m) {
					var li_class = '';
					if (i == 0) {
						li_class = def_class;
					}
					var li1 = '';
					if (m.children.length == 0) {
						li1 = _LI_1.format(li_class, m.def2, m.name, '');
					} else {
						var ul2 = e.levelMenu(m.children);
						li_class += p_class;
						li1 = _LI_1.format(li_class, m.def2, m.name, ul2);
					}
					li1s += li1;
				});
				title += _UL_1.format(li1s);
			}
			// console.log(title);
			this.$this.html(title);
		},
		levelMenu : function(menus) {
			// inner ul/li
			var _UL_2 = '<ul class="children">{0}</ul>';
			var _LI_2 = '<li><a href=\"javascript:void(0)\" data-href=\"{0}\"><i class=\"fa fa-caret-right\"></i> {1}</a></li>';
			var ul = '';
			if (menus) {
				var li1s = '';
				$.each(menus, function(i, m) {
					li1s += _LI_2.format(m.url, m.name);
				});
				ul = _UL_2.format(li1s);
			}
			return ul;
		}
	};

	$.fn.Menu = function(options) {
		var menu = new Menu(this, options);
		menu.mainMenu();
		return menu;
	};

	$.fn.Menu.Constructor = Menu;

})(jQuery, window, document);