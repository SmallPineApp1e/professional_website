/**
 * @Author Meng
 */
var contentTypeId=1;
$("#type").change(function () {
    var select=document.getElementById("type")
    var index=select.selectedIndex;
    contentTypeId=select.options[index].value;
    $.ajax({
        url:"/admin/content/"+contentTypeId,
        method:"GET",
        dataType:"JSON",
        success:function(data){
            var content=data.extended.content;
            $("#title").empty();
            $("#pdf").empty();
            if(content.content==""){
                $("#title").text("无");
                $("#pdf").text("无");
            }else{
                console.log(content);
                var title=$("<input>").attr("type","text").attr("value",content.contentTitle).attr("id","titleText");
                title.appendTo($("#title"))
                var object=$("<object></object>").attr("type","application/pdf").attr("data",content.content).attr("width",500).attr("height",600);
                object.appendTo($("#pdf"))
            }
        }
    })
})

$("#upload").click(function () {
    console.log($("#titleText").val())
    var data=document.getElementById("data").files[0];
    var formdata=new FormData();
    formdata.append("contentTypeId",contentTypeId);
    formdata.append("contentTitle",$("#titleText").val());
    formdata.append("data",data);
    $.ajax({
        url:"/admin/content",
        data:formdata,
        type:"POST",
        dataType:"JSON",
        async:false,
        processData:false,
        contentType:false,
        success:function(data){
            if(data.code==200){
                alert("提交成果");
                window.location.reload();
            }
        }
    })
})