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
public class JsonSalarySumController implements DataSalarySumController {
    private final DataReader reader;
    private final StringToFloatService stfService;
    private final EmployeeEarningSumService empService;

    public JsonSalarySumController(@Qualifier("jsonReader") DataReader reader, StringToFloatService stfService, EmployeeEarningSumService empService) {
        this.reader = reader;
        this.stfService = stfService;
        this.empService = empService;
    }

    public void ReturnCalculatedDataToConsole(){
        Map<String, Float> salaryPerJob = empService.CountEarningsByOccupation(reader.readData("employees (2) .json"), stfService);
        System.out.println("Calculated Data Json: ");
        salaryPerJob.forEach( (x, y) -> System.out.println("Occupation: " + x +  " Combined Salary: " + y));
    }
}
