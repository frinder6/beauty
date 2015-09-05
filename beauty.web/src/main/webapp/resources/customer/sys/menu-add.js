/**
 * frinder_liu
 * 
 * @date 2015-09-05 16:15
 */
$(function() {
	init();

	$('#pselect').select({
		url : '/menu/select.action',
	});

	// 验证提交
	mySub();

});