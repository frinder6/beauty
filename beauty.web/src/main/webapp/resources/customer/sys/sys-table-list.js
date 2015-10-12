/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
var _render_oper = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-copy pointer" title="配置" data-href="/pages/bracket/sys/columns-conf.jsp?table={0}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.tableName);
};

$(function() {
	init();

	var tools = '<div class="btn-group">\
                <button type="button" class="btn btn-default fa fa-copy" onclick="config()">&nbsp;配置</button>\
            </div>';

	var columnDefs = [ {
		'targets' : 1,
		'render' : _render_oper
	} ];

	var table = $('#list').datatable({
		tableName : 'TABLES',
		url : '/table/load/schema/tables.action',
		selected : true,
		data : {
			tableSchema : 'beauty'
		},
		tools : tools,
		columnDefs : columnDefs
	});

	config = function() {
		var count = table.rows({
			selected : true
		}).count();
		if (count > 0) {
			var items = table.rows({
				selected : true
			}).data();
			var value = items[0].tableName;
			$.ajax({
				"type" : "post",
				"url" : _PATH('/table/config.action'),
				"data" : {
					tableName : value,
					tableSchema : 'beauty'
				},
				"dataType" : 'json',
				"success" : function(data) {
					layer.msg(data.value);
				},
				"error" : function(data) {
					layer.msg(data);
				}
			});
		} else {
			layer.msg('至少选择一条！');
		}
	}

});