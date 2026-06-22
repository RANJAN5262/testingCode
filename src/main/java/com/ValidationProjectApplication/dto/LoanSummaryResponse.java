package com.ValidationProjectApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanSummaryResponse {

    private String fullName;
    private Double loanAmount;
}
