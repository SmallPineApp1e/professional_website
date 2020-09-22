/**
 * @author Meng
 * @date 2019-06-29
 */

$(document).ready(function () {

    $.ajax({
        url: "/guest/teachers",
        type: "GET",
        dataType: "JSON",
        success: function (data) {
            if (data.code == 200) {
                var teachers = data.extended.teachers;
                $.each(teachers, function (index, item) {
                    var h5 = $("<h5></h5>").append("职位 - " + item.teacherPosition);
                    var a = $("<a href=/html/teacher_info.html?teacherId=" + item.teacherId + "></a>").append(item.teacherName);
                    var h4 = $("<h4></h4>").append(a);
                    $("<div class='box'></div>").append("<img class='box-img' src=" + item.teacherImg + ">").append(h4)
                        .append(h5).appendTo($("#teacher"));
                });
            }
        }
    });
});