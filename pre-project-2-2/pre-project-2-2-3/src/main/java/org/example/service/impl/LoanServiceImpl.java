package org.example.service.impl;

import org.example.dto.LoanSum;
import org.example.dto.UserIncome;
import org.example.model.Car;
import org.example.model.User;
import org.example.service.IncomeService;
import org.example.service.LoanService;
import org.example.service.UserService;
import org.example.service.impl.IncomeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private final int minIncomeValue;

    private final int minCarPrice;

    private final double carPricePartToComputeLoan;

    private final int countMonthsToComputeLoan;

    private final IncomeService incomeService;

    private final UserService userService;

    @Autowired
    public LoanServiceImpl(@Value("${loan.minimalincome}") int minIncomeValue,
                           @Value("${loan.minimalcarprice}") int minCarPrice,
                           @Value("${loan.car-price-part-to-compute}") double carPricePartToComputeLoan,
                           @Value("${loan.months-to-compute}") int countMonthsToComputeLoan,
                           IncomeService incomeService,
                           UserService userService) {
        this.minIncomeValue = minIncomeValue;
        this.minCarPrice =  minCarPrice;
        this.carPricePartToComputeLoan = carPricePartToComputeLoan;
        this.countMonthsToComputeLoan = countMonthsToComputeLoan;
        this.incomeService = incomeService;
        this.userService = userService;
    }


    @Override
    public LoanSum computeApplyLoanSum(Long userId) {
        Optional<User> userOp = userService.getUserById(userId);
        if (userOp.isPresent()) {
            User user = userOp.get();
            UserIncome userIncome = incomeService.getUserIncome(userId);
            Car car = user.getCar();
            if ((userIncome.getIncome() != null && userIncome.getIncome() > minIncomeValue) ||
                (car != null && car.getPrice() != null && car.getPrice() >= minCarPrice)) {
                int carPrice = 0;
                if (car != null && car.getPrice() != null) {
                    carPrice = car.getPrice();
                }
                int income = 0;
                if (userIncome.getIncome() != null) {
                    income = userIncome.getIncome();
                }
                return new LoanSum(Math.max(
                        countMonthsToComputeLoan * income,
                        (int) (carPrice * carPricePartToComputeLoan)
                ));
            }
        }
        return new LoanSum(0);
    }
}
