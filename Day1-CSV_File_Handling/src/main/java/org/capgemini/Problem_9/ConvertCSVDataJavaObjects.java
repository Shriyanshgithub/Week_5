package org.capgemini.Problem_9;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class ConvertCSVDataJavaObjects {
    public static void main(String[] args) {
        String filePath = "src/main/resources/student.csv";
        try(CSVReader csvReader = new CSVReader(new FileReader(filePath))){
            List<Student> list = new CsvToBeanBuilder<Student>(csvReader)
                    .withType(Student.class)
                    .build()
                    .parse();

            for(Student student : list){
                System.out.println(student.getStudent_id() + " , " + student.getName() + " , " + student.getRoll_no());
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}


