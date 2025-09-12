package com.ohgiraffers.dynamic;

import java.util.Objects;

public class SearchCriteria {
    private String condition;   // 검색 조건
    private String value;       // 검색어

    public SearchCriteria() {
    }

    public SearchCriteria(String condition, String value) {
        this.condition = condition;
        this.value = value;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SearchCriteria that = (SearchCriteria) o;
        return Objects.equals(condition, that.condition) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, value);
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "condition='" + condition + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
