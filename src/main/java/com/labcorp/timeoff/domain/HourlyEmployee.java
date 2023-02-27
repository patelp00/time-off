package com.labcorp.timeoff.domain;

public class HourlyEmployee extends Employee {

    private static final float VACATAION_LIMIT = 10.0f;

    private static final float ACUMULATION_FACTOR = VACATAION_LIMIT / 260;

    public HourlyEmployee(String name) {
        super(name);
    }

    @Override
    public void work(int workedDays) {
        super.accumulateVacationDays(workedDays, ACUMULATION_FACTOR);
    }

}
