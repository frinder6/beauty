/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var _RENDER_OPER = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-edit pointer auth" data-auth="RES-QUEUE-UPD" title="更新" data-href="/pages/bracket/sys/queue-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
		<span class="fa fa-play pointer auth" data-auth="RES-QUEUE-START-RECEIVE" title="开启接收" onclick="start(\'{1}\')"></span>\
		<span class="fa fa-pause pointer auth" data-auth="RES-QUEUE-STOP-RECEIVE" title="停止接收" onclick="stop(\'{2}\')"></span>\
	';
	return result.format(row.id, row.id, row.id);
};

/**
 * 队列类型
 * @param data
 * @param type
 * @param row
 * @param meta
 * @returns {string}
 * @private
 */
var _RENDER_QUEUE_TYPE = function(data, type, row, meta) {
	if (data == 1){
		return 'DIRECT';
	} else if (data == 2){
		return 'TOPIC';
	} else if (data == 3){
		return 'FANOUT';
	} else {
		return 'DIRECT';
	}
};

$(function() {

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/queue-add.jsp" class="btn btn-default fa fa-plus-square-o auth" data-auth="RES-QUEUE-ADD" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o oper-operate auth" data-auth="RES-QUEUE-DEL">&nbsp;删除</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_QUEUE',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/queue/load/page.action')
			}
		},
		ajax : {
			url : '/queue/remove.action'
		}
	});


	start = function (id) {
		var url = '/qe/manager/start/receive.action';
		_OPER(table, {id: id, url: url});
	};


	stop = function (id) {
		var url = '/qe/manager/stop/receive.action';
		_OPER(table, {id: id, url: url});
	};

});