package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.config.LoanServiceProperties;
import org.example.model.Car;
import org.example.service.UserService;
import org.example.dto.LoanSum;
import org.example.model.User;
import org.example.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import my.starter.dto.UserIncome;
import my.starter.service.IncomeService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final IncomeService incomeService;

    private final UserService userService;

    private final LoanServiceProperties properties;

    @Override
    public LoanSum computeApplyLoanSum(Long userId) {
        return userService.getUserById(userId)
                .map(user -> {
                    UserIncome userIncome = incomeService.getUserIncome(userId);
                    Car car = user.getCar();

                    int income = Optional.ofNullable(userIncome.getIncome()).orElse(0);
                    int carPrice = Optional.ofNullable(car.getPrice()).orElse(0);

                    if ((income > properties.getMinimalIncome()) ||
                            (carPrice >= properties.getMinimalCarPrice())) {
                        return new LoanSum(Math.max(
                                properties.getMonthsToCompute() * income,
                                (int) (properties.getCarPricePartToCompute() * carPrice)
                        ));
                    }
                    return new LoanSum(0);
                })
                .orElse(new LoanSum(0));
    }
}
