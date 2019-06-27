package com.turing.professional_website.entity;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIsNull() {
            addCriterion("teacher_email is null");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIsNotNull() {
            addCriterion("teacher_email is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailEqualTo(String value) {
            addCriterion("teacher_email =", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotEqualTo(String value) {
            addCriterion("teacher_email <>", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailGreaterThan(String value) {
            addCriterion("teacher_email >", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_email >=", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLessThan(String value) {
            addCriterion("teacher_email <", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLessThanOrEqualTo(String value) {
            addCriterion("teacher_email <=", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailLike(String value) {
            addCriterion("teacher_email like", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotLike(String value) {
            addCriterion("teacher_email not like", value, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailIn(List<String> values) {
            addCriterion("teacher_email in", values, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotIn(List<String> values) {
            addCriterion("teacher_email not in", values, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailBetween(String value1, String value2) {
            addCriterion("teacher_email between", value1, value2, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherEmailNotBetween(String value1, String value2) {
            addCriterion("teacher_email not between", value1, value2, "teacherEmail");
            return (Criteria) this;
        }

        public Criteria andTeacherBornIsNull() {
            addCriterion("teacher_born is null");
            return (Criteria) this;
        }

        public Criteria andTeacherBornIsNotNull() {
            addCriterion("teacher_born is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherBornEqualTo(String value) {
            addCriterion("teacher_born =", value, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornNotEqualTo(String value) {
            addCriterion("teacher_born <>", value, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornGreaterThan(String value) {
            addCriterion("teacher_born >", value, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_born >=", value, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornLessThan(String value) {
            addCriterion("teacher_born <", value, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornLessThanOrEqualTo(String value) {
            addCriterion("teacher_born <=", value, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornLike(String value) {
            addCriterion("teacher_born like", value, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornNotLike(String value) {
            addCriterion("teacher_born not like", value, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornIn(List<String> values) {
            addCriterion("teacher_born in", values, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornNotIn(List<String> values) {
            addCriterion("teacher_born not in", values, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornBetween(String value1, String value2) {
            addCriterion("teacher_born between", value1, value2, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherBornNotBetween(String value1, String value2) {
            addCriterion("teacher_born not between", value1, value2, "teacherBorn");
            return (Criteria) this;
        }

        public Criteria andTeacherJobIsNull() {
            addCriterion("teacher_job is null");
            return (Criteria) this;
        }

        public Criteria andTeacherJobIsNotNull() {
            addCriterion("teacher_job is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherJobEqualTo(String value) {
            addCriterion("teacher_job =", value, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobNotEqualTo(String value) {
            addCriterion("teacher_job <>", value, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobGreaterThan(String value) {
            addCriterion("teacher_job >", value, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_job >=", value, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobLessThan(String value) {
            addCriterion("teacher_job <", value, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobLessThanOrEqualTo(String value) {
            addCriterion("teacher_job <=", value, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobLike(String value) {
            addCriterion("teacher_job like", value, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobNotLike(String value) {
            addCriterion("teacher_job not like", value, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobIn(List<String> values) {
            addCriterion("teacher_job in", values, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobNotIn(List<String> values) {
            addCriterion("teacher_job not in", values, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobBetween(String value1, String value2) {
            addCriterion("teacher_job between", value1, value2, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherJobNotBetween(String value1, String value2) {
            addCriterion("teacher_job not between", value1, value2, "teacherJob");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationIsNull() {
            addCriterion("teacher_graduation is null");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationIsNotNull() {
            addCriterion("teacher_graduation is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationEqualTo(String value) {
            addCriterion("teacher_graduation =", value, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationNotEqualTo(String value) {
            addCriterion("teacher_graduation <>", value, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationGreaterThan(String value) {
            addCriterion("teacher_graduation >", value, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_graduation >=", value, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationLessThan(String value) {
            addCriterion("teacher_graduation <", value, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationLessThanOrEqualTo(String value) {
            addCriterion("teacher_graduation <=", value, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationLike(String value) {
            addCriterion("teacher_graduation like", value, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationNotLike(String value) {
            addCriterion("teacher_graduation not like", value, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationIn(List<String> values) {
            addCriterion("teacher_graduation in", values, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationNotIn(List<String> values) {
            addCriterion("teacher_graduation not in", values, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationBetween(String value1, String value2) {
            addCriterion("teacher_graduation between", value1, value2, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherGraduationNotBetween(String value1, String value2) {
            addCriterion("teacher_graduation not between", value1, value2, "teacherGraduation");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionIsNull() {
            addCriterion("teacher_position is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionIsNotNull() {
            addCriterion("teacher_position is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionEqualTo(String value) {
            addCriterion("teacher_position =", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotEqualTo(String value) {
            addCriterion("teacher_position <>", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionGreaterThan(String value) {
            addCriterion("teacher_position >", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_position >=", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionLessThan(String value) {
            addCriterion("teacher_position <", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionLessThanOrEqualTo(String value) {
            addCriterion("teacher_position <=", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionLike(String value) {
            addCriterion("teacher_position like", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotLike(String value) {
            addCriterion("teacher_position not like", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionIn(List<String> values) {
            addCriterion("teacher_position in", values, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotIn(List<String> values) {
            addCriterion("teacher_position not in", values, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionBetween(String value1, String value2) {
            addCriterion("teacher_position between", value1, value2, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotBetween(String value1, String value2) {
            addCriterion("teacher_position not between", value1, value2, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchIsNull() {
            addCriterion("teacher_research is null");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchIsNotNull() {
            addCriterion("teacher_research is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchEqualTo(String value) {
            addCriterion("teacher_research =", value, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchNotEqualTo(String value) {
            addCriterion("teacher_research <>", value, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchGreaterThan(String value) {
            addCriterion("teacher_research >", value, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_research >=", value, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchLessThan(String value) {
            addCriterion("teacher_research <", value, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchLessThanOrEqualTo(String value) {
            addCriterion("teacher_research <=", value, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchLike(String value) {
            addCriterion("teacher_research like", value, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchNotLike(String value) {
            addCriterion("teacher_research not like", value, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchIn(List<String> values) {
            addCriterion("teacher_research in", values, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchNotIn(List<String> values) {
            addCriterion("teacher_research not in", values, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchBetween(String value1, String value2) {
            addCriterion("teacher_research between", value1, value2, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherResearchNotBetween(String value1, String value2) {
            addCriterion("teacher_research not between", value1, value2, "teacherResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchIsNull() {
            addCriterion("teacher_scientific_research is null");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchIsNotNull() {
            addCriterion("teacher_scientific_research is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchEqualTo(String value) {
            addCriterion("teacher_scientific_research =", value, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchNotEqualTo(String value) {
            addCriterion("teacher_scientific_research <>", value, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchGreaterThan(String value) {
            addCriterion("teacher_scientific_research >", value, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_scientific_research >=", value, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchLessThan(String value) {
            addCriterion("teacher_scientific_research <", value, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchLessThanOrEqualTo(String value) {
            addCriterion("teacher_scientific_research <=", value, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchLike(String value) {
            addCriterion("teacher_scientific_research like", value, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchNotLike(String value) {
            addCriterion("teacher_scientific_research not like", value, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchIn(List<String> values) {
            addCriterion("teacher_scientific_research in", values, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchNotIn(List<String> values) {
            addCriterion("teacher_scientific_research not in", values, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchBetween(String value1, String value2) {
            addCriterion("teacher_scientific_research between", value1, value2, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherScientificResearchNotBetween(String value1, String value2) {
            addCriterion("teacher_scientific_research not between", value1, value2, "teacherScientificResearch");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionIsNull() {
            addCriterion("teacher_award_introduction is null");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionIsNotNull() {
            addCriterion("teacher_award_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionEqualTo(String value) {
            addCriterion("teacher_award_introduction =", value, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionNotEqualTo(String value) {
            addCriterion("teacher_award_introduction <>", value, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionGreaterThan(String value) {
            addCriterion("teacher_award_introduction >", value, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_award_introduction >=", value, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionLessThan(String value) {
            addCriterion("teacher_award_introduction <", value, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionLessThanOrEqualTo(String value) {
            addCriterion("teacher_award_introduction <=", value, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionLike(String value) {
            addCriterion("teacher_award_introduction like", value, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionNotLike(String value) {
            addCriterion("teacher_award_introduction not like", value, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionIn(List<String> values) {
            addCriterion("teacher_award_introduction in", values, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionNotIn(List<String> values) {
            addCriterion("teacher_award_introduction not in", values, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionBetween(String value1, String value2) {
            addCriterion("teacher_award_introduction between", value1, value2, "teacherAwardIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherAwardIntroductionNotBetween(String value1, String value2) {
            addCriterion("teacher_award_introduction not between", value1, value2, "teacherAwardIntroduction");
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