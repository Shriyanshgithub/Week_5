package org.capgemini.Problem_10;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

public class MergeTwoCSV {
    public static void main(String[] args) throws IOException, CsvValidationException {
        // Initialize CSV writer for the output file
        CSVWriter csvWriter3 = new CSVWriter(new FileWriter("src/main/resources/Student3.csv"));

        // Initialize CSV readers for input files
        CSVReader csvReader1 = new CSVReader(new FileReader("src/main/resources/Student1.csv"));
        CSVReader csvReader2 = new CSVReader(new FileReader("src/main/resources/Student2.csv"));

        // LinkedHashMap to maintain order while storing student data
        Map<String, String[]> map = new LinkedHashMap<>();
        String[] lines;

        // Skip the header of Student1.csv
        csvReader1.readNext();

        // Read Student1.csv (ID, Name, Age) and store in the map
        while ((lines = csvReader1.readNext()) != null) {
            if (lines.length >= 3) {
                // ID -> Name, Age, (empty Marks), (empty Grade)
                map.put(lines[0], new String[]{lines[1], lines[2], "", ""});
            }
        }

        // Skip the header of Student2.csv
        csvReader2.readNext();

        // Read Student2.csv (ID, Marks, Grade) and merge with existing data
        while ((lines = csvReader2.readNext()) != null) {
            if (map.containsKey(lines[0])) {
                // If ID exists, update Marks and Grade
                map.get(lines[0])[2] = lines[1];
                map.get(lines[0])[3] = lines[2];
            } else {
                // If ID is new, add it with empty Name & Age
                map.put(lines[0], new String[]{"", "", lines[1], lines[2]});
            }
        }

        // Write the header row to the output file
        csvWriter3.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

        // Write merged data from the map to Student3.csv
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            csvWriter3.writeNext(new String[]{entry.getKey(), entry.getValue()[0], entry.getValue()[1], entry.getValue()[2], entry.getValue()[3]});
        }

        // Close the writer
        csvWriter3.close();

        System.out.println("CSV merged successfully");
    }
}
