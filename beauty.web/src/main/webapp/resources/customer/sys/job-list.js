/**
 * frinder_liu
 *
 * @date 2015-08-23 22:07
 */

var _RENDER_OPER = function (data, type, row, meta) {
    var result = '\
		<span class="fa fa-edit pointer auth" data-auth="RES-JOB-UPD" title="更新" data-href="/pages/bracket/sys/job-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
		<span class="fa fa-play pointer auth" data-auth="RES-JOB-START" title="启动" onclick="start(\'{1}\')"></span>\
		<span class="fa fa-pause pointer auth" data-auth="RES-JOB-PAUSE" title="暂停" onclick="pause(\'{2}\')"></span>\
		<span class="fa fa-refresh pointer auth" data-auth="RES-JOB-TRIGGER" title="重置" onclick="trigger(\'{3}\')"></span>\
	';
    return result.format(row.id, row.id, row.id, row.id);
};

$(function () {

    var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/job-add.jsp" class="btn btn-default fa fa-plus-square-o auth" data-auth="RES-JOB-ADD" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth oper-operate" data-auth="RES-JOB-DEL">&nbsp;删除</a>\
		<a class="btn btn-default fa fa-play auth" data-auth="RES-JOB-START" onclick="start()">&nbsp;启动</a>\
		<a class="btn btn-default fa fa-pause auth" data-auth="RES-JOB-PAUSE" onclick="pause()">&nbsp;暂停</a>\
    </div>';

    var table = $('#list').DGrid({
        gridName: 'BEAUTY_JOB',
        tools: tools,
        grid: {
            ajax: {
                url: _PATH('/job/load/page.action')
            }
        },
        ajax: {
            url: '/job/remove.action'
        },
        editUrl: '/job/update.action'
    });


    start = function (id) {
        var url = '/qz/manager/job/start.action';
        _OPER(table, {id: id, url: url});
    };


    pause = function (id) {
        var url = '/qz/manager/job/pause.action';
        _OPER(table, {id: id, url: url});
    };

    trigger = function (id) {
        var url = '/qz/manager/job/trigger.action';
        _OPER(table, {id: id, url: url});
    }

});