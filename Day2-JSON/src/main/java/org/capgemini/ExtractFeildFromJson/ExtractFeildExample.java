package org.capgemini.ExtractFeildFromJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;

public class ExtractFeildExample {
    public static void main(String[] args) {
        //scanner class
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name ");
        //Take value from user
        String extractName = sc.next();

         // json data
        String  json = "[ {\"name\":\"Shriyansh\",\"email\":\"gshriyansh7222@gmail.org\"}," +
        "{\"name\":\"Siddhart\",\"email\":\"sid22@gmail.org\"}," +
                "{\"name\":\"Himanshu\",\"email\":\"himanshu292@gmail.org\"}]";

        //convert json string into json array
        JSONArray jsonArray = new JSONArray(json);

        //Loop for to iterate in an array
        for(int i =0 ; i< jsonArray.length(); i++){
            //get json object at current index
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(jsonObject.get("name").equals(extractName)){

                System.out.println(jsonObject.get("name") + " : " + jsonObject.get("email"));
                break;
            }
        }

    }
}
