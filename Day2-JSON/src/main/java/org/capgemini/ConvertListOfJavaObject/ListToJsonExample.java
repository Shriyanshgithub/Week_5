package org.capgemini.ConvertListOfJavaObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Create a list of Person objects
            List<Person> people = Arrays.asList(
                    new Person("Alice", 25),
                    new Person("Bob", 30),
                    new Person("Charlie", 22)
            );

            // Convert list to JSON array
            String jsonArray = objectMapper.writeValueAsString(people);

            // Print the JSON array
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
