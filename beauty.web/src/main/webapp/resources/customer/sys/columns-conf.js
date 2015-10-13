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

	var _grid = {
		ajax : {
			url : _PATH('/crelation/load/page.action'),
			data : {
				tableName : tableName
			}
		},
		select : {
			style : 'multi'
		},
		pagingType : 'simple'
	};

	var lopts = _grid;
	lopts.dom = '<"row"<"#columns_relation_ltool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	var ltable = $('#l-list').DGrid({
		gridName : 'columns_relation',
		tools : ltools,
		toolId : '#columns_relation_ltool',
		grid : lopts
	});

	// 导入方法
	lexport = function() {
		var items = ltable.selectItems(ltable.getTable());
		if (items.length == 0) {
			layer.msg('至少选择一条！');
			return;
		}
		var ids = $.map(items, function(item, i) {
			return item.id;
		});
		alert(ids);
		var params = {
			data : {
				values : resourceIds.join(','),
				value : authorityId,
				type : type
			},
			url : '/crelation/add.action'
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

	var ropts = _grid;
	ropts.ajax.data.conf = true;
	ropts.dom = '<"row"<"#columns_relation_rtool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	var rtable = $('#r-list').DGrid({
		gridName : 'columns_relation',
		tools : rtools,
		toolId : '#columns_relation_rtool',
		grid : ropts
	});

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
			url : '/crelation/remove.action'
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