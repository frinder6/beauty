!(function ($, window, document, undefined) {

    var defaults = {};

    var Auth = function (element, options) {
        this.$this = element;
        this.$opts = options;
    };

    Auth.prototype = {
        constructor: Auth,
        init: function () {
            var e = this;
            var url = (_BASE + '/user/auths.action');
            $.ajax({
                type: 'POST',
                url: url,
                dataType: 'JSON',
                async: false,
                success: function (data) {
                    e._AUTHS = data;
                },
                error: function (msg) {
                    layer.msg(msg);
                }
            });
        },
        isAuth: function (v) {
            v = v.toUpperCase();
            var e = this;
            var len = $.inArray(v, e._AUTHS);
            return len == -1 ? false : true;
        },
        remove: function () {
            var e = this;
            var needs = $('.auth');
            if (needs) {
                $.each(needs, function (i, need) {
                    var auth = $(need).attr('data-auth');
                    if (auth) {
                        if (!e.isAuth(auth)) {
                            $(need).remove();
                        }
                    }
                });
            }
        }
    };

    $.fn.Auth = function (options) {
        var auth = new Auth(this, options);
        auth.init();
        auth.remove();
        return auth;
    };

    $.fn.Auth.Constructor = Auth;

})(jQuery, window, document);