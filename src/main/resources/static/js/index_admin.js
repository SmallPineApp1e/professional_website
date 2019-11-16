/**
 * @Author Meng
 */
$("#select").change(function () {
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
            var imgElement=$("<img width='100' height='100'>").attr("src",e.target.result);
            imgElement.appendTo($("#view"));
        }
    }
}