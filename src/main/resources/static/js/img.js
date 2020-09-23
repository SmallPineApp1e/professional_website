/**
 * @Author Meng
 */
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/guest/contents/" + 37,
        success: function (result) {
            var contents = result.extended.contents;
            $("#list").empty();
            for (var i = 0; i < 2; i++) {
                $.each(contents, function (index, item) {
                    var img = $("<img>").attr("src", item.content).attr("title", "这是文字这是文字这是文字这是文字这是文字这是文字这是文字这是文字这是文字这是文字这是文字这是文字这是文字这是文字这是文字这是文字");
                    var a = $("<a href='#'>").append(img);
                    var li = $("<li></li>").append(a);
                    li.appendTo($("#list"));
                })
            }
        }
    })
    $.ajax({
        type: "GET",
        url: "/guest/contents/" + 36,
        success: function (data) {
            var contents = data.extended.contents;
            $.each(contents, function (index, item) {
                var div = $("<div class='swiper-slide'></div>");
                var img = $("<img alt='' style='width:280px;height:210px;'>").attr("src", item.content);
                div.append(img).appendTo($("#lunboleft"));
            })
        }
    })
    $.ajax({
        type: "GET",
        dataType: "JSON",
        url: "/guest/contents/25",
        success: function (data) {
            var contents = data.extended.contents;
            for (var i = contents.length-1; i > contents.length-8; i--) {
                var li = $("<li></li>").text(contents[i].contentTitle);
                var a=$("<a style=\"text-decoration:none;color:black\"></a>").attr("href","content.html?id="+contents[i].id);
                a.append(li);
                var td = $("<td></td>").append(a);
                var td1 = $("<td align='right'></td>").text(contents[i].uploadTime.split(" ")[0] + "".substring(5, 10));
                var tr = $("<tr></tr>").append(td).append(td1)
                tr.appendTo($("#announcement"));
            }
        }
    })
    $.ajax({
        type: "GET",
        dataType: "JSON",
        url: "/guest/contents/26",
        success: function (data) {
            var contents = data.extended.contents;
            for (var i = contents.length-1; i > contents.length-7; i--) {
                var li = $("<li></li>").text(contents[i].contentTitle);
                var a=$("<a style=\"text-decoration:none;color:black\"></a>").attr("href","content.html?id="+contents[i].id);
                a.append(li);
                var td = $("<td colspan='2'></td>").append(a);
                var tr = $("<tr></tr>").append(td);
                tr.appendTo($("#cooperate"));
            }
        }
    })
    $.ajax({
        type: "GET",
        dataType: "JSON",
        url: "/guest/contents/27",
        success: function (data) {
            var contents = data.extended.contents;
            for (var i = contents.length-1; i > contents.length-10; i--) {
                var li = $("<li></li>").text(contents[i].contentTitle);
                var a=$("<a style=\"text-decoration:none;color:black\"></a>").attr("href","content.html?id="+contents[i].id);
                a.append(li);
                var td = $("<td width='400'></td>").append(a);
                var td1 = $("<td align='right'></td>").text(contents[i].uploadTime.split(" ")[0] + "".substring(0,10));
                var tr = $("<tr></tr>").append(td).append(td1)
                tr.appendTo($("#information"));
            }
        }
    })
})