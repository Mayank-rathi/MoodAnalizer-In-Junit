package com.bridgelabz.moodAnalysisExcption;

public class MoodAnalysisException extends RuntimeException {
    public moodException type;

    public enum moodException
    {
        ENTERED_NULL,ENTERED_EMPTY,ENTERED_CLASS_NOT_FOUND,
        NO_SUCH_FIELD,NO_SUCH_METHOD,NO_SUCH_CLASS,
        OBJECT_CREATION_ISSUE,METHOD_INVOCATION_ISSUE,FILED_SETING_ISSUE
    }
    public MoodAnalysisException(moodException type, String message) {
        super(message);
        this.type=type;
    }
    public MoodAnalysisException(moodException type, String message, Throwable cause){
        super(cause);
        this.type=type;
    }

}
