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
 * ********************* init ***********************
 */

var init = function() {
	//resetHeight();
	// 
	//exchangeNav();

};

//
var resetHeight = function() {
	var defHeight = 1050;
	var otherHeight = 122;
	var height = defHeight - otherHeight;
	var sheight = $('div.table-responsive').height();
	var frame = $(window.parent.document).find("#iframe-main");
	var panel = $(window.parent.document).find('.contentpanel');
	var result = height;
	if (height < sheight) {
		result = sheight;
	}
	frame.height(result);
	panel.height(result);
};

// fill nav
var fillNav = function(e) {
	_NAVS.stitle = $(e).children('a').text();
	var panode = $(e).parent('ul').parent('li').children('a');
	_NAVS.title = panode.find('span').text();
	_NAVS.icon = panode.find('i').attr('class');
}

// reset nav
var exchangeNav = function() {
	var nav = '\
		<h2>\
			<i class="{0}"></i> {1} <span>{2}</span>\
		</h2>\
	';
	var data = parent._NAVS;
	$(window.parent.document).find('div.pageheader').html(nav.format(data.icon, data.title, data.stitle));
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
		"type" : "post",
		"url" : _PATH(params.url),
		"data" : params.data,
		"dataType" : 'json',
		"async" : false,
		"success" : function(data) {
			layer.msg(data.value);
			if (fn) {
				fn();
			}
		},
		"error" : function(msg) {
			layer.msg(msg);
		}
	});
};

/**
 * x-editor 列表修改绑定
 */
var binding = function(arrs, nRow, aData) {
	$.each(arrs, function(key, value) {
		$(key, nRow).editable({
			mode : 'inline',
			// defaultValue : '',
			emptytext : '',
			placement : 'left',
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