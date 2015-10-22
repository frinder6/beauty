/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

$(function() {

	var tools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-copy" onclick="copy()">&nbsp;复制</a>\
		<a class="btn btn-default fa fa-minus-square-o oper-operate">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_TABLE_COLUMNS',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/columns/load/page.action')
			}
		},
		ajax : {
			url : '/columns/remove.action'
		},
		editUrl : '/columns/update.action'
	});

	copy = function() {
		var ids = table.selectIds();
		if (!ids) {
			return;
		}
		ajax({
			data : {
				values : ids.join(',')
			},
			url : '/columns/copy.action'
		}, function() {
			table.reload();
		});
	};

});