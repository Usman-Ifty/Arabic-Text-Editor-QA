package net.oujda_nlp_team;

import java.util.ArrayList;
import java.util.List;
import net.oujda_nlp_team.entity.Result;

public class AlKhalil2Analyzer {
    private static AlKhalil2Analyzer instance;

    private AlKhalil2Analyzer() {
    }

    public static synchronized AlKhalil2Analyzer getInstance() {
        if (instance == null) {
            instance = new AlKhalil2Analyzer();
        }
        return instance;
    }

    public TokenAnalysis processToken(String token) {
        return new TokenAnalysis();
    }

    public static class TokenAnalysis {
        public List<Result> getAllResults() {
            List<Result> results = new ArrayList<>();
            results.add(new Result());
            return results;
        }

        public String getAllLemmasString() {
            return "dummy_lemma";
        }

        public String getAllRootString() {
            return "dummy_root";
        }

        public String getAllStemString() {
            return "dummy_stem";
        }

        public String getAllPosString() {
            return "NOUN|VERB";
        }
    }
}
