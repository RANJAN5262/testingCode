package com.ValidationProjectApplication.repository;

import com.ValidationProjectApplication.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository <LoanApplication, Long> {
}
