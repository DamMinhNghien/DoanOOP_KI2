/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Card.MainCard;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class NewSceneController implements Initializable {

    Pane paneLabel = new Pane();
    @FXML
    private Button DanNhan;

    @FXML
    private Label LabelMove;
    @FXML
    private FontAwesomeIcon IconMove;

    @FXML
    private Button XButton;
    private Connection conn = null;
    private PreparedStatement pat = null;
    @FXML
    private AnchorPane newScenePane;
    private CardController cardController;
    private Stage NewStage;
    private MainCard card;
    @FXML
    private TextField TextField2 = new TextField();
    @FXML
    private Label dataLabel = new Label();
    @FXML
    private Label labeldes = new Label();
    @FXML
    private AnchorPane CardPane2;
    @FXML
    private Button XacNhan = new Button();
    @FXML
    private Button XacNhan2;
    @FXML
    private Pane PaneDes;
    @FXML
    private AnchorPane CardPane3;

    public void PaneLabel(String myColor) {

        paneLabel.setPrefSize(40, 25);
        paneLabel.setLayoutX(52);
        paneLabel.setLayoutY(90);
        paneLabel.setStyle(" -fx-background-color: " + myColor + ";");
        CardPane3.getChildren().add(paneLabel);
    }

    public void PaneLabel2() {

        CardPane3.getChildren().remove(paneLabel);

    }

    public void rePaneLabel() {
        if (!card.getLabelColor().equals("khong")) {
            paneLabel.setPrefSize(40, 25);
            paneLabel.setLayoutX(52);
            paneLabel.setLayoutY(90);
            paneLabel.setStyle(" -fx-background-color: " + card.getLabelColor() + ";");
            CardPane3.getChildren().add(paneLabel);
        }
    }

    @FXML
    public void setLabelText(String text) {
        dataLabel.setText(text);
        dataLabel.prefHeight(52);
        dataLabel.prefWidth(170);
        dataLabel.setLayoutX(73);
        dataLabel.setLayoutY(40);
        dataLabel.setFont(new Font(20));

        TextField2.setPromptText("Nhập lại tiêu đề...");
        TextField2.setPrefHeight(40);
        TextField2.setPrefWidth(300);
        TextField2.setFont(Font.font("Arial", 20));
        TextField2.setLayoutX(60);
        TextField2.setLayoutY(34);

        XacNhan.setPrefHeight(30);
        XacNhan.setPrefWidth(38);
        XacNhan.setLayoutX(370);
        XacNhan.setLayoutY(37);
        XacNhan.setText("OK");

        if (!text.isEmpty()) {

            CardPane3.getChildren().add(dataLabel);

            TextField2.setVisible(false);
            CardPane3.getChildren().add(TextField2);

            XacNhan.setVisible(false);
            CardPane3.getChildren().add(XacNhan);
            XacNhan.setOnMouseClicked(this::XacNhanClicked);
            dataLabel.setOnMouseClicked(this::labelClicked);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập tiêu đề thẻ!");

        }
    }

    @FXML
    private void labelClicked(MouseEvent e) {
        // hiển thị TextField để cho phép người dùng nhập lại tên thẻ
        TextField2.setText(dataLabel.getText());
        TextField2.setVisible(true);
        TextField2.requestFocus();
        dataLabel.setVisible(false);
        XacNhan.setVisible(true);

    }

    @FXML
    private void CardClicked() {
        CardPane3.requestFocus();

    }

    @FXML
    private void XacNhanClicked(MouseEvent e) {
        if (!TextField2.getText().isEmpty()) {
            dataLabel.setText(TextField2.getText());
            try {
                card.TitleDB(TextField2.getText(), card.IDCard);
            } catch (SQLException ex) {
                Logger.getLogger(NewSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
            dataLabel.setVisible(true);
            TextField2.setVisible(false);
            XacNhan.setVisible(false);

            if (cardController != null) {
                cardController.updateLabel(TextField2.getText()); // Gọi phương thức updateLabel() của CardController để cập nhật label
            }
            CardClicked();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập tiêu đề thẻ!");
            alert.showAndWait();
        }
    }

    public void setCard(MainCard card) {
        this.card = card;
    }

    public void setCardController(CardController cardController) {
        this.cardController = cardController;
    }

    public void IconMove() {
        LabelMove.setLayoutY(LabelMove.getLayoutY() + 120);
        IconMove.setLayoutY(IconMove.getLayoutY() + 120);
    }

    public void IconBack() {
        LabelMove.setLayoutY(LabelMove.getLayoutY() - 120);
        IconMove.setLayoutY(IconMove.getLayoutY() - 120);
    }

    public void panevi() {
        PaneDes.setVisible(false);
    }

    public void panevi1() {
        PaneDes.setVisible(true);
    }

    public void ReDes(MainCard card) throws SQLException {
        if (card.CheckDes()) {
            try {

                conn = (Connection) Conection.ConnectionDB.dbConn();
                String query = "SELECT The.description, Mota_ChiTiet.sizechu, Mota_ChiTiet.isbold "
                        + "FROM Mota_ChiTiet "
                        + "JOIN The ON Mota_ChiTiet.TheID = The.IDCard "
                        + "WHERE Mota_ChiTiet.TheID = ?";
                PreparedStatement pat = conn.prepareStatement(query);
                pat.setInt(1, card.IDCard);
                ResultSet resultSet = pat.executeQuery();
                while (resultSet.next()) {
                    String description = resultSet.getString("description");
                    int sizechu = resultSet.getInt("sizechu");
                    boolean isbold = resultSet.getBoolean("isbold");
                    description = description.replace("\\n", "\n");

                    Label labeldes1 = new Label();
                    card.description.setContent(description);
                    card.description.setSize(sizechu);
                    card.description.setInDam(isbold);

                    panevi();
                    double lineheight = card.description.getSize() * 1.5;
                    double linecount = card.description.getContent().split("\n").length;
                    double labeldesheight = lineheight * linecount;
                    checklabeldes();
                    Font font;

                    if (card.description.isInDam()) {
                        font = Font.font("Arial", FontWeight.BOLD, card.description.getSize());

                    } else {
                        font = Font.font("Arial", FontWeight.NORMAL, card.description.getSize());

                    }

                    labeldes1.setFont(font);

                    labeldes1.setText(card.description.getContent());
                    labeldes.setFont(font);
                    labeldes1.setWrapText(true);
                    labeldes1.setText(card.description.getContent());
                    labeldes.setFont(labeldes1.getFont());
                    labeldes1.setPrefSize(378, labeldesheight);

                    setLabeldes(labeldes1);
                    setviChinhSua();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void setLabeldes(Label label) throws SQLException {

        if (!CardPane3.getChildren().contains(labeldes)) {

            labeldes.setMaxWidth(label.getPrefWidth());
            labeldes.setPrefHeight(label.getPrefHeight());
            labeldes.setWrapText(true);
            labeldes.setText(label.getText());
            labeldes.setFont(label.getFont());

            labeldes.setLayoutX(52);
            labeldes.setLayoutY(163);

            CardPane3.getChildren().add(labeldes);
            move(labeldes);
            double newHeight = labeldes.getLayoutY() + labeldes.getHeight() + 10; // Add some padding
            if (newHeight > CardPane3.getHeight()) {
                CardPane3.setPrefHeight(newHeight);
            }
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(CardPane3);
            scrollPane.setFitToWidth(true);
            scrollPane.setPrefHeight(508);
            scrollPane.setPrefWidth(660);
            scrollPane.setLayoutX(0);
            scrollPane.setLayoutY(0);
            scrollPane.setPrefSize(633, 514);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            CardPane2.getChildren().add(scrollPane);
        }
    }

    public void move(Label label) {
        if (label.getPrefHeight() >= 50) {

            IconMove.setLayoutY(163 + 54 + 23 + label.getPrefHeight());
            LabelMove.setLayoutY(163 + 54 + label.getPrefHeight());
        } else {
            IconMove.setLayoutY(163 + 54 + 23 + label.getPrefHeight());
            LabelMove.setLayoutY(163 + 54 + label.getPrefHeight());
        }
    }

    @FXML
    public void XacNhan2(MouseEvent e) throws IOException {
        CardPane3.getChildren().remove(labeldes);

        IconMove();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneDes.fxml"));
        AnchorPane newScenePane = loader.load();
        Stage newStage = new Stage();

        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.initOwner(PaneDes.getScene().getWindow()); // Nếu primaryStage là stage chính của ứng dụng
        newStage.getIcons().add(new Image(getClass().getResourceAsStream("../image/trello.png")));
        newStage.initStyle(StageStyle.UNDECORATED);
        Scene newScene = new Scene(newScenePane);
        newStage.setScene(newScene);
        newStage.setX(488);
        newStage.setY(263);
        SceneDesController sceneDesController = loader.getController();
        sceneDesController.setNewSceneController(this);
        sceneDesController.setCard(card);
        sceneDesController.setTextArea(labeldes);
        newStage.setOnCloseRequest(event -> {
            event.consume();
        });

        newStage.showAndWait();
        //378 166
    }

    @FXML
    private void PaneDes(MouseEvent e) throws IOException {
        IconMove();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneDes.fxml"));
        AnchorPane newScenePane = loader.load();
        Stage newStage = new Stage();

        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.initOwner(PaneDes.getScene().getWindow()); // Nếu primaryStage là stage chính của ứng dụng
        newStage.getIcons().add(new Image(getClass().getResourceAsStream("../image/trello.png")));
        newStage.initStyle(StageStyle.UNDECORATED);
        Scene newScene = new Scene(newScenePane);
        newStage.setScene(newScene);
        newStage.setX(488);
        newStage.setY(263);
        SceneDesController sceneDesController = loader.getController();
        sceneDesController.setNewSceneController(this);
        sceneDesController.setCard(card);
        newStage.setOnCloseRequest(event -> {
            event.consume();
        });

        newStage.showAndWait();
        //378 166
    }

    public void checklabeldes() {
        if (CardPane3.getChildren().contains(labeldes)) {
            CardPane3.getChildren().remove(labeldes);
        }
    }

    public void setviChinhSua() {
        XacNhan2.setVisible(true);
    }

    public void setChinhSua1() {
        XacNhan2.setVisible(false);
    }

    public void setIconText() {
        IconMove.setLayoutY(242);
        IconMove.setLayoutX(13);
        LabelMove.setLayoutY(217);
        LabelMove.setLayoutX(52);
    }

    @FXML
    private void handleXButtonAction(ActionEvent event
    ) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void DanNhan(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan.fxml"));
        AnchorPane newScenePane = loader.load();
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);

        newStage.initOwner(DanNhan.getScene().getWindow()); // Nếu primaryStage là stage chính của ứng dụng
        newStage.getIcons().add(new Image(getClass().getResourceAsStream("../image/trello.png")));
        Scene newScene = new Scene(newScenePane);
        newStage.setScene(newScene);
        SceneNhanController sceneNhanController = loader.getController();
        sceneNhanController.setNewSceneController(this);
        sceneNhanController.setCard(card);
        sceneNhanController.Tao5Nhan(card.CheckLabelDem(), card.getNewDem(), card.getLabelColor());
        sceneNhanController.setCardController(cardController);

        newStage.showAndWait();
        //378 166
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
