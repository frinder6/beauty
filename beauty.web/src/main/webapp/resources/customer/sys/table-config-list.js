/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

$(function() {
	init();

	var tools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-copy" onclick="copy()">&nbsp;复制</a>\
		<a class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</a>\
    </div>';

	var arrs = {
		'td:eq(2)' : 'title',
		'td:eq(3)' : 'title',
		'td:eq(4)' : 'data',
		'td:eq(6)' : 'orderable',
		'td:eq(7)' : 'width',
		'td:eq(8)' : 'className',
		'td:eq(9)' : 'sequence'
	};

	var table = $('#list').datatable({
		tableName : 'BEAUTY_TABLE_CONFIG',
		url : '/table/load/config.action',
		selected : true,
		data : data,
		tools : tools,
		select : {
			style : 'multi',
			selector : 'td:first-child'
		},
		fnRowCallback : function(nRow, aData, iDisplayIndex) {
			// 绑定update
			binding(arrs, nRow, aData);
			return nRow;
		}
	});

	copy = function() {
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
			url : '/table/copy.action'
		};
		layer.confirm('确定复制？', {
			offset : '100px'
		}, function() {
			ajax(params, function() {
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
			url : '/table/remove/config.action'
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