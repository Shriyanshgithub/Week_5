package org.capgemini.ConvertJsonToXml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            //  Read JSON file
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/json1.json"));

            // Convert JSON to XML
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            //  Print XML Output
            System.out.println(xml);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

