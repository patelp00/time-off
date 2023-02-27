package com.labcorp.timeoff.domain;

import com.labcorp.timeoff.exception.VacationLimitReachedException;
import com.labcorp.timeoff.exception.NotEnoughVacationException;

public abstract class Employee {

    private String employeeNumber;
    private String name;
    protected float vacationDays = 0.0f;

    public Employee(String employeeNumber, String name) {
        this.employeeNumber = employeeNumber;
        this.name = name;
    }

    public abstract void work(float workedDays);

    public void accumulateVacationDays(int workedDays, float ACUMULATION_FACTOR) {
        float earnedDays = ACUMULATION_FACTOR * workedDays;
        if(this.vacationDays + earnedDays > VACATAION_LIMIT) {
            throw new VacationLimitReachedException("Vacation accumulation max limit reached. ")
        }
        this.vacationDays = this.vacationDays + earnedDays;
    }

    public void takeVacation(float daysTaken) {
        float value = vacationDays - daysTaken;
        if (value < 0) {
            throw new NotEnoughVacationException("Not enough vacation days accumulated.")
        }
        vacationDays = value;
    }

    public float getVacationDays() {
        return vacationDays;
    }
}
