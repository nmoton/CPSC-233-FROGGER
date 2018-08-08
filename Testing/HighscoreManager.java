
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HighscoreManager {
	private ArrayList<Score> scoreList;

	private static final String HIGHSCORE_FILE = "Highscore.dat";

	private ObjectOutputStream output;
	private ObjectInputStream input;

	public HighscoreManager() {
		scoreList = new ArrayList<Score>();
	}

	public void sortScores(){
		Collections.sort(scoreList, new Comparator<Score>()
				{
					public int compare(Score s1, Score s2) {
						return Integer.valueOf(s2.getScore()).compareTo(s1.getScore());
					}
				});
	}



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

	public void saveScore(Score toAdd) {
		loadScoreFile();
		addScoreToList(toAdd);
		updateScoreFile();
	}

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

    public void addScoreToList(Score toAdd) {
    	scoreList.add(toAdd);
    }


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
