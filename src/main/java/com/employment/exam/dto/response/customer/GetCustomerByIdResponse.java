package com.employment.exam.dto.response.customer;

import com.employment.exam.dto.response.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCustomerByIdResponse extends Response {
    private Long customerNumber;
    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private List<Savings> savings;

    @Getter
    @Setter
    public static class Savings{
        private Long accountNumber;
        private String accountType;
        private BigDecimal availableBalance;
    }
}
