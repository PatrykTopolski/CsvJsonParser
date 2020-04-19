package com.patryk.service;

import com.patryk.model.Employee;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeEarningSumService {
    public Map<String, Float> CountEarningsByOccupation(List<Employee> employees, StringToFloatService stringToFloatService){
        HashMap<String, Float> earnings = new HashMap<>();

        Map<String, List<Employee>> grouped = employees
                .stream()
                .collect(groupingBy(Employee::getJob));

        grouped.forEach((key, value) -> earnings.put(key, (float) value
                .stream()
                .mapToDouble(y -> stringToFloatService.validateAndChangeStringToFloat(y.getSalary()))
                .sum()));
        return earnings;
    }




}
