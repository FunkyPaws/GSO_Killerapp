package stockApp;

import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import shared.Item;
import shared.ItemCategory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import shared.Stock;

import java.util.List;

public class StockApp extends Application {

    //region Fields
    private Manager manager;
    private Establishment establishment;
    private List<Manager> managers;
    private StockManager stockManager;

    // scene inlog
    private Scene StockInlog;
    private Button btnLogin;
    private TextField name;
    private TextField ww;

    // scene overview
    private Scene overView;
    private ListView<Stock> stockList;
    private Button Logout;
    private Button addStock;
    // test button
    private Button buttonTest;

    // scene stockEdit
    private Scene stockEdit;
    private Button btnLohuit;
    private Button btnBack;
    private Button btnAddstock;
    private ComboBox<Item> cbItems;
    private TextField txtAmount;
    private ListView<Stock> stockListView;

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
// endregion

    @Override
    public void start(Stage primaryStage) throws Exception {
        // make manager
        manager = new Manager("manager", "manager", "Henk Ietsens");

        //make establishment
        establishment = new Establishment("Eindhoven Markt", "Eindhoven");

        // make stockinlog scene
        Parent stockInlog = FXMLLoader.load(getClass().getResource("../views/ManagerInlog.fxml"));
        StockInlog = new Scene(stockInlog);

        // make overview scene
        Parent overview = FXMLLoader.load(getClass().getResource("../views/ManagerOverview.fxml"));
        overView = new Scene(overview);

        // make stock edit scene
        Parent stockedit = FXMLLoader.load(getClass().getResource("../views/ManagerVoorraad.fxml"));
        stockEdit = new Scene(stockedit);

        // set primary stage
        primaryStage.setTitle("Mc Donalds : " + establishment.getName() + ", " + establishment.getPlace());
        primaryStage.setScene(StockInlog);
        primaryStage.show();

        initiateItems();
        initiateNodes();
        events(primaryStage);

        try {
            stockManager = new StockManager(establishment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void events(Stage primaryStage) {
        // scene login
        stockList.setItems(establishment.getObservableListStockItems());
        btnLogin.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            //TODO: sessions?
            if (manager.checkLogin(name.getText(), ww.getText())) {
                primaryStage.setScene(overView);
            } else {
                System.out.println("login is niet correct");
            }
        });

        // scene overview
        buttonTest.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            //TODO: fix the auto update
            System.out.println("stuff changed" + establishment.getStockItems().size());
            stockManager.getStock(establishment);
            stockList.refresh();
        });
        addStock.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> primaryStage.setScene(stockEdit));
        Logout.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            //TODO: End sessions?
            primaryStage.setScene(StockInlog);
        });

        // scene voorraad
        stockListView.setItems(establishment.getObservableListStockItems());
        cbItems.setItems(establishment.getItemObservableListItems());
        cbItems.setValue(establishment.getItemObservableListItems().get(0));

        btnAddstock.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            int amount = 0;
            try {
                amount = Integer.parseInt(txtAmount.getText());
            } catch (NumberFormatException e) {
                System.out.println("that was not a number");
            }
            establishment.addStock(cbItems.getValue(), amount);
        });
        btnBack.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> primaryStage.setScene(overView));
        btnLohuit.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            //TODO: Sessions?
            primaryStage.setScene(StockInlog);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void sessieSatarten(String name, String password) {
        //TODO : Fill in method
    }

    private void initiateNodes() {
        // scene stock log in
        btnLogin = (Button) StockInlog.lookup("#btnLogin");
        name = (TextField) StockInlog.lookup("#txtInlogname");
        ww = (TextField) StockInlog.lookup("#txtWW");

        // scene overview
        addStock = (Button) overView.lookup("#btnAddItems");
        Logout = (Button) overView.lookup("#btnLogOut");
        stockList = (ListView<Stock>) overView.lookup("#listviewStock1");
        // test button
        buttonTest = (Button) overView.lookup("#test");

        // scene add stock
        btnLohuit = (Button) stockEdit.lookup("#btnLogOut");
        btnBack = (Button) stockEdit.lookup("#btnBack");
        btnAddstock = (Button) stockEdit.lookup("#btnAddStock");
        cbItems = (ComboBox<Item>) stockEdit.lookup("#cbProducts");
        txtAmount = (TextField) stockEdit.lookup("#txtAmount");
        stockListView = (ListView<Stock>) stockEdit.lookup("#stocklist");
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

        //region AddItems to estab
        establishment.addItems(hamburger);
        establishment.addItems(cheesburger);
        establishment.addItems(bigmac);
        establishment.addItems(mcChicken);
        establishment.addItems(mcKroket);
        establishment.addItems(mcFish);
        establishment.addItems(mcWrap);
        establishment.addItems(QP);
        establishment.addItems(veggie);

        establishment.addItems(kip6);
        establishment.addItems(kip9);
        establishment.addItems(kip20);

        establishment.addItems(frietK);
        establishment.addItems(frietM);
        establishment.addItems(frietG);

        establishment.addItems(saladeSide);
        establishment.addItems(saladeKip);
        establishment.addItems(saladeTonijn);

        establishment.addItems(frisK);
        establishment.addItems(frisM);
        establishment.addItems(frisG);

        establishment.addItems(danone);
        establishment.addItems(tomaat);
        establishment.addItems(ijsje);
        //endregion

        //region AddStock to estab
        establishment.addStock(hamburger, 100);
        establishment.addStock(cheesburger, 100);
        establishment.addStock(bigmac, 100);
        establishment.addStock(mcChicken, 100);
        establishment.addStock(mcKroket, 100);
        establishment.addStock(mcFish, 100);
        establishment.addStock(mcWrap, 100);
        establishment.addStock(QP, 100);
        establishment.addStock(veggie, 100);

        establishment.addStock(kip6, 100);
        establishment.addStock(kip9, 100);
        establishment.addStock(kip20, 100);

        establishment.addStock(frietK, 100);
        establishment.addStock(frietM, 100);
        establishment.addStock(frietG, 100);

        establishment.addStock(saladeSide, 100);
        establishment.addStock(saladeKip, 100);
        establishment.addStock(saladeTonijn, 100);

        establishment.addStock(frisK, 100);
        establishment.addStock(frisM, 100);
        establishment.addStock(frisG, 100);

        establishment.addStock(danone, 100);
        establishment.addStock(tomaat, 100);
        establishment.addStock(ijsje, 100);
        //endregion
    }
}