package com.turing.professional_website.entity;

import java.util.ArrayList;
import java.util.List;

public class TeamAchievementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamAchievementExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAchievementIdIsNull() {
            addCriterion("achievement_id is null");
            return (Criteria) this;
        }

        public Criteria andAchievementIdIsNotNull() {
            addCriterion("achievement_id is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementIdEqualTo(Integer value) {
            addCriterion("achievement_id =", value, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementIdNotEqualTo(Integer value) {
            addCriterion("achievement_id <>", value, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementIdGreaterThan(Integer value) {
            addCriterion("achievement_id >", value, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("achievement_id >=", value, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementIdLessThan(Integer value) {
            addCriterion("achievement_id <", value, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementIdLessThanOrEqualTo(Integer value) {
            addCriterion("achievement_id <=", value, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementIdIn(List<Integer> values) {
            addCriterion("achievement_id in", values, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementIdNotIn(List<Integer> values) {
            addCriterion("achievement_id not in", values, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementIdBetween(Integer value1, Integer value2) {
            addCriterion("achievement_id between", value1, value2, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementIdNotBetween(Integer value1, Integer value2) {
            addCriterion("achievement_id not between", value1, value2, "achievementId");
            return (Criteria) this;
        }

        public Criteria andAchievementContentIsNull() {
            addCriterion("achievement_content is null");
            return (Criteria) this;
        }

        public Criteria andAchievementContentIsNotNull() {
            addCriterion("achievement_content is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementContentEqualTo(String value) {
            addCriterion("achievement_content =", value, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentNotEqualTo(String value) {
            addCriterion("achievement_content <>", value, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentGreaterThan(String value) {
            addCriterion("achievement_content >", value, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentGreaterThanOrEqualTo(String value) {
            addCriterion("achievement_content >=", value, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentLessThan(String value) {
            addCriterion("achievement_content <", value, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentLessThanOrEqualTo(String value) {
            addCriterion("achievement_content <=", value, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentLike(String value) {
            addCriterion("achievement_content like", value, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentNotLike(String value) {
            addCriterion("achievement_content not like", value, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentIn(List<String> values) {
            addCriterion("achievement_content in", values, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentNotIn(List<String> values) {
            addCriterion("achievement_content not in", values, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentBetween(String value1, String value2) {
            addCriterion("achievement_content between", value1, value2, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andAchievementContentNotBetween(String value1, String value2) {
            addCriterion("achievement_content not between", value1, value2, "achievementContent");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(Integer value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Integer value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Integer value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Integer value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Integer value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Integer> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Integer> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Integer value1, Integer value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}