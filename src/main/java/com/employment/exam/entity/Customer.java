package com.employment.exam.entity;

import com.employment.exam.constants.CustomerConst;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String customerName;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String customerMobile;

    @NotBlank
    @Email
    @Size(max = 50)
    @Column(nullable = false, length = 50, unique = true)
    private String customerEmail;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String address1;

    @Size(max = 100)
    @Column(length = 100)
    private String address2;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 1)
    private CustomerConst.ACCOUNT_TYPE accountType;
}