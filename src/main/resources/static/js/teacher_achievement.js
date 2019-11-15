var TypeId=29
$(document).ready(function () {
    TypeId = getTypeId();
    $.ajax({
        url: "/guest/content/" + TypeId,
        dataType: "JSON",
        Type: "GET",
        success: function (data) {
            console.log(data);
            if (data.code == 200) {
                var content = data.extended.content;
                    build_content_information(content);
            }
        }
    });
});

function build_content_information(content){
    $("#title").text(content.contentTitle);
    $("<object></object>").attr("data",content.content).attr("type","application/pdf").attr("width",500).attr("height",600).appendTo($("#content"));
}

/**
 * 截取教师id
 */
function getTypeId() {
    var url = window.location.href;
    if (url.indexOf("?") == -1) {
        return 29;
    } else {
        var str = url.substring(url.indexOf("=") + 1);
        return parseInt(str);
    }
}