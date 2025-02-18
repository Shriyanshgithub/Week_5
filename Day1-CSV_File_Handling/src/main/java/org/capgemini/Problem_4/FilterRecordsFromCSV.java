package org.capgemini.Problem_4;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsFromCSV {
    public static void main(String[] args) {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/studentData.csv"))) {
            String[] lines;

            // Skip header
            csvReader.readNext();

            // Read each line and filter by marks
            while ((lines = csvReader.readNext()) != null) {
                int marks = Integer.parseInt(lines[2]); // Assuming marks are in the third column

                // Filter: If marks are greater than 80
                if (marks > 80) {
                    System.out.println("Student_ID: " + lines[0] + " , Name: " + lines[1] + " , Marks: " + lines[2]);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

