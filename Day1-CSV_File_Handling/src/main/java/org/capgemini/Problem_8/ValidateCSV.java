package org.capgemini.Problem_8;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ValidateCSV {
    public static void main(String[] args) throws IOException, CsvValidationException {
        String FilePath = "src/main/resources/data.csv"; // Define file path
        CSVReader csvReader = new CSVReader(new FileReader(FilePath)); // Initialize CSV reader
        String[] lines;
        boolean isFirstRow = true; // Flag to skip header row

        while ((lines = csvReader.readNext()) != null) {
            // Skip header row
            if (isFirstRow) {
                isFirstRow = false;
                continue;
            }

            // Extract and trim email
            String email = lines[0].trim();
            // Extract and trim phone number
            String phone = lines[1].trim();

            // Regex for email validation (supports common domains)
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$";
            // Regex for phone number validation (10 digits)
            String phoneRegex = "^[0-9]{10}$";

            // Validate email
            if (email.matches(emailRegex)) {
                System.out.println("email is valid : " + email);
            } else {
                System.out.println("Invalid email " + email);
            }

            // Validate phone number
            if (phone.matches(phoneRegex)) {
                System.out.println("Valid regex : " + phone);
            } else {
                System.out.println("invalid phone " + phone);
            }
        }
    }
}
