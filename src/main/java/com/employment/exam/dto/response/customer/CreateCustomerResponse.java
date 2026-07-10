package com.employment.exam.dto.response.customer;

import com.employment.exam.dto.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerResponse extends Response {
    private Long customerNumber;
}
