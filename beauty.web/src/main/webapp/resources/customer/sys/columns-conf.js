/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
$(function() {

	var _grid = {
		ajax : {
			data : {
				tableName : tableName
			}
		},
		select : {
			style : 'multi'
		},
		pagingType : 'simple'
	};

	var ltools = '<div class="btn-group">\
        <button type="button" class="btn btn-default fa fa-copy oper-delete">&nbsp;导入</button>\
    </div>';

	var lopts = _grid;
	lopts.dom = '<"row"<"#BEAUTY_SCHEMA_COLUMNS_ltool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	lopts.ajax.url = _PATH('/schema/load/page.action');
	var ltable = $('#l-list').DGrid({
		gridName : 'BEAUTY_SCHEMA_COLUMNS',
		tools : ltools,
		toolId : '#BEAUTY_SCHEMA_COLUMNS_ltool',
		grid : lopts,
		remove : true,
		value : tableName,
		delUrl : '/columns/conf.action', // 导入方法
		extraLoad : function() {
			rtable.reload();
		}
	});

	/**
	 * -------------------------------------表格2相关--------------------------------------------
	 */

	var rtools = '<div class="btn-group">\
     	<button type="button" class="btn btn-default fa fa-minus-square-o oper-delete">&nbsp;删除</button>\
    </div>';

	var ropts = _grid;
	ropts.ajax.data.conf = true;
	ropts.dom = '<"row"<"#BEAUTY_TABLE_COLUMNS_2_rtool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	ropts.ajax.url = _PATH('/columns/load/page.action');
	var rtable = $('#r-list').DGrid({
		gridName : 'BEAUTY_TABLE_COLUMNS_2',
		tools : rtools,
		toolId : '#BEAUTY_TABLE_COLUMNS_2_rtool',
		grid : ropts,
		remove : true,
		delUrl : '/columns/remove.action',
		extraLoad : function() {
			ltable.reload();
		}
	});

});