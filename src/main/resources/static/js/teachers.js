/**
 * @author Meng
 * @date 2019-10-14
 */

var teacherId;
/**
 * 获取登录的教师id
 */
$(document).ready(function () {
    $.ajax({
        url: "/teacher/getTeacherId",
        type: "GET",
        success: function (data) {
            console.log(data);
            if (data.code == 200) {
                teacherId = data.extended.teacherId;
                build_icon(teacherId);
                to_page(1);
            }
        }
    });
})

function to_page(pn){
    $.ajax({
        url: "/teacher/teacher",
        data:{pn:pn},
        type: "GET",
        dataType: "JSON",
        success: function (data) {
            console.log(data);
            build_teachers_table(data);
            build_page_info(data);
            build_page_nav(data);
        }
    });
}

function build_page_info(data){
    $("#page_info_area").empty();
    $("#page_info_area").append("当前" + data.extended.pageinfo.pageNum + "页  " + "总" + data.extended.pageinfo.pages + "页   " + "总" + data.extended.pageinfo.total + "记录数");
}

function build_page_nav(data){
    $("#page_info_nav").empty();
    var ul = $("<ul></ul>").addClass("pagination")
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
    var prePageLi = $("<li></li>").append($("<a></a>").append("前一页").append("&laquo;"));
    if (data.extended.pageinfo.hasPreviousPage == false) {
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    }
    else {
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
    }
    else {
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

function build_teachers_table(data){
    //清空table
    $("#teachers").empty();
    var members = data.extended.pageinfo.list;
    $.each(members, function (index, item) {
        var teacherName = $("<td></td>").append(item.teacherName);
        var teacherEmail = $("<td></td>").append(item.teacherEmail);
        var teacherPosition=$("<td></td>").append(item.teacherPosition);
        var teacherGraduation = $("<td></td>").append(item.teacherGraduation);
        var showbtn = $("<button></button>").addClass("btn btn-primary btn-lg active").append("查看");
        $("<tr></tr>").append(teacherName).append(teacherEmail).append(teacherPosition).append(teacherGraduation).append(showbtn).appendTo($("#teachers"));
    });
}

$("#addTeacher").click(function () {
    $("#addTeacherModal").modal({
        backdrop: "static"
    });
})

/**
 * 文本框的非空校验
 */
function notnull(node) {
    if ($(node).val() == "") {
        $(node).parent().parent().addClass("has-error");
        $(node).next("span").text("不可以为空");
        return false;
    } else {
        return true;
    }

}

/**
 * 获取焦点后恢复正常
 * @param node
 */

function reverse(node) {
    $(node).parent().parent().removeClass("has-error");
    $(node).next("span").text("");
}
$("#addTeacherBtn").click(function(){

})