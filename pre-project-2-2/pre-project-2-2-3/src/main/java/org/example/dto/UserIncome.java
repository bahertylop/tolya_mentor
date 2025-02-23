package org.example.dto;


public class UserIncome {

    private Long id;

    private Integer income;

    public UserIncome() {
    }

    public UserIncome(Long id, Integer income) {
        this.id = id;
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }
}
