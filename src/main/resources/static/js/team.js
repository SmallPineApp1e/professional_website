/**
 * @author Zeng
 */
var teamId=1;
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
                a.attr('onClick', 'showTeamInfo(' + teamId + ')');
                a.append(teamName);
                li.append(a);
                ul.append(li).appendTo($("#team-sidebar-left"));
            }
            showTeamInfo(1);
        }
    })
})

function showTeamInfo(teamId) {
    var teamNameArea = $("#team-name");
    var teamIntroductionArea = $("#team-introduction");
    var teacherContentArea = $("#teacher-content");
    var studentContentArea = $("#student-content");
    var teamAchievementArea = $("#team-achievement");
    teamNameArea.html("");
    teamIntroductionArea.html("");
    teacherContentArea.html("");
    studentContentArea.html("");
    teamAchievementArea.html("");
    $.ajax({
        type: "GET",
        url: "/guest/team/" + teamId,
        success: function (result) {
            var team = result.extended.team;
            var teamName = team.teamName;
            var teamIntroduction = team.teamIntroduction;
            teamNameArea.append(teamName);
            teamIntroductionArea.append(teamIntroduction);
            var teachers = team.teachers;
            var a_label;
            $.each(teachers, function (index, teacher) {
                var teacherId = teacher.teacherId;
                var teacherName = teacher.teacherName;
                a_label = $("<a style='margin-right:15px'></a>").append(teacherName);
                a_label.attr('href', '/html/teacher_info.html?teacherId=' + teacherId);
                teacherContentArea.append(a_label);
            });
            var teamMembers = team.teamMembers;
            $.each(teamMembers, function (index, teamMember) {
                var memberId = teamMember.memberId;
                var memberName = teamMember.memberName;
                a_label = $("<a style='margin-right:15px'></a>").append(memberName);
                a_label.attr('href', '#');
                studentContentArea.append(a_label);
            });
            var teamAchievements = team.teamAchievements;
            $.each(teamAchievements, function (index, teamAchievement) {
                var achievementContent = teamAchievement.achievementContent;
                var teamAchievementPhotos = teamAchievement.teamAchievementPhotos;
                var achivContentArea = $("<div></div>").append(achievementContent);
                var eachTeamAchievementArea = $("<div style='margin-top:10px'></div>");
                $.each(teamAchievementPhotos, function (index, photo) {
                    var photoPath = photo.photoPath;
                    var img_label = $("<img>").attr('src', photoPath);
                    eachTeamAchievementArea.append(img_label);
                });
                eachTeamAchievementArea.append(achivContentArea);
                teamAchievementArea.append(eachTeamAchievementArea)
            });
            var teamEnvironments = team.teamEnvironments;
            console.log(teamEnvironments);
            showEnvironment(teamEnvironments);
        }
    })
}

/**
 * 展示环境信息
 * @param teamEnvironments
 */
function showEnvironment(teamEnvironments) {
    for (var i = 0; i < 2; i++) {
        $.each(teamEnvironments, function (index, item) {
            var img = $("<img width='165' height='104'>").attr("src", item.environmentPath);
            var li = $("<li></li>").append(img);
            li.appendTo($("#list"));
        })
    }
}