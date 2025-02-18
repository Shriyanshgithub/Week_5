package org.capgemini.Problem_2;


import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToCSV {
    public static void main(String[] args) {

        // Specify the path where the CSV file will be saved
        String filePath = "src/main/resources/Employee.csv";

        // Use CSVWriter to write data to the specified CSV file
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {

            // Write the header row to the CSV file (column names)
            String[] header = {"Employee_ID", "Name", "Department", "Salary"};
            csvWriter.writeNext(header);

            // Write first employee record
            String[] employee1 = {"1", "John Doe", "IT", "60000"};
            csvWriter.writeNext(employee1);

            // Write second employee record
            String[] employee2 = {"2", "Jane Smith", "HR", "55000"};
            csvWriter.writeNext(employee2);

            // Write third employee record
            String[] employee3 = {"3", "Robert Brown", "Finance", "72000"};
            csvWriter.writeNext(employee3);

            // Write fourth employee record
            String[] employee4 = {"4", "Alice Johnson", "IT", "65000"};
            csvWriter.writeNext(employee4);

            // Write fifth employee record
            String[] employee5 = {"5", "Michael Scott", "Sales", "58000"};
            csvWriter.writeNext(employee5);

            // Confirm the successful writing of employee records
            System.out.println("Employee records have been written to the CSV file successfully.");
        } catch (IOException e) {
            // Print the stack trace if an error occurs while writing to the file
            e.printStackTrace();
        }
    }
}

