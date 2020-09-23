//不用展示课件了
// function getTypeId() {
//     var url = window.location.href;
//     if (url.indexOf("?") == -1) {
//         return 42;
//     } else {
//         var str = url.substring(url.indexOf("=") + 1);
//         return parseInt(str);
//     }
// };
//
// $(function () {
//     getCourses();
//     var typeId = getTypeId();
//     if(typeId  == 42){
//         getTeachingProgram(typeId);
//     }else{
//         getCoursewareOrTeachingPlan(typeId,"2");
//     }
// });
//
// function getCourses() {
//     $.ajax({
//         url:"/guest/courses",
//         success:function (result) {
//             var teachPlanCourses = $("#teachPlanCourses");
//             var coursewareCourses = $("#coursewareCourses");
//             var greatCourses = $("#greatCourses");
//             var courses = result.extended.courses;
//             $.each(courses, function (index, course) {
//                 var courseName = course.courseName;
//                 var a_label = $("<a href='#' onclick='getCoursewareOrTeachingPlan(11,\""+(course.courseId)+"\")'></a>").append(courseName);
//                 li = $("<li></li>").append(a_label);
//                 teachPlanCourses.append(li);
//                 a_label = $("<a href='#' onclick='getCoursewareOrTeachingPlan(13,\""+(course.courseId)+"\")'></a>").append(courseName);
//                 li = $("<li></li>").append(a_label);
//                 coursewareCourses.append(li);
//                 if(course.courseName == "电路分析"){
//                     a_label = $("<a href='http://www1.gdou.edu.cn/xxxy/dljc/index.html'></a>").append(courseName);
//                 }else if(course.courseName == "Matlab语言及应用"){
//                     a_label = $("<a href='http://210.38.137.11:10086/MatlabCourse/'></a>").append(courseName);
//                 }else{
//                     a_label  =  $("<a href='#'></a>").append(courseName);
//                 }
//                 li = $("<li></li>").append(a_label);
//                 greatCourses.append(li);
//             })
//         }
//     })
// }
//
// function getCoursewareOrTeachingPlan(typeId, cId) {
//     var url = "/guest/courseware";
//     var data = {
//         contentTypeId:typeId,
//         courseId:cId
//     }
//     if(typeId == 13){
//         $.ajax({
//             url: url,
//             type: "get",
//             data: data,
//             success:function (result) {
//                 var coursewares = result.extended.coursewares;
//                 var sidebarRight = $("#sidebar-right");
//                 sidebarRight.html('');
//                 if(coursewares.length == 0){
//                     sidebarRight.append("待上传资料数据......");
//                     return ;
//                 }
//                 $.each(coursewares, function (index, courseware) {
//                     var coursewareLoc = courseware.coursewareLoc;
//                     var a_label = $("<a href='\""+coursewareLoc+"\"'></a>");
//                     a_label.attr("download","download");
//                     a_label.append(coursewareLoc.slice(coursewareLoc.lastIndexOf("/")+1,coursewareLoc.lastIndexOf(".")));
//                     a_label.attr("href", coursewareLoc);
//                     sidebarRight.append(a_label);
//                     sidebarRight.append($("<br>"));
//                 });
//             },
//             error:function (result) {
//                 alert("服务异常!请稍候再试");
//             }
//         })
//     }else{
//         $.ajax({
//             url: url,
//             type: "get",
//             data: data,
//             success:function (result) {
//                 var coursewares = result.extended.coursewares;
//                 var sidebarRight = $("#sidebar-right");
//                 sidebarRight.html('');
//                 if(coursewares.length == 0){
//                     sidebarRight.append("待上传资料数据......");
//                     return ;
//                 }
//                 $.each(coursewares, function (index, courseware) {
//                     var coursewareLoc = courseware.coursewareLoc;
//                     var contentTitle = coursewareLoc.slice(coursewareLoc.lastIndexOf("/")+1,coursewareLoc.lastIndexOf("."));
//                     var contentTitleDiv = $("<div class='title-right'></div>").append(contentTitle);
//                     var contentDetailDiv = $("<div class='content'></div>");
//                     var pdf = $("<object type='application/pdf' width='550px' height='700'></object>");
//                     pdf.attr("data",coursewareLoc);
//                     contentDetailDiv.append(pdf);
//                     sidebarRight.append(contentTitleDiv);
//                     sidebarRight.append(contentDetailDiv);
//                 })
//             },
//             error:function (result) {
//                 alert("服务异常!请稍候再试");
//             }
//         })
//     }
//
// }
//
// function getTeachingProgram(obj) {
//     var url = "/guest/content/"+obj;
//     $.ajax({
//         url: url,
//         type: "get",
//         success:function (result) {
//             var sidebarRight = $("#sidebar-right");
//             sidebarRight.html('');
//             var content = result.extended.content;
//             var contentTitle = content.contentTitle;
//             var contentDetail = content.content;
//             var contentTitleDiv = $("<div class='title-right'></div>").append(contentTitle);
//             var contentDetailDiv = $("<div class='content'></div>");
//             var pdf = $("<object type='application/pdf' width='550px' height='700'></object>");
//             pdf.attr("data",contentDetail);
//             contentDetailDiv.append(pdf);
//             sidebarRight.append(contentTitleDiv);
//             sidebarRight.append(contentDetailDiv);
//         },
//         error:function (result) {
//             alert("请求失败!请重新尝试!");
//         }
//     })
// }


var TypeId = 41
var arr = new Array(41, 42, 43, 44, 45, 46, 47);
$(document).ready(function () {
    TypeId = checkId(getTypeId()) ? getTypeId() : TypeId;
    $.ajax({
        url: "/guest/content/" + TypeId,
        dataType: "JSON",
        Type: "GET",
        success: function (data) {
            if (data.code == 200) {
                var content = data.extended.content;
                build_content_information(content);
            }
        }
    });
});

function build_content_information(content) {
    $("#title").text(content.contentTitle);
    $("<object></object>").attr("data", content.content).attr("type", "application/pdf").attr("width", 500).attr("height", 600).appendTo($("#content"));
}

function checkId(id) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] == id) return true;
    }
    return false;
}

/**
 * 截取教师id
 */
function getTypeId() {
    var url = window.location.href;
    if (url.indexOf("?") == -1) {
        return 41;
    } else {
        var str = url.substring(url.indexOf("=") + 1);
        return parseInt(str);
    }
}