/**
 * @Author Meng
 */
var contentTypeId=25;
$(document).ready(function(){
    to_page(1);
})

function to_page(pn){
    contentTypeId=getContentTypeId();
    $.ajax({
        url:"/guest/contents",
        data:{contentTypeId:contentTypeId,pn:pn},
        success:function(data){
            build_category(data);
            build_page_info(data);
            build_page_nav(data);
        }
    })
}

function build_category(data) {
    $("#content").empty();
    var contents=data.extended.pageinfo.list;
    $.each(contents,function(index,item){
        var tr=$("<tr></tr>");
        var a=$("<a></a>").attr("href","content.html?id="+item.id).text(item.contentTitle);
        var td=$("<td align='left'></td>").append(a);
        var td1=$("<td align='right'></td>").text(item.uploadTime);
        tr.append(td).append(td1).appendTo($("#content"));
    })
}

/**
 * 截取内容类型id
 */
function getContentTypeId() {
    var url = window.location.href;
    if (url.indexOf("?") == -1) {
        return 25;
    } else {
        var str = url.substring(url.indexOf("=") + 1);
        if(str!=25&&str!=26&&str!=27){
            str=25;
            return parseInt(str);
        }
        return parseInt(str);
    }
}

function build_page_info(data) {
    $("#page_info_area").empty();
    $("#page_info_area").append("当前" + data.extended.pageinfo.pageNum + "页  " + "总" + data.extended.pageinfo.pages + "页   " + "总" + data.extended.pageinfo.total + "记录数");
}

function build_page_nav(data) {
    $("#page_info_nav").empty();
    var ul = $("<ul id='pagination'></ul>").addClass("pagination");
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
    var prePageLi = $("<li></li>").append($("<a></a>").append("前一页").append("&laquo;"));
    if (data.extended.pageinfo.hasPreviousPage == false) {
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    } else {
        firstPageLi.click(function () {
            to_page(1);
        });
        prePageLi.click(function () {
            to_page(data.extended.pageinfo.pageNum - 1);
        });
    }
    var nextPaegLi = $("<li></li>").append($("<a></a>").append("后一页").append("&raquo;"));
    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
    if (data.extended.pageinfo.hasNextPage == false) {
        nextPaegLi.addClass("disabled");
        lastPageLi.addClass("disabled");
    } else {
        nextPaegLi.click(function () {
            to_page(data.extended.pageinfo.pageNum + 1);
        });
        lastPageLi.click(function () {
            to_page(data.extended.pageinfo.pages);
        });
    }
    ul.append(firstPageLi).append(prePageLi);
    $.each(data.extended.pageinfo.navigatepageNums, function (index, item) {
        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if (data.extended.pageinfo.pageNum == item) {
            numLi.addClass("active");
        }
        numLi.click(function () {
            to_page(item);
        });
        ul.append(numLi);
    })
    ul.append(nextPaegLi).append(lastPageLi);
    var navEle = $("<nav aria-label='Page navigation'></nav>").append(ul);
    navEle.appendTo("#page_info_nav");
}