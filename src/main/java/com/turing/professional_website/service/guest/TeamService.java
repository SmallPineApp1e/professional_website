package com.turing.professional_website.service.guest;

import com.turing.professional_website.entity.Team;

import java.util.List;

/**
 * @author Meng
 * @date 2019/10/30
 */
public interface TeamService {
    List<Team> findAllTeams();

    Team findTeamById(Integer teamId);
}
