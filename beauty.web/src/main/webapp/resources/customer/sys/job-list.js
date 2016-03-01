/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var _RENDER_OPER = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-edit pointer" title="更新" data-href="/pages/bracket/sys/job-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.id);
};

$(function() {

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/job-add.jsp" class="btn btn-default fa fa-plus-square-o" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth oper-operate" data-auth="RES-MENU-DEL">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_JOB',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/job/load/page.action')
			}
		},
		ajax : {
			url : '/job/remove.action'
		}
	});

});