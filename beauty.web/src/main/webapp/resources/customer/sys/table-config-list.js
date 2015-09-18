/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var editor;

$(function() {
	init();

	var tools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-copy" onclick="copy()">&nbsp;复制</a>\
		<a class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</a>\
    </div>';


	editor = new $.fn.dataTable.Editor({
		ajax : _PATH('/table/inline.action'),
		table : '#list',
		fields : [ {
			label : '表名称',
			name : 'tableName'
		}, {
			label : '列名称',
			name : 'title'
		}, {
			label : '类字段',
			name : 'data'
		}, {
			label : '数据库字段',
			name : 'columnName'
		}, {
			label : '排序',
			name : 'orderable'
		}, {
			label : '宽',
			name : 'width'
		}, {
			label : '样式',
			name : 'className'
		}, {
			label : '序号',
			name : 'sequence'
		} ]
	});

	$('#list').on('click', 'tbody td:not(:first-child)', function(e) {
		editor.inline(this, {
			onBlur : 'submit'
		});
	});

	var table = $('#list').datatable({
		tableName : 'BEAUTY_TABLE_CONFIG',
		url : '/table/load/config.action',
		selected : true,
		data : data,
		tools : tools,
		select : {
			style : 'multi',
			selector : 'td:first-child'
		}
	});
	
	copy = function(){
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