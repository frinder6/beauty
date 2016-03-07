/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var _RENDER_MARK = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-bookmark pointer auth" data-auth="RES-MESSAGE-MARK" title="标记" onclick="mark(\'{0}\')"></span>\
	';
	return result.format(row.id);
};

/**
 * 消息状态
 * @param data
 * @param type
 * @param row
 * @param meta
 * @returns {string}
 * @private
 */
var _RENDER_MSG_STATUS = function(data, type, row, meta) {
	if (data == 0){
		return '未读';
	} else if (data == 1){
		return '已读';
	} else {
		return '已读';
	}
};

$(function() {

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/message-add.jsp" class="btn btn-default fa fa-plus-square-o auth" data-auth="RES-MESSAGE-ADD" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth oper-operate" data-auth="RES-MESSAGE-DEL">&nbsp;删除</a>\
		<a class="btn btn-default fa fa-bookmark auth" data-auth="RES-MESSAGE-MARK" onclick="mark()">&nbsp;标记</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_MESSAGE',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/message/load/page.action')
			}
		},
		ajax : {
			url : '/message/remove.action'
		}
	});


	mark = function (id) {
		var url = '/message/mark.action';
		_OPER(table, {id: id, url: url});
	};

});