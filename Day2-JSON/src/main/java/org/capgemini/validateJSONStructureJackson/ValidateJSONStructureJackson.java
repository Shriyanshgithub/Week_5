package org.capgemini.validateJSONStructureJackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ValidateJSONStructureJackson {
    public static void main(String[] args) throws IOException {
        // Create ObjectMapper to handle JSON operations
        ObjectMapper objectMapper = new ObjectMapper();
        //represent json as model representation
        JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/employee.json"));

        //validate if field exits
        if(jsonNode.has("name") && jsonNode.has("age")){
            //display name
            System.out.println(jsonNode.get("name").asText());
            //display age
            System.out.println(jsonNode.get("age").asInt());
        }
        else{
            System.out.println("Key not found");
        }
    }
}
