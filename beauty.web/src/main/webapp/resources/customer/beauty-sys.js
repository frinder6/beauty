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

// 设置高
var init = function() {
	$(window.parent.document).find("#iframe-main").load(function() {
		var frame = $(window.parent.document).find("#iframe-main");
		var height = $(window.parent.document).find('.contentpanel').height();
		frame.height(height);
	});
};

// 
var ajax = function(params) {
	$.ajax({
		"type" : "post",
		"url" : _PATH(params.url),
		"data" : params.data,
		"dataType" : 'json',
		"async" : false,
		"success" : function(data) {
			layer.msg(data.value);
		},
		"error" : function(msg) {
			layer.msg(msg);
		}
	});
};

var binding = function(arrs, nRow, aData) {
	$.each(arrs, function(key, value) {
		$(key, nRow).editable({
			// mode : 'inline',
			// defaultValue : '',
			emptytext : '',
			success : function(response, newValue) {
				var data = {
					id : aData.id
				};
				data[value] = newValue;
				var params = {
					data : data,
					url : '/table/modify/config.action'
				};
				// alert(JSON.stringify(params));
				ajax(params);
			}
		});
	});
};
