package org.capgemini.IPLCensorAnalyzer;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

public class Score {
    private Map<String, Integer> scores = new HashMap<>();

    @JsonAnySetter
    public void addScore(String team, Integer runs) {
        scores.put(team, runs);
    }

    public Map<String, Integer> getScores() {
        return scores;
    }
}

