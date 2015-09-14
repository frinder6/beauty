/**
 * frinder_liu
 * 
 * @date 2015-09-05 20:25
 */
$(function() {
	init();

	$('#pselect').select2({
		width : '100%',
		minimumResultsForSearch : Infinity
	});

	// 更新初始化
	updateInit({
		url : '/auth/load/id.action',
		id : id,
		select : function(data) {
			$('#pselect').val(data.type).trigger('change');
		}
	});

	// 验证提交
	mySub(function() {
		//
		setTimeout(function() {
			_S_URL_REDIRECT('/pages/bracket/sys/auth-list.jsp');
		}, 1000);
	});

});