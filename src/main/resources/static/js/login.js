/**
 * @author Meng
 * @date 2019-06-27
 */

$(document).ready(function() {
    /**
     * 登录
     */
    $("#login").click(function(){
        var username=$("#u").val();
        var password=$("#p").val();
        if(username==""){
            $('#u').css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $("#usernamemessage").html("<font color='red'><b>×用户名不能为空</b></font>");

        }
        if(password==""){
            $('#p').css({
                border: "1px solid red",
                boxShadow: "0 0 2px red"
            });
            $("#passwordmessage").html("<font color='red'><b>密码不能为空</b></font>");
            return false;
        }
        $.ajax({
            url:"/admin/login",
            type:"POST",
            dataType:"JSON",
            data:{username:username,password:password},
            success:function(data){
                console.log(data);
                if(data.code==100){
                    $("#loginerror").html("<font color='red'><b>"+data.extended.error+"</b></font>");
                }
                else if(data.code==200){
                    window.location.href="admin/index.html";
                }
            },
            error:function(){
                alert("Connection error");
            }
        });
    });

    /**
     * 点击文本框去除异常
     */
    $("#u").focus(function(){
        $("#usernamemessage").html("");
        $("#loginerror").html("");
        $("#u").removeAttr("style");
    })

    $("#p").focus(function(){
        $("#passwordmessage").html("");
        $("#loginerror").html("");
        $("#p").removeAttr("style");
    })
});