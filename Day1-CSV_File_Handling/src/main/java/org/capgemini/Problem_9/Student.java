package org.capgemini.Problem_9;

import com.opencsv.bean.CsvBindByName;

public class Student {
    @CsvBindByName(column = "student_id")
    private int student_id;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "roll_no")
    private int roll_no;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }
}
