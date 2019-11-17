/**
 * @Author Meng
 */
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/guest/contents/"+37,
        success: function (result) {
            var contents = result.extended.contents;
            $("#list").empty();
            for (var i = 0; i < 2; i++) {
                $.each(contents, function (index, item) {
                    var img = $("<img>").attr("src", item.content);
                    var li = $("<li></li>").append(img);
                    li.appendTo($("#list"));
                })
            }
        }
    })
    $.ajax({
        type:"GET",
        url:"/guest/contents/"+36,
        success:function(data) {
            console.log(data)
            var contents = data.extended.contents;
            $.each(contents, function (index, item) {
                var div = $("<div class='swiper-slide'></div>");
                var img = $("<img alt='' style='width:280px;height:210px;'>").attr("src", item.content);
                div.append(img).appendTo($("#lunboleft"));
            })
        }
    })
    $.ajax({
        type:"GET",
        dataType:"JSON",
        url:"/guest/content/25",
        success:function(data){
            var contents=data.extended.content;
            $.each(contents,function(index,item){
                var li=$("<li></li>").text(item.contentTitle);
                var td=$("<td></td>").append(li);
                var td1=$("<td align='right'></td>");
                var tr
            })
        }
    })
})