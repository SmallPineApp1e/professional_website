package com.turing.professional_website.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AwardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwardExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAwardsIdIsNull() {
            addCriterion("awards_id is null");
            return (Criteria) this;
        }

        public Criteria andAwardsIdIsNotNull() {
            addCriterion("awards_id is not null");
            return (Criteria) this;
        }

        public Criteria andAwardsIdEqualTo(Integer value) {
            addCriterion("awards_id =", value, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsIdNotEqualTo(Integer value) {
            addCriterion("awards_id <>", value, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsIdGreaterThan(Integer value) {
            addCriterion("awards_id >", value, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("awards_id >=", value, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsIdLessThan(Integer value) {
            addCriterion("awards_id <", value, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsIdLessThanOrEqualTo(Integer value) {
            addCriterion("awards_id <=", value, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsIdIn(List<Integer> values) {
            addCriterion("awards_id in", values, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsIdNotIn(List<Integer> values) {
            addCriterion("awards_id not in", values, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsIdBetween(Integer value1, Integer value2) {
            addCriterion("awards_id between", value1, value2, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("awards_id not between", value1, value2, "awardsId");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeIsNull() {
            addCriterion("awards_time is null");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeIsNotNull() {
            addCriterion("awards_time is not null");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeEqualTo(Date value) {
            addCriterionForJDBCDate("awards_time =", value, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("awards_time <>", value, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("awards_time >", value, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("awards_time >=", value, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeLessThan(Date value) {
            addCriterionForJDBCDate("awards_time <", value, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("awards_time <=", value, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeIn(List<Date> values) {
            addCriterionForJDBCDate("awards_time in", values, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("awards_time not in", values, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("awards_time between", value1, value2, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("awards_time not between", value1, value2, "awardsTime");
            return (Criteria) this;
        }

        public Criteria andAwardsNameIsNull() {
            addCriterion("awards_name is null");
            return (Criteria) this;
        }

        public Criteria andAwardsNameIsNotNull() {
            addCriterion("awards_name is not null");
            return (Criteria) this;
        }

        public Criteria andAwardsNameEqualTo(String value) {
            addCriterion("awards_name =", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameNotEqualTo(String value) {
            addCriterion("awards_name <>", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameGreaterThan(String value) {
            addCriterion("awards_name >", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameGreaterThanOrEqualTo(String value) {
            addCriterion("awards_name >=", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameLessThan(String value) {
            addCriterion("awards_name <", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameLessThanOrEqualTo(String value) {
            addCriterion("awards_name <=", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameLike(String value) {
            addCriterion("awards_name like", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameNotLike(String value) {
            addCriterion("awards_name not like", value, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameIn(List<String> values) {
            addCriterion("awards_name in", values, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameNotIn(List<String> values) {
            addCriterion("awards_name not in", values, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameBetween(String value1, String value2) {
            addCriterion("awards_name between", value1, value2, "awardsName");
            return (Criteria) this;
        }

        public Criteria andAwardsNameNotBetween(String value1, String value2) {
            addCriterion("awards_name not between", value1, value2, "awardsName");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
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