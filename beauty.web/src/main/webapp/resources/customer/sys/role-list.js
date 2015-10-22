/**
 * frinder_liu
 * 
 */

var _RENDER_OPER = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-edit pointer auth" data-auth="RES-ROLE-UPD" title="更新" data-href="/pages/bracket/sys/role-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
		&nbsp;\
		<span class="fa fa-copy pointer auth" data-auth="RES-ROLE-CONF" title="配置" data-href="/pages/bracket/sys/role-conf.jsp?id={1}&name={2}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.id, row.id, row.name);
};

$(function() {

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/role-add.jsp" class="btn btn-default fa fa-plus-square-o auth" data-auth="RES-ROLE-ADD" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth oper-operate" data-auth="RES-ROLE-DEL">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_ROLE',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/role/load/page.action')
			}
		},
		ajax : {
			url : '/role/remove.action'
		}
	});

});