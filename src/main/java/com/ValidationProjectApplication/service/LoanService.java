package com.ValidationProjectApplication.service;

import com.ValidationProjectApplication.dto.LoanSummaryResponse;
import com.ValidationProjectApplication.entity.LoanApplication;
import com.ValidationProjectApplication.repository.LoanApplicationRepository;
import com.ValidationProjectApplication.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

    @Autowired
    private final LoanRepository loanRepository;
    private final LoanApplicationRepository loanApplicationRepository;

    public LoanApplication saveLoan(LoanApplication loanApplication) {
        return loanRepository.save(loanApplication);
    }

    public LoanSummaryResponse getLoanSummaryById(Long id) {
        return loanApplicationRepository.findLoanSummaryById(id)
                .orElseThrow(() -> new RuntimeException("Loan application not found for id: " + id));
    }
}
