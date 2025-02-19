package org.capgemini.mergeTwoJson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class MergeTwoJsonExample {
    public static void main(String[] args) throws IOException {
        // Create ObjectMapper to handle JSON operations
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the first JSON file into an ObjectNode
        ObjectNode node1 = (ObjectNode) objectMapper.readTree(new File("src/main/resources/json1.json"));

        // Read the second JSON file into an ObjectNode
        ObjectNode node2 = (ObjectNode) objectMapper.readTree(new File("src/main/resources/json2.json"));

        // Get an iterator to loop through all fields of node1
        Iterator<Map.Entry<String, JsonNode>> iterator = node1.fields();

        // Iterate over fields and add them to node2
        while (iterator.hasNext()) {
            Map.Entry<String, JsonNode> field = iterator.next();
            node2.set(field.getKey(), field.getValue()); 
        }

        // Convert the merged JSON object to a string
        String json = objectMapper.writeValueAsString(node2);

        // Print the merged JSON
        System.out.println(json);

        // Write the merged JSON to a new file
        objectMapper.writeValue(new File("src/main/resources/merge.json"), node2);
    }
}
