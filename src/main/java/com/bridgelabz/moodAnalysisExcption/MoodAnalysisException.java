package com.bridgelabz.moodAnalysisExcption;

public class MoodAnalysisException extends Exception {
    public  moodException type;
    public enum moodException
    {
        ENTERED_NULL,ENTERED_EMPTY
    }
    public MoodAnalysisException(moodException type, String message) {
        super(message);
        this.type=type;
    }



}
