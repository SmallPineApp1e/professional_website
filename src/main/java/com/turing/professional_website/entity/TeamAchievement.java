package com.turing.professional_website.entity;

import java.util.List;

public class TeamAchievement {
    private Integer achievementId;

    private String achievementContent;

    private Integer teamId;

    private List<TeamAchievementPhoto> teamAchievementPhotos;

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementContent() {
        return achievementContent;
    }

    public void setAchievementContent(String achievementContent) {
        this.achievementContent = achievementContent == null ? null : achievementContent.trim();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public List<TeamAchievementPhoto> getTeamAchievementPhotos() {
        return teamAchievementPhotos;
    }

    public void setTeamAchievementPhotos(List<TeamAchievementPhoto> teamAchievementPhotos) {
        this.teamAchievementPhotos = teamAchievementPhotos;
    }
}