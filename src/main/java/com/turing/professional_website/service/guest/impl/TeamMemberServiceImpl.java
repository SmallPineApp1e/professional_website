package com.turing.professional_website.service.guest.impl;

import com.turing.professional_website.dao.TeamMemberMapper;
import com.turing.professional_website.entity.TeamMember;
import com.turing.professional_website.service.guest.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Meng
 * @date 2019/10/31
 */
@Service
@Transactional
public class TeamMemberServiceImpl implements TeamMemberService {

    @Autowired
    private TeamMemberMapper teamMemberMapper;

    @Override
    public TeamMember findTeamMemberById(Integer teamMemberid) {
        return teamMemberMapper.selectByPrimaryKey(teamMemberid);
    }
}
