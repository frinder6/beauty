// Call template init (optional, but faster if called manually)
$.template.init();

$(function() {
	
	// 添加二级菜单
	var lis = $('#shortcuts').find('li');
	$.each(lis, function(i, li) {
		var id = '#' + $(this).attr('id') + '-DIV';
		var div = $(id)[0];
		if(div){
			$(li).menuTooltip($(id), {
				classes : [ 'anthracite-gradient', 'with-small-padding' ],
				onShow : function(target){
					resetMain(id);
				}
			});
		}
	});
	

	// 切换主菜单
	$('#shortcuts').find('li').click(function() {
		$('#shortcuts').find('li').removeClass('current');
		$(this).addClass('current');
	});

});

var resetMain = function(id){
	var options = $('#tooltips').find('select').children('option');
	var len = options.length;
	if (len == 0){
		return;
	}
	// 默认选中第1个
	// var url = options.eq(0).attr('data-href');
	// $('#iframe-main').attr('src', _PATH(url));
	$(id).find('select').change(function(){
		var spans = $('#tooltips').find('span.drop-down').children('span');
		var index = 0;
		$.each(spans, function(i, span){
			var clazz = $(span).attr('class');
			if (clazz == 'selected'){
				index = i;
				return false;
			}
		});
		var url = options.eq(index).attr('data-href');
		if (url){
			$('#iframe-main').attr('src', _PATH(url));
		}
	});
};
