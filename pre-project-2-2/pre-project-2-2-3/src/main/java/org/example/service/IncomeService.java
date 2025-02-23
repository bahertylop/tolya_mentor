package org.example.service;

import org.example.dto.UserIncome;

import java.util.List;

public interface IncomeService {

    List<UserIncome> getIncomeData();

    UserIncome getUserIncome(Long userId);
}
