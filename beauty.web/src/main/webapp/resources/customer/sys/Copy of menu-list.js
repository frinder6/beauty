/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var _render_oper = function(data, type, row, meta) {
	if (row.id == 0) {
		return '--';
	}
	var result = '\
		<span class="fa fa-edit pointer auth" title="更新" data-auth="RES-MENU-UPD" data-href="/pages/bracket/sys/menu-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.id);
};


$(function() {
	init();

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/menu-add.jsp" class="btn btn-default fa fa-plus-square-o auth" data-auth="RES-MENU-ADD" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth" data-auth="RES-MENU-DEL" onclick="del()">&nbsp;删除</a>\
    </div>';

	var columnDefs = [ {
		'targets' : 1,
		'render' : _render_oper
	} ];

	var table = $('#list').datatable({
		tableName : 'BEAUTY_MENU',
		url : '/menu/load/page.action',
		tools : tools,
		selected : true,
		title : '<input type="checkbox" onclick="checkbox(this)" />',
		columnDefs : columnDefs,
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

	del = function() {
		var items = table.rows({
			selected : true
		}).data();
		if (items.length == 0) {
			layer.msg('至少选择一条！');
			return;
		}
		var ids = $.map(items, function(item, i) {
			if (item.id != 0)
				return item.id;
		});
		var params = {
			data : {
				values : ids.join(',')
			},
			url : '/menu/remove.action'
		};
		layer.confirm('删除无法恢复，确定删除？', {
			offset : '100px'
		}, function() {
			ajax(params, function() {
				table.row('.selected').remove().draw(false);
				table.ajax.reload();
			});
		});
	};

});