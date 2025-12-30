package com.sumithra.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PastesException extends RuntimeException{
    public PastesException(String mess) {
        super(mess);
    }
}
