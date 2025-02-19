package org.capgemini.CreateJsonObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class CreateJsonExample {
    public static void main(String[] args) throws JsonProcessingException {
        //Student object
        Student student = new Student("Shriyansh" , 22 , List.of("Java" , "Python" , "Cpp"));
        //Object mapper convet java object into json
        ObjectMapper objectMapper = new ObjectMapper();
        //write value in json
        String json = objectMapper.writeValueAsString(student);
        //display json
        System.out.println(json);
    }
}
