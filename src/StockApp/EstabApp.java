package StockApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class EstabApp extends Application {

    private Manager manager;
    private List<Manager> managers;
    private Reg registry;

    @Override
    public void start(Stage primaryStage) throws Exception {
        registry = new Reg();


        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Mc Donald's");
        primaryStage.setScene(new Scene(root, 1200, 1000));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void sessieSatarten(String name, String password) {


    }

}
