/**
 * 通用配置
 * Created by gameloft9 on 2018/7/19.
 */

/*开发环境*/
var runEnv = 'product';
//var runEnv = 'dev';
var IP =window.location.protocol+"//"+window.location.hostname;
var port =window.location.port;
var DZ = IP +":"+port;

var config = {
    url: function () {
        url = runEnv === 'product' ? '/api1/' : '/api1/'  // 请求地址
        return url;
    },
    meeting_url: function () {
        url = runEnv === 'product' ? '/conference' : '/conference' //会议url
        return url;
    },
    hdgl_url: function () {
        url = runEnv === 'product' ? '/mactivity/' : '/mactivity'  // 请求地址
        return url;
    },
    dzoa: function () {
        url = runEnv === 'product' ? '/dzoa/' : '/dzoa'  // 党政OA
        return url;
    },
    activity_url: function () {
        url = runEnv === 'product' ? '/activity/' : '/activity'  // 请求地址
        return url;
    },
    knowledgeBase_url: function () {
        url = runEnv === 'product' ? '/knowledgebase/' : '/zsk'  // 请求地址
        return url;
    },
    assets_url: function () {
        url = runEnv === 'product' ? '/gdzc/' : IP + ':9014';  // 请求地址
        return url;
    },
    webofficesaveurl: function () {
        url = runEnv === 'product' ? DZ + '/data/' : DZ + '/api1'  // 请求地址
        return url;
    },
    officfileurl: function () {
        var url = DZ + '/officefile'
        return url;
    },
    webpdf: function () {
        var url = '/pdffile/'
        return url;
    },
    yxwps: function () {
        url = runEnv === 'product' ? DZ + '/yx_wps/' : DZ + '/yx_wps'  // 请求地址
        return url;
    },
    supervise_url: function () {
        url = runEnv === 'product' ? '/dcdb/' : '/dcdb';  // 绩效url   http://192.168.1.119:9011
        return url;
    },
    infoexchangeurl: function () {
        url = runEnv === 'product' ? '/infoexchange/' : '/api4'  // 请求地址
        return url;
    },
    zjrsturl: function () {
        url = runEnv === 'product' ? '/zjrst/' : '/zjrst'  // 请求地址
        return url;
    },
    zjzzb_url: function () {
        url = runEnv === 'product' ? '/zjzzb/' : '/zjzzb'  // 请求地址
        return url;
    },
    zjyjturl: function () {
        url = runEnv === 'product' ? '/zjyjt/' : '/zjyjt'  // 请求地址
        return url;
    },
    archivesurl: function () {
        url = runEnv === 'product' ? '/archives/' : '/archives'  // 请求地址
        return url;
    },
    workcenterurl: function () {
        url = runEnv === 'product' ? '/api6' : IP + ':9023'  // 请求地址
        return url;
    },
    urlkd: function () {
        url = runEnv === 'product' ? '/data/' : '/api1'  // 快捷登录
        return url
    },
    workflow_url: function () {
        url = runEnv === 'product' ? '/workflow' : '/workflow'  // 工作流url
        return url;
    },
    urlfw: function () {
        url = runEnv === 'product' ? IP + ':8080' : IP + ':8080'  // 常用下载
        return url;
    },

    weboffice_url: function () {
        url = runEnv === 'product' ? IP + ':8080' : IP + ':8080'  // weboffice
        return url;
    },
    ddurl: function () {
        url = runEnv === 'product' ? '/api3' : 'http://61.164.248.165:12219'  //单点url  http://61.164.248.165:12219/--资源厅    http://61.164.248.165:12202/ --人社厅
        return url;
    },
    ddurlifr: function () {
        url = runEnv === 'product' ? 'http://61.164.248.165:12219/' : 'http://61.164.248.165:12219/'  //单点url  http://61.164.248.165:12219/--资源厅    http://61.164.248.165:12202/ --人社厅
        return url;
    },
    infourl: function () {
        url = runEnv === 'product' ? '/info' : '/info'  // 请求地址
        return url;
    },
    archiveurl: function () {
        url = runEnv === 'product' ? '/archive' : '/archive'  // 请求地址
        return url;
    },
    filecon_url: function () {
        url = runEnv === 'product' ? '/fileConversion/' : '/file_convertion'  // 请求地址
        return url;
    },
    rule_url: function () {
        url = runEnv === 'product' ? '/rule/' : '/rule'  // 请求地址
        return url;
    },
    ky_url: function () {
        url = runEnv === 'product' ? '/ky' : '/ky'  // 请求地址
        return url;
    },
    lib_url: function () {
        url = runEnv === 'product' ? '/lib' : '/lib'  // 请求地址
        return url;
    },
    cy_url: function () {
        url = runEnv === 'product' ? '/cy' : '/cy'  // 请求地址
        return url;
    },
    ws_url: function () {
        url = runEnv === 'product' ? '/ws' : '/ws'  // 请求地址
        return url;
    },
    ueditor_url: function () {
        url = runEnv === 'product' ? '/ueditor' : '/ueditor'  // 请求地址
        return url;
    },
    dxyq_url: function () {
        url = runEnv === 'product' ? '/dxyq' : '/dxyq'  // 请求地址
        return url;
    },
    jjgl_url: function () {
        url = runEnv === 'product' ? '/jjgl' : '/jjgl'  // 请求地址
        return url;
    },
    kbzx_url: function () {
        url = runEnv === 'product' ? '/kbzx' : '/kbzx'  // 请求地址
        return url;
    },
    khgl_url: function () {
        url = runEnv === 'product' ? '/khgl' : '/khgl'  // 请求地址
        return url;
    },
    cwsj_url: function () {
        url = runEnv === 'product' ? '/cwsj' : '/cwsj'  // 请求地址
        return url;
    },
    zjyjturl: function () {
        url = runEnv === 'product' ? '/zjyjt/' : '/zjyjt'  // 请求地址
        return url;
    },
    nkymisurl: function () {
        url = runEnv === 'product' ? '/rs/' : '/rs'  // 请求地址
        return url;
    },
    sso_url: function () {
        url = runEnv === 'product' ? '/msso' : '/msso'  // 请求地址
        return url;
    },
    nkymisdqurl: function () {
        url = runEnv === 'product' ? '/dq/' : '/dq'  // 请求地址
        return url;
    },
    nkymiscyurl: function(){
        url = runEnv === 'product' ? '/cy/' : '/cy'  // 请求地址
        return url;
    },
    ysqy_url: function(){
        url = runEnv === 'product' ? '/ysqy/' : '/ysqy'  // 请求地址
        return url;
    },
    activiti_url: function () {
        //服务器地址
        url = 'http://192.168.1.6:9090';
        //本地地址
        // url = 'http://' + '本地IP' + ':' + '本地web前端项目nginx代理端口';
    },
    number: function (m, n) { //随机数m是开始，n是结束，例：（1，100），随机数为1-100随机
        num = Math.floor(Math.random() * (m - n) + n);
        return num;
    },
    createTime: function (datetime, times) {
        var reg = new RegExp("-", "g");
        var str = datetime.replace("T", ' ').replace(reg, "/");

        if (str.indexOf(".") == "-1") {
            var daytime = str;
        } else {
            var daytime = str.substring(0, str.indexOf("."));
        }
        var myDate = new Date(+new Date(daytime))
        var year = myDate.getFullYear();
        var mon = myDate.getMonth() + 1 < 10 ? "0" + (myDate.getMonth() + 1) : myDate.getMonth() + 1;
        var date = myDate.getDate() < 10 ? "0" + myDate.getDate() : myDate.getDate();

        var h = myDate.getHours(); //获取当前小时数(0-23)
        var m = myDate.getMinutes(); //获取当前分钟数(0-59)
        if (m < 10) {
            m = "0" + m;
        }
        var s = myDate.getSeconds(); //获取当前秒
        var week = myDate.getDay();
        var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        if (times == "mm-dd") {
            return mon + "-" + date;
        } else if (times == "mm-ddS") {
            return mon + "-" + (myDate.getDate() + 1);
        } else if (times == "yyyy") {
            return year;
        } else if (times == "yyyy-mm-dd") {
            return year + "-" + mon + "-" + date;
        } else if (times == "yyyy-mm-ddS") {
            return year + "-" + mon + "-" + (myDate.getDate() + 1);
        } else if (times == "HH:mm") {
            if (h < 10) {
                h = "0" + h;
            }
            return h + ":" + m;
        } else if (times == "HH:mmS") {
            return (h + 1) + ":" + m;
        } else if (times == "yyyy-mm-dd HH:mm") {
            if (h < 10) {
                h = "0" + h;
            }
            return year + "-" + mon + "-" + date + " " + h + ":" + m;
        } else if (times == "yyyy-mm-dd HH:mmS") {
            h = h + 1;
            if (h < 10) {
                h = "0" + h;
            }
            return year + "-" + mon + "-" + date + " " + h + ":" + m;
        } else if (times == "yyyy-mm-dd HH:mm:ss") {
            if (h < 10) {
                h = "0" + h;
            }
            return year + "-" + mon + "-" + date + " " + h + ":" + m + ":" + s;
        } else if (times == "yyyy-mm-dd HH:mm:ss T") {
            if (h < 10) {
                h = "0" + h;
            }
            return year + "-" + mon + "-" + date + " " + h + ":" + m + ":" + s + " " + weeks[week];
        } else if (times == "yyyy-mm-dd T") {
            return year + "-" + mon + "-" + date + " " + weeks[week];
        }

    },
    getTime: function (key, dtime) {
        var reg = new RegExp("-", "g");
        var str = dtime.replace("T", ' ').replace(reg, "/");
        if (str.indexOf(".") == "-1") {
            dtime = str;
        } else {
            dtime = str.substring(0, str.indexOf("."));
        }
        var myDate = "";
        var t = Date.parse(dtime);
        if (!isNaN(t)) {
            myDate = new Date(+new Date(dtime))
        } else {
            myDate = new Date();
        }
        var year = myDate.getFullYear();
        var month = myDate.getMonth() + 1;
        //获取当前日
        var date = myDate.getDate();
        var h = myDate.getHours(); //获取当前小时数(0-23)
        var m = myDate.getMinutes(); //获取当前分钟数(0-59)
        var s = myDate.getSeconds();
        var week = myDate.getDay();
        var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        if (key == "yyyy") {
            return year;
        }
        else if (key == "yyyy-MM") {
            return year + '-' + config.conver(month);
        }
        else if (key == "yyyy/MM") {
            return year + '/' + config.conver(month);
        }
        else if (key == "yyyy-MM-dd") {
            return year + '-' + config.conver(month) + "-" + config.conver(date);
        }
        else if (key == "yyyy/MM/dd") {
            return year + '/' + config.conver(month) + "/" + config.conver(date);
        }
        else if (key == "yyyy-MM-dd hh:mm:ss") {
            return year + '-' + config.conver(month) + "-" + config.conver(date) + " " + config.conver(h) + ':' + config.conver(m) + ":" + config.conver(s);
        }
        else if (key == "yyyy/MM/dd hh:mm:ss") {
            return year + '/' + config.conver(month) + "/" + config.conver(date) + " " + config.conver(h) + ':' + config.conver(m) + ":" + config.conver(s);
        }
        else if (key == "MM/dd") {
            return config.conver(month) + '/' + config.conver(date);
        }
        else if (key == "hh:mm:ss") {
            return config.conver(h) + ':' + config.conver(m) + ":" + config.conver(s);
        }
        else if (key == "hh:mm") {
            return config.conver(h) + ':' + config.conver(m);
        }
        else if (key == "hh/mm") {
            return config.conver(h) + '/' + config.conver(m);
        }else if(key == "yyyy-MM-dd hh:mm:ssT") {
            return year + '-' + config.conver(month) + "-" + config.conver(date) + " " + config.conver(h) + ':' + config.conver(m) + ":" + config.conver(s) + " " + weeks[week];
        }
    },
    conver: function (s) {
        return s < 10 ? '0' + s : s;
    },
    atime: function (time) {
        var now = new Date(time);
        var month = now.getMonth() + 1;
        var day = now.getDay();
        var s = now.getSeconds();
        var arr = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
        week = arr[day];
        return week
    },
    verificationCode: function () {
        var arr = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
        var rand1 = Math.floor((Math.random() * 62));
        var rand2 = Math.floor((Math.random() * 62));
        var rand3 = Math.floor((Math.random() * 62));
        var rand4 = Math.floor((Math.random() * 62));
        var rand5 = Math.floor((Math.random() * 62));
        var rand6 = Math.floor((Math.random() * 62));
        //alert("验证码为: " + " " + arr[rand1] + " " + arr[rand2] + " " +  arr[rand3] + " "  + arr[rand4] + " "  + arr[rand5] + " "  + arr[rand6])  ;
        return arr[rand1] + arr[rand2] + arr[rand3] + arr[rand4] + arr[rand5] + arr[rand6]
    },
    webprotection: function () {  // 网页安全
        $(document).bind("selectstart", function () {
            return false;
        });//禁止文本选择复制
        document.oncontextmenu = function () {
            return false;
        }; //禁止F12和右键
        document.onkeydown = function () {
            if (window.event && window.event.keyCode == 123) {
                layui.use('layer', function () {
                    layer.msg('<span style="color: red">无权限查看源代码，请联系管理员！</span>', {icon: 5});
                });
                event.keyCode = 0;
                event.returnValue = false;
                return false;
            }
        };
    },
    token: function () { //token
        token = getCookie('token')
        return token;
    },
    signs: function (name) { //token
        signs = sign.signs(name)
        return signs;
    },
    headers: function (name) { //login请求头封装（新）
        if (getCookie('token') == "") {
            top.location.href = "/login.html";
        }
        head = {"token": getCookie('token'), "sign": sign.signs(name)}
        return head;
    },
    headers_nologin: function (name) { //login请求头封装（新）
        /*if (getCookie('token') == "") {
            top.location.href = "/login.html";
        }*/
        head = {"token": getCookie('token'), "sign": sign.signs(name)}
        return head;
    },
    head: function () { //login请求头封装（旧）
        head = {
            db_name: 1,
            "token": getCookie('token'),
            "personID": getCookie('personID'),
            "userID": getCookie('userID'),
            "personName": getCookie('personName'),
            "databaseId": getCookie('databaseId')
        }
        return head;
    },
    setcooikeaddtime: function () {
        setCookie('personID', getCookie("personID"), getCookie("time"));
        setCookie('userID', getCookie("userID"), getCookie("time"));
        setCookie('personName', getCookie("personName"), getCookie("time"));
        setCookie('databaseId', getCookie("databaseId"), getCookie("time"));
        setCookie('unitid', getCookie("unitid"), getCookie("time"));
        setCookie('token', getCookie("token"), getCookie("time"));
    },
    error: function () { //原生失败回调函数
        err = function (e) {
            if (e.responseJSON && e.responseJSON.message == "请先登录") {
                top.location.href = "/login.html";
            } else if (e.status == "401") {
                top.location.href = "/login.html";
            } else if (e.status == "402") {
                layui.use('layer', function () {
                    layer.msg('数字签名验证失败！');
                })
            } else {
                layui.use('layer', function () {
                    layer.msg('数据请求中，请稍后！');
                })
                /*setCookie("token", "", -1);*/
            }
        }
        return err;
    },
    errorajx: function (e) { //ajax封装错误失败回调函数
        if (e.responseJSON && e.responseJSON.message == "请先登录") {
            top.location.href = "/login.html";
        } else if (e.status == "401") {
            top.location.href = "/login.html";
        } else if (e.status == "402") {
            layui.use('layer', function () {
                layer.msg('数字签名验证失败！');
            })
        } else {
            layui.use('layer', function () {
                layer.msg('数据请求中，请稍后！');
            })
            /*setCookie("token", "", -1);*/
        }
    },
    errorzdy: function (url, content) {//url 为当前访问接口   content 为异常内容
        err = function () {
            window.location.replace("/home/tpl/error.html?ycurl=" + decodeURI(window.location.href) + "&ycapi=" + url + "&yccontent=" + content)
        }
        return err;
    },
    /**
     * ajax封装
     * url 发送请求的地址
     * data 发送到服务器的数据，数组存储，如：{"date": new Date().getTime(), "state": 1}
     * name 发送请求的接口函数名：例- http:192.168.1.232:96/test?type=a&name=b ------  name=test
     * async 默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
     *       注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
     * type 请求方式("POST" 或 "GET")， 默认为 "GET"
     * dataType 预期服务器返回的数据类型，常用的如：xml、html、json、text
     * successfn 成功回调函数
     * errorfn 失败回调函数
     */
    configajax: function (type, url, data, name, async, dataType, successfn, errorfn) {
        async = (async == null || async == "" || typeof (async) == "undefined") ? "true" : async;
        type = (type == null || type == "" || typeof (type) == "undefined") ? "post" : type;
        dataType = (dataType == null || dataType == "" || typeof (dataType) == "undefined") ? "json" : dataType;
        data = (data == null || data == "" || typeof (data) == "undefined") ? {"date": new Date().getTime()} : data;
        errorfn = (errorfn == null || errorfn == "" || typeof (errorfn) == "undefined") ? false : errorfn;
        if (url.indexOf('?') > -1) {
            url += '&mathnum=' + Math.random();
        } else {
            url += '?mathnum=' + Math.random();
        }
        $.ajax({
            type: type,
            url: url,
            data: data,
            async: async,
            dataType: dataType,
            headers: config.headers(name),
            success: function (d) {
                successfn(d);
            },
            error: function (e) {
                if (errorfn != false) {
                    errorfn(e);
                }
            }
        });
    },
    /**
     * ajax封装 无请求头
     * type 请求方式("POST" 或 "GET")， 默认为 "GET"
     * url 发送请求的地址
     * data 发送到服务器的数据，数组存储，如：{"date": new Date().getTime(), "state": 1}
     *  dataType 预期服务器返回的数据类型，常用的如：xml、html、json、text
     * successfn 成功回调函数
     * errorfn 失败回调函数
     */
    axgpost: function (type, url, data, dataType, successfn, errorfn) {
        data = (data == null || data == "" || typeof (data) == "undefined") ? {"date": new Date().getTime()} : data;
        type = (type == null || type == "" || typeof (type) == "undefined") ? "post" : type;
        dataType = (dataType == null || dataType == "" || typeof (dataType) == "undefined") ? "json" : dataType;
        errorfn = (errorfn == null || errorfn == "" || typeof (errorfn) == "undefined") ? false : errorfn;
        if (url.indexOf('?') > -1) {
            url += '&mathnum=' + Math.random();
        } else {
            url += '?mathnum=' + Math.random();
        }
        $.ajax({
            type: type,
            data: data,
            url: url,
            dataType: dataType,
            success: function (d) {
                successfn(d);
            },
            error: function (e) {
                if (errorfn != false) {
                    errorfn(e);
                }
            }
        });
    },
    /**
     * ajax封装
     * url 发送请求的地址
     * params 请求内容
     * name 接口验签
     */
    ajax: function (url, params, name) {
        if (getCookie('token') == "") {
            top.location.href = "/login.html";
        }
        if (!name) {
            var end = url.indexOf("?");
            name = url.substring(url.lastIndexOf("/") + 1, end == -1 ? url.length : end);
        }
        params.headers = config.headers(name);
        var json = {
            type: "get",
            dataType: 'json',
            success: function (res) {
                typeof params.success === "function" ? params.success(res) : '';
            },
            error: function (xhr, type, errorThrown) {
                //console.log(url, "  调用失败: ");
                typeof params.error === "function" ? params.error(xhr, type, errorThrown) : config.errorajx(xhr);
            }
        };
        $.each(params, function (k, v) {
            if (k !== "success" && k !== "error") {
                json[k] = v;
            }
        });
        if (url.indexOf('?') > -1) {
            url += '&mathnum=' + Math.random();
        } else {
            url += '?mathnum=' + Math.random();
        }
        $.ajax(url, json);
    },
    ajaxnontlogin: function (url, params, name) {
        // if (getCookie('token') == "") {
        //     loader();
        // }
        if (!name) {
            var end = url.indexOf("?");
            name = url.substring(url.lastIndexOf("/") + 1, end == -1 ? url.length : end);
        }
        params.headers = config.headers_nologin(name);
        var json = {
            type: "get",
            dataType: 'json',
            success: function (res) {
                typeof params.success === "function" ? params.success(res) : '';
            },
            error: function (xhr, type, errorThrown) {
                console.log(url, "  调用失败: ");
                typeof params.error === "function" ? params.error(xhr, type, errorThrown) : config.errorajx(xhr);
            }
        };
        $.each(params, function (k, v) {
            if (k !== "success" && k !== "error") {
                json[k] = v;
            }
        });
        if (url.indexOf('?') > -1) {
            url += '&mathnum=' + Math.random();
        } else {
            url += '?mathnum=' + Math.random();
        }
        $.ajax(url, json);
    },
    get_ajax: function (url, params, name) {
        params.type = "get";
        config.ajax(url, params, name);
    },
    put_ajax: function (url, params, name) {
        params.type = "put";
        config.ajax(url, params, name);
    },
    delete_ajax: function (url, params, name) {
        params.type = "delete";
        config.ajax(url, params, name);
    },
    post_ajax: function (url, params, name) {
        params.type = "post";
        config.ajax(url, params, name);
    },
    get_ajax_nologin: function (url, params, name) {
        params.type = "get";
        config.ajaxnontlogin(url, params, name);
    },
    post_ajax_nologin: function (url, params, name) {
        params.type = "post";
        config.ajaxnontlogin(url, params, name);
    },
    closeFrame: function () {
        //关闭弹窗
        var index = parent.layer.getFrameIndex(window.name); // 先得到当前iframe层的索引
        parent.layer.close(index); // 再执行关闭
    },
    tableReload: function (name) {
        parent.layui.table.reload(name);
    },
    getUrlParam: function (key, defvalue) {
        // 获取url参数
        var url = window.location.search;
        // 正则筛选地址栏
        var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)", "i");
        // 匹配目标参数
        var result = url.substr(1).match(reg);
        //返回参数值
        if (defvalue != "" && typeof (defvalue) != "undefined") {
            return result ? decodeURIComponent(result[2]) : defvalue;
        } else {
            return result ? decodeURIComponent(result[2]) : '';
        }
    },
    log: function (msg) {
        window.console && console.log(msg);
    },
    trim: function (name) {
        return name.replace(/(^\s*)|(\s*$)/g, "");
    },
    /**
     * 预览图片接口
     * @param url 请求地址
     * @param auth
     * @param img img对象
     */
    imgFun: function (url, auth, img) {
        var windowUrl = window.URL || window.webkitURL;//处理浏览器兼容性
        var xhr = new XMLHttpRequest();
        xhr.open("GET", url, true);
        xhr.responseType = "blob";
        xhr.setRequestHeader("token", getCookie("token"));
        xhr.setRequestHeader("sign", config.signs("download"));
        xhr.onload = function () {
            //console.log(this);
            if (this.status === 200) {
                var blob = this.response;
                $(img).attr("src", blob);
                $(img).load(function (e) {
                    windowUrl.revokeObjectURL(img.src);
                }).attr("src", windowUrl.createObjectURL(blob));
            }
        };
        xhr.send();
    },
    bgimgFun: function (url, db) {
        var windowUrl = window.URL || window.webkitURL;//处理浏览器兼容性
        var xhr = new XMLHttpRequest();
        xhr.open("GET", url, true);
        xhr.responseType = "blob";
        xhr.setRequestHeader("db_name", db);
        xhr.onload = function () {
            if (this.status == 200) {
                var blob = this.response;
                var beig = windowUrl.createObjectURL(blob);
                document.getElementById("login").setAttribute("style", "position: relative;background: url(" + beig + ") fixed center center no-repeat;width: 100%;background-size: cover; -moz-background-size:cover;-webkit-background-size:cover; ");
            }
        }
        xhr.send();
    },
    //加载页
    loaders: function (text) {
        if (text == "on") {
            layui.use('layer', function () { //独立版的layer无需执行这一句
                layer.load(0); //0代表加载的风格，支持0-2
            });
        } else {
            layui.use('layer', function () { //独立版的layer无需执行这一句
                $(".logincog").show();
                layer.closeAll('loading');
            });
        }
    },
    //true为PC端，false为手机端
    IsPC: function () {
        var userAgentInfo = navigator.userAgent;
        var Agents = ["Android", "iPhone",
            "SymbianOS", "Windows Phone",
            "iPad", "iPod"];
        var flag = true;
        for (var v = 0; v < Agents.length; v++) {
            if (userAgentInfo.indexOf(Agents[v]) > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    },

    // IE8时间转换
    timeto: function (times, format) {
        var reg = new RegExp("-", "g");
        var str = times.replace("T", ' ').replace(reg, "/");
        if (str.indexOf(".") == "-1") {
            times = str;
        } else {
            times = str.substring(0, str.indexOf("."));
        }
        var CreateTime = new Date(+new Date(times))
        var year = CreateTime.getFullYear();
        var month = CreateTime.getMonth() + 1 < 10 ? "0" + (CreateTime.getMonth() + 1) : CreateTime.getMonth() + 1;
        var day = CreateTime.getDate() < 10 ? "0" + CreateTime.getDate() : CreateTime.getDate();
        var h = CreateTime.getHours() < 10 ? "0" + CreateTime.getHours() : CreateTime.getHours();//小时
        var m = CreateTime.getMinutes() < 10 ? "0" + CreateTime.getMinutes() : CreateTime.getMinutes();//分
        var s = CreateTime.getSeconds() < 10 ? "0" + CreateTime.getSeconds() : CreateTime.getSeconds();//秒
        var CT = ''; // 精确到天

        if (format === "yyyy-MM-dd HH:mm") {
            CT = year + "-" + month + "-" + day + " " + h + ":" + m;
        } else if (format === "MM-dd") {
            CT = month + "-" + day;
        } else if (format === "yyyy-MM-dd") {
            CT = year + "-" + month + "-" + day;
        } else if (format === "MM月dd日 HH:mm") {
            CT = month + "月" + day + "日 " + h + ":" + M;
        } else {
            CT = year + "-" + month + "-" + day;
        }
        return CT
    },
    //时间转换
    showTime: function (tempDate) {
        var date = new Date(tempDate);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? '0' + m : m;
        var d = date.getDate();
        d = d < 10 ? ("0" + d) : d;
        var h = date.getHours();
        h = h < 10 ? ("0" + h) : h;
        var M = date.getMinutes();
        M = M < 10 ? ("0" + M) : M;
        var str = y + "-" + m + "-" + d + " " + h + ":" + M;
        return str;
    },
    //动态添加css/js文件
    addfile: function (filename, filetype,name) {
        var cssname= "" ? name :"tjys";
        var creatHead = $('head');
        if (filetype == "css") {
            creatHead.append('<link class="'+cssname+'" rel="stylesheet" href="' + filename + '" type="text/css" >')
        } else {
            creatHead.append('<script src="' + filename + '" type="text/javascript"></script>')
        }
    },
    //动态移除css/js文件
    removefile: function (name) {
        var cssname= "" ? name :"tjys";
        $("."+cssname).remove();
    },
    //导出文件
    exportfile: function (url, data, name) {
        var headers = config.headers(name);
        var xhr = new XMLHttpRequest();
        if (!data.async) {
            data.async = true;
        }
        xhr.open(data.type, url, data.async);//get请求，请求地址，是否异步
        xhr.setRequestHeader("token", headers.token);
        xhr.setRequestHeader("sign", headers.sign);
        xhr.responseType = 'blob';
        if (data.contentType) {
            xhr.setRequestHeader("Content-Type"
                , data.contentType);
        }
        xhr.onload = function () {// 请求完成处理函数
            if (this.status === 200) {
                var blob = this.response;// 获取返回值
                var a = document.createElement('a');
                a.download = data.filename;
                a.href = window.URL.createObjectURL(blob);
                a.click();
            }
        };
        xhr.send(data.data);
    },
    importJS: function (filePath) {
        document.write("<script type='text/javascript' src='" + filePath + "?t=" + Math.random() + "'></scr" + "ipt>");
    },

    importCss: function (filePath) {
        document.write("<link type='text/css' rel='stylesheet' href='" + filePath + "?t='" + Math.random() + "/>");
    }
};


// window._console = window.console;//将原始console对象缓存
// window.console = (function (orgConsole) {
//     return {//构造的新console对象
//         log: getConsoleFn("log"),
//         debug: getConsoleFn("debug"),
//         info: getConsoleFn("info"),
//         warn: getConsoleFn("warn"),
//         exception: getConsoleFn("exception"),
//         assert: getConsoleFn("assert"),
//         dir: getConsoleFn("dir"),
//         dirxml: getConsoleFn("dirxml"),
//         trace: getConsoleFn("trace"),
//         group: getConsoleFn("group"),
//         groupCollapsed: getConsoleFn("groupCollapsed"),
//         groupEnd: getConsoleFn("groupEnd"),
//         profile: getConsoleFn("profile"),
//         profileEnd: getConsoleFn("profileEnd"),
//         count: getConsoleFn("count"),
//         clear: getConsoleFn("clear"),
//         time: getConsoleFn("time"),
//         timeEnd: getConsoleFn("timeEnd"),
//         timeStamp: getConsoleFn("timeStamp"),
//         table: getConsoleFn("table"),
//         error: getConsoleFn("error"),
//         memory: getConsoleFn("memory"),
//         markTimeline: getConsoleFn("markTimeline"),
//         timeline: getConsoleFn("timeline"),
//         timelineEnd: getConsoleFn("timelineEnd")
//     };

//     function getConsoleFn(name) {
//         return function actionConsole() {
//             if (typeof (orgConsole) !== "object") return;
//             if (typeof (orgConsole[name]) !== "function") return;//判断原始console对象中是否含有此方法，若没有则直接返回
//             return orgConsole[name].apply(orgConsole, Array.prototype.slice.call(arguments));//调用原始函数
//         };
//     }
// }(window._console));


var b_v = navigator.appVersion;
var IE6 = b_v.search(/MSIE 6/i) != -1;
var IE7 = b_v.search(/MSIE 7/i) != -1;

if (IE6) {
    layui.use('layer', function () {
        layer.msg('您的浏览器版本过低，在本系统中不能达到良好的视觉效果，建议你升级到ie8以上！');
    })
} else if (IE7) {
    layui.use('layer', function () {
        layer.msg('您当前浏览器的版本过低，请使用高于IE7版本的浏览器查看！');
    })
}
//获取字体是否为默认还是放大
// document.write("<script type='text/javascript' src='/home/common/js/cookies.js'></scr" + "ipt>");
// var db = getCookie('db_name');
// db = (db == null || db == "" || typeof (db) == "undefined") ? "1" : db;
// $.ajax({
//     url: config.url() + "/systemParam/selectParaValue",
//     type: 'post',
//     dataType: 'json',
//     data: {paraKey: "Sys_FontSize"},
//     headers: {
//         "db_name": db
//     },
//     success: function (res) {
//         if (res.data == "1") {
//             $("head").append("<link>");
//             var toolbarCss = $("head").children(":last");
//             toolbarCss.attr({
//                 rel: "stylesheet",
//                 type: "text/css",
//                 href: "/home/common/css/fontsize.css"
//             });
//         }
//     }
// })

//点击更多搜索外面时关闭更多搜索
/*$(document).bind('click', function (e) {
    var height = $(window).height();
    var e = e || window.event; //浏览器兼容性
    var elem = e.target || e.srcElement;
    if (elem.id == "close" || elem.id == "dataSearch2" || elem.id == "dataSearch1" || elem.id == "dataSearch3" || elem.id == "dataSearch" || elem.id == "Sreach" || elem.id == "Sreach2") {
        $('#reload1').attr('style', 'text-align: center; right: -500px;');
    } else if (elem.id != "search2" || elem.id == 'reload1') {
        while (elem) { //循环判断至跟节点，防止点击的是div子元素
            if (elem.id && (elem.id == 'reload1' || elem.id == 'search2')) {
                return;
            }
            elem = elem.parentNode;
        }
        $('#reload1').attr('style', 'text-align: center; right: -500px;');
    } else {
        $("#reload1").find("div:eq(0)").attr("style", "height:" + (height - 140) + "px;overflow: auto;margin: 20px 0")
        $('#reload1').attr('style', 'text-align: center; right: 0px;height:' + (height - 50) + 'px');
    }

});*/
//点击更多搜索外面时关闭更多搜索（排除搜索按钮外）
// $(document).bind('click', function (e) {
//     var height = $(window).height();
//     var e = e || window.event; //浏览器兼容性
//     var elem = e.target || e.srcElement;
//     if (elem.id == "close") {
//         $('#reload1').attr('style', 'text-align: center; right: -500px;');
//     } else if (elem.id != "search2") {
//         while (elem) { //循环判断至跟节点，防止点击的是div子元素
//             if (elem.id && (elem.id == 'reload1' || elem.id == 'search2' || elem.id == 'reload1' || elem.id == "dataSearch2" || elem.id == "dataSearch1" || elem.id == "dataSearch3" || elem.id == "dataSearch" || elem.id == "Sreach")) {
//                 return;
//             }
//             elem = elem.parentNode;
//         }
//         $('#reload1').attr('style', 'text-align: center; right: -500px;');
//     } else {
//         $("#reload1").find("div:eq(0)").attr("style", "height:" + (height - 140) + "px;overflow: auto;margin: 20px 0")
//         $('#reload1').attr('style', 'text-align: center; right: 0px;height:' + (height - 50) + 'px');
//     }
//
// });
window.onload = function () {
    if (config.getUrlParam("mid")) {
        config.get_ajax(config.url() + "/HasViewbymoduleid", {
            data: {ModuleID: config.getUrlParam("mid")},
            success: function (res) {
                if (!res.data) {
                    location.href = "/home/tpl/qx.html";
                }
            }
        }, "HasViewbymoduleid");
    }
    if (!Array.prototype.indexOf) {
        Array.prototype.indexOf = function (elt /*, from*/) {
            var len = this.length >>> 0;
            var from = Number(arguments[1]) || 0;
            from = (from < 0) ? Math.ceil(from) : Math.floor(from);
            if (from < 0)
                from += len;
            for (; from < len; from++) {
                if (from in this &&
                    this[from] === elt)
                    return from;
            }
            return -1;
        };
    }
}

var sign = {
    signs: function (name) { //login请求头封装（新）
        signs = $.md5(getCookie('userID') + getCookie('token') + name.toLowerCase())
        return signs;
    }
}

