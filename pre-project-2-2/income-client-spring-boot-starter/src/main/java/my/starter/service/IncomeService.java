package my.starter.service;

import my.starter.dto.UserIncome;

import java.util.List;

public interface IncomeService {

    List<UserIncome> getIncomeData();

    UserIncome getUserIncome(Long userId);
}
