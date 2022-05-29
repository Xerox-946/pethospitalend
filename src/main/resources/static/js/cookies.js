function setCookie (cname, cvalue, exdays) {//存的值名字cname，值cvalue
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; "+"; path=/"; /* 浏览器关闭，cookie清除*/
}
function setCookieT (cname, cvalue, exdays) {//存的值名字cname，值cvalue
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + "; path=/" + ";" + expires; /**设置时间到了，cookie清除**/
}
function getCookie (cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}
function delCookie (name) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval;
}
function dateFormatter (cellValue,ishours){
    if(cellValue!=null) {
        var date = new Date(cellValue);
        var year=date.getFullYear();
        var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
        var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
        var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
        var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
        var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
        // 拼接
        if(ishours==true) {
            return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
        }
        else {
            return year + "-" + month + "-" + day
        }
    }
    else {
        return "";
    }
}