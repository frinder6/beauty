/**
 * util & format方法
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
var _PATH = function(url) {
	return _BASE + url;
};

/**
 * 跳转
 */
var _REDIRECT = function(url) {
	$(window.document).find("#iframe-main").attr('src', _PATH(url));
};

/**
 * 子页面跳转
 */
var _S_REDIRECT = function(e) {
	var url = $(e).attr('data-href');
	$(window.parent.document).find("#iframe-main").attr('src', _PATH(url));
};

/**
 * 子页面url跳转
 */
var _S_URL_REDIRECT = function(url) {
	$(window.parent.document).find("#iframe-main").attr('src', _PATH(url));
};

/**
 * ajax
 */
var ajax = function(params, fn) {
	$.ajax({
		type : 'POST',
		url : _PATH(params.url),
		data : params.data,
		dataType : 'JSON',
		async : false,
		success : function(data) {
			layer.msg(data.value, {
				offset : '120px'
			});
			if (fn) {
				fn();
			}
		},
		error : function(msg) {
			layer.msg(msg, {
				offset : '120px'
			});
		}
	});
};

/**
 * 类型
 */
var _RENDER_BOOLEAN = function(data, type, row, meta) {
	return (data ? '是' : '否');
};


/**
 * 禁用/启用
 */
var _RENDER_ENABLE = function(data, type, row, meta) {
	return (data == 0 ? '禁用' : '启用');
};