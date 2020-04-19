package com.patryk.service;

import com.patryk.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EmployeeEarningSumService {
    public Map<String, Float> CountEarningsByOccupation(List<Employee> employees, StringToFloatService stringToFloatService){
        HashMap<String, Float> earnings = new HashMap<>();
        //grouping all employee by their Job name
        Map<String, List<Employee>> grouped = employees.stream().collect(Collectors.groupingBy(Employee::getJob));
        //filling earning map with key - job name , value summed salary of employees with the same job
        grouped.forEach((key, value) -> earnings.put(key, (float) value.stream().mapToDouble(y -> stringToFloatService.validateAndChangeStringToFloat(y.getSalary())).sum()));
        return earnings;
    }

    private  <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


}
