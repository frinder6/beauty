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

/**
 * 子页面url跳转
 */
var _S_URL_REDIRECT = function(url) {
	$(window.parent.document).find("#iframe-main").attr('src', _PATH(url));
};

// 设置高
var init = function() {

	// 滚动条
	$(window.parent.document).scroll(function() {
		var height = $('.table-responsive').height();
		var mHeight = $(window.parent.document).find('.mainpanel').height();
		if (height > mHeight){
			$(window.parent.document).find('#iframe-main').height(height);
			$(window.parent.document).find('.contentpanel').height(height);
		} else {
			$(window.parent.document).find('#iframe-main').height(mHeight);
			$(window.parent.document).find('.contentpanel').height(mHeight);
		}
	});

	$(window.parent.document).find("#iframe-main").load(function() {
		var frame = $(window.parent.document).find("#iframe-main");
		var height = $(window.parent.document).find('.mainpanel').height();
		frame.height(height);
	});
};

// 
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

// 列表修改绑定
var binding = function(arrs, nRow, aData) {
	$.each(arrs, function(key, value) {
		$(key, nRow).editable({
			mode : 'inline',
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

/**
 * 验证提交
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
				}, error : function(msg){
					layer.msg(msg);
				}
			});
			return false;
		}
	});
};


/**
 * select2 初始化
 * iUrl : 初始化 url
 * pid : 父节点id
 * sid : select控件 #id
 * sUrl : select控件 url
 */
var selectInit = function(opts) {
	$.ajax({
		"type" : "post",
		"url" : _PATH(opts.iUrl),
		"data" : {
			pid : opts.pid,
			search : ''
		},
		"dataType" : 'json',
		"async" : false,
		"success" : function(data) {
			$(opts.sid).select({
				url : opts.sUrl,
				init : function(e, callback) {
					if (data && data.length > 0){
						callback({
							id : data[0].id,
							text : data[0].text
						});
					} else {
						callback({
							id : 0,
							text : '/'
						});
					}
				}
			});
		},
		"error" : function(msg) {
			layer.msg(msg);
		}
	});
};

/**
 * 更新加载方法
 * url : findById方法url
 * id : 目标对象id
 * iUrl : 初始化 url
 * sid : select控件 #id
 * sUrl : select控件 url
 */
var updateInit = function(opts){
	$.ajax({
		type : "POST",
		url : _PATH(opts.url),
		data : {
			id : opts.id
		},
		dataType : "json",
		success : function(data) {
			$("#basicForm").fill(data);
			selectInit({
				sid : opts.sid,
				pid : data.parentId,
				iUrl : opts.iUrl,
				sUrl : opts.sUrl
			});
		},
		error : function(msg) {
			layer.msg(msg);
		}
	});
}
