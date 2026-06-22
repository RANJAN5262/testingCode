package com.ValidationProjectApplication.service;

import com.ValidationProjectApplication.dto.EmiRequest;
import com.ValidationProjectApplication.dto.EmiResponse;
import com.ValidationProjectApplication.entity.CustomerEmiDetails;
import com.ValidationProjectApplication.repository.CustomerEmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerEmiService {

    @Autowired
    private CustomerEmiRepository customerEmiRepository;

    // EMI Formula: [P * R * (1+R)^N] / [(1+R)^N - 1]
    private Double calculateEmi(Double principal, Double annualRate, Integer tenureMonths) {
        double monthlyRate = annualRate / (12 * 100);
        double power = Math.pow(1 + monthlyRate, tenureMonths);
        return (principal * monthlyRate * power) / (power - 1);
    }

    // POST - Save EMI details
    public EmiResponse saveEmiDetails(EmiRequest request) {
        Double emi = calculateEmi(request.getPrincipalAmount(), request.getInterestRate(), request.getLoanTenureMonths());
        int tenureYears = request.getLoanTenureMonths() / 12;

        CustomerEmiDetails entity = CustomerEmiDetails.builder()
                .customerName(request.getCustomerName())
                .principalAmount(request.getPrincipalAmount())
                .interestRate(request.getInterestRate())
                .loanTenureMonths(request.getLoanTenureMonths())
                .loanTenureYears(tenureYears)
                .emiAmount(Math.round(emi * 100.0) / 100.0)
                .totalAmount(Math.round(emi * request.getLoanTenureMonths() * 100.0) / 100.0)
                .build();

        CustomerEmiDetails saved = customerEmiRepository.save(entity);
        return mapToResponse(saved);
    }

    // GET - By Loan ID
    public EmiResponse getById(Long id) {
        CustomerEmiDetails entity = customerEmiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EMI record not found for id: " + id));
        return mapToResponse(entity);
    }

    // GET - By Customer Name
    public List<EmiResponse> getByCustomerName(String customerName) {
        return customerEmiRepository.findByCustomerName(customerName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private EmiResponse mapToResponse(CustomerEmiDetails e) {
        return EmiResponse.builder()
                .id(e.getId())
                .customerName(e.getCustomerName())
                .principalAmount(e.getPrincipalAmount())
                .interestRate(e.getInterestRate())
                .loanTenureMonths(e.getLoanTenureMonths())
                .emiAmount(e.getEmiAmount())
                .totalAmountMonthly(e.getTotalAmount())
                .loanTenureYears(e.getLoanTenureYears())
                .yearlyPayment(Math.round(e.getEmiAmount() * 12 * 100.0) / 100.0)
                .totalAmountYearly(e.getTotalAmount())
                .build();
    }
}
