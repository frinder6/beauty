/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
var _render = function(data, type, row, meta) {
	var result = '<a href="#" data-href="/pages/sys/column-config-list.jsp?schema=beauty&table={0}" onclick="_REDIRECT(this)">{1}</a>';
	return result.format(data, data);
};

var editor;

$(function() {
	init();

	var tools = '<div class="btn-group">\
                <button type="button" class="btn btn-default" onclick="del()">删除</button>\
            </div>';

	var columnDefs = [ {
		'targets' : 1,
		'render' : _render
	} ];

	editor = new $.fn.dataTable.Editor({
		ajax : _PATH('/table/inline.action'),
		table : '#list',
		fields : [ {
			label : '列名称',
			name : 'title'
		}, {
			label : '类字段',
			name : 'data'
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
		} ],
		i18n : {
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
		tableName : 'BEAUTY_TABLE_CONFIG',
		url : '/table/load/config.action',
		data : data,
		dom : "Bfrtip",
		// tools : tools,
		columnDefs : columnDefs,
		select : {
			style : 'multi',
			selector : 'td:first-child'
		},
		buttons : [ {
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