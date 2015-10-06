/**
 * frinder_liu
 * 
 */

var _render_oper = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-edit pointer" data-href="/pages/bracket/sys/auth-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
		&nbsp;\
		<span class="fa fa-copy pointer" data-href="/pages/bracket/sys/auth-conf.jsp?id={1}&name={2}&type={3}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.id, row.id, row.name, row.type);
};

var _render_type = function(data, type, row, meta) {
	var text = data == '2' ? '资源权限' : '菜单权限';
	return text;
};

$(function() {
	init();

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/auth-add.jsp" class="btn btn-default fa fa-plus-square-o" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</a>\
		<a class="btn btn-default fa fa-group" onclick="group()">&nbsp;分组</a>\
    </div>';

	var table = $('#list').datatable({
		tableName : 'BEAUTY_AUTHORITY',
		url : '/auth/load/page.action',
		// title : '<input type="checkbox" onclick="checkbox(this)" />',
		tools : tools,
		selected : true,
		select : {
			style : 'multi'
		},
		columnDefs : [ {
			'targets' : 1,
			'render' : _render_oper
		}, {
			'targets' : 4,
			'render' : _render_type
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

	modify = function(e) {
		var items = table.rows({
			selected : true
		}).data();
		if (items.length == 0) {
			layer.msg('至少选择一条！');
			return;
		}
		var url = $(e).attr('data-href');
		_S_URL_REDIRECT(url.format(items[0].id));
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
			url : '/auth/remove.action'
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

	// 
	group = function() {
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
			url : '/auth/group.action'
		};
		layer.prompt({
			title : '请输入分组组名：',
			formType : 3,
			offset : '100px'
		}, function(text) {
			params.data.value = text;
			ajax(params);
			table.rows().deselect();
			table.ajax.reload();
		});
	};

});