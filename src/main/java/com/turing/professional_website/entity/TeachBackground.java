package com.turing.professional_website.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TeachBackground {
    private Integer backgroundId;
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date backgroundStartTime;
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date backgroundEndTime;

    private String backgroundContent;

    private Integer teacherId;

    public Integer getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(Integer backgroundId) {
        this.backgroundId = backgroundId;
    }

    public Date getBackgroundStartTime() {
        return backgroundStartTime;
    }

    public void setBackgroundStartTime(Date backgroundStartTime) {
        this.backgroundStartTime = backgroundStartTime;
    }

    public Date getBackgroundEndTime() {
        return backgroundEndTime;
    }

    public void setBackgroundEndTime(Date backgroundEndTime) {
        this.backgroundEndTime = backgroundEndTime;
    }

    public String getBackgroundContent() {
        return backgroundContent;
    }

    public void setBackgroundContent(String backgroundContent) {
        this.backgroundContent = backgroundContent == null ? null : backgroundContent.trim();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}