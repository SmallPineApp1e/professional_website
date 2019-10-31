package com.turing.professional_website.service.guest.impl;

import com.turing.professional_website.dao.TeamMapper;
import com.turing.professional_website.entity.Team;
import com.turing.professional_website.service.guest.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Meng
 * @date 2019/10/30
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Team> findAllTeams() {
        return teamMapper.selectTeamList();
    }

    @Override
    public Team findTeamById(Integer teamId) {
        return teamMapper.selectTeamById(teamId);
    }
}
