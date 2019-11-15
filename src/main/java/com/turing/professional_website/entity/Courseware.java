package com.turing.professional_website.entity;

public class Courseware {
    private Integer coursewareId;

    private String coursewareLoc;

    private Integer courseId;

    private Integer contentType;

    public Integer getCoursewareId() {
        return coursewareId;
    }

    public void setCoursewareId(Integer coursewareId) {
        this.coursewareId = coursewareId;
    }

    public String getCoursewareLoc() {
        return coursewareLoc;
    }

    public void setCoursewareLoc(String coursewareLoc) {
        this.coursewareLoc = coursewareLoc == null ? null : coursewareLoc.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }
}