package com.labcorp.timeoff.exception.exception;

public class VacationLimitReachedException extends Exception {

    public VacationLimitReachedException(String errorMessage) {
        super(errorMessage);
    }
}
