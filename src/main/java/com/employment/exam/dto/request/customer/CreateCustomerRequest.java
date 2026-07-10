package com.employment.exam.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {
    @NotEmpty(message = "Customer Name must not be empty")
    private String customerName;
    @NotEmpty(message = "Mobile number must not be empty")
    private String customerMobile;
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
    private String customerEmail;
    @NotEmpty(message = "Address must not be empty")
    private String address1;
    private String address2;
}
