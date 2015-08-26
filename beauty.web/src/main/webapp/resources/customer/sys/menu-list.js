/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
$(function() {
	init();

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/add-menu.jsp" class="btn btn-default fa fa-plus-square-o" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a data-href="/pages/bracket/sys/add-menu.jsp" class="btn btn-default fa fa-minus-square-o" onclick="_S_REDIRECT(this)">&nbsp;删除</a>\
    </div>';

	var table = $('#menu-list').datatable({
		tableName : 'BEAUTY_MENU',
		url : '/menu/load/page.action',
		tools : tools,
		selected : true,
		title : '<input type="checkbox" onclick="checkbox(this)" />',
		select : {
			style : 'multi'
		}
	});

	// 表格全选方法
	checkbox = function(e) {
		var checked = $(e).attr('checked');
		if (checked) {
			// 全选
			table.rows().select();
		} else {
			// 取消全选
			table.rows().deselect();
		}
	};

});