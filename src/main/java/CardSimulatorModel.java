/* *****************************************
 * Name: Jonathan Basom
 * Date: 11/9/2021
 *
 * Project: CardGameSimulator
 * Class: CardSimulatorModel
 *
 * Description:
 * Model for the Card Simulator MVC
 * ****************************************
 */

import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Model for the Card Simulator MVC
 */
public class CardSimulatorModel {

    /** Default amount of times the tournament should be simulated */
    private static final int DEFAULT_NUM_SIMULATIONS = 1000;

    /** Amount of times the tournament should be simulated */
    private int numberSimulations = DEFAULT_NUM_SIMULATIONS;

    /** Simulation of a single tournament */
    private Simulation simulation;

    /** Constructor */
    public CardSimulatorModel(){
        this.simulation = new Simulation();
    }

    /**
     * Runs all of the tournament simulations
     */
    public String runSimulations() {
        // Array of the point cutoffs from each tournament simulation
        int[] lowestQualifyingScores = new int[numberSimulations];

        // Contains the sum of all point cutoffs from each tournament simulation (used to calculate the average)
        int totalLowestQualifyingScores = 0;

        // Point cutoff for the current simulation
        int curLowestQualifyingScore;

        // Simulate the tournament for each
        for (int i = 0; i < numberSimulations; i++){
            curLowestQualifyingScore = simulation.run();

            totalLowestQualifyingScores += curLowestQualifyingScore;
            lowestQualifyingScores[i] = curLowestQualifyingScore;

            simulation.reset();
        }

        Arrays.sort(lowestQualifyingScores);

        double averageLowestQualifyingScore = (double) totalLowestQualifyingScores / numberSimulations;
        int medianLowestQualifyingScore = lowestQualifyingScores[numberSimulations / 2];

        String resultString = String.format("Average Point Cutoff: %.3f\nMedian Point Cutoff: %d\n", averageLowestQualifyingScore, medianLowestQualifyingScore);

        return resultString;
    }

    /**
     * Change the number of simulations
     * @param updatedNumSim updated number of simulations
     */
    public void setNumberSimulations(int updatedNumSim){
        this.numberSimulations = updatedNumSim;
    }

    /**
     * Change the number of rounds in the first stage of the tournament
     * @param numberRounds updated number of rounds
     */
    public void setNumberRounds(int numberRounds){
        this.simulation.setNumRounds(numberRounds);
    }

    /**
     * Change the number of qualifiers who advance to the second stage
     * @param numberQualifiers updated number of qualifiers
     * @throws InputMismatchException thrown when there is a number of qualifiers greater than the number of players
     */
    public void setNumberQualifiers(int numberQualifiers) throws InputMismatchException{
        if (numberQualifiers < 0 || numberQualifiers > Simulation.getNumPlayers()){
            throw new InputMismatchException("Invalid Number of Qualifiers");
        }
        this.simulation.setNumQualifiers(numberQualifiers);
    }

    public static int getDefaultNumSimulations() {
        return DEFAULT_NUM_SIMULATIONS;
    }
}
