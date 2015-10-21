/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

var _RENDER_OPER = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-edit pointer" title="更新" data-href="/pages/bracket/sys/resource-update.jsp?id={0}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.id);
};

var _RENDER_MARK = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-bookmark pointer auth" title="标记" data-id="{0}" onclick="markId(this)"></span>\
	';
	return result.format(row.id);
};

$(function() {

	var tools = '<div class="btn-group">\
		<a data-href="/pages/bracket/sys/resource-add.jsp" class="btn btn-default fa fa-plus-square-o" onclick="_S_REDIRECT(this)">&nbsp;新增</a>\
		<a class="btn btn-default fa fa-minus-square-o oper-delete">&nbsp;删除</a>\
		<a class="btn btn-default fa fa-copy" data-toggle="modal" data-target=".bs-url-modal">&nbsp;导入</a>\
		<a class="btn btn-default fa fa-group" onclick="group()">&nbsp;分组</a>\
    </div>';

	var mtools = '<div class="btn-group">\
		<a class="btn btn-default fa fa-copy oper-delete">&nbsp;导入</a>\
    </div>';

	var table = $('#list').DGrid({
		gridName : 'BEAUTY_RESOURCE',
		tools : tools,
		grid : {
			ajax : {
				url : _PATH('/resource/load/page.action')
			}
		},
		remove : true,
		delUrl : '/resource/remove.action'
	});

	var mtable = $('#m-list').DGrid({
		gridName : 'BEAUTY_URL',
		tools : mtools,
		toolId : '#BEAUTY_URL_mtool',
		grid : {
			ajax : {
				url : _PATH('/url/load/page.action'),
				data : {
					dialog : true
				}
			},
			pagingType : 'simple',
			dom : "<'row'<'#BEAUTY_URL_mtool.col-xs-12'f>>t<'row'<'col-xs-6'i><'col-xs-6'p>>"
		},
		remove : true,
		delUrl : '/resource/config.action',
		extraLoad : function() {
			table.reload();
		}
	});

	// 
	group = function() {
		var ids = table.selectIds();
		if (!ids) {
			return;
		}
		layer.prompt({
			title : '请输入分组组名：',
			formType : 3,
			offset : '100px'
		}, function(text) {
			ajax({
				data : {
					values : ids.join(','),
					value : text
				},
				url : '/resource/group.action'
			}, function() {
				table.reload();
			});
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
			mtable.reload();
		});
	};

});