package com.turing.professional_website.dao;

import com.turing.professional_website.entity.TeamAchievement;
import com.turing.professional_website.entity.TeamAchievementExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TeamAchievementMapper {
    int countByExample(TeamAchievementExample example);

    int deleteByExample(TeamAchievementExample example);

    int deleteByPrimaryKey(Integer achievementId);

    int insert(TeamAchievement record);

    int insertSelective(TeamAchievement record);

    List<TeamAchievement> selectByExample(TeamAchievementExample example);

    TeamAchievement selectByPrimaryKey(Integer achievementId);

    int updateByExampleSelective(@Param("record") TeamAchievement record, @Param("example") TeamAchievementExample example);

    int updateByExample(@Param("record") TeamAchievement record, @Param("example") TeamAchievementExample example);

    int updateByPrimaryKeySelective(TeamAchievement record);

    int updateByPrimaryKey(TeamAchievement record);
}