package com.turing.professional_website.entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> f7b55bc21105ec2acf2f7a0d8d4f7c9b60de3116

import java.util.Date;

public class Content {
    private Integer id;

    private String contentTitle;

    private String content;
<<<<<<< HEAD

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT-5")
    private Date uploadTime;

    private Integer contentType;

=======
    @JsonIgnore
    private Date uploadTime;
    @JsonIgnore
    private Integer contentType;
    @JsonIgnore
>>>>>>> f7b55bc21105ec2acf2f7a0d8d4f7c9b60de3116
    private Boolean isFile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle == null ? null : contentTitle.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public Boolean getIsFile() {
        return isFile;
    }

    public void setIsFile(Boolean isFile) {
        this.isFile = isFile;
    }
}