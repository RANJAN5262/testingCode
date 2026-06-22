package com.ValidationProjectApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEmiDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private Double principalAmount;
    private Double interestRate;
    private Integer loanTenureMonths;   // e.g. 24 months
    private Integer loanTenureYears;    // auto-derived (24/12 = 2 years)
    private Double emiAmount;           // auto-calculated
    private Double totalAmount;         // emiAmount * tenure
}
