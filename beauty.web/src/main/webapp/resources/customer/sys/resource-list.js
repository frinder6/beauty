/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
var _render = function(data, type, row, meta) {
	var result = '<a href="#" data-href="/pages/bracket/sys/resource-update.jsp?id={0}" onclick="_S_REDIRECT(this)">{1}</a>';
	return result.format(row.id, data);
};

$(function() {
	init();

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/resource-add.jsp" class="btn btn-default fa fa-plus-square-o" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</a>\
		<a class="btn btn-default fa fa-copy" data-toggle="modal" data-target=".bs-url-modal">&nbsp;导入</a>\
    </div>';

	var mtools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-copy" onclick="exp()">&nbsp;导入</a>\
    </div>';

	var columnDefs = [ {
		'targets' : 1,
		'render' : _render
	} ];

	editor = new $.fn.dataTable.Editor({
		ajax : _PATH('/resource/inline.action'),
		table : '#list',
		fields : [ {
			label : '资源名称',
			name : 'name'
		}, {
			label : '资源编码',
			name : 'code'
		}, {
			label : '备注',
			name : 'remark'
		}, {
			label : '资源路径',
			name : 'url'
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
			// onBlur : 'submit'
			buttons : {
				label : '&gt;',
				fn : function() {
					this.submit();
				}
			}
		});
	});

	var table = $('#list').datatable({
		tableName : 'BEAUTY_RESOURCE',
		url : '/resource/load/page.action',
		dom : "Bfrtip",
		// tools : tools,
		title : '<input type="checkbox" onclick="checkbox(this)" />',
		columnDefs : columnDefs,
		select : {
			style : 'os',
			selector : 'td:first-child'
		},
		buttons : [ {
			extend : "create",
			text : '新增',
			editor : editor
		}, {
			extend : "edit",
			text : '更新',
			editor : editor
		}, {
			extend : "remove",
			text : '删除',
			editor : editor
		} ]
	});

	var mtable = $('#m-list').datatable({
		tableName : 'BEAUTY_URL',
		url : '/url/load/page.action',
		tools : mtools,
		selected : true,
		title : '<input type="checkbox" onclick="mcheckbox(this)" />',
		pagingType : 'simple',
		toolid : '#my-mtool',
		dom : "<'row'<'#my-mtool.col-xs-12'f>>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
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
			return item.id;
		});
		var params = {
			data : {
				values : ids.join(',')
			},
			url : '/resource/remove.action'
		};
		layer.confirm('删除无法恢复，确定删除？', {
			offset : '100px'
		}, function() {
			ajax(params, function() {
				table.ajax.reload();
			});
		});
	};

	exp = function() {
		var items = mtable.rows({
			selected : true
		}).data();
		if (items.length == 0) {
			$('.bs-url-modal').modal('hide');
			return;
		}
		var ids = $.map(items, function(item, i) {
			return item.id;
		});
		var params = {
			data : {
				values : ids.join(',')
			},
			url : '/resource/config.action'
		};
		ajax(params, function() {
			table.ajax.reload();
		});
		$('.bs-url-modal').modal('hide');
	};

	// 表格全选方法
	mcheckbox = function(e) {
		var checked = $(e).attr('checked');
		if (checked) {
			// 全选
			mtable.rows().select();
		} else {
			// 取消全选
			mtable.rows().deselect();
		}
	};

	// editor.on('preSubmit', function (e, data) {
	// // alert(JSON.stringify(data));
	// } );
	//	
	// editor.on('postSubmit', function (e, json, data) {
	// //alert(JSON.stringify(data));
	// } );

});