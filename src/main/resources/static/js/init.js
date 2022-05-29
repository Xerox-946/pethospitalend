//初始化菜单
$.ajax({
    url: '/admin/menu/listAdminMenu',
    type: 'GET',
    success: function (res) {
        console.log(res);
        if (res.code == 200) {
            //for循环初始化菜单
            var str = '';
            $.each(res.data, function (i, item) {
                str += '<li class="layui-nav-item">';
                str += '<a href="' + item.url + '" class="layui-nav-item">';
                str += item.menuname;
                str += '</a>';
                str += '<dl class="layui-nav-child">';
                if (item.childMenu.length != 0) {
                    $.each(item.childMenu, function (j, item2) {
                        str += '<dd><a href="#" class="site-demo-active" lay-href="' + item2.url + '"data-title="'+item2.menuname+'">';
                        str += item2.menuname;
                        str += '</a></dd>';
                    })
                }
                str += '</dl></li>';
            });
            $("#menu-ul").html(str);
        }
    },
    error: function () {
    }
});


