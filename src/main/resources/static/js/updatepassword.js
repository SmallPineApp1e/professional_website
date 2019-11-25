/**
 * @author Meng
 * @date 2019-07-11
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
            }
        }
    });
});



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
 * 修改密码
 */
$("#updatepassword").click(function(){
    var x=notnull($("#oldpassword"))&&notnull($("#newpassword"));
    if(!x){
        alert("请正确填写");
        return false;
    }
    var oldpassword=$("#oldpassword").val();
    var newpassword=$("#newpassword").val();
    $.ajax({
        url:"/teacher/updatePass/"+teacherId,
        type:"POST",
        data:{oldPassword:oldpassword,newPassword:newpassword,teacherId:teacherId,_method:"PUT"},
        success:function(data){
            console.log(data);
            if(data.code==100){
                alert(data.extended.fail);
                window.location.reload();
            }
            else if(data.code==200){
                alert(data.extended.success);
                window.location.href="/html/login.html";
            }
        }
    });
})