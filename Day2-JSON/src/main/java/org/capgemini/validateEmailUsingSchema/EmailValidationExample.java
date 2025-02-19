package org.capgemini.validateEmailUsingSchema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

import java.io.File;
import java.io.IOException;

public class EmailValidationExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonValidator validator = JsonSchemaFactory.byDefault().getValidator();

            //  Load JSON Schema
            JsonNode schemaNode = objectMapper.readTree(new File("src/main/resources/email-schema.json"));
            JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);

            //  Load JSON Data to Validate
            JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/user.json"));

            // Validate JSON Data
            ProcessingReport report = schema.validate(jsonData);

            //  Print Validation Result
            if (report.isSuccess()) {
                System.out.println(" JSON is valid!");
            } else {
                System.out.println(" JSON is invalid: " + report);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}
