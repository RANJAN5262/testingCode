package com.ValidationProjectApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmiRequest {

    private String customerName;
    private Double principalAmount;
    private Double interestRate;
    private Integer loanTenureMonths;  // user only passes this
}
