package org.capgemini.Problem_11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {
    public static void main(String[] args) {
        // Update with actual file path
        String filePath = "src/main/resources/Student3.csv";
        // Process in chunks of 100 lines
        int batchSize = 100;
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                recordCount++;

                // Display progress every 100 records
                if (recordCount % batchSize == 0) {
                    System.out.println("Processed " + recordCount + " records...");
                }
            }

            System.out.println("Total records processed: " + recordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
