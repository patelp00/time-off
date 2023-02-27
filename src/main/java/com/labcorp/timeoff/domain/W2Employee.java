package com.labcorp.timeoff.domain;

public class W2Employee extends Employee {

    private static final float VACATAION_LIMIT = 15.0f;

    private static final float ACUMULATION_FACTOR = VACATAION_LIMIT / 260.0f;

    public W2Employee(String name) {
        super(name);
    }

    @Override
    public void work(int workedDays) {
        super.accumulateVacationDays(workedDays, ACUMULATION_FACTOR);
    }
}
