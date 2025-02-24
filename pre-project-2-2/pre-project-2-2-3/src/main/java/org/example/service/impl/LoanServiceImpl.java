package org.example.service.impl;

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
        Optional<User> userOp = userService.getUserById(userId);
        if (userOp.isPresent()) {
            User user = userOp.get();
            UserIncome userIncome = incomeService.getUserIncome(userId);
            Car car = user.getCar();
            if ((userIncome.getIncome() != null && userIncome.getIncome() > properties.getMinimalIncome()) ||
                (car != null && car.getPrice() != null && car.getPrice() >= properties.getMinimalCarPrice())) {
                int carPrice = 0;
                if (car != null && car.getPrice() != null) {
                    carPrice = car.getPrice();
                }
                int income = 0;
                if (userIncome.getIncome() != null) {
                    income = userIncome.getIncome();
                }
                return new LoanSum(Math.max(
                        properties.getMonthsToCompute() * income,
                        (int) (carPrice * properties.getCarPricePartToCompute())
                ));
            }
        }
        return new LoanSum(0);
    }
}
