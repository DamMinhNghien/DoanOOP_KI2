/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller;

import Card.MainCard;
import List.List1;
import WMS.adminDashboardController;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class FXMLDocumentController implements Initializable {

    public void setAdminDashboardController(adminDashboardController AdminDashboardController) {
        this.AdminDashboardController = AdminDashboardController;
    }

    adminDashboardController AdminDashboardController;

    @FXML
    private Button ok;
    @FXML
    private Button OKList;
    @FXML
    private AnchorPane BangList;
    @FXML
    private TextField ThemList;

    @FXML
    private AnchorPane BangList2;
    private Connection conn = null;
    private PreparedStatement pat = null;
    @FXML
    private Button minimize;

    @FXML
    private Button close_Btn;

    @FXML
    private AnchorPane container;
    @FXML
    private Button Return;

    public void close(ActionEvent event) {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) container.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void Return(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../WMS/adminDashboard.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Khai báo và chú thích biến container với @FXML
//    @FXML
//private Button myButton;
    @FXML
    private AnchorPane CardPane;

    @FXML
    public void TaoCard(ActionEvent event, List1 list, ListView listview) throws IOException, SQLException {
        MainCard NewCard1 = new MainCard();

        createNewCard(NewCard1, list, listview);
    }

    @FXML
    public void ReTaoCard(List1 list, ListView listview) throws IOException, SQLException {
        Connection conn = null;
        PreparedStatement pat = null;
        ResultSet rs = null;

        try {
            conn = Conection.ConnectionDB.dbConn();
            String sql = "SELECT COUNT(IDCard) AS NumCards FROM The WHERE IDList=?";
            pat = conn.prepareStatement(sql);
            pat.setInt(1, list.getListID());
            rs = pat.executeQuery();
            if (rs.next()) {
                int numCards = rs.getInt("NumCards");
                System.out.println("Number of cards: " + numCards);
                // Tạo các card còn thiếu để đạt đến số lượng mong muốn
                for (int i = 0; i < numCards; i++) {
                    MainCard newCard = new MainCard();
                    newCard.IDCard = i + 1;
                    createNewCard(newCard, list, listview);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pat != null) {
                pat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    @FXML
    private void createNewCard(MainCard NewCard, List1 list, ListView listview) throws SQLException {
        try {

            conn = (Connection) Conection.ConnectionDB.dbConn();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Card.fxml"));
            AnchorPane cardPane = loader.load();
            CardController cardController = loader.getController();
            cardController.setList(list);
            cardController.setCard(NewCard);
            cardController.UpTitleDB();
            cardController.reSetLabelCard();
            ObservableList<AnchorPane> items = listview.getItems();
            items.add(cardPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void TaoList(String name) throws IOException, SQLException {
//400,122

        List1 list = new List1();
        int z = list.CountList();
        list.setListID(z);
        list.setListName(name);
        if (list.getListID() == 0) {
            list.setLayoutX(30);
        } else {
            list.setLayoutX(list.MaxLayoutX());
        }
        int x = list.getLayoutX();
        list.InsertList(z, name);
        VBox vbox = new VBox();
        vbox.setLayoutX(22.0);
        vbox.setLayoutY(12.0);
        vbox.setPrefWidth(182.0);
        vbox.setPrefHeight(454.0);
        vbox.setLayoutX(x);
        vbox.setLayoutY(6);
        vbox.setStyle(" -fx-border-color:linear-gradient(to top right, #752131, #8825a1);;-fx-border-width: 2px;");
        Pane pane = new Pane();
        pane.setPrefWidth(190.0);
        pane.setPrefHeight(62.0);
        pane.getStyleClass().add("AnchorPane");
        pane.getStylesheets().add(getClass().getResource("../Css/Style.css").toExternalForm());

        Label label = new Label(name);

        label.setLayoutX(22.0);
        label.setLayoutY(15.0);

        MenuButton menuButton = new MenuButton();
        menuButton.setLayoutX(141.0);
        menuButton.setLayoutY(9);
        menuButton.getStyleClass().add("OKbutton");
        menuButton.getStylesheets().add(getClass().getResource("../Css/Style.css").toExternalForm());

        MenuItem menuItem1 = new MenuItem("Thêm thẻ");
        ListView<AnchorPane> listView = new ListView<>();
        listView.setPrefWidth(183.0);
        listView.setPrefHeight(442.0);
        listView.setId(list.getListTable(z));
        listView.getStylesheets().add(getClass().getResource("../Css/style.css").toExternalForm());
        menuItem1.setOnAction(event -> {
            try {
                TaoCard(event, list, listView);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        MenuItem menuItem2 = new MenuItem("Xóa thẻ");
        menuItem2.setOnAction(event -> {
            // Xử lý hành động cho MenuItem 2
        });

        MenuItem menuItem3 = new MenuItem("Di chuyển thẻ");
        menuItem3.setOnAction(event -> {
            // Xử lý hành động cho MenuItem 3
        });
        MenuItem menuItem4 = new MenuItem("Xóa List");
        menuItem4.setOnAction(event -> {
            try {
                list.DeleteList();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            BangList2.getChildren().remove(vbox);
        });

        menuButton.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);
        pane.getChildren().addAll(label, menuButton);

        vbox.getChildren().addAll(pane, listView);
        BangList2.getChildren().addAll(vbox);
    }

    @FXML
    public void ok1() throws IOException, SQLException {
        List1 list2 = new List1();
        if (!list2.CheckList()) {
            TaoList("Cần Làm");

            TaoList("Đang Làm");
            TaoList("Đã xong");
            System.out.println("right");

        } else if (list2.CheckList()) {
            reTaoList(list2.MaxList());
        }
        addscroll(); // Gọi hàm addscroll() ở đây

    }

    public void reTaoList(int p) throws SQLException, IOException {
        for (int i = 0; i < p + 1; i++) {
            List1 list = new List1();
            int z = i;
            list.setListID(z);
            list.setListName(list.SelectName());
            if (list.getListID() == 0) {
                list.setLayoutX(30);
            } else {
                list.setLayoutX(list.SeLectLayoutX());
                System.out.println(list.SeLectLayoutX());
            }
            int x = list.getLayoutX();
            VBox vbox = new VBox();
            vbox.setLayoutX(22.0);
            vbox.setLayoutY(12.0);
            vbox.setId("vbox" + i);
            vbox.setPrefWidth(182.0);
            vbox.setPrefHeight(454.0);
            vbox.setLayoutX(x);
            vbox.setLayoutY(6);
            vbox.setStyle(" -fx-border-color:linear-gradient(to top right, #752131, #8825a1);;-fx-border-width: 2px;");
            Pane pane = new Pane();
            pane.setPrefWidth(190.0);
            pane.setPrefHeight(62.0);
            pane.getStyleClass().add("AnchorPane");
            pane.getStylesheets().add(getClass().getResource("../Css/Style.css").toExternalForm());

            Label label = new Label(list.getListName());

            label.setLayoutX(22.0);
            label.setLayoutY(15.0);

            MenuButton menuButton = new MenuButton();
            menuButton.setLayoutX(141.0);
            menuButton.setLayoutY(9);
            menuButton.getStyleClass().add("OKbutton");
            menuButton.getStylesheets().add(getClass().getResource("../Css/Style.css").toExternalForm());

            MenuItem menuItem1 = new MenuItem("Thêm thẻ");
            ListView<AnchorPane> listView = new ListView<>();
            listView.setPrefWidth(183.0);
            listView.setPrefHeight(442.0);
            listView.setId(list.getListTable(z));
            listView.getStylesheets().add(getClass().getResource("../Css/style.css").toExternalForm());
            menuItem1.setOnAction(event -> {
                try {
                    TaoCard(event, list, listView);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            MenuItem menuItem2 = new MenuItem("Xóa thẻ");
            menuItem2.setOnAction(event -> {
                // Xử lý hành động cho MenuItem 2
            });

            MenuItem menuItem3 = new MenuItem("Di chuyển thẻ");
            menuItem3.setOnAction(event -> {
                // Xử lý hành động cho MenuItem 3
            });
            MenuItem menuItem4 = new MenuItem("Xóa List");
            menuItem4.setOnAction(event -> {
                try {
                    list.DeleteList();
                    BangList2.getChildren().remove(vbox);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            menuButton.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);
            pane.getChildren().addAll(label, menuButton);

            vbox.getChildren().addAll(pane, listView);
            BangList2.getChildren().addAll(vbox);
            ReTaoCard(list, listView);
        }

    }

    @FXML
    void OKList(MouseEvent event) throws IOException, SQLException {
        String name = ThemList.getText();
        TaoList(name);
    }

    public void addscroll() {
        ScrollPane scrollpane = new ScrollPane();
        scrollpane.setContent(BangList2);
        scrollpane.setPannable(true);

        scrollpane.setPrefSize(938, 473);
        scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        BangList.getChildren().addAll(scrollpane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
