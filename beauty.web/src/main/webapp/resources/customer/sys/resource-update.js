/**
 * frinder_liu
 * 
 * @date 2015-09-05 20:25
 */
$(function() {
	init();
	
	// 更新初始化
	updateInit({
		url : '/resource/load/id.action',
		id : id
	});
	
	//验证提交
	mySub(function(){
		//
		setTimeout(function(){
			_S_URL_REDIRECT('/pages/bracket/sys/resource-list.jsp');
		}, 1000);
	});

});