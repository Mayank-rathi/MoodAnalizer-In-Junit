package com.bridgelabz.com;
import com.bridgelabz.moodAnalysisExcption.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalizerTest {

    @Test
    public void givenHappyMood_Should_ReturnHappy() {
        try {
            MoodAnalizer moodAnalizer = new MoodAnalizer(" I am happy");
            String mood = moodAnalizer.analizerMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {

        }
    }
    @Test
    public void givenUnppyMood_ShouldReturnFalse() {
        try {
            MoodAnalizer moodAnalizer = new MoodAnalizer("I am sad");
            String mood = moodAnalizer.analizerMood();
            Assert.assertEquals("SAD",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenNullMood_ShouldReturnHappy() {
        MoodAnalizer moodAnalizer = new MoodAnalizer();
        try {
            String mood = moodAnalizer.analizerMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.moodException.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void giveEmptyMood_Should_ReturnMessage(){
        String mood;
        MoodAnalizer moodAnalizer = new MoodAnalizer("");
        try {
            mood = moodAnalizer.analizerMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.moodException.ENTERED_EMPTY,e.type);
            return;
        }
            Assert.assertEquals("This is empty",mood);
    }

    @Test
    public void giveMoodAnalizer_Should_ReturnObject() {
        try {
            Constructor constructor=Class.forName("com.bridgelabz.com.MoodAnalizer").getConstructor(String.class);
            try {
                Object obj = constructor.newInstance("I am in happy mood");
                MoodAnalizer objMood = (MoodAnalizer) obj;
                String mood = objMood.analizerMood();
                Assert.assertEquals("HAPPY",mood);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException | MoodAnalysisException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenMoodAnalyserClass_WhenProper_Should_ReturnException() {
        MoodAnalizer moodAnalizer=null;
        try {
            moodAnalizer = MoodAnalizerFactory.creatMoodAnalizer();
            Assert.assertEquals(new MoodAnalizer(), moodAnalizer);
        }catch (MoodAnalysisException e){
            e.printStackTrace();
        }
    }


    @Test
    public void givenNullMoodShouldThrowException1() throws MoodAnalysisException {
       try {
           MoodAnalizerFactory.getConstructor("com.moodanalyzer.MoodAnalyzer",String.class);
       }catch (MoodAnalysisException e)
       {
           Assert.assertEquals(MoodAnalysisException.moodException.ENTERED_CLASS_NOT_FOUND, e.type);
       }
    }

    @Test
    public void giveWrongConstructorName_ShouldReturnNoSuchMethod() {
        try {
            MoodAnalizerFactory.getConstructor("com.bridgelabz.com.MoodAnalizer",Integer.class);
        }catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.moodException.NO_SUCH_METHOD, e.type);
        }
    }
}
