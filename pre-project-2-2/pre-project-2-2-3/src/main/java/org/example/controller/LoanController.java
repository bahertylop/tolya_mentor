package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.LoanSum;
import org.example.service.LoanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping
    public LoanSum computeApplyLoanSum(@RequestParam Long userId) {
        return loanService.computeApplyLoanSum(userId);
    }
}
