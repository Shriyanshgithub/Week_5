package org.capgemini.IPLCensorAnalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonProcessor {
    private static final String INPUT_JSON = "src/main/resources/ipl_matches.json";
    private static final String OUTPUT_JSON = "src/main/resources/censored_ipl_matches.json";

    public static void processJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON file into list of IPLMatch objects
        List<IPLMatch> matches = objectMapper.readValue(new File(INPUT_JSON),
                objectMapper.getTypeFactory().constructCollectionType(List.class, IPLMatch.class));

        // Apply censorship rules
        for (IPLMatch match : matches) {
            match.setTeam1(CensorshipUtil.maskTeamName(match.getTeam1()));
            match.setTeam2(CensorshipUtil.maskTeamName(match.getTeam2()));
            match.setPlayerOfMatch(CensorshipUtil.redactPlayer(match.getPlayerOfMatch()));
        }

        // Write Censored JSON back to file
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(OUTPUT_JSON), matches);

        System.out.println("Censored JSON saved to: " + OUTPUT_JSON);
    }
}

