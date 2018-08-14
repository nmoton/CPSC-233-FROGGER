import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	/**
	 * This test case if the updateScore() checks if the score
	 * increases when the frog moves up without moving back 
	 */
	@Test
	public void test__alwaysGoUp() {
		Score player = new Score(480);//Starting score is zero
		
		assertEquals("Player should have 0", 0, player.getScore());
		
		double playerPos = 448;//moving up
		player.updateScore(playerPos);
		assertEquals("Player should have 10 points", 10, player.getScore());
		
		playerPos = 416;//moving up
		player.updateScore(playerPos);
		assertEquals("Player should have 20 points", 20, player.getScore());
		
		playerPos = 384;//moving up
		player.updateScore(playerPos);
		assertEquals("Player should have 30 points", 30, player.getScore());
			
	}
	
	/**
	 * This test case checks what happens if the fog moves back down and 
	 * moves up again.
	 */
	@Test
	public void test__moveDownAndUp() {
		Score player = new Score(480);//Starting score is zero
		
		assertEquals("Player should have 0", 0, player.getScore());
		
		double playerPos = 448;//moving up
		player.updateScore(playerPos);
		assertEquals("Player should have 10 points", 10, player.getScore());
		
		playerPos = 416;//moving up
		player.updateScore(playerPos);
		assertEquals("Player should have 20 points", 20, player.getScore());
		
		playerPos = 448;//moving down
		player.updateScore(playerPos);
		assertEquals("Player should still have 20 points", 20, player.getScore());
		
		playerPos = 416;//moving up again back to its highest position reached
		player.updateScore(playerPos);
		assertEquals("Player should still have 20 points", 20, player.getScore());
		
		playerPos = 384;//moving up to new highest y position
		player.updateScore(playerPos);
		assertEquals("Player should have 30 points", 30, player.getScore());
			
	}
	
}
