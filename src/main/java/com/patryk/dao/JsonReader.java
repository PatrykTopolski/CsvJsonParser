package com.patryk.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patryk.model.Employee;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Repository
public class JsonReader implements DataReader {
    public List<Employee> readData(String fileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new ClassPathResource(fileName).getFile();
            JsonNode rootNode = objectMapper.readTree(file);
            JsonNode nameNode = rootNode.path("employees");
            Iterator nodeIterator = nameNode.elements();
            List<Employee> employees = new ArrayList<>();

            nodeIterator.forEachRemaining(x -> {
                try {
                    employees.add(parseObjectToEmployeeObject(objectMapper, x));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            return employees;
        }catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private Employee parseObjectToEmployeeObject(ObjectMapper objectMapper, Object x) throws IOException {
        return objectMapper.readValue(x.toString(), Employee.class);
    }
}
