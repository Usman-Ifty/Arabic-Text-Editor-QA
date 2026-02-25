package net.oujda_nlp_team.entity;

public class Result {
    private String stem = "dummy_stem";
    private String lemma = "dummy_lemma";
    private String partOfSpeech = "NOUN|VERB";
    private String root = "dummy_root";

    public String getStem() {
        return stem;
    }

    public String getLemma() {
        return lemma;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getRoot() {
        return root;
    }
}
