/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var _RENDER_MARK = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-bookmark pointer" title="标记" data-id="{0}" onclick="markId(this)"></span>\
	';
	return result.format(row.id);
};

$(function() {

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/message-add.jsp" class="btn btn-default fa fa-plus-square-o auth" data-auth="RES-MENU-ADD" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth oper-operate" data-auth="RES-MENU-DEL">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_MESSAGE',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/message/load/page.action')
			}
		},
		ajax : {
			url : '/message/remove.action'
		}
	});

});