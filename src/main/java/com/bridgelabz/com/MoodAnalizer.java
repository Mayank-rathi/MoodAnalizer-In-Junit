package com.bridgelabz.com;

import com.bridgelabz.moodAnalysisExcption.MoodAnalysisException;

public class MoodAnalizer {
    private String mood;

    public MoodAnalizer() {
    }

    public MoodAnalizer(String mood) {
        this.mood = mood;
    }

    public String analizerMood() throws MoodAnalysisException {
        try {
            if (mood.contains("")) {
                throw new MoodAnalysisException(MoodAnalysisException.moodException.ENTERED_EMPTY,"This is empty");
            }
            if (mood.contains("happy"))
                return "HAPPY";
            else {
                return "SAD";
            }
        } catch (NullPointerException ex) {
            throw new MoodAnalysisException(MoodAnalysisException.moodException.ENTERED_NULL, "This is null");
        }
    }
}
