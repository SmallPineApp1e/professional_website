package com.turing.professional_website.service.guest;

import com.turing.professional_website.entity.TeamMember;

/**
 * @author Meng
 * @date 2019/10/31
 */
public interface TeamMemberService {
    TeamMember findTeamMemberById(Integer teamMemberid);
}
