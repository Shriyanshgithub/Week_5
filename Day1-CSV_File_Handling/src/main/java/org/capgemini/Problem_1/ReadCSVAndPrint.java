package org.capgemini.Problem_1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ReadCSVAndPrint {
    public static void main(String[] args) {

        // Specify the path of the CSV file
        String filePath = "src/main/resources/student.csv";

        // Use CSVReader to read the CSV file
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {

            String[] record;

            // Skip the header row if necessary
            csvReader.readNext();

            // Loop through all records in the CSV
            while ((record = csvReader.readNext()) != null) {
                // Assuming the CSV structure is ID, Name, Age, Marks
                System.out.println("Student ID: " + record[0]);
                System.out.println("Name: " + record[1]);
                System.out.println("Roll: " + record[2]);
                System.out.println("Marks: " + record[3]);
                System.out.println("----------------------------");
            }

        } catch (IOException | CsvValidationException e) {
            // Handle any exceptions that occur while reading the CSV
            e.printStackTrace();
        }
    }
}

