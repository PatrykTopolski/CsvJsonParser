package com.patryk.model;

import com.patryk.service.StringToFloatService;
import org.springframework.beans.factory.annotation.Autowired;


public class Employee {
    private int id;
    private String name;
    private String surname;
    private String job;
    private String SalaryAsString;

    public Employee(int id, String name, String surname, String job, String salaryAsString) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.job = job;
        SalaryAsString = salaryAsString;
    }

    public Employee() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(String salary) {
        salary = salary = salary.replace("\"", "");
        SalaryAsString = salary.trim();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getJob() {
        return job;
    }

    public String getSalary() {
        return SalaryAsString;
    }



}
