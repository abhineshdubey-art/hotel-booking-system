package com.guest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Hotel not found")
public class ResourceNotFoundException extends RuntimeException {

   public ResourceNotFoundException(String message) {
        super(message);
    }
}
