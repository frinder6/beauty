/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
$(function() {

	var _grid = {
		ajax : {
			url : _PATH('/ra/load/page.action'),
			data : {
				roleId : roleId,
				table : 'left'
			}
		},
		pagingType : 'simple'
	};

	var ltools = '<div class="btn-group">\
        <a class="btn btn-default fa fa-copy oper-operate">&nbsp;导入</a>\
    </div>';

	var lopts = _grid;
	lopts.dom = '<"row"<"#BEAUTY_ROLE_AUTHORITY_ltool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	var ltable = $('#l-list').DGrid({
		gridName : 'BEAUTY_ROLE_AUTHORITY',
		tools : ltools,
		toolId : '#BEAUTY_ROLE_AUTHORITY_ltool',
		grid : lopts,
		ajax : {
			url : '/ra/add.action',
			data : {
				value : roleId
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
	ropts.dom = '<"row"<"#BEAUTY_ROLE_AUTHORITY_rtool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	ropts.ajax.data.table = 'right';
	var rtable = $('#r-list').DGrid({
		gridName : 'BEAUTY_ROLE_AUTHORITY',
		tools : rtools,
		toolId : '#BEAUTY_ROLE_AUTHORITY_rtool',
		grid : ropts,
		ajax : {
			url : '/ra/remove.action'
		},
		extraLoad : function() {
			ltable.reload();
		}
	});

});