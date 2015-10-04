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

	var ltable = $('#l-list').datatable({
		tableName : 'BEAUTY_U_R',
		url : '/ur/load/page.action',
		data : {
			userId : userId
		},
		tools : ltools,
		selected : true,
		pagingType : 'simple',
		dom : "<'row'<'#my-ltool.col-xs-12'f>>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
		toolid : '#my-ltool',
		title : '<input type="checkbox" onclick="lcheckbox(this)" />',
		select : {
			style : 'multi'
		}
	});

	// 表格全选方法
	lcheckbox = function(e) {
		var checked = $(e).attr('checked');
		if (checked) {
			// 全选
			ltable.rows().select();
		} else {
			// 取消全选
			ltable.rows().deselect();
		}
	};

	// 导入方法
	lexport = function() {
		var items = ltable.rows({
			selected : true
		}).data();
		if (items.length == 0) {
			layer.msg('至少选择一条！');
			return;
		}
		var roleIds = $.map(items, function(item, i) {
			return item.roleId;
		});
		var params = {
			data : {
				values : roleIds.join(','),
				value : userId
			},
			url : '/ur/add.action'
		};
		//
		ajax(params, function() {
			ltable.row('.selected').remove().draw(false);
			rtable.row('.selected').remove().draw(false);
			ltable.ajax.reload();
			rtable.ajax.reload();
		});
	};

	/**
	 * -------------------------------------表格2相关--------------------------------------------
	 */

	var rtools = '<div class="btn-group">\
	             	<button type="button" class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</button>\
	            </div>';

	var rtable = $('#r-list').datatable({
		tableName : 'BEAUTY_U_R_CONFIGED',
		url : '/ur/load/page.action',
		data : {
			userId : userId,
			conf : true
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
			rtable.rows().select();
		} else {
			// 取消全选
			rtable.rows().deselect();
		}
	};

	del = function() {
		var items = rtable.rows({
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
			url : '/ur/remove.action'
		};
		//
		ajax(params, function() {
			ltable.row('.selected').remove().draw(false);
			rtable.row('.selected').remove().draw(false);
			ltable.ajax.reload();
			rtable.ajax.reload();
		});
	};
});