package com.ValidationProjectApplication.repository;

import com.ValidationProjectApplication.entity.CustomerEmiDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerEmiRepository extends JpaRepository <CustomerEmiDetails, Long> {

    List<CustomerEmiDetails> findByCustomerName(String customerName);
}
