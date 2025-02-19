package org.capgemini.readJsonFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonAndPrint {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/sample.json"));

            // Print all keys and values recursively
            printJson(rootNode, "");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Recursive method to print all keys and values
    private static void printJson(JsonNode node, String keyPrefix) {
        if (node.isObject()) {
            // Iterate over object fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJson(field.getValue(), keyPrefix + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            //  Iterate over array elements
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), keyPrefix + "[" + i + "].");
            }
        } else {
            //Print key and value for primitive types (string, number, boolean)
            System.out.println(keyPrefix.substring(0, keyPrefix.length() - 1) + " : " + node.asText());
        }
    }
}

