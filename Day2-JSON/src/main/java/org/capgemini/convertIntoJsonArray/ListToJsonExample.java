package org.capgemini.convertIntoJsonArray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ListToJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            //  Create a List of Person objects
            List<Person> people = Arrays.asList(
                    new Person("Alice", 25),
                    new Person("Bob", 30),
                    new Person("Charlie", 22)
            );

            //  Convert the list to JSON array string
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(people);

            //  Print JSON array
            System.out.println(jsonArray);

            //  Write JSON array to a file
            objectMapper.writeValue(new File("src/main/resources/.json"), people);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

