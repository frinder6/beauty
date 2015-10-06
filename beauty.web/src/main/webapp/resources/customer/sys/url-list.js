/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

$(function() {
	init();

	var tools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-bookmark" onclick="mark()">&nbsp;标记</a>\
		<a class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</a>\
    </div>';

	var table = $('#list').datatable({
		tableName : 'BEAUTY_URL',
		url : '/url/load/page.action',
		title : '<input type="checkbox" onclick="checkbox(this)" />',
		tools : tools,
		selected : true,
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

	mark = function() {
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
			url : '/url/mark.action'
		};
		layer.confirm('确定标记为配置不可见？', {
			offset : '100px'
		}, function() {
			ajax(params, function() {
				table.rows().deselect();
				table.ajax.reload();
			});
		});
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
			url : '/url/remove.action'
		};
		layer.confirm('删除无法恢复，确定删除？', {
			offset : '100px'
		}, function() {
			ajax(params, function() {
				table.row('.selected').remove().draw(false);
				table.rows().deselect();
				table.ajax.reload();
			});
		});
	};

});