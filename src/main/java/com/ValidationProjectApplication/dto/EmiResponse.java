package com.ValidationProjectApplication.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmiResponse {

    private Long id;
    private String customerName;
    private Double principalAmount;
    private Double interestRate;

    // Monthly breakdown
    private Integer loanTenureMonths;
    private Double emiAmount;
    private Double totalAmountMonthly;

    // Yearly breakdown
    private Integer loanTenureYears;
    private Double yearlyPayment;      // emiAmount * 12
    private Double totalAmountYearly;  // same as monthly total
}
