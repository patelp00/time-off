package com.labcorp.timeoff.exception;

public class NotEnoughVacationException extends Exception {

    public NotEnoughVacationException(String errorMessage) {
        super(errorMessage);
    }
}
