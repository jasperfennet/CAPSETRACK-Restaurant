package com.capgemini.restaurant.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class InvalidTableFormatException extends RuntimeException {

    public InvalidTableFormatException(String message) {
        super(message);
    }

}
