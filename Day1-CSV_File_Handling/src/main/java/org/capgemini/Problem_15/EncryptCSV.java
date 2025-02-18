package org.capgemini.Problem_15;

import com.opencsv.CSVWriter;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class EncryptCSV {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "1234567890123456"; // 16-byte secret key for AES

    public static void main(String[] args) throws Exception {
        // Employee data
        String[][] data = {
                {"1", "John Doe", "IT", "60000", "john.doe@example.com"},
                {"2", "Jane Smith", "HR", "55000", "jane.smith@example.com"},
                {"3", "Robert Brown", "Finance", "72000", "robert.brown@example.com"}
        };

        // Initialize the AES encryption
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Write the encrypted data to a CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter("src/main/resources/employee_encrypted.csv"))) {
            // Writing header
            writer.writeNext(new String[]{"Employee_ID", "Name", "Department", "Salary", "Email"});

            for (String[] record : data) {
                // Encrypt sensitive fields (Salary and Email)
                String encryptedSalary = encrypt(record[3], cipher);
                String encryptedEmail = encrypt(record[4], cipher);

                // Writing encrypted record
                writer.writeNext(new String[]{record[0], record[1], record[2], encryptedSalary, encryptedEmail});
            }
        }
    }

    // Method to encrypt data using AES
    private static String encrypt(String data, Cipher cipher) throws Exception {
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }
}

