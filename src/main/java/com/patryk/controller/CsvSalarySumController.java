package com.patryk.controller;

import com.patryk.dao.DataReader;
import com.patryk.model.Employee;
import com.patryk.service.EmployeeEarningSumService;
import com.patryk.service.StringToFloatService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class CsvSalarySumController implements DataSalarySumController {
    private final DataReader reader;
    private final StringToFloatService stfService;
    private final EmployeeEarningSumService empService;

    public CsvSalarySumController(@Qualifier("csvReader")DataReader reader, StringToFloatService stfService, EmployeeEarningSumService empService) {
        this.reader = reader;
        this.stfService = stfService;
        this.empService = empService;
    }

    public void ReturnCalculatedDataToConsole(){
        Map<String, Float> salaryPerJob = empService.CountEarningsByOccupation(reader.readData("employees (3).csv"), stfService);
        System.out.println("Calculated Data ForCsv: ");
        salaryPerJob.forEach( (x, y) -> System.out.println("Occupation: " + x +  " Combined Salary: " + y));
    }
}
