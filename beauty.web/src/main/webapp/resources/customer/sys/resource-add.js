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
	mySub(function(){
		//
		setTimeout(function(){
			_S_URL_REDIRECT('/pages/bracket/sys/resource-list.jsp');
		}, 1000);
	});

});