/**
 * @Author Meng
    * 定时器
    */
window.onload = function () {
    setInterval(function () {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getUTCDate();
        var week = convertweek(date.getUTCDay());
        var hour = date.getHours();
        var minute = date.getMinutes();
        var second = convertsecond(date.getSeconds() + "");
        var time = document.getElementById("time");
        time.innerHTML = year + "年" + month + "月" + day + "日星期" + week + " " + hour + ":" + minute +
            ":" + second;
    }, 1000);

}
/**
 * 秒数的转换
 */
function convertsecond(second) {
    second = second.length < 2 ? '0' + second : second;
    return second;
}

/**
 * 对星期的转换
 */
function convertweek(week) {
    switch (week) {
        case 0:
            week = "一";
            break;
        case 1:
            week = "二";
            break;
        case 2:
            week = "三";
            break;
        case 3:
            week = "四";
            break;
        case 4:
            week = "五";
            break;
        case 5:
            week = "六";
            break;
        case 6:
            week = "日"
            break;
    };
    return week;
}

