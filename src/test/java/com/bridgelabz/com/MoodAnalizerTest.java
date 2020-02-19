package com.bridgelabz.com;
import com.bridgelabz.moodAnalysisExcption.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalizerTest {

    @Test
    public void givenHappyMood_ShouldReturnHappy() {
        try {
            MoodAnalizer moodAnalizer = new MoodAnalizer("I am happy");
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
        try {
            MoodAnalizer moodAnalizer = new MoodAnalizer();
            String mood = moodAnalizer.analizerMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.moodException.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void giveEmptyMood_Should_ReturnMessage() {
        MoodAnalizer moodAnalizer = new MoodAnalizer("");
        try {
            String mood = moodAnalizer.analizerMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.moodException.ENTERED_EMPTY,e.type);
        }

    }
}
