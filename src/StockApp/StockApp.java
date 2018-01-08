package StockApp;

import Shared.Item;
import Shared.ItemCategory;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class StockApp extends Application {

    private Manager manager;
    private List<Manager> managers;
    private StockManager stockManager;

    // scene inlog
    private Scene StockInlog;
    private Button btnLogin;
    private TextField name;
    private TextField ww;
    private String strname;
    private String strww;

    // scene overview
    private Scene Overview;

    // all items
    private Item hamburger;
    private Item cheesburger;
    private Item bigmac;
    private Item mcChicken;
    private Item mcKroket;
    private Item mcFish;
    private Item kip6;
    private Item kip9;
    private Item kip20;
    private Item mcWrap;
    private Item QP;
    private Item veggie;
    private Item frietK;
    private Item frietM;
    private Item frietG;
    private Item saladeSide;
    private Item saladeTonijn;
    private Item saladeKip;
    private Item frisK;
    private Item frisM;
    private Item frisG;
    private Item ijsje;
    private Item tomaat;
    private Item danone;


    // test button
    public Button buttonTest;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // make manager
        Manager manager = new Manager("henk", "henk", "Henk Ietsens");

        // make stockinlog scene
        Parent stockInlog = FXMLLoader.load(getClass().getResource("../Views/ManagerInlog.fxml"));
        StockInlog = new Scene(stockInlog);

        // make overview scene
        Parent overview =FXMLLoader.load(getClass().getResource("../Views/ManagerOverview.fxml"));
        Overview = new Scene(overview);

        



        primaryStage.setTitle("Mc Donald's");
        primaryStage.setScene(StockInlog);
        primaryStage.show();

        initiateItems();
        initiateNodes();
        events(primaryStage);

        try {
            stockManager = new StockManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void events(Stage primaryStage) {
        //test
        buttonTest.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stockManager.getStock("Mcd Eindhoven");
            }
        });

        btnLogin.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                primaryStage.setScene(Overview);
            }
        });


    }


    public static void main(String[] args) {
        launch(args);
    }

    public void sessieSatarten(String name, String password) {
        //TODO : Fill in method
    }

    private void initiateNodes() {
        //test button
        buttonTest = (Button) StockInlog.lookup("#henk");

        btnLogin = (Button) StockInlog.lookup("#btnLogin");
        name = (TextField) StockInlog.lookup("#txtInlogname");
        ww = (TextField) StockInlog.lookup("#txtWW");


    }

    private void initiateItems() {
        hamburger = new Item("hamburger", 1.20, ItemCategory.Burger);
        cheesburger = new Item("cheesburger", 1.50, ItemCategory.Burger);
        bigmac = new Item("Big Mac", 3.45, ItemCategory.Burger);
        mcChicken = new Item("Mc Chicken", 3.45, ItemCategory.Burger);
        mcKroket = new Item("Mc Kroket", 2.00, ItemCategory.Burger);
        mcFish = new Item("Mc fish", 3.45, ItemCategory.Burger);
        mcWrap = new Item("Mc Wrap", 3.95, ItemCategory.Burger);
        QP = new Item("Quarter Pounder", 3.45, ItemCategory.Burger);
        veggie = new Item("Veggie", 3.50, ItemCategory.Burger);

        kip6 = new Item("kip 6", 2.00, ItemCategory.Burger);
        kip9 = new Item("kip 9", 3.50, ItemCategory.Burger);
        kip20 = new Item("kip 20", 6.00, ItemCategory.Burger);

        frietK = new Item("kleine friet", 1.00, ItemCategory.Fries);
        frietM = new Item("medium friet", 1.75, ItemCategory.Fries);
        frietG = new Item("groote friet", 2.15, ItemCategory.Fries);

        saladeSide = new Item("side salade", 1.25, ItemCategory.Salad);
        saladeKip = new Item("Ceasan salade met kip", 2.45, ItemCategory.Salad);
        saladeTonijn = new Item("Tonijn salade", 2.45, ItemCategory.Salad);

        frisK = new Item("kleine frisdrank", 1.25, ItemCategory.Drink);
        frisM = new Item("medium frisdrank", 1.90, ItemCategory.Drink);
        frisG = new Item("groote frisdrank", 2.30, ItemCategory.Drink);

        danone = new Item("danoontje", 0.90, ItemCategory.Other);
        tomaat = new Item("snoeptomaatjes", 0.90, ItemCategory.Other);
        ijsje = new Item("klein ijshoorntje", 1.00, ItemCategory.Other);
    }
}
