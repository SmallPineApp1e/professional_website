/**
 * @Author Meng
 *
 */
var id = 74;
$(document).ready(function () {
    id=getContentId();
    $.ajax({
        url:"/guest/content",
        data:{id:id},
        method:"get",
        dataType:"JSON",
        success:function(data){
            if(data.code==200){
                var content=data.extended.content;
                build_information(content);
            }
        }
    })
})

/**
 * 截取内容id
 */
function getContentId() {
    var url = window.location.href;
    if (url.indexOf("?") == -1) {
        return 74;
    } else {
        var str = url.substring(url.indexOf("=") + 1);
        return parseInt(str);
    }
}

function build_information(content){
    $("#contentTitle").text(content.contentTitle);
    $("#uploadTime").text(content.uploadTime);
    $('#content').text(content.content);
}