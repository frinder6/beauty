/**
 * frinder_liu
 * 
 */

var _render = function(data, type, row, meta) {
	var text = data == '2' ? '资源' : '菜单';
	return text;
};

$(function() {
	init();

	editor = new $.fn.dataTable.Editor({
		ajax : _PATH('/auth/inline.action'),
		table : '#list',
		fields : [ {
			label : '权限名称',
			name : 'name'
		}, {
			label : '权限编码',
			name : 'code'
		}, {
			label : '类型',
			name : 'type'
		}, {
			label : '备注',
			name : 'remark'
		} ],
		i18n : {
			create : {
				button : "create",
				title : "新增资源",
				submit : "提交"
			},
			edit : {
				button : "edit",
				title : "更新资源",
				submit : "提交"
			},
			remove : {
				button : "remove",
				title : "删除资源",
				submit : "确定",
				confirm : {
					_ : "确定删除这 %d 行数据，删除后无法恢复！",
					1 : "确定删除这 1 行数据，删除后无法恢复！"
				}
			},
			error : {
				system : "系统错误！"
			}
		}
	});

	$('#list').on('click', 'tbody td:not(:first-child)', function(e) {
		editor.inline(this, {
			onBlur : 'submit'
		});
	});

	var table = $('#list').datatable({
		tableName : 'BEAUTY_AUTHORITY',
		url : '/auth/load/page.action',
		dom : "Bfrtip",
		title : '<input type="checkbox" onclick="checkbox(this)" />',
		select : {
			style : 'multi',
			selector : 'td:first-child'
		},
		columnDefs : [ {
			'targets' : 4,
			'render' : _render
		} ],
		buttons : [ {
			extend : "create",
			className : 'btn btn-default fa fa-plus-square-o',
			text : '&nbsp;新增',
			editor : editor
		}, {
			extend : "edit",
			className : 'btn btn-default fa fa-edit',
			text : '&nbsp;更新',
			editor : editor
		}, {
			extend : "remove",
			className : 'btn btn-default fa fa-minus-square-o',
			text : '&nbsp;删除',
			editor : editor
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

});