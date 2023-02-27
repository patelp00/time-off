package com.labcorp.timeoff.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TimeOffExceptionHandler {

    @ExceptionHandler(NotEnoughVacationException.class)
    public ResponseEntity<ErrorMessage> handleNotEnoughVacationException(HttpServletRequest request,
                                                            NotEnoughVacationException e) {
        return new ResponseEntity<>(
               new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage(), e.getErrorCode());
    }

    @ExceptionHandler(VacationLimitReachedException.class)
    public ResponseEntity<ErrorMessage> handleVacationLimitReachedException(HttpServletRequest request,
                                                                            VacationLimitReachedException e) {
        return new ResponseEntity<>(
                new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage(), e.getErrorCode());
    }

}
