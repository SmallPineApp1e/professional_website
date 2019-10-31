package com.turing.professional_website.entity;

import java.util.List;

public class Team {
    private Integer teamId;

    private String teamName;

    private String teamIntroduction;

    private List<Teacher> teachers;

    private List<TeamMember> teamMembers;

    private List<TeamEnvironment> teamEnvironments;

    private List<TeamAchievement> teamAchievements;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public String getTeamIntroduction() {
        return teamIntroduction;
    }

    public void setTeamIntroduction(String teamIntroduction) {
        this.teamIntroduction = teamIntroduction == null ? null : teamIntroduction.trim();
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public List<TeamEnvironment> getTeamEnvironments() {
        return teamEnvironments;
    }

    public void setTeamEnvironments(List<TeamEnvironment> teamEnvironments) {
        this.teamEnvironments = teamEnvironments;
    }

    public List<TeamAchievement> getTeamAchievements() {


         
        return teamAchievements;
    }

    public void setTeamAchievements(List<TeamAchievement> teamAchievements) {
        this.teamAchievements = teamAchievements;
    }
}