/**
 * @author Zeng
 */
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/guest/teams",
        success: function (result) {
            var teams = result.extended.teams;
            var ul = $("<ul></ul>");
            for (var index = 0; index < teams.length; index++) {
                var teamId = teams[index].teamId;
                var teamName = teams[index].teamName;
                var li = $("<li></li>");
                var a = $("<a></a>");
                a.attr('onClick', 'showTeamInfo(' + teamId+')');
                a.append(teamName);
                li.append(a);
                ul.append(li).appendTo($("#team-sidebar-left"));
            }
        }
    })
})

function showTeamInfo(teamId){
    $("#team-introduction").html("");
    $("#teacher-content").html("");
    $("student-content").html("");
    $.ajax({
        type: "GET",
        url: "/guest/team/"+teamId,
        success:function(result){
            var team = result.extended.team;
            var teamName = team.teamName;
            var teamIntroduction = team.teamIntroduction;
        }
    })
}