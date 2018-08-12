import static org.junit.Assert.*;
import org.junit.Test;

public class LogTest{


    @Test
    public void test_logConstructor() {
        Log l1 = new Log(32, 320, 1, 5, false);
        assertEquals("Created left bound log with constructor with length of 5", false, l1.isLogRightBound());
        assertEquals("Created left bound log with constructor with length of 5", 32.0, l1.getLogPosX(), 0.000001);
        assertEquals("Created left bound log with constructor with length of 5", 320.0, l1.getLogPosY(), 0.000001);
        assertEquals("Created left bound log with constructor with length of 5", 5.0, l1.getLogLength(), 0.000001);
    }


    @Test
    public void test_rightBoundLengthSeven() {
        Log l1 = new Log(32, 320, 0.5, 7, true);
        assertEquals("Created right bound log with constructor with length of 7 and move right", true, l1.isLogRightBound());
        if (l1.isLogRightBound()){
            l1.moveLogRightX();
        }
        else{
            l1.moveLogLeftX();
        }
        assertEquals("Created right bound log with constructor with length of 7 and move right", 32.5, l1.getLogPosX(), 0.000001);
        assertEquals("Created right bound log with constructor with length of 7 and move right", 320.0, l1.getLogPosY(), 0.000001);
        assertEquals("Created right bound log with constructor with length of 7 and move right", 7.0, l1.getLogLength(), 0.000001);
    }

    @Test
    public void test_leftBoundLengthThree() {
        Log l1 = new Log(32, 320, 1.5, 3, false);
        assertEquals("Created left bound log with constructor with length of 3 and move left", false, l1.isLogRightBound());
        if (l1.isLogRightBound()){
            l1.moveLogRightX();
        }
        else{
            l1.moveLogLeftX();
        }
        assertEquals("Created left bound log with constructor with length of 3 and move left", 30.5, l1.getLogPosX(), 0.000001);
        assertEquals("Created left bound log with constructor with length of 3 and move left", 320.0, l1.getLogPosY(), 0.000001);
        assertEquals("Created left bound log with constructor with length of 3 and move left", 3.0, l1.getLogLength(), 0.000001);
    }
}