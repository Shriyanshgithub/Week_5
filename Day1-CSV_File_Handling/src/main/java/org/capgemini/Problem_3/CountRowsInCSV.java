package org.capgemini.Problem_3;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CountRowsInCSV {
    public static void main(String[] args) {
        int recordCount = 0;  // To count the number of records

        try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/studentData.csv"))) {
            String[] lines;

            // Skip header row
            csvReader.readNext();

            // Read each line and count the records
            while ((lines = csvReader.readNext()) != null) {
                recordCount++;
            }

            // Output the count of records
            System.out.println("Number of records (excluding header): " + recordCount);
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

