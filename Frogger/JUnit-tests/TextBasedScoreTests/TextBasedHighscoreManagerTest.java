import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TextBasedHighscoreManagerTest {
/**
 * Note:
 * - The highscore system should not display the scores in a
 * descending order
 * -Repeated scores are shown
 */

    /**
     * This test case checks if the sortScore() method can
     * properly sort the Score objects with different scores
     * in a descending order.
     */
    @Test
    public void test_sortScores_differentScores() {
        TextBasedScore s1 = new TextBasedScore(9, "EEE");
        TextBasedScore s2 = new TextBasedScore(12, "BBB");
        TextBasedScore s3 = new TextBasedScore(10, "DDD");
        TextBasedScore s4 = new TextBasedScore(13, "AAA");
        TextBasedScore s5 = new TextBasedScore(11, "CCC");

        TextBasedHighscoreManager hm = new TextBasedHighscoreManager();
        hm.addScoreToList(s1);
        hm.addScoreToList(s2);
        hm.addScoreToList(s3);
        hm.addScoreToList(s4);
        hm.addScoreToList(s5);

        hm.sortScores();
        ArrayList<TextBasedScore> testList = new ArrayList<TextBasedScore>(hm.copyList());//Copies the assorted arrayList in to a different list

        assertEquals("AAA(0) - score: ", 13, testList.get(0).getScore());
        assertEquals("BBB(1) - score: ", 12, testList.get(1).getScore());
        assertEquals("CCC(2) - score: ", 11, testList.get(2).getScore());
        assertEquals("DDD(3) - score: ", 10, testList.get(3).getScore());
        assertEquals("EEE(4) - score: ", 9, testList.get(4).getScore());
    }

    /**
     * This test case checks if the sortScore() method can
     * properly sort the Score objects when there are two
     * score object with the same score while the others
     * have different scores.
     */
    @Test
    public void test_sortScores_twoSameScores() {
        TextBasedScore s1 = new TextBasedScore(11, "EEE");
        TextBasedScore s2 = new TextBasedScore(12, "BBB");
        TextBasedScore s3 = new TextBasedScore(10, "DDD");
        TextBasedScore s4 = new TextBasedScore(13, "AAA");
        TextBasedScore s5 = new TextBasedScore(11, "CCC");

        TextBasedHighscoreManager hm = new TextBasedHighscoreManager();
        hm.addScoreToList(s1);
        hm.addScoreToList(s2);
        hm.addScoreToList(s3);
        hm.addScoreToList(s4);
        hm.addScoreToList(s5);

        hm.sortScores();
        ArrayList<TextBasedScore> testList = new ArrayList<TextBasedScore>(hm.copyList());//Copies the assorted arrayList in to a different list

        assertEquals("AAA(0) - score: ", 13, testList.get(0).getScore());
        assertEquals("BBB(1) - score: ", 12, testList.get(1).getScore());
        assertEquals("EEE(2)added first - score: ", 11, testList.get(2).getScore());
        assertEquals("CCC(3) - score: ", 11, testList.get(3).getScore());
        assertEquals("DDD(4) - score: ", 10, testList.get(4).getScore());
    }

    /**
     * This test case checks if the sortScore() method can
     * properly sort the Score objects when all the Score objects
     * have the same score.
     */
    @Test
    public void test_sortScores_allSameScores() {
        TextBasedScore s1 = new TextBasedScore(11, "EEE");
        TextBasedScore s2 = new TextBasedScore(11, "BBB");
        TextBasedScore s3 = new TextBasedScore(11, "DDD");
        TextBasedScore s4 = new TextBasedScore(11, "AAA");
        TextBasedScore s5 = new TextBasedScore(11, "CCC");

        TextBasedHighscoreManager hm = new TextBasedHighscoreManager();
        hm.addScoreToList(s1);
        hm.addScoreToList(s2);
        hm.addScoreToList(s3);
        hm.addScoreToList(s4);
        hm.addScoreToList(s5);

        hm.sortScores();
        ArrayList<TextBasedScore> testList = new ArrayList<TextBasedScore>(hm.copyList());//Copies the assorted arrayList in to a different list

        assertEquals("EEE(0) - score: ", 11, testList.get(0).getScore());
        assertEquals("BBB(1) - score: ", 11, testList.get(1).getScore());
        assertEquals("DDD(2) - score: ", 11, testList.get(2).getScore());
        assertEquals("AAA(3) - score: ", 11, testList.get(3).getScore());
        assertEquals("CCC(4) - score: ", 11, testList.get(4).getScore());
    }










}