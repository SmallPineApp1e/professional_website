$(function () {
    initData();
});
function initData() {
    $.ajax({
        url: "/guest/professionalProfile",
        type:"get",
        success:function (result) {
            var ul = $("#sidebar-left-ul");
            var sidebarRight = $("#sidebar-right");
            var contents = result.extended.contents;
            $.each(contents, function (index, content) {
                var contentTitle = content.contentTitle;
                var contentDetail = content.content;
                var a = $("<a href='#'></a>").append(contentTitle);
                var li = $("<li></li>").append(a);
                ul.append(li);
                var titleRightDiv = $("<div class='title-right'></div>");
                var contentTitleStrong = $("<strong></strong>").append(contentTitle);
                titleRightDiv.append(contentTitleStrong);
                sidebarRight.append(titleRightDiv);
                var contentDetailDiv = $("<div class='content'></div>").append(contentDetail);
                sidebarRight.append(contentDetailDiv);
                sidebarRight.append("<br/>");
            })
        }
    });
};