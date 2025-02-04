package com.ninja.khatabook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String month;
    private Long maxLimit;

    public Budget(){

    }
    public Budget(Long id, String month, Long maxLimit){
        this.id = id;
        this.month = month;
        this.maxLimit = maxLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    public Long getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Long maxLimit) {
        this.maxLimit = maxLimit;
    }
}
