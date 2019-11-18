package com.turing.professional_website.entity;

public class TeamEnvironment {
    private Integer environmentId;

    private Integer teamId;

    private String environmentPath;

    public Integer getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(Integer environmentId) {
        this.environmentId = environmentId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getEnvironmentPath() {
        return environmentPath;
    }

    public void setEnvironmentPath(String environmentPath) {
        this.environmentPath = environmentPath == null ? null : environmentPath.trim();
    }
}