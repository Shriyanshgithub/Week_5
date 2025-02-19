package org.capgemini.convertCsvToJson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            //  Create CsvMapper and ObjectMapper
            CsvMapper csvMapper = new CsvMapper();
            ObjectMapper objectMapper = new ObjectMapper();

            // Define CSV schema (auto-detect headers)
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

            // Read CSV file and map to List of JsonNode
            List<JsonNode> jsonNodes = csvMapper.readerFor(JsonNode.class)
                    .with(csvSchema)
                    .readValues(new File("src/main/resources/data.csv"))
                    .readAll();

            // Convert List to JSON String
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(jsonNodes);

            //  Print JSON Output
            System.out.println(jsonOutput);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

