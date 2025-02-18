package org.capgemini.Problem_14.CsvToJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        // Path to the input CSV file and output JSON file
        String csvFilePath = "src/main/resources/StudentJsonToCsv.csv";
        String jsonFilePath = "src/main/resources/Student.json";

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            // Read the header
            String[] header = csvReader.readNext();

            // Create a list to store the student data as maps
            List<Map<String, Object>> students = new ArrayList<>();

            String[] record;
            while ((record = csvReader.readNext()) != null) {
                Map<String, Object> student = new HashMap<>();

                // Map the CSV columns to the header keys
                for (int i = 0; i < header.length; i++) {
                    student.put(header[i], record[i]);
                }

                // Add the student map to the list
                students.add(student);
            }

            // Use ObjectMapper to convert the list to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(jsonFilePath), students);

            System.out.println("JSON file has been written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
