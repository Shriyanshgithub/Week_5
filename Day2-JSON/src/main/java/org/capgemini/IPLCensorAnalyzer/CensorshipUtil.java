package org.capgemini.IPLCensorAnalyzer;

public class CensorshipUtil {

    // Mask Team Name (Replace part with "***")
    public static String maskTeamName(String teamName) {
        String[] parts = teamName.split(" ", 2);
        return parts[0] + " ***";
    }

    // Redact Player of the Match
    public static String redactPlayer(String player) {
        return "REDACTED";
    }
}
