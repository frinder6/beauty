/**
 * frinder_liu
 * 
 * @date 2015-09-05 16:15
 */
$(function() {
	init();

	$('#pselect').select2({
		width : '100%',
		minimumResultsForSearch: Infinity
	});

	// 验证提交
	mySub(function() {
		//
		setTimeout(function() {
			_S_URL_REDIRECT('/pages/bracket/sys/auth-list.jsp');
		}, 1000);
	});

});