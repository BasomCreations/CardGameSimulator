/* *****************************************
 * Name: Jonathan Basom
 * Date: 11/9/2021
 *
 * Project: CardGameSimulator
 * Class: CardSimulatorController
 *
 * Description:
 * Controller for the Card Game Simulator MVC
 * ****************************************
 */

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import java.util.InputMismatchException;

/**
 * Controller for the Card Game Simulator MVC
 */
public class CardSimulatorController {

    /** Model for the MVC */
    private CardSimulatorModel cardSimulatorModel;

    /** View for the MVC */
    private CardSimulatorView cardSimulatorView;

    /**
     * Constructor
     * @param cardSimulatorModel model object for the Card Game Simulator MVC
     * @param cardSimulatorView view object for the Card Game Simulator MVC
     */
    public CardSimulatorController(CardSimulatorModel cardSimulatorModel, CardSimulatorView cardSimulatorView){
        this.cardSimulatorModel = cardSimulatorModel;
        this.cardSimulatorView = cardSimulatorView;

        this.cardSimulatorView.getRunSimulationBtn().setOnAction(this::handleRunSimulationsButtonClick);
    }

    /**
     * Runs the simulations with any of the updated values from the user input
     * @param event the event which occurred
     */
    public void handleRunSimulationsButtonClick(ActionEvent event) {
        int numberSimulations, numberRounds, numberQualifiers;
        try {
            // Check the number of simulations input
            String numberSimulationsString = this.cardSimulatorView.getNumberSimulationsInput().getText();
            if (numberSimulationsString.length() > 0){
                numberSimulations = Integer.parseInt(numberSimulationsString);
                this.cardSimulatorModel.setNumberSimulations(numberSimulations);
            }
            else {
                this.cardSimulatorModel.setNumberSimulations(CardSimulatorModel.getDefaultNumSimulations());
            }

            // Check the number of rounds input
            String numRoundsString = this.cardSimulatorView.getNumberRoundsInput().getText();
            if (numRoundsString.length() > 0){
                numberRounds = Integer.parseInt(numRoundsString);
                this.cardSimulatorModel.setNumberRounds(numberRounds);
            }
            else {
                this.cardSimulatorModel.setNumberRounds(Simulation.getDefaultNumRounds());
            }

            // Check the number of qualifiers input
            String numberQualifiersString = this.cardSimulatorView.getNumberSecondRoundQualifiers().getText();
            if (numberQualifiersString.length() > 0){
                numberQualifiers = Integer.parseInt(numberQualifiersString);
                this.cardSimulatorModel.setNumberQualifiers(numberQualifiers);
            }
            else {
                this.cardSimulatorModel.setNumberQualifiers(Simulation.getDefaultNumQualifiers());
            }

                String result = this.cardSimulatorModel.runSimulations();
                this.cardSimulatorView.getLblResult().setText(result);
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect input!");
            alert.setHeaderText("Incorrect input specified!");
            alert.show();
        }
        catch (InputMismatchException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect input!");
            alert.setHeaderText("Incorrect input specified!");
            alert.show();
        }
    }
}
