package com.turing.professional_website.dao;

import com.turing.professional_website.entity.Content;
import com.turing.professional_website.entity.ContentExample;
<<<<<<< HEAD
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
=======
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
>>>>>>> f7b55bc21105ec2acf2f7a0d8d4f7c9b60de3116
@Mapper
public interface ContentMapper {
    int countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Content record);

    int insertSelective(Content record);

    List<Content> selectByExample(ContentExample example);

    Content selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
<<<<<<< HEAD

    Content selectByContentTypeId(Integer contentTypeId);
=======
>>>>>>> f7b55bc21105ec2acf2f7a0d8d4f7c9b60de3116
}