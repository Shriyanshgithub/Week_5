package org.capgemini.Problem_12;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DetectDuplicateInCSV {
    public static void main(String[] args) throws FileNotFoundException {
        // Using LinkedHashMap to store unique records while maintaining insertion order
        Map<String , String[]> map = new LinkedHashMap<>();

        try(CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/duplicate.csv"))){
            String[] lines;

            // Skip the header row
            csvReader.readNext();

            while((lines = csvReader.readNext()) != null){
                // Check if ID already exists in the map
                if(!map.containsKey(lines[0])){
                    // Store the record in the map (ID as key, other fields as value)
                    map.put(lines[0] , new String[]{lines[1], lines[2], lines[3], lines[4]});
                }
                else{
                    // Print duplicate record
                    System.out.println(lines[0] + " , " + lines[1] + " , " + lines[2] + " , " + lines[3] + " , " + lines[4]);
                }
            }
        }
        // Handle exceptions (file not found, IO error, CSV format issues)
        catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}
