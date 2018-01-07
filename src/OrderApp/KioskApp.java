package OrderApp;

import Shared.IEstabOrder;
import Shared.Item;
import Shared.ItemCategory;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class KioskApp extends Application implements IEstabOrder {

    private Order order;

    // Scene KioskStart
    private Scene KioskStart;
    // btn burgers
    private Button btnHamburger;
    private Button btnCheeseburger;
    private Button btnBigMac;
    private Button btnmcChicken;
    private Button btnmcKroket;
    private Button btnmcFish;
    private Button btnkip6;
    private Button btnkip9;
    private Button btnkip20;
    private Button btnmcWrap;
    private Button btnQP;
    private Button btnveggie;
    // btn friet
    private Button btnfrietK;
    private Button btnfrietM;
    private Button btnfrietG;
    // btn salade
    private Button btnsaladeSide;
    private Button btnsaladeTonijn;
    private Button btnsaladeKip;
    // btn fris
    private Button btnfrisK;
    private Button btnfrisM;
    private Button btnfrisG;
    // btn overig
    private Button btnijsje;
    private Button btntomaat;
    private Button btndanone;

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
    // friet
    private Item frietK;
    private Item frietM;
    private Item frietG;
    // salade
    private Item saladeSide;
    private Item saladeTonijn;
    private Item saladeKip;
    // fris
    private Item frisK;
    private Item frisM;
    private Item frisG;
    // overig
    private Item ijsje;
    private Item tomaat;
    private Item danone;


    @Override
    public void start(Stage primaryStage) throws Exception {
        // make kioskStart scene
        Parent kioskStart = FXMLLoader.load(getClass().getResource("../Views/KioskStart.fxml"));
        KioskStart = new Scene(kioskStart);

        // set primary stage
        primaryStage.setTitle("MC Donalds");
        primaryStage.setScene(KioskStart);
        primaryStage.show();

        newOrder();
        initiateItems();
        initiateNodes();
        Events();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void placeOrder() {
        //TODO fill in methode.
    }

    public void newOrder() {
        order = new Order(false);
    }

    public void initiateItems() {
        hamburger = new Item("hamburger", 1.20, ItemCategory.Burger);
        cheesburger = new Item("cheesburger", 1.50, ItemCategory.Burger);
        bigmac = new Item("Big Mac", 3.45, ItemCategory.Burger);

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

    public void initiateNodes() {
        btnHamburger = (Button) KioskStart.lookup("#btnHB");
        btnCheeseburger = (Button) KioskStart.lookup("#btnCB");
        btnBigMac = (Button) KioskStart.lookup("#btnBM");
        btnmcChicken = (Button) KioskStart.lookup("#btnMcC");
        btnmcKroket = (Button) KioskStart.lookup("#btnMcK");
    }

    public void Events() {
        btnHamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                order.addItem(hamburger, 1);
            }
        });
    }


}
