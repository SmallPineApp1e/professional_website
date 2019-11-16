$(function () {
    getData("卓越方案");
});

function getData(obj) {
    var url = null
    switch (obj) {
        case "卓越方案":
            url = "/guest/content/8";
            break;
        case "普通方案":
            url = "/guest/content/9";
            break;
    }
    $.ajax({
        url: url,
        type: "get",
        success:function (result) {
            var sidebarRight = $("#sidebar-right");
            sidebarRight.html('');
            var content = result.extended.content;
            var contentTitle = content.contentTitle;
            var contentDetail = content.content;
            var contentTitleDiv = $("<div class='title-right'></div>").append(contentTitle);
            var contentDetailDiv = $("<div class='content'></div>");
            var pdf = $("<object type='application/pdf' width='550px' height='700'></object>");
            pdf.attr("data",contentDetail);
            contentDetailDiv.append(pdf);
            sidebarRight.append(contentTitleDiv);
            sidebarRight.append(contentDetailDiv);
        },
        error:function (result) {
            alert("请求失败!请重新尝试!");
        }
    })
}
