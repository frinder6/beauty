$(function () {
    var menu = $('#leftpanelinner').Menu();
    var nav = $('#main-nav').Nav();
    var message = $(document).Message();
    var serverMessage = $(document).ServerMessage({
        userId: _userId
    });

    $('#cache-flush').click(function () {
        ajax({
            url: '/redis/flush.action'
        });
    });

    $('#user-profile').click(function () {
        var nav = '\
					<h2>\
						<i class="{0}"></i> {1} <span>{2}</span>\
					</h2>\
				';
        var data = {
            icon: 'fa fa-user',
            title: '用户管理',
            stitle: '用户信息'
        };
        $(window.document).find('div.pageheader').html(nav.format(data.icon, data.title, data.stitle));
    });


});

/**
 * 显示信息
 *
 * @param message
 */
function showMessage(message) {
    var obj = JSON.parse(message);
    jQuery.gritter.add({
        title: obj.messageHead,
        text: obj.messageBody,
        image: _PATH('/resources/bracket/images/screen.png'),
        sticky: false,
        time: 10000
    });
    return false;
}