package OrderApp;

import Shared.IEstabOrder;
import Shared.Item;
import Shared.ItemCategory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class KioskApp extends Application implements IEstabOrder {

    private Order order;
    private Double money;
    private int number;
    private int seconds;

    // Scene KioskStart
    private Scene KioskStart;
    private ListView<OrderRegel> listView;
    private Button endOrder;
    private Button proceedOrder;
    // btn foods
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
    private Button btnfrietK;
    private Button btnfrietM;
    private Button btnfrietG;
    private Button btnsaladeSide;
    private Button btnsaladeTonijn;
    private Button btnsaladeKip;
    private Button btnfrisK;
    private Button btnfrisM;
    private Button btnfrisG;
    private Button btnijsje;
    private Button btntomaat;
    private Button btndanone;

    // scene bestelling afronden
    private Scene KioskEndOrder;
    private Button btnJa;
    private Button btnNee;
    private ListView<OrderRegel> listViewDone;

    // scene pay order
    private Scene KioskPayOrder;
    private Button btnPay;
    private Button btnCancel;
    private TextField txtMoney;

    //scene kiosk number
    private Scene KioskNumber;
    private TextField txtNumber;

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        // make kioskStart scene
        Parent kioskStart = FXMLLoader.load(getClass().getResource("../Views/KioskStart.fxml"));
        KioskStart = new Scene(kioskStart);

        // make kioskEndOrder scene
        Parent kioskEndORder = FXMLLoader.load(getClass().getResource("../Views/KioskEndOrder.fxml"));
        KioskEndOrder = new Scene(kioskEndORder);

        // make kioskpayOrder scene
        Parent kioskPayOrder = FXMLLoader.load(getClass().getResource("../Views/KioskPayOrder.fxml"));
        KioskPayOrder = new Scene(kioskPayOrder);

        // make kiosk number scene
        Parent kioskNumber = FXMLLoader.load(getClass().getResource("../Views/KioskGiveNumber.fxml"));
        KioskNumber = new Scene(kioskNumber);

        // set primary stage
        primaryStage.setTitle("MC Donalds");
        primaryStage.setScene(KioskStart);
        primaryStage.show();

        // set variable
        money = 0.0;
        number = 0;

        order = new Order();
        initiateItems();
        initiateNodes();
        Events(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void placeOrder() {
        //TODO fill in methode for rmi.
    }

    public void resetOrder() {
        while (!order.getObserverListOrderregels().isEmpty()) {
            order.removeAllItems();
        }
        listView.refresh();
    }

    private void doTime(Stage primaryStage) {
        seconds = 5;
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        if (time != null) {
            time.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seconds--;
                if (seconds <= 0) {
                    primaryStage.setScene(KioskStart);
                    resetOrder();
                    time.stop();
                }
            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();
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

    private void initiateNodes() {
        //scene kioskstart
        listView = (ListView<OrderRegel>) KioskStart.lookup("#list");
        endOrder = (Button) KioskStart.lookup("#btnAnnuleren");
        proceedOrder = (Button) KioskStart.lookup("#btnAfronden");
        btnHamburger = (Button) KioskStart.lookup("#btnHB");
        btnCheeseburger = (Button) KioskStart.lookup("#btnCB");
        btnBigMac = (Button) KioskStart.lookup("#btnBM");
        btnmcChicken = (Button) KioskStart.lookup("#btnMcC");
        btnmcKroket = (Button) KioskStart.lookup("#btnMcK");
        btnmcFish = (Button) KioskStart.lookup("#btnFish");
        btnmcWrap = (Button) KioskStart.lookup("#btnWrap");
        btnQP = (Button) KioskStart.lookup("#btnQP");
        btnveggie = (Button) KioskStart.lookup("#btnVeggie");
        btnkip6 = (Button) KioskStart.lookup("#btnKip6");
        btnkip9 = (Button) KioskStart.lookup("#btnKip9");
        btnkip20 = (Button) KioskStart.lookup("#btnKip20");
        btnfrietK = (Button) KioskStart.lookup("#btnFrietK");
        btnfrietM = (Button) KioskStart.lookup("#btnFrietM");
        btnfrietG = (Button) KioskStart.lookup("#btnFrietG");
        btnsaladeSide = (Button) KioskStart.lookup("#btnSide");
        btnsaladeKip = (Button) KioskStart.lookup("#btnKipSalade");
        btnsaladeTonijn = (Button) KioskStart.lookup("#btnTonijnSalade");
        btnfrisK = (Button) KioskStart.lookup("#btnFrisK");
        btnfrisM = (Button) KioskStart.lookup("#brnFrisM");
        btnfrisG = (Button) KioskStart.lookup("#btnFrisG");
        btndanone = (Button) KioskStart.lookup("#btnDanone");
        btntomaat = (Button) KioskStart.lookup("#btnTomaat");
        btnijsje = (Button) KioskStart.lookup("#btnIjs");

        //scene kioskendorder
        btnJa = (Button) KioskEndOrder.lookup("#btnJa");
        btnNee = (Button) KioskEndOrder.lookup("#btnNee");
        listViewDone = (ListView<OrderRegel>) KioskEndOrder.lookup("#finalList");

        //scene kioskpayorder
        btnPay = (Button) KioskPayOrder.lookup("#btnPay");
        btnCancel = (Button) KioskPayOrder.lookup("#btnBack");
        txtMoney = (TextField) KioskPayOrder.lookup("#txtMoney");

        //scene kiosknumber
        txtNumber = (TextField) KioskNumber.lookup("#txtNumber");
    }

    private void Events(Stage primaryStage) {
        //Scene kiosk pay order
        btnPay.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            number = order.nextOrderNumber();
            txtNumber.setText(Integer.toString(number));
            primaryStage.setScene(KioskNumber);
            doTime(primaryStage);
        });
        btnCancel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> primaryStage.setScene(KioskStart));

        //Scene kiosk end order
        listViewDone.setItems(order.getObserverListOrderregels());
        btnNee.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> primaryStage.setScene(KioskStart));
        btnJa.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            primaryStage.setScene(KioskPayOrder);
            money = order.getTotalPrice();
            txtMoney.setText(money.toString());
        });

        //Scene kiosk start
        listView.setItems(order.getObserverListOrderregels());
        endOrder.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> resetOrder());
        proceedOrder.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> primaryStage.setScene(KioskEndOrder));

        // food buttons
        btnHamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(hamburger, 1));
        btnCheeseburger.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(cheesburger, 1));
        btnBigMac.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(bigmac, 1));
        btnmcChicken.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(mcChicken, 1));
        btnmcKroket.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(mcKroket, 1));
        btnmcFish.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(mcFish, 1));
        btnmcWrap.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(mcWrap, 1));
        btnQP.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(QP, 1));
        btnveggie.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(veggie, 1));
        btnkip6.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(kip6, 1));
        btnkip9.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(kip9, 1));
        btnkip20.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(kip20, 1));
        btnfrietK.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(frietK, 1));
        btnfrietM.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(frietM, 1));
        btnfrietG.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(frietG, 1));
        btnsaladeSide.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(saladeSide, 1));
        btnsaladeKip.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(saladeKip, 1));
        btnsaladeTonijn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(saladeTonijn, 1));
        btnfrisK.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(frisK, 1));
        btnfrisM.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(frisM, 1));
        btnfrisG.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(frisG, 1));
        btndanone.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(danone, 1));
        btntomaat.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(tomaat, 1));
        btnijsje.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> order.addItem(ijsje, 1));
    }
}