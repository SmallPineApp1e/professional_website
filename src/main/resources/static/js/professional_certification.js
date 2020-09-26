/**
 * @author Meng
 * @date 2019-07-11
 */
var TypeId = 18
var arr = new Array(18, 19, 20, 21);
$(document).ready(function () {
    TypeId = getTypeId();
    $.ajax({
        url: "/guest/content/" + TypeId,
        dataType: "JSON",
        Type: "GET",
        success: function (data) {
            if (data.code == 200) {
                var content = data.extended.content;
                build_content_information(content);
            }
        }
    });
});

function build_content_information(content) {
    $("#title").text(content.contentTitle);
    $("<object></object>").attr("data", content.content).attr("type", "application/pdf").attr("width", 500).attr("height", 600).appendTo($("#content"));
}

function checkId(id) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] == id) return true;
    }
    return false;
}

/**
 * 截取教师id
 */
function getTypeId() {
    var url = window.location.href;
    if (url.indexOf("?") == -1) {
        return 18;
    } else {
        var str = url.substring(url.indexOf("=") + 1);
        return parseInt(str);
    }
}