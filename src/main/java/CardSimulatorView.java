/* *****************************************
 * Name: Jonathan Basom
 * Date: 11/9/2021
 *
 * Project: CardGameSimulator
 * Class: CardSimulatorView
 *
 * Description:
 * View for the Card Simulator MVC
 * ****************************************
 */

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * View for the Card Simulator MVC
 */
public class CardSimulatorView {

    /** Model for the MVC */
    private CardSimulatorModel cardSimulatorModel;

    /** Root node for the scene graph */
    private VBox root;

    /** layout container for the number of simulations setting */
    private FlowPane numSimulationsPane;

    /** control where the user enters the number of simulations */
    private TextField numberSimulationsInput;

    /** layout container for the number of rounds setting */
    private FlowPane numRoundsPane;

    /** control where the user enters the number of rounds */
    private TextField numberRoundsInput;

    /** layout container for the number of second round qualifiers setting */
    private FlowPane numQualifiersPane;

    /** control where the user enters the number of simulations */
    private TextField numberSecondRoundQualifiers;

    /** Shows the result of the simulations */
    private Label lblResult;

    /** The button that causes the simulations to run */
    private Button runSimulationBtn;

    /**
     * Constructor
     * @param theModel Model object for the Card Simulator MVC
     */
    public CardSimulatorView(CardSimulatorModel theModel) {
        this.cardSimulatorModel = theModel;
        initSceneGraph();
    }

    /**
     * Initializes the interface layout and design
     */
    private void initSceneGraph() {
        root = new VBox();
        root.setPrefSize(600,300);
        root.setPadding(new Insets(15));

        // Set up container to hold the text field to enter the number of simulations
        numSimulationsPane = new FlowPane(Orientation.HORIZONTAL);
        numSimulationsPane.setAlignment(Pos.CENTER_LEFT);
        numSimulationsPane.setHgap(10);

        // Text Field to enter the number of simulations
        numberSimulationsInput = new TextField();
        numberSimulationsInput.setPromptText("1000");
        numberSimulationsInput.setAlignment(Pos.CENTER_RIGHT);
        numberSimulationsInput.setPrefColumnCount(3);

        // Add leaf nodes for numSimulationsPane
        numSimulationsPane.getChildren().add(new Label(String.format("%-65s", "Number of Simulations:")));
        numSimulationsPane.getChildren().add(numberSimulationsInput);

        // Set up container to hold the text field to enter the number of rounds
        numRoundsPane = new FlowPane(Orientation.HORIZONTAL);
        numRoundsPane.setAlignment(Pos.CENTER_LEFT);
        numRoundsPane.setHgap(10);

        // Text Field to enter the number of rounds
        numberRoundsInput = new TextField();
        numberRoundsInput.setPromptText("7");
        numberRoundsInput.setAlignment(Pos.CENTER_RIGHT);
        numberRoundsInput.setPrefColumnCount(3);

        // Add leaf nodes for numRoundsPane
        numRoundsPane.getChildren().add(new Label(String.format("%-66s", "Number of Rounds:")));
        numRoundsPane.getChildren().add(numberRoundsInput);


        // Set up container to hold the text field to enter the number of second round qualifiers
        numQualifiersPane = new FlowPane(Orientation.HORIZONTAL);
        numQualifiersPane.setAlignment(Pos.CENTER_LEFT);
        numQualifiersPane.setHgap(10);

        // Text Field to enter the number of second round qualifiers
        numberSecondRoundQualifiers = new TextField();
        numberSecondRoundQualifiers.setPromptText("32");
        numberSecondRoundQualifiers.setAlignment(Pos.CENTER_RIGHT);
        numberSecondRoundQualifiers.setPrefColumnCount(3);

        // Add leaf nodes for numRoundsPane
        numQualifiersPane.getChildren().add(new Label(String.format("%-55s", "Number of Second Rounds Qualifiers:")));
        numQualifiersPane.getChildren().add(numberSecondRoundQualifiers);


        BorderPane bottomPane = new BorderPane();
        bottomPane.setPadding(new Insets(15));

        // Section that will show the result
        lblResult = new Label("");
        lblResult.setPrefWidth(175);
        lblResult.setPrefHeight(50);

        // Set up a border to appear around the results
        lblResult.setBorder(new Border(new BorderStroke(null,
                                                        BorderStrokeStyle.SOLID,
                                                        new CornerRadii(4),
                                                        BorderWidths.DEFAULT)));
        lblResult.setStyle("-fx-border-style: solid; "+
                "-fx-border-radius: 4");
        lblResult.setAlignment(Pos.CENTER);

        // Set up the button to run the simulations
        runSimulationBtn = new Button("Run Simulations");
        BorderPane.setAlignment(runSimulationBtn, Pos.CENTER);

        bottomPane.setCenter(lblResult);
        bottomPane.setBottom(runSimulationBtn);

        root.getChildren().add(numSimulationsPane);
        root.getChildren().add(numRoundsPane);
        root.getChildren().add(numQualifiersPane);
        root.getChildren().add(bottomPane);
    }

    /** Getters */
    public Parent getRoot() {
        return root;
    }

    public Label getLblResult(){
        return this.lblResult;
    }

    public Button getRunSimulationBtn(){
        return this.runSimulationBtn;
    }

    public TextField getNumberSimulationsInput() {
        return numberSimulationsInput;
    }

    public TextField getNumberRoundsInput() {
        return numberRoundsInput;
    }

    public TextField getNumberSecondRoundQualifiers() {
        return numberSecondRoundQualifiers;
    }
}
