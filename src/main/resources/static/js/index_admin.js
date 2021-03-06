/**
 * @Author Meng
 */
var contentTypeId=38;
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
$("#select").change(function () {
    $("#content").empty();
    var select = document.getElementById("select")
    var index = select.selectedIndex;
    contentTypeId = select.options[index].value;
    if(contentTypeId==36||contentTypeId==37){
        $.ajax({
            url:"/guest/contents/"+contentTypeId,
            dataType:"JSON",
            method:"GET",
            success:function(data){
                if(data.code==200){
                    var contents=data.extended.contents;
                    build_img(contents);
                }
            }
        })
    }
})

/**
 * 构建图片信息
 * @param contents
 */
function build_img(contents){
    $.each(contents,function(index,item){
        var img=$("<img width='150' height='150'>").attr("src",item.content);
        img.appendTo($("#content"));
    })
}

/**
 * 图片的预览
 */
function loadImageFile(){
    var imgs=document.getElementById("img");
    if(document.getElementById("img").files.length==0){
        alert("请选择照片");
        return;
    }
    if(document.getElementById("img").files.length!=5){
        alert("请选择5张照片");
        return;
    }
    for(var i=0;i<imgs.files.length;i++) {
        if (document.getElementById("img").files[i].size > 5242800) {
            alert("上传的图片不能大于5M");
            return;
        }
        var img=document.getElementById("img").files[i];
        var reader=new FileReader();
        reader.readAsDataURL(img);
        reader.onload=function(e){
            var imgElement=$("<img width='150' height='150'>").attr("src",e.target.result);
            imgElement.appendTo($("#view"));
        }
    }
}

$("#upload").click(function(){
    var formData=new FormData();
    var imgs=document.getElementById("img").files;
    formData.append("contentTypeId",contentTypeId);
    for(var i=0;i<imgs.length;i++){
        formData.append("data",imgs[i]);
    }
    formData.append("contentTitle","");
    $.ajax({
        url:"/admin/contents",
        data:formData,
        dataType:"JSON",
        method:"POST",
        async:false,
        processData:false,
        contentType:false,
        success:function(data){
            if(data.code==200){
                alert("操作成功");
                window.location.reload();
            }else{
                alert("操作错误");
            }
        }
    })
})