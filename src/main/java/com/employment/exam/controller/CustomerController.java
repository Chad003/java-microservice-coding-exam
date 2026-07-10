package com.employment.exam.controller;

import com.employment.exam.dto.request.customer.CreateCustomerRequest;
import com.employment.exam.dto.response.customer.CreateCustomerResponse;
import com.employment.exam.dto.response.customer.GetCustomerByIdResponse;
import com.employment.exam.service.CustomerService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("account")
    public CreateCustomerResponse create(@Valid @RequestBody CreateCustomerRequest request){
        return customerService.createCustomer(request);
    }

    @GetMapping("account/{customerId}")
    public GetCustomerByIdResponse getCustomerByIdResponse(@PathVariable Long customerId){
        return customerService.getCustomerInfo(customerId);
    }
}
