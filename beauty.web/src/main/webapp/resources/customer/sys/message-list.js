/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var _RENDER_MARK = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-bookmark pointer" title="标记" data-id="{0}" onclick="markId(this)"></span>\
	';
	return result.format(row.id);
};

$(function() {

	var tools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-bookmark oper-operate">&nbsp;标记</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_MESSAGE',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/message/load/page.action')
			}
		}
	});

});