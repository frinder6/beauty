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
	resetHeight();
	// 
	exchangeNav();

};

//
var resetHeight = function() {
	var defHeight = 1050;
	var otherHeight = 122;
	var height = defHeight - otherHeight;
	var sheight = $('.table-responsive').height();
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
	$(window.parent.document).find('.pageheader').html(nav.format(data.icon, data.title, data.stitle));
};

/**
 * ********************* init ***********************
 */

/**
 * 
 * 
 * 
 * 
 * 华丽的分割
 * 
 * 
 * 
 * 
 * 
 * 
 */

/**
 * ********************* path & redirect ***********************
 */

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
 * ********************* path & redirect ***********************
 */

/**
 * 
 * 
 * 
 * 
 * 华丽的分割
 * 
 * 
 * 
 * 
 * 
 * 
 */

/**
 * ********************* ajax & form * x-eidtor ***********************
 */

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

/**
 * form 验证提交
 */
var mySub = function(fn) {
	// 验证表单
	jQuery("#basicForm").validate({
		highlight : function(element) {
			jQuery(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		},
		success : function(element) {
			jQuery(element).closest('.form-group').removeClass('has-error');
		},
		submitHandler : function(form) {
			// 提交
			$('#basicForm').ajaxSubmit({
				success : function(data) {
					layer.msg(data.value);
					//
					fn();
				},
				error : function(msg) {
					layer.msg(msg);
				}
			});
			return false;
		}
	});
};

/**
 * form 更新加载方法 url : findById方法url id : 目标对象id sid : select控件 #id sUrl :
 * select控件 url
 */
var updateInit = function(opts) {
	$.ajax({
		type : "POST",
		url : _PATH(opts.url),
		data : {
			id : opts.id
		},
		dataType : "json",
		success : function(data) {
			$("#basicForm").fill(data);
			if (opts.select) {
				opts.select(data);
			}
		},
		error : function(msg) {
			layer.msg(msg);
		}
	});
};

/**
 * ********************* ajax & form * x-eidtor ***********************
 */

