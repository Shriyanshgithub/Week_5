package org.capgemini.Problem_15;

import com.opencsv.CSVReader;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class DecryptCSV {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "1234567890123456"; // 16-byte secret key for AES

    public static void main(String[] args) throws Exception {
        // Initialize the AES decryption
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Read the encrypted CSV file
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/duplicate.csv"))) {
            String[] record;
            reader.readNext(); // Skip header

            while ((record = reader.readNext()) != null) {
                // Decrypt sensitive fields (Salary and Email)
                String decryptedSalary = decrypt(record[3], cipher);
                String decryptedEmail = decrypt(record[4], cipher);

                // Print the decrypted record
                System.out.println(record[0] + " , " + record[1] + " , " + record[2] + " , " + decryptedSalary + " , " + decryptedEmail);
            }
        }
    }

    // Method to decrypt data using AES
    private static String decrypt(String encryptedData, Cipher cipher) throws Exception {
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }
}

