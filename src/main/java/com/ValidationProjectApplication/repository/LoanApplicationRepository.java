package com.ValidationProjectApplication.repository;

import com.ValidationProjectApplication.dto.LoanSummaryResponse;
import com.ValidationProjectApplication.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoanApplicationRepository extends JpaRepository <LoanApplication, Long> {
    @Query("SELECT new com.ValidationProjectApplication.dto.LoanSummaryResponse(l.fullName, l.loanAmount) FROM LoanApplication l WHERE l.id = :id")
    Optional<LoanSummaryResponse> findLoanSummaryById(@Param("id") Long id);
}
