/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller;

import Card.MainCard;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class FXMLDocumentController implements Initializable {

    private Connection conn = null;
    private PreparedStatement pat = null;

    @FXML
    private Button Return;

    @FXML
    void Return(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../WMS/adminDashboard.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    private ListView<AnchorPane> container1; // Khai báo và chú thích biến container với @FXML
//    @FXML
//private Button myButton;
    @FXML
    private AnchorPane CardPane;

    @FXML
    public void TaoCard(MouseEvent event) throws IOException, SQLException {
        MainCard NewCard1 = new MainCard();
        createNewCard(NewCard1);
    }

    @FXML
    public void ReTaoCard() throws IOException, SQLException {
        Connection conn = null;
        PreparedStatement pat = null;
        ResultSet rs = null;
        try {
            conn = Conection.ConnectionDB.dbConn();
            String sql = "SELECT COUNT(IDCard) AS NumCards FROM The";
            pat = conn.prepareStatement(sql);
            rs = pat.executeQuery();
            if (rs.next()) {
                int numCards = rs.getInt("NumCards");
                System.out.println("Number of cards: " + numCards);
                // Tạo các card còn thiếu để đạt đến số lượng mong muốn
                for (int i = 0; i < numCards; i++) {
                    MainCard newCard = new MainCard();
                    newCard.IDCard = i + 1;
                    createNewCard(newCard);
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
    private void createNewCard(MainCard NewCard) throws SQLException {
        try {

            conn = (Connection) Conection.ConnectionDB.dbConn();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/Card.fxml"));
            AnchorPane cardPane = loader.load();
            CardController cardController = loader.getController();
            cardController.setCard(NewCard);
            cardController.UpTitleDB();
            ObservableList<AnchorPane> items = container1.getItems();
            items.add(cardPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ReTaoCard();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
