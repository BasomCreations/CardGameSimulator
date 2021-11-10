/* *****************************************
 * Name: Jonathan Basom
 * Date: 11/9/2021
 *
 * Project: CardGameSimulator
 * Class: CardGameSimulatorMain
 *
 * Description:
 * The main program to start the card game simulation app
 * ****************************************
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main program to start the card game simulation app
 */
public class CardGameSimulatorMain extends Application {

    /** Model for the MVC design pattern */
    private CardSimulatorModel cardSimulatorModel;

    /** View for the MVC design pattern */
    private CardSimulatorView cardSimulatorView;

    /** Controller for the MVC design pattern */
    private CardSimulatorController cardSimulatorController;

    public static void main(String[] args){
        launch(args);
    }

    /**
     * The application initialization method that is called before the start() method
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init();
        this.cardSimulatorModel = new CardSimulatorModel();
        this.cardSimulatorView = new CardSimulatorView(cardSimulatorModel);
        this.cardSimulatorController = new CardSimulatorController(cardSimulatorModel, cardSimulatorView);
    }
    
    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(this.cardSimulatorView.getRoot());
        primaryStage.setTitle("Card Game Simulator");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
