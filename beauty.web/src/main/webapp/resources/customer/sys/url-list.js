/**
 * frinder_liu
 * 
 * @date 2015-08-23 22:07
 */

$(function() {
	init();


	var table = $('#list').datatable({
		tableName : 'BEAUTY_URL',
		url : '/url/load/page.action',
		title : '<input type="checkbox" />'
	});


});