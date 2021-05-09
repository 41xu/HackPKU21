package com.jimo.model;

import java.util.ArrayList;
import java.util.List;

public class DishExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DishExample() {
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

        public Criteria andDishIdIsNull() {
            addCriterion("dish_id is null");
            return (Criteria) this;
        }

        public Criteria andDishIdIsNotNull() {
            addCriterion("dish_id is not null");
            return (Criteria) this;
        }

        public Criteria andDishIdEqualTo(String value) {
            addCriterion("dish_id =", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotEqualTo(String value) {
            addCriterion("dish_id <>", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdGreaterThan(String value) {
            addCriterion("dish_id >", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdGreaterThanOrEqualTo(String value) {
            addCriterion("dish_id >=", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdLessThan(String value) {
            addCriterion("dish_id <", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdLessThanOrEqualTo(String value) {
            addCriterion("dish_id <=", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdLike(String value) {
            addCriterion("dish_id like", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotLike(String value) {
            addCriterion("dish_id not like", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdIn(List<String> values) {
            addCriterion("dish_id in", values, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotIn(List<String> values) {
            addCriterion("dish_id not in", values, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdBetween(String value1, String value2) {
            addCriterion("dish_id between", value1, value2, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotBetween(String value1, String value2) {
            addCriterion("dish_id not between", value1, value2, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishNameIsNull() {
            addCriterion("dish_name is null");
            return (Criteria) this;
        }

        public Criteria andDishNameIsNotNull() {
            addCriterion("dish_name is not null");
            return (Criteria) this;
        }

        public Criteria andDishNameEqualTo(String value) {
            addCriterion("dish_name =", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameNotEqualTo(String value) {
            addCriterion("dish_name <>", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameGreaterThan(String value) {
            addCriterion("dish_name >", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameGreaterThanOrEqualTo(String value) {
            addCriterion("dish_name >=", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameLessThan(String value) {
            addCriterion("dish_name <", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameLessThanOrEqualTo(String value) {
            addCriterion("dish_name <=", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameLike(String value) {
            addCriterion("dish_name like", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameNotLike(String value) {
            addCriterion("dish_name not like", value, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameIn(List<String> values) {
            addCriterion("dish_name in", values, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameNotIn(List<String> values) {
            addCriterion("dish_name not in", values, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameBetween(String value1, String value2) {
            addCriterion("dish_name between", value1, value2, "dishName");
            return (Criteria) this;
        }

        public Criteria andDishNameNotBetween(String value1, String value2) {
            addCriterion("dish_name not between", value1, value2, "dishName");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCanteenIsNull() {
            addCriterion("canteen is null");
            return (Criteria) this;
        }

        public Criteria andCanteenIsNotNull() {
            addCriterion("canteen is not null");
            return (Criteria) this;
        }

        public Criteria andCanteenEqualTo(String value) {
            addCriterion("canteen =", value, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenNotEqualTo(String value) {
            addCriterion("canteen <>", value, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenGreaterThan(String value) {
            addCriterion("canteen >", value, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenGreaterThanOrEqualTo(String value) {
            addCriterion("canteen >=", value, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenLessThan(String value) {
            addCriterion("canteen <", value, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenLessThanOrEqualTo(String value) {
            addCriterion("canteen <=", value, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenLike(String value) {
            addCriterion("canteen like", value, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenNotLike(String value) {
            addCriterion("canteen not like", value, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenIn(List<String> values) {
            addCriterion("canteen in", values, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenNotIn(List<String> values) {
            addCriterion("canteen not in", values, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenBetween(String value1, String value2) {
            addCriterion("canteen between", value1, value2, "canteen");
            return (Criteria) this;
        }

        public Criteria andCanteenNotBetween(String value1, String value2) {
            addCriterion("canteen not between", value1, value2, "canteen");
            return (Criteria) this;
        }

        public Criteria andIndegrentIsNull() {
            addCriterion("indegrent is null");
            return (Criteria) this;
        }

        public Criteria andIndegrentIsNotNull() {
            addCriterion("indegrent is not null");
            return (Criteria) this;
        }

        public Criteria andIndegrentEqualTo(String value) {
            addCriterion("indegrent =", value, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentNotEqualTo(String value) {
            addCriterion("indegrent <>", value, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentGreaterThan(String value) {
            addCriterion("indegrent >", value, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentGreaterThanOrEqualTo(String value) {
            addCriterion("indegrent >=", value, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentLessThan(String value) {
            addCriterion("indegrent <", value, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentLessThanOrEqualTo(String value) {
            addCriterion("indegrent <=", value, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentLike(String value) {
            addCriterion("indegrent like", value, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentNotLike(String value) {
            addCriterion("indegrent not like", value, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentIn(List<String> values) {
            addCriterion("indegrent in", values, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentNotIn(List<String> values) {
            addCriterion("indegrent not in", values, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentBetween(String value1, String value2) {
            addCriterion("indegrent between", value1, value2, "indegrent");
            return (Criteria) this;
        }

        public Criteria andIndegrentNotBetween(String value1, String value2) {
            addCriterion("indegrent not between", value1, value2, "indegrent");
            return (Criteria) this;
        }

        public Criteria andCaloriesIsNull() {
            addCriterion("calories is null");
            return (Criteria) this;
        }

        public Criteria andCaloriesIsNotNull() {
            addCriterion("calories is not null");
            return (Criteria) this;
        }

        public Criteria andCaloriesEqualTo(Integer value) {
            addCriterion("calories =", value, "calories");
            return (Criteria) this;
        }

        public Criteria andCaloriesNotEqualTo(Integer value) {
            addCriterion("calories <>", value, "calories");
            return (Criteria) this;
        }

        public Criteria andCaloriesGreaterThan(Integer value) {
            addCriterion("calories >", value, "calories");
            return (Criteria) this;
        }

        public Criteria andCaloriesGreaterThanOrEqualTo(Integer value) {
            addCriterion("calories >=", value, "calories");
            return (Criteria) this;
        }

        public Criteria andCaloriesLessThan(Integer value) {
            addCriterion("calories <", value, "calories");
            return (Criteria) this;
        }

        public Criteria andCaloriesLessThanOrEqualTo(Integer value) {
            addCriterion("calories <=", value, "calories");
            return (Criteria) this;
        }

        public Criteria andCaloriesIn(List<Integer> values) {
            addCriterion("calories in", values, "calories");
            return (Criteria) this;
        }

        public Criteria andCaloriesNotIn(List<Integer> values) {
            addCriterion("calories not in", values, "calories");
            return (Criteria) this;
        }

        public Criteria andCaloriesBetween(Integer value1, Integer value2) {
            addCriterion("calories between", value1, value2, "calories");
            return (Criteria) this;
        }

        public Criteria andCaloriesNotBetween(Integer value1, Integer value2) {
            addCriterion("calories not between", value1, value2, "calories");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andFlavorIsNull() {
            addCriterion("flavor is null");
            return (Criteria) this;
        }

        public Criteria andFlavorIsNotNull() {
            addCriterion("flavor is not null");
            return (Criteria) this;
        }

        public Criteria andFlavorEqualTo(String value) {
            addCriterion("flavor =", value, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorNotEqualTo(String value) {
            addCriterion("flavor <>", value, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorGreaterThan(String value) {
            addCriterion("flavor >", value, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorGreaterThanOrEqualTo(String value) {
            addCriterion("flavor >=", value, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorLessThan(String value) {
            addCriterion("flavor <", value, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorLessThanOrEqualTo(String value) {
            addCriterion("flavor <=", value, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorLike(String value) {
            addCriterion("flavor like", value, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorNotLike(String value) {
            addCriterion("flavor not like", value, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorIn(List<String> values) {
            addCriterion("flavor in", values, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorNotIn(List<String> values) {
            addCriterion("flavor not in", values, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorBetween(String value1, String value2) {
            addCriterion("flavor between", value1, value2, "flavor");
            return (Criteria) this;
        }

        public Criteria andFlavorNotBetween(String value1, String value2) {
            addCriterion("flavor not between", value1, value2, "flavor");
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