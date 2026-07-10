package com.employment.exam.constants;

import lombok.Getter;

public interface CustomerConst {
    @Getter
    enum ACCOUNT_TYPE{
        S("Savings"),
        C("Checking"),
        ;

        final String accountType;

        ACCOUNT_TYPE(String accountType){
            this.accountType = accountType;
        }
    }
}
