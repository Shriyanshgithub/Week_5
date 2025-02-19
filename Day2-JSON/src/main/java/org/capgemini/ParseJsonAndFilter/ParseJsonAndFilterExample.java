package org.capgemini.ParseJsonAndFilter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;

public class ParseJsonAndFilterExample {
    public static void main(String[] args) throws IOException {
        //create the instance of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON file and parse into JsonNode
        JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/student.json"));

        // Convert JsonNode to String (JSON format)
        String json = jsonNode.toString();

        //Convert JSON String to JSONArray
        JSONArray jsonArray = new JSONArray(json);

        // Iterate through JSON array
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            // Check if age is greater than 25
            if ((int) jsonObject.get("age") > 25) {
                //  Print the filtered JSON object
                System.out.println(jsonObject.toString());
            }
        }
    }
}
