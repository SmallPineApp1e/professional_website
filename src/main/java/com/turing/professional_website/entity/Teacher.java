package com.turing.professional_website.entity;

import java.util.List;

public class Teacher {
    private Integer teacherId;

    private String teacherName;

    private String teacherEmail;

    private String teacherBorn;

    private String teacherJob;

    private String teacherGraduation;

    private String teacherPosition;

    private String teacherResearch;

    private String teacherScientificResearch;

    private String teacherAwardIntroduction;

    private String teacherImg;

    private List<TeachBackground> teachBackgrounds;

    public List<TeachBackground> getTeachBackgrounds() {
        return teachBackgrounds;
    }

    public void setTeachBackgrounds(List<TeachBackground> teachBackgrounds) {
        this.teachBackgrounds = teachBackgrounds;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail == null ? null : teacherEmail.trim();
    }

    public String getTeacherBorn() {
        return teacherBorn;
    }

    public void setTeacherBorn(String teacherBorn) {
        this.teacherBorn = teacherBorn == null ? null : teacherBorn.trim();
    }

    public String getTeacherJob() {
        return teacherJob;
    }

    public void setTeacherJob(String teacherJob) {
        this.teacherJob = teacherJob == null ? null : teacherJob.trim();
    }

    public String getTeacherGraduation() {
        return teacherGraduation;
    }

    public void setTeacherGraduation(String teacherGraduation) {
        this.teacherGraduation = teacherGraduation == null ? null : teacherGraduation.trim();
    }

    public String getTeacherPosition() {
        return teacherPosition;
    }

    public void setTeacherPosition(String teacherPosition) {
        this.teacherPosition = teacherPosition == null ? null : teacherPosition.trim();
    }

    public String getTeacherResearch() {
        return teacherResearch;
    }

    public void setTeacherResearch(String teacherResearch) {
        this.teacherResearch = teacherResearch == null ? null : teacherResearch.trim();
    }

    public String getTeacherScientificResearch() {
        return teacherScientificResearch;
    }

    public void setTeacherScientificResearch(String teacherScientificResearch) {
        this.teacherScientificResearch = teacherScientificResearch == null ? null : teacherScientificResearch.trim();
    }

    public String getTeacherAwardIntroduction() {
        return teacherAwardIntroduction;
    }

    public void setTeacherAwardIntroduction(String teacherAwardIntroduction) {
        this.teacherAwardIntroduction = teacherAwardIntroduction == null ? null : teacherAwardIntroduction.trim();
    }

    public String getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(String teacherImg) {
        this.teacherImg = teacherImg == null ? null : teacherImg.trim();
    }
}