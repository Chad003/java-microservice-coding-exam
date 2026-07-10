package com.employment.exam.constants;

import lombok.Getter;

public interface StatusCodes {
    @Getter
    enum TRANSACTION_CODE{
        SUCCESS(0),
        FAILED(-1),
        ;

        final int statusCode;

        TRANSACTION_CODE(int statusCode){
            this.statusCode = statusCode;
        }
    }
}
