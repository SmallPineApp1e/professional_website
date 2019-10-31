package com.turing.professional_website.controller.guest;

import com.turing.professional_website.entity.TeamMember;
import com.turing.professional_website.service.guest.TeamMemberService;
import com.turing.professional_website.util.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Meng
 * @date 2019/10/31
 */
@RestController
@RequestMapping(value = "/guest")
@Api(tags = "前台获取团队成员信息接口")
public class TeamMemberController {

    @Autowired
    private TeamMemberService teamMemberService;

    @ApiOperation(value = "根据成员id获取详细成员信息", notes = "根据成员id获取详细成员信息")
    @GetMapping(value = "/teammember/{teamMemberId}")
    public Msg findTeamMemberById(@PathVariable("teamMemberId") Integer teamMemberid){
        TeamMember teamMember=teamMemberService.findTeamMemberById(teamMemberid);
        return Msg.success().add("TeamMember",teamMember);
    }
}
