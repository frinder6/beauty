// Call template init (optional, but faster if called manually)
$.template.init();

$(function() {
	// 切换左侧菜单
	var changeMenu = function(id) {
		var url = _PATH('/menu/load/level.action');
		$.ajax({
			"type" : "post",
			"url" : url,
			"data" : {
				id : id
			},
			"dataType" : 'json',
			// "async" : false,
			"success" : function(data) {
				$('.navigable').html(data.value);
				currentMenu();
			},
			"error" : function(msg) {
				alert(msg);
			}
		});
	};

	// 初始化左侧菜单
	var currentId = $('li.current').attr('data-id');
	changeMenu(currentId);

	// 切换主菜单
	$('#shortcuts').find('li').click(function() {
		$('#shortcuts').find('li').removeClass('current');
		$(this).addClass('current');
		var id = $(this).attr('data-id');
		changeMenu(id);
	});
	
	// 选中菜单
	var currentMenu = function(){
		$('.big-menu').find('a').click(function(){
			$('.big-menu').find('a').removeClass('current').removeClass('navigable-current');
			$(this).addClass('current').addClass('navigable-current');
			// 主标题
			$('#main-title').find('h1').text($(this).text());
		});
	};
	

});