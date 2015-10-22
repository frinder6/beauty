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
		pagingType : 'simple'
	};

	var ltools = '<div class="btn-group">\
        <a class="btn btn-default fa fa-copy oper-operate">&nbsp;导入</a>\
    </div>';

	var lopts = _grid;
	lopts.dom = '<"row"<"#BEAUTY_SCHEMA_COLUMNS_ltool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	lopts.ajax.url = _PATH('/schema/load/page.action');
	var ltable = $('#l-list').DGrid({
		gridName : 'BEAUTY_SCHEMA_COLUMNS',
		tools : ltools,
		toolId : '#BEAUTY_SCHEMA_COLUMNS_ltool',
		grid : lopts,
		ajax : {
			url : '/columns/conf.action',
			data : {
				value : tableName
			}
		},
		extraLoad : function() {
			rtable.reload();
		}
	});

	/**
	 * -------------------------------------表格2相关--------------------------------------------
	 */

	var rtools = '<div class="btn-group">\
     	<a class="btn btn-default fa fa-minus-square-o oper-operate">&nbsp;删除</a>\
    </div>';

	var ropts = _grid;
	ropts.dom = '<"row"<"#BEAUTY_SCHEMA_COLUMNS_rtool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	ropts.ajax.url = _PATH('/columns/load/page.action');
	var rtable = $('#r-list').DGrid({
		gridName : 'BEAUTY_SCHEMA_COLUMNS',
		tools : rtools,
		toolId : '#BEAUTY_SCHEMA_COLUMNS_rtool',
		grid : ropts,
		ajax : {
			url : '/columns/remove.action'
		},
		extraLoad : function() {
			ltable.reload();
		}
	});

});