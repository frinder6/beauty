/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

$(function() {

	var tools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-bookmark" onclick="mark()">&nbsp;标记</a>\
		<a class="btn btn-default fa fa-minus-square-o" onclick="del()">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_TABLE_COLUMNS',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/columns/load/page.action')
			}
		}
	});

});