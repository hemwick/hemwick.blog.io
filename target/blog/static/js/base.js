/**
 * 清除bootstrap模态窗的缓存
 */
$('.modal').on('hidden.bs.modal', function () {
    $(this).removeData('bs.modal');//清除数据
    $('form')[0].reset();//重置表单
    $('form :hidden').val('');
});
/**
 * 获取项目根路径
 * @returns {string} http://localhost:6589/Blog_war_exploded   注意最后没有[/]
 */
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/'+ webName;
}

/**
 * 退出登陆
 */
function logout() {
    if(confirm('确定退出本系统吗？')){
        $.getJSON(getRootPath()+'/logout',function (res) {
            if(res.code==1){
                location.replace(getRootPath()+'/admin/login.html');
            }
        });
    }
}

function show403() {
    alert('请先登录！');
    location.replace(getRootPath()+'/admin/login.html');
}

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}

function getUrlAnchor() {
    var url=window.location.href;
    return url.split('#')[1];
}

/**
 * 点击数
 * @param aid
 */
function addHits(aid) {
    $.post(getRootPath()+'/post/addHits',{aid:aid});
}