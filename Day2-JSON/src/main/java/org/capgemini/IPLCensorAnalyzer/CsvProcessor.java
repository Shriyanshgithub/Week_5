package org.capgemini.IPLCensorAnalyzer;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class CsvProcessor {
    private static final String INPUT_CSV = "src/main/resources/ipl_matches.csv";
    private static final String OUTPUT_CSV = "src/main/resources/censored_ipl_matches.csv";

    public static void processCsv() throws IOException, CsvException {
        try (Reader reader = new FileReader(INPUT_CSV);
             Writer writer = new FileWriter(OUTPUT_CSV);
             CSVReader csvReader = new CSVReader(reader);
             CSVWriter csvWriter = new CSVWriter(writer)) {

            // Read CSV Header
            List<String[]> records = csvReader.readAll();
            List<String[]> newRecords = new ArrayList<>();

            // Process Each Row (Apply Censorship)
            for (String[] record : records) {
                if (!record[0].equals("match_id")) { // Skip header
                    record[1] = CensorshipUtil.maskTeamName(record[1]);
                    record[2] = CensorshipUtil.maskTeamName(record[2]);
                    record[6] = CensorshipUtil.redactPlayer(record[6]);
                }
                newRecords.add(record);
            }

            // Write Censored Data to New CSV
            csvWriter.writeAll(newRecords);
            System.out.println(" Censored CSV saved to: " + OUTPUT_CSV);
        }
    }
}

