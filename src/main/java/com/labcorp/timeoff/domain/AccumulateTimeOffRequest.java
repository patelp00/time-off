package com.labcorp.timeoff.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class AccumulateTimeOffRequest {

    @Min(value = 0)
    @Max(value = 260)
    private Integer workedDays;

}
