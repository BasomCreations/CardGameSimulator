/* *****************************************
 * Name: Jonathan Basom
 * Date: 11/6/2021
 *
 * Project: CardGameSimulator
 * Class: Player
 *
 * Description:
 * Class representing a player in the card game tournament
 * ****************************************
 */

/**
 * Class representing a player in the card game tournament
 */
public class Player {

    /** Total amount of points the player has accumulated throughout the stage */
    private int totalPoints;

    /** The player's score during an individual round which determines the player's rank for that round */
    private int currentRoundScore;

    /** Constructor */
    public Player(){
        totalPoints = 0;
        currentRoundScore = 0;
    }

    /**
     * Add points to the player's total for the stage
     * @param points - number of points to add
     */
    public void addPoints(int points){
        this.totalPoints += points;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getCurrentRoundScore() {
        return currentRoundScore;
    }

    public void setCurrentRoundScore(int currentRoundScore) {
        this.currentRoundScore = currentRoundScore;
    }
}
