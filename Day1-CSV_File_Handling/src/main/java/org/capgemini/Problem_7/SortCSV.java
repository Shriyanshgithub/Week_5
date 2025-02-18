package org.capgemini.Problem_7;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SortCSV {
    public static void main(String[] args) {

        try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/sortData.csv"))) {
            // Skip the header
            csvReader.readNext();

            // Parse the CSV file into a list of Employee objects
            List<Employee> employeeList = new CsvToBeanBuilder<Employee>(csvReader)
                    .withType(Employee.class)
                    .build()
                    .parse();

            // Sort the employee list by salary in descending order
            employeeList.sort((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()));

            // Print the sorted list
            for (Employee employee : employeeList) {
                System.out.println(employee.getEmployee_ID() + " , " + employee.getName() + " , " + employee.getDepartment() + " , " + employee.getSalary());
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
