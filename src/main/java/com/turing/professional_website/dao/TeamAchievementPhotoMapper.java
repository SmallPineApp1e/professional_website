package com.turing.professional_website.dao;

import com.turing.professional_website.entity.TeamAchievementPhoto;
import com.turing.professional_website.entity.TeamAchievementPhotoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamAchievementPhotoMapper {
    int countByExample(TeamAchievementPhotoExample example);

    int deleteByExample(TeamAchievementPhotoExample example);

    int deleteByPrimaryKey(Integer photoId);

    int insert(TeamAchievementPhoto record);

    int insertSelective(TeamAchievementPhoto record);

    List<TeamAchievementPhoto> selectByExample(TeamAchievementPhotoExample example);

    TeamAchievementPhoto selectByPrimaryKey(Integer photoId);

    int updateByExampleSelective(@Param("record") TeamAchievementPhoto record, @Param("example") TeamAchievementPhotoExample example);

    int updateByExample(@Param("record") TeamAchievementPhoto record, @Param("example") TeamAchievementPhotoExample example);

    int updateByPrimaryKeySelective(TeamAchievementPhoto record);

    int updateByPrimaryKey(TeamAchievementPhoto record);
}