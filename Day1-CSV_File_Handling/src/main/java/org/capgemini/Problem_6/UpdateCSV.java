package org.capgemini.Problem_6;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        // Original CSV file
        String inputFile = "src/main/resources/EmployeeData.csv";
        // New updated CSV file
        String outputFile = "src/main/resources/Employee.csv";

        List<String[]> updatedData = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(inputFile));
             CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile))) {

            String[] row;
            boolean isHeader = true;

            while ((row = csvReader.readNext()) != null) {
                // Add the header row unchanged
                if (isHeader) {
                    updatedData.add(row);
                    isHeader = false;
                    continue;
                }

                // Read department and salary columns
                String department = row[2].trim();
                double salary = Double.parseDouble(row[3].trim());

                // If department is IT, increase salary by 10%
                if (department.equalsIgnoreCase("IT")) {
                    // Increase by 10%
                    salary *= 1.10;
                    // Update salary with 2 decimal places
                    row[3] = String.format("%.2f", salary);
                }

                updatedData.add(row); // Add updated row
            }

            // Write updated data to new CSV file
            csvWriter.writeAll(updatedData);
            System.out.println("Updated CSV file saved successfully!");

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
