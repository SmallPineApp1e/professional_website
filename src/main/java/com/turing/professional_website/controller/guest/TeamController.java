package com.turing.professional_website.controller.guest;

import com.turing.professional_website.entity.Team;
import com.turing.professional_website.service.guest.TeamService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Meng
 * @date 2019/10/30
 */
@RestController
@RequestMapping(value = "/guest")
@Api(tags = "前台获取团队信息接口")
public class  TeamController {

    @Autowired
    private TeamService teamService;

    @ApiOperation(value = "获取所有的团队信息以及带头人", notes = "获取所有的团队信息以及带头人")
    @GetMapping(value = "/teams")
    public Msg findAllTeams(){
        List<Team> teams=teamService.findAllTeams();
        return Msg.success().add("teams",teams);
    }

    @ApiOperation(value = "根据团队id获取详细团队信息，团队成员，获奖以及图片", notes = "根据团队id获取详细团队信息，团队成员，获奖以及图片")
    @GetMapping(value = "/team/{teamId}")
    public Msg findTeamById(@PathVariable("teamId")Integer teamId){
        Team team=teamService.findTeamById(teamId);
        return Msg.success().add("team",team);
    }
}
