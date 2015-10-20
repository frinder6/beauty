/**
 * frinder_liu
 * 
 */

var _RENDER_OPER = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-edit pointer auth" data-auth="RES-USER-UPD" title="更新" data-href="/pages/bracket/sys/user-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
		&nbsp;\
		<span class="fa fa-copy pointer auth" data-auth="RES-USER-CONF" title="配置" data-href="/pages/bracket/sys/user-conf.jsp?id={1}&name={2}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.id, row.id, row.name);
};

var _RENDER_SEX = function(data, type, row, meta) {
	var text = '保密';
	if (data == 1) {
		text = '男';
	} else if (data == 2) {
		text = '女';
	} else {
	}
	return text;
};

$(function() {

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/user-add.jsp" class="btn btn-default fa fa-plus-square-o auth" data-auth="RES-USER-ADD" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth oper-delete" data-auth="RES-USER-DEL">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_USER',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/user/load/page.action')
			}
		},
		remove : true,
		delUrl : '/user/remove.action'
	});

});