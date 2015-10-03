/**
 * frinder_liu
 * 
 */

var _render_upd = function(data, type, row, meta) {
	var result = '<a href="#" data-href="/pages/bracket/sys/role-update.jsp?id={0}" onclick="_S_REDIRECT(this)">{1}</a>';
	return result.format(row.id, data);
};


$(function() {
	init();

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/role-add.jsp" class="btn btn-default fa fa-plus-square-o" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a data-href="/pages/bracket/sys/role-conf.jsp?id={0}&name={1}" class="btn btn-default fa fa-copy" onclick="conf(this)">&nbsp;配置</a>\
		<a class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</a>\
    </div>';

	var table = $('#list').datatable({
		tableName : 'BEAUTY_ROLE',
		url : '/role/load/page.action',
		title : '<input type="checkbox" onclick="checkbox(this)" />',
		tools : tools,
		selected : true,
		select : {
			style : 'multi'
		},
		columnDefs : [ {
			'targets' : 1,
			'render' : _render_upd
		} ]
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
	
	conf = function(e){
		var items = table.rows({
			selected : true
		}).data();
		if (items.length == 0) {
			layer.msg('至少选择一条！');
			return;
		}
		var url = $(e).attr('data-href');
		_S_URL_REDIRECT(url.format(items[0].id, items[0].name));
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
			return item.id;
		});
		var params = {
			data : {
				values : ids.join(',')
			},
			url : '/role/remove.action'
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