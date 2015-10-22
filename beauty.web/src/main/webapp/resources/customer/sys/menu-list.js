/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var _RENDER_OPER = function(data, type, row, meta) {
	if (row.id == 0) {
		return '--';
	}
	var result = '\
		<span class="fa fa-edit pointer auth" title="更新" data-auth="RES-MENU-UPD" data-href="/pages/bracket/sys/menu-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.id);
};

$(function() {

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/menu-add.jsp" class="btn btn-default fa fa-plus-square-o auth" data-auth="RES-MENU-ADD" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth oper-operate" data-auth="RES-MENU-DEL">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_MENU',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/menu/load/page.action')
			}
		},
		ajax : {
			url : '/menu/remove.action'
		}
	});

});