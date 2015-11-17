/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
var _RENDER_MARK = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-bookmark pointer auth" title="标记" data-id="{0}" onclick="markId(this)"></span>\
	';
	return result.format(row.id);
};

$(function() {

	var tools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-bookmark" onclick="mark()">&nbsp;标记</a>\
		<a class="btn btn-default fa fa-minus-square-o oper-operate">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_URL',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/url/load/page.action')
			}
		},
		ajax : {
			url : '/url/remove.action'
		}
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

	markId = function(e) {
		var id = $(e).attr('data-id');
		var ids = [ id ];
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
