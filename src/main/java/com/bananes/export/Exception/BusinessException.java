package com.bananes.export.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BusinessException extends ResponseStatusException {


    public BusinessException(String message) {
        super(HttpStatus.BAD_REQUEST,message);

    }


}
