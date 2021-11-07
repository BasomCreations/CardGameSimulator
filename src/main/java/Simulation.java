/* *****************************************
 * Name: Jonathan Basom
 * Date: 11/6/2021
 *
 * Project: CardGameSimulator
 * Class: Simulation
 *
 * Description:
 * Class that can simulate the card game tournament
 * ****************************************
 */

import java.util.Arrays;
import java.util.Random;

/**
 * Class that can simulate the card game tournament
 */
public class Simulation {

    /** The number of players in the tournament */
    private static final int NUM_PLAYERS = 120;

    /** The number of rounds in the first stage */
    private static final int NUM_ROUNDS = 7;

    /** The amount of players seated at a table */
    private static final int TABLE_SIZE = 8;

    /** The total number of tables */
    private int numTables = NUM_PLAYERS / TABLE_SIZE;

    /** The amount of top scorers who qualify for the second stage */
    private static final int NUM_QUALIFIERS = 32;

    /** Array of all of the players in the tournament */
    private Player[] players = new Player[NUM_PLAYERS];

    /** Random object to determine rankings */
    private static final Random rand = new Random();

    /** Constructor */
    public Simulation(){
        initializePlayers();
    }

    /**
     * Instantiates new players within the players array
     */
    private void initializePlayers(){
        for (int i = 0; i < players.length; i++){
            players[i] = new Player();
        }
    }

    /**
     * Runs the simulation of a single tournament
     * @return the lowest qualifying score to advance to the second stage of the tournament
     */
    public int run(){
        // Play each round of the first stage
        for (int i = 0; i < NUM_ROUNDS; i++){
            playRound();
        }
        // Order players by their total points earned throughout the first stage (lowest to highest)
        Arrays.sort(players, (p1, p2) -> Integer.compare(p1.getTotalPoints(), p2.getTotalPoints()));

        int lowestQualifyingScore = players[NUM_PLAYERS - NUM_QUALIFIERS].getTotalPoints();

        return lowestQualifyingScore;
    }

    /**
     * Simulate a single round of the first stage
     */
    private void playRound(){
        int startPlayerIndex, endPlayerIndex;
        // Each table will play one round
        for (int i = 0; i < numTables; i++){
            startPlayerIndex = i * TABLE_SIZE;
            endPlayerIndex = (startPlayerIndex + TABLE_SIZE) - 1;
            playTable(startPlayerIndex, endPlayerIndex);
        }
    }

    /**
     * Simulate a single round for one table
     * @param firstPlayerIndex - index of the first player at the table within the players array
     * @param lastPlayerIndex - index of the last player at the table within the players array
     */
    private void playTable(int firstPlayerIndex, int lastPlayerIndex){
        // Randomly assign numbers for the score of each player
        for(int i = firstPlayerIndex; i <= lastPlayerIndex; i++){
            players[i].setCurrentRoundScore(rand.nextInt());
        }

        // Order players based on their scores (lowest to highest)
        Arrays.sort(players, firstPlayerIndex, lastPlayerIndex + 1, (p1, p2) -> Integer.compare(p1.getCurrentRoundScore(), p2.getCurrentRoundScore()));

        // Assign corresponding points to each player (assume a lower score is ranked higher)
        assignPoints(firstPlayerIndex, lastPlayerIndex);
    }

    /**
     * Assigns points to all of the players at the table after a round
     * @param firstPlayerIndex - index of the first player at the table within the players array
     * @param lastPlayerIndex - index of the last player at the table within the players array
     */
    private void assignPoints(int firstPlayerIndex, int lastPlayerIndex){
        int rank = 1;
        for(int i = firstPlayerIndex; i <= lastPlayerIndex; i++){
            switch (rank) {
                case 1:
                    players[i].addPoints(Rank.FIRST.getPoints());
                    break;
                case 2:
                    players[i].addPoints(Rank.SECOND.getPoints());
                    break;
                case 3:
                    players[i].addPoints(Rank.THIRD.getPoints());
                    break;
                case 4:
                    players[i].addPoints(Rank.FOURTH.getPoints());
                    break;
                case 5:
                    players[i].addPoints(Rank.FIFTH.getPoints());
                    break;
                case 6:
                    players[i].addPoints(Rank.SIXTH.getPoints());
                    break;
                case 7:
                    players[i].addPoints(Rank.SEVENTH.getPoints());
                    break;
                case 8:
                    players[i].addPoints(Rank.EIGHTH.getPoints());
                    break;
                default:
                    break;
            }
            rank++;
        }
    }

    /**
     * Reset the simulation by resetting the players
     */
    public void reset(){
        initializePlayers();
    }
}
