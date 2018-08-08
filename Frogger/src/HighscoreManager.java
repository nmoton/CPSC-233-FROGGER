package frogger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 
 * @author Justin Flores
 * 
 * This class stores scores and names of players and stores them in an arrayList. It sorts the 
 * arrayList based on the player's score or who achieved the score first. it manages how scores
 * are handled/sorted and where they should be stored.
 * 
 * Last Updated: 07/08/2018
 *
 */
public class HighscoreManager {
	private ArrayList<Score> scoreList;//Where the scores are added
	
	private static final String HIGHSCORE_FILE = "Highscore.dat";//Where the arrayList of scores are stored
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	
	/**
	 * Initializes the arrayList for the scores
	 */
	public HighscoreManager() {
		scoreList = new ArrayList<Score>();
	}
	
	/**
	 * Arranges the scores around the arrayList based which score object got the highest score
	 * or who got the highest score first.
	 */
	public void sortScores(){
		Collections.sort(scoreList, new Comparator<Score>()
				{
					public int compare(Score s1, Score s2) {
						return Integer.valueOf(s2.getScore()).compareTo(s1.getScore());
					}
				});
	}
	
	
	/**
	 * Loads the Higscore.dat file which contains the scores and 
	 * puts them in the scoreList arrayList
	 */
	private void loadScoreFile() {
		try {
			input = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
			scoreList = (ArrayList<Score>) input.readObject();
		}catch (FileNotFoundException e) {
			System.out.println("[Laad] FNF Error: " + e.getMessage());
		}catch (IOException e) {
			System.out.println("[Laad] IO Error: " + e.getMessage());
		}catch (Exception e) {			
			System.out.println("[Laad] CNF Error: " + e.getMessage());
		}finally {
			try {
				if(output != null) {
					output.flush();
					output.close();
				}
			}catch (IOException e) {
				System.out.println("[Laad] IO Error: " + e.getMessage());
			}
		}
	}
	
	/**
	 * Calls various methods in the class to add a score object to the
	 * the arrayList and the Highscore.dat file
	 * @param toAdd - the score object to be added to the scoreList and 
	 * Highscore.dat file
	 */
	public void saveScore(Score toAdd) {
		loadScoreFile();
		addScoreToList(toAdd);
		updateScoreFile();
	}
	
	/**
	 * Writes the "score"-arraylist to the Highscore.dat file
	 */
    private void updateScoreFile() {
        try {
            output = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            output.writeObject(scoreList);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (output != null) {
                    output.flush();
                    output.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }
    
    /**
     * Adds a score object to the scoreList arrayList
     * @param toAdd - the score object that is going to be added
     */
    public void addScoreToList(Score toAdd) {
    	scoreList.add(toAdd);
    }
	
	/**
	 * Note: only used for text-based version
	 * Creates a string that shows the top five scores and the players' name
	 * @return highscoreString - string with a certain format that shows the highscores
	 */
    public String getHighscoreString() {
        String highscoreString = "";
        int max = 5;
        
        loadScoreFile();
        sortScores();
     
        int i = 0;
        int x = scoreList.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + "]" + " " + scoreList.get(i).getUsername() + " ------ " + scoreList.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
        
    } 
    
    //Only used for JUnit Testing
    public ArrayList<Score> copyList(){
    	ArrayList<Score> copyList = new ArrayList<Score>(scoreList);
    	return copyList;
    }
	
	
}
