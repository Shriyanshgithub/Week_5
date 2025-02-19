package org.capgemini.IPLCensorAnalyzer;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Processing JSON...");
            JsonProcessor.processJson();

            System.out.println(" Processing CSV...");
            CsvProcessor.processCsv();

            System.out.println(" Processing completed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
