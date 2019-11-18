package com.turing.professional_website.dao;

import com.turing.professional_website.entity.TeamEnvironment;
import com.turing.professional_website.entity.TeamEnvironmentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TeamEnvironmentMapper {
    int countByExample(TeamEnvironmentExample example);

    int deleteByExample(TeamEnvironmentExample example);

    int deleteByPrimaryKey(Integer environmentId);

    int insert(TeamEnvironment record);

    int insertSelective(TeamEnvironment record);

    List<TeamEnvironment> selectByExample(TeamEnvironmentExample example);

    TeamEnvironment selectByPrimaryKey(Integer environmentId);

    int updateByExampleSelective(@Param("record") TeamEnvironment record, @Param("example") TeamEnvironmentExample example);

    int updateByExample(@Param("record") TeamEnvironment record, @Param("example") TeamEnvironmentExample example);

    int updateByPrimaryKeySelective(TeamEnvironment record);

    int updateByPrimaryKey(TeamEnvironment record);
}