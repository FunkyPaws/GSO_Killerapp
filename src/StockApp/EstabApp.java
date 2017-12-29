package StockApp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class EstabApp extends Application {

    private Manager manager;
    private List<Manager> managers;
    private EstablishmentManager establishmentManager;

    public Button buttonTest;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/ManagerInlog.fxml"));
        primaryStage.setTitle("Mc Donald's");
        primaryStage.setScene(new Scene(root, 1200, 1000));
        primaryStage.show();

        buttonTest = (Button) root.lookup("#henk");

        try {
            establishmentManager = new EstablishmentManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        buttonTest.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                establishmentManager.getStock("Henkus");

            }
        });



    }


    public static void main(String[] args) {
        launch(args);
    }

    public void sessieSatarten(String name, String password) {
    }
}
