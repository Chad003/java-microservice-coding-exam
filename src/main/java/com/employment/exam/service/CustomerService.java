package com.employment.exam.service;

import com.employment.exam.dto.request.customer.CreateCustomerRequest;
import com.employment.exam.dto.response.customer.CreateCustomerResponse;
import com.employment.exam.dto.response.customer.GetCustomerByIdResponse;
import org.springframework.stereotype.Service;

public interface CustomerService {
    CreateCustomerResponse createCustomer(CreateCustomerRequest request);
    GetCustomerByIdResponse getCustomerInfo(Long customerId);
}
