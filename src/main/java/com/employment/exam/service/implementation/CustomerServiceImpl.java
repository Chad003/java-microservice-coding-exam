package com.employment.exam.service.implementation;

import com.employment.exam.constants.CustomerConst;
import com.employment.exam.dto.request.customer.CreateCustomerRequest;
import com.employment.exam.dto.response.customer.CreateCustomerResponse;
import com.employment.exam.dto.response.customer.GetCustomerByIdResponse;
import com.employment.exam.entity.Customer;
import com.employment.exam.repository.CustomerRepository;
import com.employment.exam.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        CreateCustomerResponse response = new CreateCustomerResponse();

        // Check if email already exist
        if(Objects.nonNull(customerRepository.getCustomerByCustomerEmail(request.getCustomerEmail()))){
            throw new DataIntegrityViolationException("Email already exists");
        }

        Customer newCustomer;
        newCustomer = new Customer();

        newCustomer.setCustomerName(request.getCustomerName());
        newCustomer.setCustomerMobile(request.getCustomerMobile());
        newCustomer.setCustomerEmail(request.getCustomerEmail());
        newCustomer.setAddress1(request.getAddress1());
        newCustomer.setAddress2(request.getAddress2());
        newCustomer.setAccountType(CustomerConst.ACCOUNT_TYPE.S);

        Customer saveCustomer = customerRepository.save(newCustomer);

        response.setCustomerNumber(saveCustomer.getId());
        response.setTransactionStatusCode(201);
        response.setTransactionStatusDescription("Customer account created");
        return response;
    }

    @Override
    public GetCustomerByIdResponse getCustomerInfo(Long customerId) {
        GetCustomerByIdResponse response = new GetCustomerByIdResponse();
        Customer customerFromDB = customerRepository.getCustomerById(customerId);

        if(Objects.isNull(customerFromDB)){
            response.setTransactionStatusCode(HttpStatus.NOT_FOUND.value());
            response.setTransactionStatusDescription("Customer not found");
            return response;
        }

        // Sample savings data only
        GetCustomerByIdResponse.Savings savings = new GetCustomerByIdResponse.Savings();
        savings.setAccountType(CustomerConst.ACCOUNT_TYPE.S.getAccountType());
        savings.setAccountNumber(10001L);
        savings.setAvailableBalance(BigDecimal.valueOf(5000));

        List<GetCustomerByIdResponse.Savings> savingsList = new ArrayList<>(); // Or fetch from Database
        savingsList.add(savings);

        response.setCustomerMobile(customerFromDB.getCustomerMobile());
        response.setCustomerEmail(customerFromDB.getCustomerEmail());
        response.setCustomerName(customerFromDB.getCustomerName());
        response.setAddress1(customerFromDB.getAddress1());
        response.setAddress1(customerFromDB.getAddress2());
        response.setSavings(savingsList);

        return response;
    }
}
