package com.labcorp.timeoff.domain;

public class Manager extends Employee {
    private static final float VACATAION_LIMIT = 30.0f;

    private static final float ACUMULATION_FACTOR = VACATAION_LIMIT / 260.0f;

    public Manager(String name) {
        super(name);
    }

    @Override
    public void work(int workedDays) {
        super.accumulateVacationDays(workedDays, ACUMULATION_FACTOR);
    }
}
