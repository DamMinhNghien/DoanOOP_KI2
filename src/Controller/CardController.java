/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Card.MainCard;
import List.List1;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class CardController implements Initializable {

    Pane paneLabel = new Pane();

    private Label labeldes1 = new Label();
    private MainCard card;
    private Connection conn = null;
    private PreparedStatement pat = null;
    @FXML
    private Label label = new Label();
    @FXML
    private AnchorPane CardPane;
    @FXML
    private Button AddTitle;
    @FXML
    private TextField TextField1;

    private List1 list;

    public void setCard(MainCard card) {
        this.card = card;
    }

    public void setList(List1 list) {
        this.list = list;
    }

    public void setLabelCard(String myColor) {

        paneLabel.setPrefSize(35, 10);
        paneLabel.setLayoutX(6);
        paneLabel.setLayoutY(26);
        paneLabel.setStyle(" -fx-background-color: " + myColor + "; -fx-background-radius: 5px;");
        CardPane.getChildren().add(paneLabel);

    }

    public void setLabelCard2() {
        CardPane.getChildren().remove(paneLabel);
    }

    public void reSetLabelCard() {
        if (!card.getLabelColor(list.getListID()).equals("khong")) {
            paneLabel.setPrefSize(35, 10);
            paneLabel.setLayoutX(6);
            paneLabel.setLayoutY(26);
            paneLabel.setStyle(" -fx-background-color: " + card.getLabelColor(list.getListID()) + "; -fx-background-radius: 5px;");
            CardPane.getChildren().add(paneLabel);
        }
    }

    @FXML
    private void addTitle(MouseEvent e) throws SQLException {
        String text = TextField1.getText();

        if (!text.isEmpty()) {
            int maxId = card.MaxID(list.getListID());
            card.IDCard = maxId + 1;
            card.setTitle(text);
            label.setText(card.title);

            card.IDTitleDB(card.IDCard, card.title, list.getListID());
            label.setPrefSize(165, 55);
            label.setAlignment(Pos.TOP_LEFT);
            label.setLayoutX(5);
            label.setLayoutY(36);
            label.setWrapText(true);
            CardPane.getChildren().add(label);
            label.setStyle("-fx-text-fill: black;");
            AddTitle.setVisible(false);
            TextField1.setVisible(false);
        } else {
            // Hiển thị thông báo lỗi cho người dùng
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập tiêu đề thẻ!");
            alert.showAndWait();
        }

    }

    public void UpTitleDB() {
        if (card.checkTitle(list.getListID()) == true) {
            label.setText(card.title);
            label.setPrefSize(165, 55);
            label.setAlignment(Pos.TOP_LEFT);
            label.setLayoutX(5);
            label.setLayoutY(36);
            label.setWrapText(true);
            CardPane.getChildren().add(label);
            label.setStyle("-fx-text-fill: black;");
            AddTitle.setVisible(false);
            TextField1.setVisible(false);
        }
    }

    public void newscene(MouseEvent e) throws IOException, SQLException {
        if (!card.checkTitle(list.getListID())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng tạo thẻ mới");
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/newScene.fxml"));
            AnchorPane newScenePane = loader.load();
            NewSceneController newSceneController = loader.getController();
            newSceneController.setList(list);
            newSceneController.setCard(card);
            newSceneController.ReDes(card);
            newSceneController.rePaneLabel();

            String labelText = label.getText();
            newSceneController.setLabelText(labelText);
            newSceneController.setCardController(this);
            Stage newStage = new Stage();
            newStage.initStyle(StageStyle.UNDECORATED);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.initOwner(CardPane.getScene().getWindow()); // Nếu primaryStage là stage chính của ứng dụng
            newStage.setTitle("Chỉnh Sửa Thẻ");
            newStage.getIcons().add(new Image(getClass().getResourceAsStream("../image/trello.png")));
            Scene newScene = new Scene(newScenePane);
            newStage.setScene(newScene);

            newStage.showAndWait();
            newStage.setOnCloseRequest(event -> {
                label.setVisible(true);
            });
        }
    }

    public void updateLabel(String newTitle) {
        label.setText(newTitle);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
