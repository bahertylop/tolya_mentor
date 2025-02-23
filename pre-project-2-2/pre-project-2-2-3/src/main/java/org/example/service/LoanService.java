package org.example.service;

import org.example.dto.LoanSum;

public interface LoanService {

    LoanSum computeApplyLoanSum(Long userId);
}
