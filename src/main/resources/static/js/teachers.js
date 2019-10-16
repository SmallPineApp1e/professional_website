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

function to_page(pn) {
    $.ajax({
        url: "/teacher/teacher",
        data: {pn: pn},
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

function build_teachers_table(data) {
    //清空table
    $("#teachers").empty();
    var members = data.extended.pageinfo.list;
    $.each(members, function (index, item) {
        var teacherName = $("<td></td>").append(item.teacherName);
        var teacherEmail = $("<td></td>").append(item.teacherEmail);
        var teacherPosition = $("<td></td>").append(item.teacherPosition);
        var teacherGraduation = $("<td></td>").append(item.teacherGraduation);
        var showbtn = $("<button></button>").addClass("btn btn-primary btn-lg active").append("查看");
        showbtn.click(function () {
            $("#showTeacherModal").modal({
                backdrop: "static"
            });
            $.ajax({
                url:"/teacher/"+item.teacherId,
                dataType:"JSON",
                success:function(data){
                    build_teacher_detail_information(data);
                }
            })
        })
        $("<tr></tr>").append(teacherName).append(teacherEmail).append(teacherPosition).append(teacherGraduation).append(showbtn).appendTo($("#teachers"));
    });
}

/**
 * 构建查看老师的详细信息
 * @param data
 */
function build_teacher_detail_information(data){
    console.log(data);
    var teacher=data.extended.teacher;
    $("#showTeacherName").val(teacher.teacherName);
    $("#showTeacherJob").val(teacher.teacherJob);
    $("#showTeacherPosition").val(teacher.teacherPosition);
    $("#showTeacherResearch").val(teacher.teacherResearch);
    $("#showTeacherScientificResearch").val(teacher.teacherScientificResearch);
    $("#showTeacherGraduation").val(teacher.teacherGraduation);
    $("#showTeacherEmail").val(teacher.teacherEmail);
    $("#showTeacherBorn").val(teacher.teacherBorn);
    $("#showTeacherGraduation").val(teacher.teacherGraduation);

    $("#showTeacherAwardIntroduction").text(teacher.teacherAwardIntroduction);
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

var totalBackgrounds = 1;

/**
 * 点击按钮后新增教育背景填写框
 */
function insertNewBackground() {

    var startTimeInput = $("<input class=\"time\" type=\"date\" value=\"2015-09-24\" onfocus=\"reverse(this)\">");
    startTimeInput.attr("id", "backgroundStartTime" + totalBackgrounds);
    var endTimeInput = $("<input class=\"time\" type=\"date\" value=\"2015-09-24\" onfocus=\"reverse(this)\">");
    endTimeInput.attr("id", "backgroundEndTime" + totalBackgrounds);
    var graduateText = $("<div>毕业院校</div>");
    var backgroundContent = $("<input class=\"backgroundContent\" type=\"text\" onblur=\"notnull(this)\" onfocus=\"reverse(this)\">")
    backgroundContent.attr("id", "backgroundContent" + totalBackgrounds);
    var helpBlock = $("<span class=\"help-block\"></span>");
    var area = $("<div></div>");
    var areaId = "area" + totalBackgrounds;
    area.attr("id", areaId);
    area.append("起始时间", startTimeInput, "结束时间", endTimeInput, graduateText, backgroundContent, helpBlock);
    $("#teacherBackgroundInputArea").append(area);
    totalBackgrounds += 1;
}

/**
 * 点击按钮后删除教育背景填写框
 */
function delNewBackground() {
    if (totalBackgrounds === 1) {
        alert("至少要填写一项您的教育背景！");
        return;
    }
    var areaId = "#area" + (totalBackgrounds - 1);
    $(areaId).remove();
    totalBackgrounds -= 1;
}

/**
 * 添加教师
 */
function addTeacher() {
    var x = notnull($("#teacherName")) && notnull($("#teacherAwardIntroduction")) && notnull($("#teacherBorn")) && notnull($("#teacherEmail")) && notnull($("#teacherGraduation")) && notnull($("#teacherJob")) && notnull($("#teacherPosition")) && notnull($("#teacherResearch")) && notnull($("#teacherScientificResearch"));
    if (!x) {
        alert("请正确填写资料");
        return;
    }
    var checkteacherBackground = true;
    var teacherBackgroundsArray = new Array(totalBackgrounds);
    for (var index = 0; index < teacherBackgroundsArray.length; index++) {
        var backgroundStartTimeId = "#backgroundStartTime" + index;
        var backgroundEndTimeId = "#backgroundEndTime" + index;
        var backgroundContentId = "#backgroundContent" + index;
        var background = {
            backgroundStartTime: $(backgroundStartTimeId).val(),
            backgroundEndTime: $(backgroundEndTimeId).val(),
            backgroundContent: $(backgroundContentId).val()
        };
        teacherBackgroundsArray[index] = background;
        checkteacherBackground = checkteacherBackground && notnull($(backgroundStartTimeId)) && notnull($(backgroundEndTimeId)) && notnull($(backgroundContentId));
    }
    if (!checkteacherBackground) {
        alert("请正确填写资料");
        return;
    }
    var data = {
        teacherName: $("#teacherName").val(),
        teacherEmail: $("#teacherEmail").val(),
        teacherBorn: $("#teacherBorn").val(),
        teacherJob: $("#teacherJob").val(),
        teacherGraduation: $("#teacherGraduation").val(),
        teacherPosition: $("#teacherPosition").val(),
        teacherResearch: $("#teacherResearch").val(),
        teacherScientificResearch: $("#teacherScientificResearch").val(),
        teacherAwardIntroduction: $("#teacherAwardIntroduction").val(),
        teachBackgrounds: teacherBackgroundsArray
    }
    $.ajax({
        method: "POST",
        url: "/teacher",
        dataType: "JSON",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result) {
            alert(result.msg);
            window.location.reload();
        },
        error: function (result) {
            alert(result.msg);
        }
    })
}
