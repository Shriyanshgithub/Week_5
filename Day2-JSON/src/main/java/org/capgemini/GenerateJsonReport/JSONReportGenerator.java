package org.capgemini.GenerateJsonReport;

import java.sql.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class JSONReportGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_user";
        String password = "your_password";

        String query = "SELECT id, name, age FROM employees";
        JSONArray jsonArray = new JSONArray();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", rs.getInt("id"));
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("age", rs.getInt("age"));
                jsonArray.put(jsonObject);
            }

            try (FileWriter file = new FileWriter("employees.json")) {
                file.write(jsonArray.toString(4)); // Pretty print with 4 spaces
                System.out.println("JSON report generated successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

