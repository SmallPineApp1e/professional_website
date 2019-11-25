/**
 * @author Meng
 * @date 2019-6-29
 */
var teacherId;
$(document).ready(function () {
    teacherId = getteacherId();
    $.ajax({
        url: "/guest/teacherInfo/" + teacherId,
        dataType: "JSON",
        Type: "GET",
        success: function (data) {
            if (data.code == 200) {
                var teacher = data.extended.teacher;
                if (teacher == null) {
                    window.location.href = "/html/teacher.html";
                } else {
                    build_teacher_information(teacher);
                    build_teacher_backgrounds(teacher.teachBackgrounds);
                    build_teacher_awards(teacher.awards);
                }
            }
        },
        error: function () {
            window.location.href = "/html/teacher.html";
        }
    });
});

/**
 * 截取教师id
 */
function getteacherId() {
    var url = window.location.href;
    if (url.indexOf("?") == -1) {
        return 1;
    } else {
        var str = url.substring(url.indexOf("=") + 1);
        return parseInt(str);
    }
}

/**
 * 构建教师信息
 * @param teacher
 */
function build_teacher_information(teacher) {

    $("#teacherAwardIntroduction").prepend(teacher.teacherAwardIntroduction);
    $("#teacherBorn").text("出生地 : " + teacher.teacherBorn);
    $("#teacherEmail").text("邮箱 : " + teacher.teacherEmail);
    $("#teacherGraduation").text("毕业院校 : " + teacher.teacherGraduation);
    $("#teacherJob").text("职业 : " + teacher.teacherJob);
    $("#teacherName").text(teacher.teacherName);
    $("#teacherPosition").text(" - 职称:" + teacher.teacherPosition);
    $("#teacherResearch").text(teacher.teacherResearch);
    $("#teacherScientificResearch").text(teacher.teacherScientificResearch);
    $("#teacherImg").attr("src",teacher.teacherImg);
}

/**
 * 构建教师背景
 * @param backgrounds
 */
function build_teacher_backgrounds(backgrounds) {
    $.each(backgrounds, function (index, item) {
        var backgroundStartTime = (item.backgroundStartTime).replace("-", ".");
        var backgroundEndTime = (item.backgroundEndTime).replace("-", ".");
        var backgroundContent = item.backgroundContent;
        $("<li></li>").text(backgroundStartTime + "-" + backgroundEndTime + " " + backgroundContent).appendTo($("#teacherBackgrounds"));
    });
}

/**
 * 构建获奖信息
 * @param awards
 */
function build_teacher_awards(awards) {
    $.each(awards,function(index,item){
       $("<li></li>").append(item.awardsName+", "+item.awardsTime).appendTo($("#awards"));
    });
}
