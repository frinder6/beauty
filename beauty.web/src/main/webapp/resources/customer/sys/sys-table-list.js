/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */
var _RENDER_OPER = function(data, type, row, meta) {
	var result = '\
		<span class="fa fa-copy pointer" title="配置" data-href="/pages/bracket/sys/columns-conf.jsp?table={0}" onclick="_S_REDIRECT(this)"></span>\
	';
	return result.format(row.tableName);
};

$(function() {

	var table = $('#list').DGrid({
		gridName : 'TABLES',
		grid : {
			ajax : {
				url : _PATH('/table/load/page.action')
			}
		}
	});

});