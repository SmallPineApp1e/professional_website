/**
 * @author Meng
 * @date 2019-06-27
 */

var teacherId;
$(document).ready(function () {
    $.ajax({
        url: "/teacher/getTeacherId",
        type: "GET",
        success: function (data) {
            console.log(data);
            if (data.code == 200) {
                teacherId = data.extended.teacherId;
                build_information(teacherId);
            }
        }
    });
});

/**
 * 获取教师详细信息
 * @param id
 */
function build_information(id) {
    $.ajax({
        url: "/teacher/" + id,
        dataType: "JSON",
        success: function (data) {
            console.log(data);
            var teacher = data.extended.teacher;
            if (data.code == 200) {
                $("#teacherName").val(teacher.teacherName);
                $("#teacherJob").val(teacher.teacherJob);
                $("#teacherPosition").val(teacher.teacherPosition);
                $("#teacherResearch").val(teacher.teacherResearch);
                $("#teacherScientificResearch").val(teacher.teacherScientificResearch);
                $("#teacherGraduation").val(teacher.teacherGraduation);
                $("#teacherEmail").val(teacher.teacherEmail);
                $("#teacherBorn").val(teacher.teacherBorn);
                $("#teacherGraduation").val(teacher.teacherGraduation);
                $("#loginname").text(teacher.teacherName);
                $("#teacherAwardIntroduction").text(teacher.teacherAwardIntroduction);
                $.each(teacher.teachBackgrounds, function (index, item) {
                    $("<li></li>").append(item.backgroundStartTime + "-" + item.backgroundEndTime + " " + item.backgroundContent).appendTo($("#teachBackgrounds"))
                });
                $.each(teacher.awards, function (index, item) {
                    $("<li></li>").append(item.awardsName + "," + item.awardsTime).appendTo($("#awards"));
                });
            }
        },
    });
}

/**
 * 添加教育背景的模态框
 */
$("#addteachBackgrounds").click(function () {
    $("#BackgroundModal").modal({
        backdrop: "static"
    });
});

/**
 * 添加获奖情况模态框
 */
$("#addteachAwards").click(function () {
    $("#AwardModal").modal({
        backdrop: "static"
    });
})

/**
 * 文本框的非空校验
 */
function notnull(node) {
    if ($(node).val() == "") {
        $(node).parent().addClass("has-error");
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
    $(node).parent().removeClass("has-error");
    $(node).next("span").text("");
}


/**
 * 修改资料
 */
$("#updateinformation").click(function updateinformation() {
    var x = notnull($("#teacherName")) && notnull($("#teacherAwardIntroduction")) && notnull($("#teacherName")) && notnull($("#teacherBorn")) && notnull($("#teacherName")) && notnull($("#teacherEmail")) && notnull($("#teacherName")) && notnull($("#teacherGraduation")) && notnull($("#teacherName")) && notnull($("#teacherId")) && notnull($("#teacherJob")) && notnull($("#teacherPosition")) && notnull($("#teacherName")) && notnull($("#teacherResearch")) && notnull($("#teacherScientificResearch"));
    if (!x) {
        alert("文本框不可以为空");
    } else {
        var teacherAwardIntroduction=$("#teacherAwardIntroduction").val();
        var teacherBorn=$("#teacherBorn").val();
        var teacherEmail=$("#teacherEmail").val();
        var teacherGraduation=$("#teacherGraduation").val();
        var teacherJob=$("#teacherJob").val();
        var teacherName=$("#teacherName").val();
        var teacherPosition=$("#teacherPosition").val();
        var teacherResearch=$("#teacherResearch").val();
        var teacherScientificResearch=$("#teacherScientificResearch").val();
        $.ajax({
            url:"/teacher/"+teacherId,
            dataType:"JSON",
            type:"POST",
            data:{_method:"PUT",
                teacherId:teacherId,
                teacherAwardIntroduction:teacherAwardIntroduction,
                teacherBorn:teacherBorn,
                teacherEmail:teacherEmail,
                teacherGraduation:teacherGraduation,
                teacherJob:teacherJob,
                teacherName:teacherName,
                teacherPosition:teacherPosition,
                teacherResearch:teacherResearch,
                teacherScientificResearch:teacherScientificResearch,
            },
            success:function(data){
                if(data.code==200){
                    window.location.reload();
                }
            }
        });
    }
});