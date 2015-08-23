/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
$(function() {
	init();

	var tools = '<div class="btn-group">\
        <button type="button" class="btn btn-default">新增</button>\
        <button type="button" class="btn btn-default">更新</button>\
        <button type="button" class="btn btn-default">删除</button>\
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