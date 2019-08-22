/**
 * @author Meng
 * @date 2019-07-11
 */

/**
 * 构建教师姓名和头像
 * @param teacherId  教师id
 */
function build_icon(teacherId){
    $.ajax({
        url: "/teacher/" + teacherId,
        dataType: "JSON",
        success:function(data){
            var teacher = data.extended.teacher;
            $("#loginname").text(teacher.teacherName);
            var img=document.getElementsByName("teacherImg");
            for(var i=0;i<img.length;i++){
                img[i].src=teacher.teacherImg;
            }
        }
    });
}