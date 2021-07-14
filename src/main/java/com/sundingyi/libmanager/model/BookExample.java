package com.sundingyi.libmanager.model;

import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;
    
    protected boolean distinct;
    
    protected List<Criteria> oredCriteria;
    
    public BookExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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
        
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }
        
        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }
        
        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }
        
        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        
        public Criteria andBooknameIsNull() {
            addCriterion("bookname is null");
            return (Criteria) this;
        }
        
        public Criteria andBooknameIsNotNull() {
            addCriterion("bookname is not null");
            return (Criteria) this;
        }
        
        public Criteria andBooknameEqualTo(String value) {
            addCriterion("bookname =", value, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameNotEqualTo(String value) {
            addCriterion("bookname <>", value, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameGreaterThan(String value) {
            addCriterion("bookname >", value, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameGreaterThanOrEqualTo(String value) {
            addCriterion("bookname >=", value, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameLessThan(String value) {
            addCriterion("bookname <", value, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameLessThanOrEqualTo(String value) {
            addCriterion("bookname <=", value, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameLike(String value) {
            addCriterion("bookname like", value, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameNotLike(String value) {
            addCriterion("bookname not like", value, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameIn(List<String> values) {
            addCriterion("bookname in", values, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameNotIn(List<String> values) {
            addCriterion("bookname not in", values, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameBetween(String value1, String value2) {
            addCriterion("bookname between", value1, value2, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andBooknameNotBetween(String value1, String value2) {
            addCriterion("bookname not between", value1, value2, "bookname");
            return (Criteria) this;
        }
        
        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }
        
        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }
        
        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }
        
        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedIsNull() {
            addCriterion("borrowed is null");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedIsNotNull() {
            addCriterion("borrowed is not null");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedEqualTo(Integer value) {
            addCriterion("borrowed =", value, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedNotEqualTo(Integer value) {
            addCriterion("borrowed <>", value, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedGreaterThan(Integer value) {
            addCriterion("borrowed >", value, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowed >=", value, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedLessThan(Integer value) {
            addCriterion("borrowed <", value, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedLessThanOrEqualTo(Integer value) {
            addCriterion("borrowed <=", value, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedIn(List<Integer> values) {
            addCriterion("borrowed in", values, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedNotIn(List<Integer> values) {
            addCriterion("borrowed not in", values, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedBetween(Integer value1, Integer value2) {
            addCriterion("borrowed between", value1, value2, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowed not between", value1, value2, "borrowed");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToIsNull() {
            addCriterion("borrowed_to is null");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToIsNotNull() {
            addCriterion("borrowed_to is not null");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToEqualTo(String value) {
            addCriterion("borrowed_to =", value, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToNotEqualTo(String value) {
            addCriterion("borrowed_to <>", value, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToGreaterThan(String value) {
            addCriterion("borrowed_to >", value, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToGreaterThanOrEqualTo(String value) {
            addCriterion("borrowed_to >=", value, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToLessThan(String value) {
            addCriterion("borrowed_to <", value, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToLessThanOrEqualTo(String value) {
            addCriterion("borrowed_to <=", value, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToLike(String value) {
            addCriterion("borrowed_to like", value, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToNotLike(String value) {
            addCriterion("borrowed_to not like", value, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToIn(List<String> values) {
            addCriterion("borrowed_to in", values, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToNotIn(List<String> values) {
            addCriterion("borrowed_to not in", values, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToBetween(String value1, String value2) {
            addCriterion("borrowed_to between", value1, value2, "borrowedTo");
            return (Criteria) this;
        }
        
        public Criteria andBorrowedToNotBetween(String value1, String value2) {
            addCriterion("borrowed_to not between", value1, value2, "borrowedTo");
            return (Criteria) this;
        }
    }
    
    /**
     *
     */
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