package com.example.travel_tours.exception;

import com.example.travel_tours.model.enums.ExceptionConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.travel_tours.model.enums.ExceptionConstants.UNEXPECTED_EXCEPTION;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handle(Exception ex){
        log.error("ActionLog.handle.error", ex);
        return new ErrorResponse(UNEXPECTED_EXCEPTION.getCode(),UNEXPECTED_EXCEPTION.getMessage());
    }

    public ErrorResponse handle(NotFuondException ex){
        log.error("ActionLog.handle.error", ex);
        return new ErrorResponse(ex.getCode(),ex.getMessage());
    }



}
