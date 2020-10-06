$(function () {
    getData("双一流专业制度建设");
});

function getData(obj) {
    var url = "/guest/professionalBuilding";
    var data = null;
    switch (obj) {
        case "双一流专业制度建设":
            data = {contentTypeId:"4"};
            break;
        case "双一流专业建设成果":
            data = {contentTypeId:"5"};
            break;
        case "特色专业登记书":
            data = {contentTypeId:"2"};
            break;
        case "特色专业实证材料":
            data = {contentTypeId:"3"};
            break;
        case "特色专业申报书":
            data = {contentTypeId:"49"};
            break;
    }
    $.ajax({
        url: url,
        type: "get",
        data: data,
        success:function (result) {
            var sidebarRight = $("#sidebar-right");
            sidebarRight.html('');
            var content = result.extended.contents[0];
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