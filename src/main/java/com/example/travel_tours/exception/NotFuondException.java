package com.example.travel_tours.exception;

import lombok.Getter;

@Getter
public class NotFuondException extends RuntimeException{
    private String code;

    public NotFuondException(String message, String code) {
        super(message);
        this.code = code;
    }
}
