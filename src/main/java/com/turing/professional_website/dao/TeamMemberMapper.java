package com.turing.professional_website.dao;

import com.turing.professional_website.entity.TeamMember;
import com.turing.professional_website.entity.TeamMemberExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TeamMemberMapper {
    int countByExample(TeamMemberExample example);

    int deleteByExample(TeamMemberExample example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(TeamMember record);

    int insertSelective(TeamMember record);

    List<TeamMember> selectByExample(TeamMemberExample example);

    TeamMember selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") TeamMember record, @Param("example") TeamMemberExample example);

    int updateByExample(@Param("record") TeamMember record, @Param("example") TeamMemberExample example);

    int updateByPrimaryKeySelective(TeamMember record);

    int updateByPrimaryKey(TeamMember record);
}