package com.patryk.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.patryk.model.Employee;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.util.Collections;
import java.util.List;

@Repository
public class CsvReader implements DataReader{

    public  List<Employee> readData(String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema
                    .emptySchema()
                    .withHeader()
                    .withColumnSeparator(';')
                    .withoutQuoteChar();

            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();

            MappingIterator<Employee> readValues = mapper
                            .reader(Employee.class)
                            .with(bootstrapSchema)
                            .readValues(file);

            return repairAcquiredString(readValues.readAll());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private List<Employee> repairAcquiredString(List<Employee> employees){
         employees.forEach(x -> {
             x.setJob(x.getJob().replace("\"", "").trim());
             x.setName(x.getName().replace("\"", "").trim());
             x.setSurname(x.getSurname().replace("\"", "").trim());
             x.setSalary(x.getSalary().replace("\"", "").trim());
         });
        return employees;
    }
}
