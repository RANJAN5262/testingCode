package com.ValidationProjectApplication.controller;

import com.ValidationProjectApplication.dto.EmiRequest;
import com.ValidationProjectApplication.dto.EmiResponse;
import com.ValidationProjectApplication.service.CustomerEmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emi")
public class CustomerEmiController {

    @Autowired
    private CustomerEmiService customerEmiService;

    @PostMapping("/save")
    public ResponseEntity<EmiResponse> saveEmi(@RequestBody EmiRequest request) {
        return ResponseEntity.ok(customerEmiService.saveEmiDetails(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmiResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerEmiService.getById(id));
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<EmiResponse>> getByName(@RequestParam String customerName) {
        return ResponseEntity.ok(customerEmiService.getByCustomerName(customerName));
    }
}

