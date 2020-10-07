$(function () {
    initData();
});
function initData() {
    var url = window.location.href;
    if (url.indexOf("?") !== -1) {
        $.ajax({
            url: "/guest/professionalProfile",
            type: "get",
            success: function (result) {
                var ul = $("#sidebar-left-ul");
                var contents = result.extended.contents;
                $.each(contents, function (index, content) {
                    var contentTitle = content.contentTitle;
                    var a = $("<a href='/html/professional_profile.html'></a>").append(contentTitle);
                    var li = $("<li></li>").append(a);
                    ul.append(li);
                })
                ul.append($("<li><a href='#'>培养效果</a></li>"))
            }
        });
        $.ajax({
            url: "/guest/content/" + 48,
            dataType: "JSON",
            Type: "GET",
            success: function (data) {
                if (data.code == 200) {
                    var content = data.extended.content;
                    build_content_information(content);
                }
            }
        });
    }else {
        $.ajax({
            url: "/guest/professionalProfile",
            type: "get",
            success: function (result) {
                var ul = $("#sidebar-left-ul");
                var sidebarRight = $("#sidebar-right");
                var contents = result.extended.contents;
                $.each(contents, function (index, content) {
                    var contentTitle = content.contentTitle;
                    var contentDetail = content.content;
                    var a = $("<a href='/html/professional_profile.html'></a>").append(contentTitle);
                    var li = $("<li></li>").append(a);
                    ul.append(li);
                    var titleRightDiv = $("<div class='title-right'></div>");
                    var contentTitleStrong = $("<strong></strong>").append(contentTitle);
                    titleRightDiv.append(contentTitleStrong);
                    sidebarRight.append(titleRightDiv);
                    var contentDetailDiv = $("<div class='content'></div>");
                    if (contentTitle == "历史沿革") {
                        contentDetailDiv.append($("<img src='../static/img/发展历程.jpg' style='width: 530px'>"))
                    }
                    contentDetailDiv.append(contentDetail);
                    sidebarRight.append(contentDetailDiv);
                    sidebarRight.append("<br/>");
                })
                ul.append($("<li><a href='/html/professional_profile.html?typeId=48'>培养效果</a></li>"))
            }
        });
    }
};


function build_content_information(content) {
    $("#sidebar-right").empty();
    $("#title").text(content.contentTitle);
    $("<object></object>").attr("data", content.content).attr("type", "application/pdf").attr("width", 500).attr("height", 600).appendTo($("#sidebar-right"));
}