package com.ValidationProjectApplication.controller;

import com.ValidationProjectApplication.dto.LoanSummaryResponse;
import com.ValidationProjectApplication.entity.LoanApplication;
import com.ValidationProjectApplication.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanApplication> createLoan(
            @RequestBody LoanApplication loanApplication) {

        LoanApplication savedLoan =
                loanService.saveLoan(loanApplication);

        return new ResponseEntity<>(
                savedLoan,
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}/summary")
    public ResponseEntity<LoanSummaryResponse> getLoanSummary(@PathVariable Long id) {
        LoanSummaryResponse response = loanService.getLoanSummaryById(id);
        return ResponseEntity.ok(response);
    }

}
