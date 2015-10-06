/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var _render_oper = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-edit pointer" data-href="/pages/bracket/sys/resource-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.id);
};

$(function() {
	init();

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/resource-add.jsp" class="btn btn-default fa fa-plus-square-o" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</a>\
		<a class="btn btn-default fa fa-copy" data-toggle="modal" data-target=".bs-url-modal">&nbsp;导入</a>\
		<a class="btn btn-default fa fa-group" onclick="group()">&nbsp;分组</a>\
    </div>';

	var mtools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-copy" onclick="exp()">&nbsp;导入</a>\
    </div>';

	var columnDefs = [ {
		'targets' : 1,
		'render' : _render_oper
	} ];

	var table = $('#list').datatable({
		tableName : 'BEAUTY_RESOURCE',
		url : '/resource/load/page.action',
		tools : tools,
		title : '<input type="checkbox" onclick="checkbox(this)" />',
		columnDefs : columnDefs,
		selected : true,
		select : {
			style : 'multi'
		}
	});

	var mtable = $('#m-list').datatable({
		tableName : 'BEAUTY_URL',
		url : '/url/load/page.action',
		tools : mtools,
		x : false,
		data : {
			dialog : true
		},
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
				table.row('.selected').remove().draw(false);
				table.ajax.reload();
			});
		});
	};

	exp = function() {
		var items = mtable.rows({
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
			url : '/resource/config.action'
		};
		ajax(params, function() {
			mtable.row('.selected').remove().draw(true);
			mtable.ajax.reload();
			table.ajax.reload();
		});
		// $('.bs-url-modal').modal('hide');
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
			url : '/resource/group.action'
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