!(function ($, window, document, undefined) {

    'use strict';

    var defaults = {};

    var Message = function (element, options) {
        this.$this = element;
        this.$opts = options;
    };

    var msg_div = '<div class="btn-group">\
                    <button class="btn btn-default dropdown-toggle tp-icon" data-toggle="dropdown">\
                        <i class="glyphicon glyphicon-user"></i> <span class="badge">{0}</span>\
                    </button>\
                    <div class="dropdown-menu dropdown-menu-head pull-right">\
                        <h5 class="title">共&nbsp;{1}&nbsp;条消息</h5>\
                        <ul class="dropdown-list user-list">\
                            {2}\
                            <li class="new"><a href="javascript:_REDIRECT(\'{3}\')">查看所有消息</a></li>\
                        </ul>\
                    </div>\
                </div>';

    var msg_li = '<li class="new">\
                        <div class="thumb">\
                            <a href=""><i class="glyphicon glyphicon-envelope"></i></a>\
                        </div>\
                        <div class="desc">\
                            <h5>\
                                <a href="">{0}</a> <span class="badge badge-success">new</span>\
                            </h5>\
                        </div>\
                    </li>';

    Message.prototype = {
        constructor: Message,
        init: function () {
            var url = _PATH('/message/load/by/account.action');
            var url_all = '/pages/bracket/sys/message-list.jsp';
            $.ajax({
                type : 'POST',
                url : url,
                dataType : 'JSON',
                async : false,
                success : function(data) {
                    var total = data.length;
                    var lis = [];
                    $.each(data, function(i, d){
                        lis.push(msg_li.format(d.messageHead));
                    });

                    $('.top-message').html(msg_div.format(total, total, lis.join(''), url_all));
                },
                error : function(msg) {
                    layer.msg(msg);
                }
            });
        }
    };

    $.fn.Message = function (options) {
        var message = new Message(this, options);
        message.init();
        return message;
    };


    $.fn.Message.Constructor = Message;

})(jQuery, window, document);