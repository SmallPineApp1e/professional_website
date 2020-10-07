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
                    var img = $("<img>").attr("src", item.content).attr("title", "实验室环境");
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
            var arr = [
                "2019年9月21日海滨学院教室讨论申报书的撰写",
                "2019年12月27日王骥主任和徐国保副主任在成都参加受理专业培训会",
                "2020年1月3日邀请北京科技大学李擎教授指导工程认证",
                "2020年1月11日海滨学院实验室集中讨论人才培养方案修订",
                "2020年4月5日科技楼516集中修改自评报告",
                "2020年7月15-20日在河池集中撰写自评报告",
                "2020年7月31日-10日在海滨学院101集中修改自评报告",
                "2020年9月22日提交自评报告一刻",
                "2020年9月22日最后一天修改并提交自评报告"
            ]
            $.each(contents, function (index, item) {
                var img = $("<img alt='' style='width:500px;height:320px;'>").attr("src", item.content);
                img.attr("title", arr[index]);
                $("#" + (String.fromCharCode(97 + index))).append(img).appendTo($("#lunboleft"));
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
                var li = $("<li></li>").text(fun(contents[i].contentTitle));
                console.log(fun(contents[i].contentTitle))
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
                var li = $("<li></li>").text(fun(contents[i].contentTitle));
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
                var li = $("<li></li>").text(fun(contents[i].contentTitle));
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


function fun(str){

    return str.length<=15?str:str.substring(0,16)+".....";
}