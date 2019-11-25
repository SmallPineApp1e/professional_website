var teacherId;
$(function () {
    $.ajax({
        url: "/teacher/getTeacherId",
        type: "GET",
        success: function (data) {
            if (data.code == 200) {
                teacherId = data.extended.teacherId;
                build_icon(teacherId);
            }
        }
    });
    $.ajax({
        url: "/admin/findAllCourses",
        type: "get",
        success:function (result) {
            var courseArea = $("#course");
            var courses = result.extended.courses;
            $.each(courses, function (index, course) {
                var option = $("<option></option>");
                option.attr("value", course.courseId);
                option.html(course.courseName);
                courseArea.append(option);
            })
        },
        error:function (result) {
            alert("服务异常!请重试!");
        }
    });
    $.ajax({
        url: "/admin/findContentType",
        type: "get",
        success:function (result) {
            var contentTypeArea = $("#contentTypeArea");
            var types = result.extended.types;
            $.each(types, function (index, type) {
                var option = $("<option></option>");
                option.attr("value", type.id);
                option.html(type.name);
                contentTypeArea.append(option);
            })
        },
        error:function (result) {
            alert("服务异常!请重试!");
        }
    })
});

function findData() {
    var contentTypeId = document.getElementById("contentTypeArea");
    var index = contentTypeId.selectedIndex;
    var contentTypeValue = contentTypeId.options[index].value;
    var course = document.getElementById("course");
    index = course.selectedIndex;
    var courseId = course.options[index].value;

    $.ajax({
        url: "/admin/findByCourIdAndTypeId",
        data: {"courseId":courseId,"contentTypeId":contentTypeValue},
        success:function (result) {
            var coursewares = result.extended.coursewares;
            var detailArea = $("#detailArea");
            detailArea.html('');
            if(contentTypeValue === "11"){
                //授课计划,PDF形式展现
                var courseware = coursewares[0];
                var pdf = $("<object type='application/pdf' width='500px' height='600px'></object>");
                pdf.attr("data", courseware.coursewareLoc);
                detailArea.append(pdf);
                return ;
            }else{
                //找PPT
                $.each(coursewares,function (index, courseware) {
                    var a_label = $("<a></a>");
                    var coursewareLoc = courseware.coursewareLoc;
                    a_label.attr("href", coursewareLoc);
                    a_label.attr("download", coursewareLoc.slice(coursewareLoc.lastIndexOf("/")+1,coursewareLoc.lastIndexOf(".")));
                    a_label.html(coursewareLoc.slice(coursewareLoc.lastIndexOf("/")+1,coursewareLoc.lastIndexOf(".")));
                    var delete_btn = $("<button>删除</button>");
                    delete_btn.attr("onclick", "deleteCourseware("+courseware.coursewareId+")");
                    detailArea.append(a_label);
                    detailArea.append(delete_btn);
                    detailArea.append($("<br/>"))
                });
                return ;
            }
        },
        error:function (result) {
            alert("服务异常!请重试!");
        }
    });
}

function deleteCourseware(obj){
    $.ajax({
        url: "/admin/course/deletePowerpoint",
        type:"delete",
        data:{"coursewareId":obj},
        success:function (result) {
            alert(result.msg);
            window.location.reload();
        },
        error:function (result) {
            alert("服务异常,请重试!")
        }
    })
}

function uploadFile() {
    var contentTypeId = document.getElementById("contentTypeArea");
    var index = contentTypeId.selectedIndex;
    var contentTypeValue = contentTypeId.options[index].value;
    var course = document.getElementById("course");
    index = course.selectedIndex;
    var courseId = course.options[index].value;
    var formdata = new FormData();
    formdata.append("contentTypeId", contentTypeValue);
    formdata.append("courseId", courseId);
    var files = document.getElementById("files").files;
    if(contentTypeValue == "13"){
        //上传PPT
        $.each(files, function(i, file){
            formdata.append('files', file);
        });
        formdata.append("files[]", files);
        $.ajax({
            url:"/admin/course/ppt",
            type:"POST",
            traditional:true,
            data:formdata,
            dataType:"JSON",
            async:false,
            processData:false,
            contentType:false,
            success:function(data){
                if(data.code==200){
                    alert("提交成功");
                    window.location.reload();
                }
            },
            error:function (result) {
                alert("服务异常！请稍候再试！");
            }
        })
    }else{
        //上传授课计划
        formdata.append("file", files[0]);
        $.ajax({
            url:"/admin/course/pdf",
            type:"POST",
            data:formdata,
            dataType:"JSON",
            async:false,
            processData:false,
            contentType:false,
            success:function(data){
                if(data.code==200){
                    alert("提交成功");
                    window.location.reload();
                }
            },
            error:function (result) {
                alert("服务异常！请稍候再试！");
            }
        })
    }
}