package org.capgemini.Problem_5;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecordInCSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take the name as input from the user
        System.out.println("Enter the name ");
        String name = sc.next();

        try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/duplicate.csv"))) {
            String[] lines;

            // Skip the header row
            csvReader.readNext();

            while ((lines = csvReader.readNext()) != null) {
                // Check if the second column (Name) matches the input
                if (lines[1].equals(name)) {
                    // Print the entire matching row
                    for (String string : lines) {
                        System.out.print(string + " , ");
                    }
                    // Stop searching after the first match
                    break;
                }
            }
        }
        catch (IOException e) {
            // Handle file reading errors
            e.printStackTrace();
        }
        catch (CsvValidationException e) {
            // Handle CSV parsing errors
            throw new RuntimeException(e);
        }
    }
}
