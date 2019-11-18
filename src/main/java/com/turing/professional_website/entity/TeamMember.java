package com.turing.professional_website.entity;

public class TeamMember {
    private Integer memberId;

    private Integer teamId;

    private String memberName;

    private String memberDirection;

    private String memberIcon;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberDirection() {
        return memberDirection;
    }

    public void setMemberDirection(String memberDirection) {
        this.memberDirection = memberDirection == null ? null : memberDirection.trim();
    }

    public String getMemberIcon() {
        return memberIcon;
    }

    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon == null ? null : memberIcon.trim();
    }
}