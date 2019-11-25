/**
 @Author Meng
 */
var memberId=1;
$(document).ready(function () {
    memberId=getMemberId();
    $.ajax({
        url: "/guest/teammember/" + memberId,
        dataType: "JSON",
        Type: "GET",
        success: function (data) {
            if (data.code == 200) {
                var member = data.extended.TeamMember;
                if(member==null){
                    $("body").empty();
                }
                build_member_information(member);
            }
        }
    });
});

function build_member_information(member) {
    $("#memberIcon").attr("src",member.memberIcon);
    $("#memberName").text(member.memberName);
    $("#memberDirection").text(member.memberDirection);
}

/**
 * 成员id
 */
function getMemberId() {
    var url = window.location.href;
    if (url.indexOf("?") == -1) {
        return 1;
    } else {
        var str = url.substring(url.indexOf("=") + 1);
        return parseInt(str);
    }
}