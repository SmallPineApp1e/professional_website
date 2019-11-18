var contentTypeId = 25;
var id;
$("#select").change(function () {
    $("#content").empty();
    var select = document.getElementById("select")
    var index = select.selectedIndex;
    contentTypeId = select.options[index].value;
    to_page(1);

})

function to_page(pn) {
    $.ajax({
        url: "/admin/content",
        data: {pn: pn, contentTypeId: contentTypeId},
        type: "GET",
        dataType: "JSON",
        success: function (data) {
            build_contents_table(data);
            build_page_info(data);
            build_page_nav(data);
        }
    });
}

function build_contents_table(data) {
    var contents = data.extended.pageinfo.list;
    $("#contents").empty();
    $.each(contents, function (index, item) {
        var contentTilte = $("<td align='left'></td>").append(item.contentTitle);
        var content = $("<td align='left'></td>").append(item.content);
        var uploadTime = $("<td align='left'></td>").append(item.uploadTime);
        var showbtn = $("<button></button>").addClass("btn btn-primary btn-lg ").append("查看");
        var deletebtn = $("<button></button>").addClass("btn btn-danger btn-lg ").append("删除");
        showbtn.click(function () {
            id=item.id;
            $("#showContentModal").modal({
                backdrop: "static"
            });
            $.ajax({
                url: "/admin/content/content/" + item.id,
                dataType: "JSON",
                success: function (data) {
                    build_content_detail_information(data);
                }
            })
        })
        deletebtn.click(function () {
            $.ajax({
                method:"POST",
                url: "/admin/content/" + item.id,
                data:{_method:"DELETE"},
                dataType: "JSON",
                success: function (data) {
                    if(data.code==200){
                        alert("删除成功");
                        window.location.reload();
                    }
                }
            })
        })
        $("<tr></tr>").append(contentTilte).append(content).append(uploadTime).append(showbtn).append(deletebtn).appendTo($("#contents"));
    })
}

function build_page_info(data) {
    $("#page_info_area").empty();
    $("#page_info_area").append("当前" + data.extended.pageinfo.pageNum + "页  " + "总" + data.extended.pageinfo.pages + "页   " + "总" + data.extended.pageinfo.total + "记录数");
}

function build_page_nav(data) {
    $("#page_info_nav").empty();
    var ul = $("<ul></ul>").addClass("pagination")
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
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#page_info_nav");
}

function build_content_detail_information(data) {
    console.log(data)
    var content = data.extended.content;
    console.log(content)
    $("#showContentTitle").val(content.contentTitle);
    $("#showContent").val(content.content);
    $("#showUploadTime").val(content.uploadTime);
}

$("#addContent").click(function () {
    $("#addContentModal").modal({
        backdrop: "static"
    });
})

function addContent() {
    var contentTitle=$("#contentTitle").val();
    var content=$("#content").val();
    $.ajax({
        method:"POST",
        url:"/admin/content/content",
        dataType:"JSON",
        data:{
            contentTitle:contentTitle,
            content:content,
            contentType:contentTypeId
        },
        success:function(data){
            if(data.code==200){
                alert("操作成功");
                window.location.reload();
            }
        }
    })
}

function updateContent() {
    var contentTitle = $("#showContentTitle").val();
    var content = $("#showContent").val();
    $.ajax({
        method: "POST",
        url: "/admin/content/",
        data: {
            _method: "PUT",
            contentTitle: contentTitle,
            content: content,
            id: id
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 200) {
                alert("更改成功");
                window.location.reload();
            }
        }
    })
}