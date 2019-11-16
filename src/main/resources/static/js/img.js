$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/guest/contents/"+37,
        success: function (result) {
            var contents = result.extended.contents;
            $("#list").empty();
            for (var i = 0; i < 2; i++) {
                $.each(contents, function (index, item) {
                    var img = $("<img width='190' height='198'>").attr("src", item.content);
                    var li = $("<li></li>").append(img);
                    li.appendTo($("#list"));
                })
            }
        }
    })
})