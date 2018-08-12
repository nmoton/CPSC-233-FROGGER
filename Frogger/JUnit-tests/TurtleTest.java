import static org.junit.Assert.*;
import org.junit.Test;

public class TurtleTest{

    @Test
    public void test_turtleConstructor() {
        Turtle t1 = new Turtle(32, 320, 1, 2);
        t1.moveTurtleX();
        assertEquals("Created left bound turtle with constructor with length of 2", 31.0, t1.getTurtlePosX(), 0.000001);
        assertEquals("Created left bound turtle with constructor with length of 2", 320.0, t1.getTurtlePosY(), 0.000001);
        assertEquals("Created left bound turtle with constructor with length of 2", 2.0, t1.getTurtleLength(), 0.000001);
    }

    @Test
    public void test_leftBoundLengthThree() {
        Turtle t1 = new Turtle(32, 320, 1.5, 3);
        t1.moveTurtleX();
        assertEquals("Created left bound turtle with constructor with length of 3 and move turtle", 30.5, t1.getTurtlePosX(), 0.000001);
        assertEquals("Created left bound turtle with constructor with length of 3 and move turtle", 320.0, t1.getTurtlePosY(), 0.000001);
        assertEquals("Created left bound turtle with constructor with length of 3 and move turtle", 3.0, t1.getTurtleLength(), 0.000001);
    }
}