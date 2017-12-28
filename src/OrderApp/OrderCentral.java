package OrderApp;

import Shared.IEstabOrder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrderCentral extends Application implements IEstabOrder {

    private Order order;
    private Order currentOrder;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/KioskStart.fxml"));
        primaryStage.setTitle("mc Donalds");
        primaryStage.setScene(new Scene(root, 700, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void placeOrder() {
//TODO fill in methode.
    }

    public void newOrder(){
        order = new Order(1, false);
        currentOrder = order;
        //TODO check
    }
}
