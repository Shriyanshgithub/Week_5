package org.capgemini.Problem_13;

import com.opencsv.CSVWriter;
import java.io.*;
import java.sql.*;

public class EmployeeCSVReport {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Update with your DB
        String username = "Shriyansh"; // Update with your username
        String password = "888888"; // Update with your password
        String csvFilePath = "src/main/resources/EmployeeReport.csv";

        String sql = "SELECT employee_id, name, department, salary FROM employees"; // Query

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             CSVWriter csvWriter = new CSVWriter(new FileWriter("src/main/resources/Employee.csv"))) {

            // Write CSV header
            csvWriter.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});

            // Write data rows
            while (rs.next()) {
                String empId = rs.getString("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                String salary = rs.getString("salary");

                csvWriter.writeNext(new String[]{empId, name, department, salary});
            }

            System.out.println("CSV Report generated successfully: " + csvFilePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
