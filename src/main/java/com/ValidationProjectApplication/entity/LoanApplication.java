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
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String panNumber;
    private String aadhaarNumber;
    private String address;
    private Double loanAmount;
    private Integer loanTenure;

    public LoanApplication(String fullName, Double loanAmount) {
    }

//    public LoanApplication(Long id, String fullName, String panNumber, String aadhaarNumber, String address, Double loanAmount, Integer loanTenure) {
//        this.id = id;
//        this.fullName = fullName;
//        this.panNumber = panNumber;
//        this.aadhaarNumber = aadhaarNumber;
//        this.address = address;
//        this.loanAmount = loanAmount;
//        this.loanTenure = loanTenure;
//    }

}
