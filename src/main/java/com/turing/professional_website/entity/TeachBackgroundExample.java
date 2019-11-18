package com.turing.professional_website.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeachBackgroundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeachBackgroundExample() {
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

        public Criteria andBackgroundIdIsNull() {
            addCriterion("background_id is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdIsNotNull() {
            addCriterion("background_id is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdEqualTo(Integer value) {
            addCriterion("background_id =", value, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdNotEqualTo(Integer value) {
            addCriterion("background_id <>", value, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdGreaterThan(Integer value) {
            addCriterion("background_id >", value, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("background_id >=", value, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdLessThan(Integer value) {
            addCriterion("background_id <", value, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdLessThanOrEqualTo(Integer value) {
            addCriterion("background_id <=", value, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdIn(List<Integer> values) {
            addCriterion("background_id in", values, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdNotIn(List<Integer> values) {
            addCriterion("background_id not in", values, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdBetween(Integer value1, Integer value2) {
            addCriterion("background_id between", value1, value2, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundIdNotBetween(Integer value1, Integer value2) {
            addCriterion("background_id not between", value1, value2, "backgroundId");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeIsNull() {
            addCriterion("background_start_time is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeIsNotNull() {
            addCriterion("background_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("background_start_time =", value, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("background_start_time <>", value, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("background_start_time >", value, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("background_start_time >=", value, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("background_start_time <", value, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("background_start_time <=", value, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("background_start_time in", values, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("background_start_time not in", values, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("background_start_time between", value1, value2, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("background_start_time not between", value1, value2, "backgroundStartTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeIsNull() {
            addCriterion("background_end_time is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeIsNotNull() {
            addCriterion("background_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("background_end_time =", value, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("background_end_time <>", value, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("background_end_time >", value, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("background_end_time >=", value, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("background_end_time <", value, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("background_end_time <=", value, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("background_end_time in", values, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("background_end_time not in", values, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("background_end_time between", value1, value2, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("background_end_time not between", value1, value2, "backgroundEndTime");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentIsNull() {
            addCriterion("background_content is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentIsNotNull() {
            addCriterion("background_content is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentEqualTo(String value) {
            addCriterion("background_content =", value, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentNotEqualTo(String value) {
            addCriterion("background_content <>", value, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentGreaterThan(String value) {
            addCriterion("background_content >", value, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentGreaterThanOrEqualTo(String value) {
            addCriterion("background_content >=", value, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentLessThan(String value) {
            addCriterion("background_content <", value, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentLessThanOrEqualTo(String value) {
            addCriterion("background_content <=", value, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentLike(String value) {
            addCriterion("background_content like", value, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentNotLike(String value) {
            addCriterion("background_content not like", value, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentIn(List<String> values) {
            addCriterion("background_content in", values, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentNotIn(List<String> values) {
            addCriterion("background_content not in", values, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentBetween(String value1, String value2) {
            addCriterion("background_content between", value1, value2, "backgroundContent");
            return (Criteria) this;
        }

        public Criteria andBackgroundContentNotBetween(String value1, String value2) {
            addCriterion("background_content not between", value1, value2, "backgroundContent");
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