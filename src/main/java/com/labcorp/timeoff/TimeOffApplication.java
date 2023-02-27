package com.labcorp.timeoff;

import javax.validation.Valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@SpringBootApplication
@RestController
@RequestMapping("/api/timeoff-service")
@Validated
public class TimeOffApplication implements CommandLineRunner {

    public static List<Employee> employeeList;

    public static void main(String[] args) {
        SpringApplication.run(TimeOffApplication.class, args);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @PostMapping("/employees/{employeeNumber}/accumulate-timeOff")
    public Employee accumulateTimeOff(@PathVariable("employeeNumber") String employeeNumber,
                                      @RequestBody @Valid AccumulateTimeOffRequest request) {
        Employee employee = employeeList.stream().filter(emp -> emp.getEmployeeNumber().equals(employeeNumber))
                .findFirst().orElse(null);
        if(employee == null) {
            // TODO: - throw ResourceNotFoundException(..);
        }
        employee.work(request.getWorkedDays());
        return employee;
    }

    @PostMapping("/employees/{employeeNumber}/take-timeOff/{timeOffDays}")
    public Employee takeTimeOff(@PathVariable("employeeNumber") String employeeNumber,
                                @PathVariable("timeOffDays") String timeOffDays) {
        Employee employee = employeeList.stream().filter(emp -> emp.getEmployeeNumber().equals(employeeNumber))
                .findFirst().orElse(null);
        if(employee == null) {
            // TODO: - throw ResourceNotFoundException(..);
        }
        employee.takeVacation(Float.parseFloat(timeOffDays));
        return employee;
    }

    @Override
    public void run(String...args) throws Exception {
        employeeList = new ArrayList<>();
        IntStream.iterate(0, n -> n+1).limit(10).forEach(i -> {
            employeeList.add(new HourlyEmployee("HourlyEmployee" + i,"HourlyEmployee" + i ));
            employeeList.add(new W2Employee("W2Employee" + i, "W2Employee" + i));
            employeeList.add(new Manager("Manager" + i, "Manager" + i));
        });
    }
}
