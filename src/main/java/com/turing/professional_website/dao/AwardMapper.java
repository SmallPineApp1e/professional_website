package com.turing.professional_website.dao;

import com.turing.professional_website.entity.Award;
import com.turing.professional_website.entity.AwardExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AwardMapper {
    int countByExample(AwardExample example);

    int deleteByExample(AwardExample example);

    int insert(Award record);

    int insertSelective(Award record);

    List<Award> selectByExample(AwardExample example);

    int updateByExampleSelective(@Param("record") Award record, @Param("example") AwardExample example);

    int updateByExample(@Param("record") Award record, @Param("example") AwardExample example);
}