/* ***************************************** *
 * Name: Jonathan Basom
 * Date: 11/6/2021
 *
 * Project: CardGameSimulator
 * Class: Main
 *
 * Description:
 * Main class to determine the average and median point cutoff to qualify for the second round of a card game tournament
 * ****************************************
 */

import java.util.Arrays;

/**
 * Main class to determine the average and median point cutoff to qualify for the second round of a card game tournament
 */
public class Main {

    /** Amount of times the tournament should be simulated */
    private static final int NUM_SIMULATIONS = 1000;

    /** Simulation of a single tournament */
    private static Simulation simulation = new Simulation();

    /** Array of the point cutoffs from each tournament simulation */
    private static int[] lowestQualifyingScores = new int[NUM_SIMULATIONS];

    /** Contains the sum of all point cutoffs from each tournament simulation (used to calculate the average) */
    private static int totalLowestQualifyingScores = 0;

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args){
        runSimulations();

        Arrays.sort(lowestQualifyingScores);

        double averageLowestQualifyingScore = (double) totalLowestQualifyingScores / NUM_SIMULATIONS;
        int medianLowestQualifyingScore = lowestQualifyingScores[NUM_SIMULATIONS / 2];

        System.out.printf("Average Point Cutoff: %.3f\n", averageLowestQualifyingScore);
        System.out.printf("Median Point Cutoff: %d\n", medianLowestQualifyingScore);
    }

    /**
     * Runs all of the tournament simulations
     */
    private static void runSimulations() {
        // Point cutoff for the current simulation
        int curLowestQualifyingScore;

        // Simulate the tournament for each
        for (int i = 0; i < NUM_SIMULATIONS; i++){
            curLowestQualifyingScore = simulation.run();

            totalLowestQualifyingScores += curLowestQualifyingScore;
            lowestQualifyingScores[i] = curLowestQualifyingScore;

            simulation.reset();
        }
    }
}
