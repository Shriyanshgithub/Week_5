package org.capgemini.Problem_14;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;
import java.util.Map;
public class JsonToCsvConverter {
    public static void main(String[] args) {
        // Path to the input JSON file and output CSV file
        String jsonFilePath = "src/main/resources/Student.json";
        String csvFilePath = "src/main/resources/StudentJsonToCsv.csv";

        try {
            // Create an ObjectMapper for JSON to Map conversion
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file into a list of maps
            List<Map<String, Object>> students = objectMapper.readValue(new File(jsonFilePath), List.class);

            // Prepare a CSVWriter to write to the CSV file
            try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath))) {
                // Write the header (assuming you know the column names in advance)
                String[] header = {"ID", "Name", "Age", "Marks"};
                csvWriter.writeNext(header);

                // Write each student record to CSV
                for (Map<String, Object> student : students) {
                    String[] record = {
                            student.get("id").toString(),
                            student.get("name").toString(),
                            student.get("age").toString(),
                            student.get("marks").toString()
                    };
                    csvWriter.writeNext(record);
                }
            }

            System.out.println("CSV file has been written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

