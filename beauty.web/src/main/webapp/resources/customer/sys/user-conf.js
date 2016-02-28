/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
$(function() {

	var _grid = {
		ajax : {
			url : _PATH('/ur/load/page.action'),
			data : {
				userId : userId,
				table : 'left'
			}
		},
		pagingType : 'simple'
	};

	var ltools = '<div class="btn-group">\
        <a class="btn btn-default fa fa-copy oper-operate">&nbsp;导入</a>\
    </div>';

	var lopts = _grid;
	lopts.dom = '<"row"<"#BEAUTY_USER_ROLE_ltool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	var ltable = $('#l-list').DGrid({
		gridName : 'BEAUTY_USER_ROLE',
		tools : ltools,
		toolId : '#BEAUTY_USER_ROLE_ltool',
		grid : lopts,
		ajax : {
			url : '/ur/add.action',
			data : {
				value : userId
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
	ropts.dom = '<"row"<"#BEAUTY_USER_ROLE_rtool.col-xs-12"f>>t<"row"<"col-xs-6"i><"col-xs-6"p>>';
	ropts.ajax.data.table = 'right';
	var rtable = $('#r-list').DGrid({
		gridName : 'BEAUTY_USER_ROLE',
		tools : rtools,
		toolId : '#BEAUTY_USER_ROLE_rtool',
		grid : ropts,
		ajax : {
			url : '/ur/remove.action',
			data : {
				value : userId
			}
		},
		extraLoad : function() {
			ltable.reload();
		}
	});

});