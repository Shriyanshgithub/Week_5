package org.capgemini.Problem_7;

import com.opencsv.bean.CsvBindByName;

public class Employee {

    @CsvBindByName(column = "Employee_ID")   // Column in CSV
    private int employee_ID;

    @CsvBindByName(column = "Name")          // Column in CSV
    private String name;

    @CsvBindByName(column = "Department")    // Column in CSV
    private String department;

    @CsvBindByName(column = "Salary")        // Column in CSV
    private int salary;

    // Getters and Setters
    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
