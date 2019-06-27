package com.turing.professional_website.dao;

import com.turing.professional_website.entity.TeachBackground;
import com.turing.professional_website.entity.TeachBackgroundExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TeachBackgroundMapper {
    int countByExample(TeachBackgroundExample example);

    int deleteByExample(TeachBackgroundExample example);

    int insert(TeachBackground record);

    int insertSelective(TeachBackground record);

    List<TeachBackground> selectByExample(TeachBackgroundExample example);

    int updateByExampleSelective(@Param("record") TeachBackground record, @Param("example") TeachBackgroundExample example);

    int updateByExample(@Param("record") TeachBackground record, @Param("example") TeachBackgroundExample example);
}