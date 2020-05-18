/**
 * Created by tuz on 2020/5/13.
 */
function divtime() {
    document.getElementById("system_clock").innerText =  getTimeRecordStr();
}
window.onload = function () {
//利用定时器,动态刷新时间
    setInterval("divtime()",1000);
};
