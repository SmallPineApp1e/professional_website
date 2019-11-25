/**
 * @author Meng
 * @date 2019-06-27
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
            if (data.code == 200) {
                teacherId = data.extended.teacherId;
                build_icon(teacherId);
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

                $("#teacherAwardIntroduction").text(teacher.teacherAwardIntroduction);

                $.each(teacher.teachBackgrounds, function (index, item) {
                    //叉叉
                    var closebtn = $("<button type='button'  style=color:red; class='close' aria-albel='Close'></button>").append("&times;");
                    //绑定事件
                    closebtn.click(function () {
                        if (!confirm("你确认要删除此背景吗")) {
                            return false;
                        }
                        else {
                            $.ajax({
                                url: "/teacher/teachBack/" + item.backgroundId,
                                type: 'POST',
                                data: { _method: "DELETE" },
                                success: function (data) {
                                    if (data.code == 200) {
                                        window.location.reload();
                                    }
                                }
                            });
                        }
                    });
                    //如果不是不会前端，谁会这么写呢，哭了
                    var div = $("<div style=clear:both></div>")
                    $("<li style=float:left></li>").append(item.backgroundStartTime + "-" + item.backgroundEndTime + " " + item.backgroundContent).append(closebtn).appendTo($("#teachBackgrounds"));
                    div.appendTo($("#teachBackgrounds"));
                });
                $.each(teacher.awards, function (index, item) {
                    //叉叉
                    var closebtn = $("<button type='button' style=color:red;   class='close' aria-albel='Close'></button>").append("&times;");
                    //绑定事件
                    closebtn.click(function () {
                        if (!confirm("你确认要删除此获奖吗")) {
                            return false;
                        }
                        else {
                            $.ajax({
                                url: "/teacher/award/" + item.awardsId,
                                type: 'POST',
                                data: { _method: "DELETE" },
                                success: function (data) {
                                    if (data.code == 200) {
                                        window.location.reload();
                                    }
                                }
                            });
                        }
                    });
                    //如果不是不会前端，谁会这么写呢，哭了
                    var div = $("<div style=clear:both></div>");
                    $("<li  style=float:left></li>").append(item.awardsName + "," + item.awardsTime).append(closebtn).appendTo($("#awards"));
                    div.appendTo($("#awards"));
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
    /**
     * 添加背景
     */
    $("#addbackground").click(function () {
        var x = notnull($("#backgroundContent")) && notnull($("#backgroundStartTime")) && notnull($("#backgroundEndTime"));
        if (!x) {
            alert("文本框不可以为空");
        }
        else {
            var backgroundStartTime = $("#backgroundStartTime").val();
            var backgroundEndTime = $("#backgroundEndTime").val();
            var backgroundContent = $("#backgroundContent").val();
            $.ajax({
                url: "/teacher/teachBack",
                type: "POST",
                dataType: "JSON",
                data: { backgroundStartTime: backgroundStartTime, backgroundEndTime: backgroundEndTime, backgroundContent: backgroundContent, teacherId: teacherId },
                success: function (data) {
                    if (data.code == 200) {
                        window.location.reload();
                    }
                }
            })
        }
    });
});

/**
 * 添加获奖情况模态框
 */
$("#addteachAwards").click(function () {
    $("#AwardModal").modal({
        backdrop: "static"
    });

    /**
     * 添加获奖情况
     */
    $("#addaward").click(function () {
        var x = notnull($("#awardsTime")) && notnull($("#awardsName"));
        if (!x) {
            alert("文本框不可以为空");
        }
        else {
            var awardsTime = format($("#awardsTime").val());
            var awardsName = $("#awardsName").val();
            $.ajax({
                url: "/teacher/award",
                type: "POST",
                dataType: "JSON",
                data: { awardsTime: awardsTime, awardsName: awardsName, teacherId: teacherId },
                success: function (data) {
                    if (data.code == 200) {
                        window.location.reload();
                    }
                }
            })
        }
    });

})

/**
 * 修改头像模态框
 */
$("#updateteacherImg").click(function () {
    $("#TeacherImgModal").modal({
        backdrop: "static"
    });
    $("#updateImg").click(function(){
        var img=document.getElementById("file").files[0];
        var formdata=new FormData();
        formdata.append("img",img);
        formdata.append("teacherId",teacherId);
        formdata.append("_method","PUT");
        $.ajax({
            url:"/teacher/icon/"+teacherId,
            type:"POST",
            dataType:"JSON",
            data:formdata,
            async: false,
            processData: false,
            contentType: false,
            success:function(data){
                if(data.code==200){
                    window.location.reload();
                }
            }
        });
    })

});

/**
 * 格式化时间
 * @param str
 */
function format(str) {
    var index = str.indexOf("-");
    return str.substring(0, index);
}

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
        var teacherAwardIntroduction = $("#teacherAwardIntroduction").val();
        var teacherBorn = $("#teacherBorn").val();
        var teacherEmail = $("#teacherEmail").val();
        var teacherGraduation = $("#teacherGraduation").val();
        var teacherJob = $("#teacherJob").val();
        var teacherName = $("#teacherName").val();
        var teacherPosition = $("#teacherPosition").val();
        var teacherResearch = $("#teacherResearch").val();
        var teacherScientificResearch = $("#teacherScientificResearch").val();
        $.ajax({
            url: "/teacher/" + teacherId,
            dataType: "JSON",
            type: "POST",
            data: {
                _method: "PUT",
                teacherId: teacherId,
                teacherAwardIntroduction: teacherAwardIntroduction,
                teacherBorn: teacherBorn,
                teacherEmail: teacherEmail,
                teacherGraduation: teacherGraduation,
                teacherJob: teacherJob,
                teacherName: teacherName,
                teacherPosition: teacherPosition,
                teacherResearch: teacherResearch,
                teacherScientificResearch: teacherScientificResearch,
            },
            success: function (data) {
                if (data.code == 200) {
                    window.location.reload();
                }
            }
        });
    }
});

/**
 * 退出登录
 */
$("#signout").click(function () {
    $.ajax({
        url:"/teacher/logout",
        dataType:"JSON",
        type:"POST",
        success:function(data){
            if(data.code==200){
                window.location.href="/html/login.html"
            }
        }
    });
})

/**
 * 图片的预览
 */
ofReader=new FileReader();
ofReader.onload=function(oFREvent){
    document.getElementById("img").src=oFREvent.target.result;
};

function loadImageFile(){
    if(document.getElementById("file").files.length==0){
        alert("请选择照片");
        return;
    }
    if(document.getElementById("file").files[0].size>5242800){
        alert("上传的图片不能大于5M");
        return;
    }
    var oFile=document.getElementById("file").files[0];
    ofReader.readAsDataURL(oFile);
}
