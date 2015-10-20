/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

$(function() {

	var tools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-bookmark" onclick="mark()">&nbsp;标记</a>\
		<a class="btn btn-default fa fa-minus-square-o oper-delete">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_URL',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/url/load/page.action')
			}
		},
		remove : true,
		delUrl : '/url/remove.action'
	});

	mark = function() {
		var ids = table.selectIds();
		if (!ids) {
			return;
		}
		ajax({
			data : {
				values : ids.join(',')
			},
			url : '/url/mark.action'
		}, function() {
			table.reload();
		});
	};

});