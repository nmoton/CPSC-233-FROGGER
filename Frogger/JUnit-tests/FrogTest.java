import static org.junit.Assert.*;
import org.junit.Test;

public class FrogTest{

    //Testing Constructors
    @Test
    public void test_defaultConstructor() {
        Frog f1 = new Frog();
        assertEquals("Created frog with default constructor", 0.0, f1.getPlayerPosX(), 0.000001);
        assertEquals("Created frog with default constructor", 448.0, f1.getPlayerPosY(), 0.000001);
        assertEquals("Created frog with default constructor", 'U', f1.getLastFacing());
    }

    @Test
    public void test_constructor_validXandY() {
        Frog f1 = new Frog(32, 320);
        assertEquals("Create frog with valid X and Y arguments", 32.0, f1.getPlayerPosX(), 0.000001);
        assertEquals("Create frog with valid X and Y arguments", 320.0, f1.getPlayerPosY(), 0.000001);
        assertEquals("Created frog with constructor", 'U', f1.getLastFacing());
    }

    @Test
    public void test_constructor_invalidXandY() {
        Frog f1 = new Frog(1000, 1000);
        assertEquals("Create frog with invalid X and Y arguments", 0.0, f1.getPlayerPosX(), 0.000001);
        assertEquals("Create frog with invalid X and Y arguments", 448.0, f1.getPlayerPosY(), 0.000001);
        assertEquals("Created frog with constructor", 'U', f1.getLastFacing());
    }

    //Testing setters
    @Test
    public void test_setters() {
        Frog f1 = new Frog();
        f1.setPosX(64);
        f1.setPosY(100);
        assertEquals("Set frog X to 64", 64.0, f1.getPlayerPosX(), 0.000001);
        assertEquals("Set frog Y to 64", 100.0, f1.getPlayerPosY(), 0.000001);
    }

    //Testing move methods
    @Test
    public void test_moveFrogRight(){
        Frog f1 = new Frog();
        f1.moveRight();
        assertEquals("Move frog right", 32.0, f1.getPlayerPosX(),0.000001);
        assertEquals("Move frog right", 448.0, f1.getPlayerPosY(),0.000001);
        assertEquals("Move frog right", 'R', f1.getLastFacing());
    }

    @Test
    public void test_moveFrogRight_tooFarRight(){
        Frog f1 = new Frog(600,448);
        f1.moveRight();
        assertEquals("Move frog right", 608.0, f1.getPlayerPosX(),0.000001);
        assertEquals("Move frog right", 448.0, f1.getPlayerPosY(),0.000001);
        assertEquals("Move frog right", 'R', f1.getLastFacing());
    }

    @Test
    public void test_moveFrogLeft(){
        Frog f1 = new Frog(32, 448);
        f1.moveLeft();
        assertEquals("Move frog left", 0.0, f1.getPlayerPosX(),0.000001);
        assertEquals("Move frog left", 448.0, f1.getPlayerPosY(),0.000001);
        assertEquals("Move frog left", 'L', f1.getLastFacing());
    }


    @Test
    public void test_moveFrogLeft_tooFarLeft(){
        Frog f1 = new Frog(1, 448);
        f1.moveLeft();
        assertEquals("Move frog left", 0.0, f1.getPlayerPosX(),0.000001);
        assertEquals("Move frog left", 448.0, f1.getPlayerPosY(),0.000001);
        assertEquals("Move frog left", 'L', f1.getLastFacing());
    }

    @Test
    public void test_moveFrogUp(){
        Frog f1 = new Frog(32, 448);
        f1.moveUp();
        assertEquals("Move frog left", 32.0, f1.getPlayerPosX(),0.000001);
        assertEquals("Move frog left", 416.0, f1.getPlayerPosY(),0.000001);
        assertEquals("Move frog left", 'U', f1.getLastFacing());
    }

    @Test
    public void test_moveFrogUp_tooFarUp(){
        Frog f1 = new Frog(0, 1);
        f1.moveUp();
        assertEquals("Move frog left", 0.0, f1.getPlayerPosX(),0.000001);
        assertEquals("Move frog left", 0.0, f1.getPlayerPosY(),0.000001);
        assertEquals("Move frog left", 'U', f1.getLastFacing());
    }

    @Test
    public void test_moveFrogDown(){
        Frog f1 = new Frog(32, 0);
        f1.moveDown();
        assertEquals("Move frog left", 32.0, f1.getPlayerPosX(),0.000001);
        assertEquals("Move frog left", 32.0, f1.getPlayerPosY(),0.000001);
        assertEquals("Move frog left", 'D', f1.getLastFacing());
    }

    @Test
    public void test_moveFrogDown_tooFarDown(){
        Frog f1 = new Frog(0, 1);
        f1.moveDown();
        assertEquals("Move frog left", 0.0, f1.getPlayerPosX(),0.000001);
        assertEquals("Move frog left", 33.0, f1.getPlayerPosY(),0.000001);
        assertEquals("Move frog left", 'D', f1.getLastFacing());
    }
}