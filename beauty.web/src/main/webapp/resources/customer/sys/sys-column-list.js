/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
$(function() {
	init();

	var ltools = '<div class="btn-group">\
                <button type="button" class="btn btn-default fa fa-copy" onclick="lexport()">&nbsp;导入</button>\
            </div>';

	var unconfig = $('#l-list').datatable({
		tableName : 'COLUMNS',
		url : '/table/load/table/columns.action',
		data : {
			tableName : tableName,
			tableSchema : tableSchema
		},
		tools : ltools,
		selected : true,
		pagingType : 'simple',
		dom : "<'row'<'#my-ltool.col-xs-12'>>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
		toolid : '#my-ltool',
		title : '<input type="checkbox" onclick="lcheckbox(this)" />'
	});

	// 表格全选方法
	lcheckbox = function(e) {
		var checked = $(e).attr('checked');
		if (checked) {
			// 全选
			unconfig.rows().select();
		} else {
			// 取消全选
			unconfig.rows().deselect();
		}
	};

	// 导入方法
	lexport = function() {
		var items = unconfig.rows({
			selected : true
		}).data();
		if (items.length == 0) {
			layer.msg('至少选择一条！');
			return;
		}
		var columns = $.map(items, function(item, i) {
			return item.columnName;
		});
		var params = {
			data : {
				values : columns.join(','),
				tableName : tableName
			},
			url : '/table/copy/config.action'
		};
		//
		ajax(params, function() {
			unconfig.row('.selected').remove().draw(false);
			configed.row('.selected').remove().draw(false);
			unconfig.ajax.reload();
			configed.ajax.reload();
		});
	};

	/**
	 * -------------------------------------表格2相关--------------------------------------------
	 */

	var rtools = '<div class="btn-group">\
	             	<button type="button" class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</button>\
					<button type="button" class="btn btn-default fa fa-minus-square-o" onclick="conf()">&nbsp;去配置</button>\
	            </div>';

	var configed = $('#r-list').datatable({
		tableName : 'BEAUTY_TABLE_CONFIGED',
		url : '/table/load/config.action',
		data : {
			tableName : tableName,
			tableSchema : tableSchema
		},
		tools : rtools,
		selected : true,
		pagingType : 'simple',
		dom : "<'row'<'#my-rtool.col-xs-12'>>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
		toolid : '#my-rtool',
		title : '<input type="checkbox" onclick="rcheckbox(this)" />',
		select : {
			style : 'multi'
		}
	});

	// 表格全选方法
	rcheckbox = function(e) {
		var checked = $(e).attr('checked');
		if (checked) {
			// 全选
			configed.rows().select();
		} else {
			// 取消全选
			configed.rows().deselect();
		}
	};

	del = function() {
		var items = configed.rows({
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
		//
		ajax(params, function() {
			unconfig.row('.selected').remove().draw(false);
			configed.row('.selected').remove().draw(false);
			unconfig.ajax.reload();
			configed.ajax.reload();
		});
	};
});