package com.employment.exam.exceptions;

import com.employment.exam.dto.response.Response;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class RequestExceptions {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleBadRequestException(MethodArgumentNotValidException exception){
        Response response = new Response();
        response.setTransactionStatusCode(HttpStatus.BAD_REQUEST.value());
        FieldError fieldError = exception.getBindingResult().getFieldError();
        if (Objects.nonNull(fieldError)) {
            response.setTransactionStatusDescription(fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Response> handleDuplicateData(DataIntegrityViolationException exception){
        Response response = new Response();
        response.setTransactionStatusCode(HttpStatus.CONFLICT.value());
        response.setTransactionStatusDescription(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(response);
    }
}
