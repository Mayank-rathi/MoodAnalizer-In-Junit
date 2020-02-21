package com.bridgelabz.com;

import com.bridgelabz.moodAnalysisExcption.MoodAnalysisException;

public class MoodAnalizer {
    private String mood;


    public MoodAnalizer() {
        this.mood="default";
    }

    public MoodAnalizer(String mood) {
                this.mood = mood;
    }
    public String analizerMood(String mood) /*throws MoodAnalysisException*/ {
        this.mood=mood;
        return analizerMood();
    }
    public String analizerMood() /*throws MoodAnalysisException*/ {
        try {
            if (mood.length()==0) {
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
    public boolean equals(Object another){
        if (this.mood.equals(((MoodAnalizer) another).mood))
            return true;
        return false;
    }

}
