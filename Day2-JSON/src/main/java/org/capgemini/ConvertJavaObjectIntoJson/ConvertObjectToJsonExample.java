package org.capgemini.ConvertJavaObjectIntoJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertObjectToJsonExample {
    public static void main(String[] args) throws JsonProcessingException {
        Car car = new Car("Honda City" , 2000000 , 5 ,"Petrol");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(car);

        System.out.println(json);

    }
}
