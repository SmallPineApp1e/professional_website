package com.turing.professional_website.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Award {
    private Integer awardsId;
    @JsonFormat(pattern = "yyyy", timezone = "GMT+8")
    private Date awardsTime;

    private String awardsName;

    private Integer teacherId;

    public Integer getAwardsId() {
        return awardsId;
    }

    public void setAwardsId(Integer awardsId) {
        this.awardsId = awardsId;
    }

    public Date getAwardsTime() {
        return awardsTime;
    }

    public void setAwardsTime(Date awardsTime) {
        this.awardsTime = awardsTime;
    }

    public String getAwardsName() {
        return awardsName;
    }

    public void setAwardsName(String awardsName) {
        this.awardsName = awardsName == null ? null : awardsName.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}