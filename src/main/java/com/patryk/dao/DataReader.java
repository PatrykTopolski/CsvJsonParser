package com.patryk.dao;

import com.patryk.model.Employee;

import java.util.List;

public interface DataReader {
    public List<Employee> ReadData(String fileName);
}
