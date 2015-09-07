/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
var _render = function(data, type, row, meta) {
	var result = '<a href="#" data-href="/pages/sys/column-config-list.jsp?schema=beauty&table={0}" onclick="_REDIRECT(this)">{1}</a>';
	return result.format(data, data);
};
$(function() {
	init();

	var tools = '<div class="btn-group">\
                <button type="button" class="btn btn-default" onclick="del()">删除</button>\
            </div>';

	var columnDefs = [ {
		'targets' : 1,
		'render' : _render
	} ];

	var arrs = {
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
		tools : tools,
		columnDefs : columnDefs,
		select : {
			style : 'multi'
		},
		fnRowCallback : function(nRow, aData, iDisplayIndex) {
			// 绑定update
			binding(arrs, nRow, aData);
			return nRow;
		}
	});

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
				table.ajax.reload();
			});
		});
	};

});