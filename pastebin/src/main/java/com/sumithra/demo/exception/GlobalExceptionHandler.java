package com.sumithra.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PastesException.class)
    public String handlePastesException(Model model) {
        model.addAttribute("message",
                "This paste is expired, deleted, or has reached its view limit.");
        return "error";
    }
}
