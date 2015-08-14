/**
 * format方法
 */
String.prototype.format = function() {
	var s = this, i = arguments.length;

	while (i--) {
		s = s.replace(new RegExp('\\{' + i + '\\}', 'gm'), arguments[i]);
	}
	return s;
};

/**
 * 添加根路径
 */
var _PATH = function(url){
	return _BASE + url;
};

/**
 * 跳转
 */
var _REDIRECT = function(e){
	var url = $(e).attr('data-href');
	$(window.parent.document).find("#iframe-main").attr('src', _PATH(url));
};

// 设置高
var init = function(){
	$(window.parent.document).find("#iframe-main").load(function() {
		var main = $(window.parent.document).find("#iframe-main");
		var height = $(window.parent.document).height();
		main.height(height);
	});
};