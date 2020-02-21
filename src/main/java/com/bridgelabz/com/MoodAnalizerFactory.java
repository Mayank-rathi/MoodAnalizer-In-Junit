package com.bridgelabz.com;

import com.bridgelabz.moodAnalysisExcption.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalizerFactory {

    public static MoodAnalizer creatMoodAnalizer() {
        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.com.MoodAnalizer").getConstructor();
            Object objCreation = constructor.newInstance();
            MoodAnalizer objMood = (MoodAnalizer) objCreation;
            return objMood;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static MoodAnalizer creatMoodAnalizer(String message,String className) {
        try {
            Constructor<?> constructor = Class.forName(className).getConstructor(String.class);
            Object objCreation = constructor.newInstance(message);
            MoodAnalizer objMood = (MoodAnalizer) objCreation;
            return objMood;

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.moodException.ENTERED_CLASS_NOT_FOUND,"This is empty class");
            // e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void getConstructor(String stringName,Class<?> stringClass) throws MoodAnalysisException{
        try{
            Class var =Class.forName(stringName);
            try {
                var.getConstructor(stringClass);
            }catch (NoSuchMethodException e)
            {
                throw new MoodAnalysisException(MoodAnalysisException.moodException.NO_SUCH_METHOD,"Method not found");
            }

        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.moodException.ENTERED_CLASS_NOT_FOUND,"No such type of class");

        }

    }

    public static String getMethod(MoodAnalizer obj, String methodName) {
        try {
                Method m = obj.getClass().getDeclaredMethod(methodName);
                return (String) m.invoke(obj);
            } catch (NoSuchMethodException e) {
                throw new MoodAnalysisException(MoodAnalysisException.moodException.NO_SUCH_METHOD, "Method not found");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
