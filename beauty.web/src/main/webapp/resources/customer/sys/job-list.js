/**
 * frinder_liu
 *
 * @date 2015-08-23 22:07
 */

var _RENDER_OPER = function (data, type, row, meta) {
    var result = '\
		<span class="fa fa-edit pointer" title="更新" data-href="/pages/bracket/sys/job-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
		<span class="fa fa-play pointer" title="启动" onclick="start(\'{1}\')"></span>\
		<span class="fa fa-pause pointer" title="暂停" onclick="pause(\'{2}\')"></span>\
		<span class="fa fa-refresh pointer" title="重置" onclick="trigger(\'{3}\')"></span>\
	';
    return result.format(row.id, row.id, row.id, row.id);
};

$(function () {

    var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/job-add.jsp" class="btn btn-default fa fa-plus-square-o" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o auth oper-operate" data-auth="RES-MENU-DEL">&nbsp;删除</a>\
		<a class="btn btn-default fa fa-play auth" data-auth="RES-MENU-DEL" onclick="start()">&nbsp;启动</a>\
		<a class="btn btn-default fa fa-pause auth" data-auth="RES-MENU-DEL" onclick="pause()">&nbsp;暂停</a>\
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


    _oper = function (params) {
        var ids = [];
        var id = params.id;
        if (id) {
            ids.push(id);
        } else {
            ids = table.selectIds();
        }
        if (!ids) {
            return;
        }
        ajax({
            data: {
                values: ids.join(',')
            },
            url: params.url
        }, function () {
            table.reload();
        });
    }


    start = function (id) {
        var url = '/qz/manager/job/start.action';
        _oper({id: id, url: url});
    };


    pause = function (id) {
        var url = '/qz/manager/job/pause.action';
        _oper({id: id, url: url});
    };

    trigger = function (id) {
        var url = '/qz/manager/job/trigger.action';
        _oper({id: id, url: url});
    }

});