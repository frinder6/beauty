/**
 * frinder_liu
 * 
 */

var _RENDER_OPER = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-edit pointer auth" data-auth="RES-AUTH-UPD" title="更新" data-href="/pages/bracket/sys/auth-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
		&nbsp;\
		<span class="fa fa-copy pointer auth" data-auth="RES-AUTH-CONF" title="配置" data-href="/pages/bracket/sys/auth-conf.jsp?id={1}&name={2}&type={3}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.id, row.id, row.name, row.type);
};

var _RENDER_TYPE = function(data, type, row, meta) {
	var text = data == '2' ? '资源权限' : '菜单权限';
	return text;
};

$(function() {

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/auth-add.jsp" class="btn btn-default fa fa-plus-square-o auth" data-auth="RES-AUTH-ADD" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth oper-delete" data-auth="RES-AUTH-DEL">&nbsp;删除</a>\
		<a class="btn btn-default fa fa-group auth" data-auth="RES-AUTH-GROUP" onclick="group()">&nbsp;分组</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_AUTHORITY',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/auth/load/page.action')
			}
		},
		remove : true,
		delUrl : '/auth/remove.action'
	});

	group = function() {
		var ids = table.selectIds();
		if (!ids) {
			return;
		}
		layer.prompt({
			title : '请输入分组组名：',
			formType : 3,
			offset : '100px'
		}, function(text) {
			ajax({
				data : {
					values : ids.join(','),
					value : text
				},
				url : '/auth/group.action'
			}, function() {
				table.reload();
			});
		});
	};

});