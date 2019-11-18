package com.turing.professional_website.entity;

public class TeamAchievementPhoto {
    private Integer photoId;

    private String photoPath;

    private Integer ahievementId;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }

    public Integer getAhievementId() {
        return ahievementId;
    }

    public void setAhievementId(Integer ahievementId) {
        this.ahievementId = ahievementId;
    }
}