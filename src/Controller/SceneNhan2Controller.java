/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Card.MainCard;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class SceneNhan2Controller implements Initializable {

    @FXML
    private Pane ReviewNhan;
    @FXML
    private TextField LabelTieuDe;

    @FXML
    private Button TaoNhanMoi;
    private int p1 = 2;
    private int p2 = 2;
    private int p3 = 2;
    private int p4 = 2;
    private int p5 = 2;
    private int p6 = 2;
    private int p7 = 2;
    private int p8 = 2;
    private int p9 = 2;
    private int p10 = 2;
    private int p11 = 2;
    private int p12 = 2;

    @FXML
    private Pane PickColor1;

    @FXML
    private Pane PickColor10;

    @FXML
    private Pane PickColor11;

    @FXML
    private Pane PickColor12;

    @FXML
    private Pane PickColor2;

    @FXML
    private Pane PickColor3;

    @FXML
    private Pane PickColor4;

    @FXML
    private Pane PickColor5;

    @FXML
    private Pane PickColor6;

    @FXML
    private Pane PickColor7;

    public void setX(int x) {
        this.x = x;
    }
    private int x;

    public void setK(int k) {
        this.k = k;
    }
    private int k;
    @FXML
    private Pane PickColor8;
    private CardController cardController;
    private NewSceneController newSceneController;
    @FXML
    private Pane PickColor9;
    private SceneNhanController sceneNhanController;
    private MainCard card;
    @FXML
    private Button BackNhan;
    private String idd;

    public void setCard(MainCard card) {
        this.card = card;
    }

    @FXML
    public void setTextField(String text) {
        LabelTieuDe.setText(text);
    }

    @FXML
    public void TaoNhanMoi(MouseEvent event) throws IOException, SQLException {
        if (p1 != 1 && p2 != 1 && p3 != 1 && p4 != 1 && p5 != 1 && p6 != 1 && p7 != 1 && p8 != 1 && p9 != 1 && p10 != 1 && p11 != 1 && p12 != 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn nhãn để tạo!");
            alert.showAndWait();
        } else {
            String style = ReviewNhan.getStyle();
            Color backgroundColor = Color.valueOf(style.replaceAll("-fx-background-color:", "").replaceAll(";", ""));
            String backgournColor2 = "";
            if (backgroundColor.equals(Color.BLUE)) {
                backgournColor2 = "blue";
            }
            if (backgroundColor.equals(Color.RED)) {
                backgournColor2 = "red";
            }
            if (backgroundColor.equals(Color.PURPLE)) {
                backgournColor2 = "purple";
            }
            if (backgroundColor.equals(Color.YELLOW)) {
                backgournColor2 = "yellow";
            }
            if (backgroundColor.equals(Color.BROWN)) {
                backgournColor2 = "brown";
            }
            if (backgroundColor.equals(Color.CORAL)) {
                backgournColor2 = "coral";
            }
            if (backgroundColor.equals(Color.HOTPINK)) {
                backgournColor2 = "hotpink";
            }
            if (backgroundColor.equals(Color.GREENYELLOW)) {
                backgournColor2 = "greenyellow";
            }
            if (backgroundColor.equals(Color.GREY)) {
                backgournColor2 = "grey";
            }
            if (backgroundColor.equals(Color.LIGHTSEAGREEN)) {
                backgournColor2 = "lightseagreen";
            }
            if (backgroundColor.equals(Color.PEACHPUFF)) {
                backgournColor2 = "peachpuff";
            }
            if (backgroundColor.equals(Color.WHITE)) {
                backgournColor2 = "white";
            }

            for (int i = 1; i < x + 1; i++) {
                card.getLabels().setIDDem(i);
                card.getLabel(card.getLabels().getIDDem());
                if (!backgournColor2.equals(card.getLabels().getColor()) && k == i) {
                    card.UpdateLabel(backgournColor2, LabelTieuDe.getText(), i);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    SceneNhanController sceneNhanController = loader.getController();
                    sceneNhanController.setCard(card);
                    sceneNhanController.setNewSceneController(newSceneController);
                    sceneNhanController.setCardController(cardController);
                    sceneNhanController.reLabel(card.getNewDem(), card.getLabelColor());
                    stage.show();
                }
                if (backgournColor2.equals(card.getLabels().getColor()) && k == i) {
                    card.UpdateLabel(backgournColor2, LabelTieuDe.getText(), i);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    SceneNhanController sceneNhanController = loader.getController();
                    sceneNhanController.setCard(card);
                    sceneNhanController.setNewSceneController(newSceneController);
                    sceneNhanController.setCardController(cardController);
                    sceneNhanController.reLabel(card.getNewDem(), card.getLabelColor());
                    stage.show();
                }
                if (backgournColor2.equals(card.getLabels().getColor())) {
                    card.UpdateLabel(backgournColor2, LabelTieuDe.getText(), i);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    SceneNhanController sceneNhanController = loader.getController();
                    sceneNhanController.setCard(card);
                    sceneNhanController.setNewSceneController(newSceneController);
                    sceneNhanController.setCardController(cardController);
                    sceneNhanController.reLabel(card.getNewDem(), card.getLabelColor());
                    stage.show();
                }
            }
            if (!backgournColor2.equals(card.getLabels().getColor()) && k == 0) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                SceneNhanController sceneNhanController = loader.getController();
                sceneNhanController.setCard(card);
                sceneNhanController.setNewSceneController(newSceneController);
                sceneNhanController.setCardController(cardController);
                sceneNhanController.reLabel(card.getNewDem(), card.getLabelColor());
                sceneNhanController.TaoNhan2(backgournColor2, LabelTieuDe.getText(), x + 1, card.getLabelColor(), x + 2);
                sceneNhanController.insertLabel(backgournColor2, x + 1, LabelTieuDe.getText());
                stage.show();

            }

        }

    }

    public void idd(String id, int x) throws SQLException {
        setX(x);
        idd = id.substring(id.lastIndexOf("button") + "button".length());

        for (int i = 1; i < x + 1; i++) {
            if (Integer.parseInt(idd) == i) {
                card.getLabels().setIDDem(Integer.parseInt(idd));
                setK(Integer.parseInt(idd));
                card.getLabel(card.getLabels().getIDDem());
                if (card.getLabels().getColor().equals("blue")) {
                    PickColor1.setStyle("-fx-background-color: blue;-fx-border-width: 4px;; -fx-border-color: black;");
                    p1 = 1;

                    ReviewNhan.setStyle("-fx-background-color:blue;");
                }
                if (card.getLabels().getColor().equals("red")) {
                    PickColor2.setStyle("-fx-background-color: red;-fx-border-width: 4px;; -fx-border-color: black;");

                    p2 = 1;

                    ReviewNhan.setStyle("-fx-background-color:red;");
                }
                if (card.getLabels().getColor().equals("purple")) {
                    PickColor3.setStyle("-fx-background-color: purple;-fx-border-width: 4px;; -fx-border-color: black;");

                    p3 = 1;

                    ReviewNhan.setStyle("-fx-background-color:purple;");

                }
                if (card.getLabels().getColor().equals("yellow")) {
                    PickColor4.setStyle("-fx-background-color: yellow;-fx-border-width: 4px;; -fx-border-color: black;");

                    p4 = 1;

                    ReviewNhan.setStyle("-fx-background-color:yellow;");

                }
                if (card.getLabels().getColor().equals("brown")) {
                    PickColor5.setStyle("-fx-background-color: brown;-fx-border-width: 4px;; -fx-border-color: black;");

                    p5 = 1;

                    ReviewNhan.setStyle("-fx-background-color:brown;");

                }

                if (card.getLabels().getColor().equals("hotpink")) {
                    PickColor6.setStyle("-fx-background-color: hotpink;-fx-border-width: 4px;; -fx-border-color: black;");

                    p6 = 1;

                    ReviewNhan.setStyle("-fx-background-color:hotpink;");

                }
                if (card.getLabels().getColor().equals("coral")) {
                    PickColor7.setStyle("-fx-background-color: coral;-fx-border-width: 4px;; -fx-border-color: black;");

                    p7 = 1;

                    ReviewNhan.setStyle("-fx-background-color:coral;");

                }
                if (card.getLabels().getColor().equals("greenyellow")) {
                    PickColor8.setStyle("-fx-background-color: greenyellow;-fx-border-width: 4px;; -fx-border-color: black;");

                    p8 = 1;

                    ReviewNhan.setStyle("-fx-background-color:greenyellow;");

                }
                if (card.getLabels().getColor().equals("grey")) {
                    PickColor9.setStyle("-fx-background-color: grey;-fx-border-width: 4px;; -fx-border-color: black;");

                    p9 = 1;

                    ReviewNhan.setStyle("-fx-background-color:grey;");

                }
                if (card.getLabels().getColor().equals("lightseagreen")) {
                    PickColor10.setStyle("-fx-background-color: lightseagreen;-fx-border-width: 4px;; -fx-border-color: black;");

                    p10 = 1;

                    ReviewNhan.setStyle("-fx-background-color:lightseagreen;");

                }
                if (card.getLabels().getColor().equals("peachpuff")) {
                    PickColor11.setStyle("-fx-background-color: peachpuff;-fx-border-width: 4px;; -fx-border-color: black;");

                    p11 = 1;

                    ReviewNhan.setStyle("-fx-background-color:peachpuff;");

                }
                if (card.getLabels().getColor().equals("white")) {
                    PickColor12.setStyle("-fx-background-color: brown;-fx-border-width: 4px;; -fx-border-color: black;");

                    p12 = 1;
                    ReviewNhan.setStyle("-fx-background-color:white;");

                }
            } else {
                card.getLabels().setIDDem(i);
                card.getLabel(i);
                if (card.getLabels().getColor().equals("blue")) {
                    PickColor1.setStyle("-fx-background-color: blue; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p1 = 3;
                }
                if (card.getLabels().getColor().equals("red")) {
                    PickColor2.setStyle("-fx-background-color: red; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p2 = 3;
                }
                if (card.getLabels().getColor().equals("purple")) {
                    PickColor3.setStyle("-fx-background-color: purple; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p3 = 3;
                }
                if (card.getLabels().getColor().equals("yellow")) {
                    PickColor4.setStyle("-fx-background-color: yellow; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p4 = 3;
                }
                if (card.getLabels().getColor().equals("brown")) {
                    PickColor5.setStyle("-fx-background-color: brown; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p5 = 3;
                }
                if (card.getLabels().getColor().equals("hotpink")) {
                    PickColor6.setStyle("-fx-background-color: hotpink; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p6 = 3;
                }
                if (card.getLabels().getColor().equals("coral")) {
                    PickColor7.setStyle("-fx-background-color: coral; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p7 = 3;
                }
                if (card.getLabels().getColor().equals("greenyellow")) {
                    PickColor8.setStyle("-fx-background-color: greenyellow; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p8 = 3;
                }
                if (card.getLabels().getColor().equals("grey")) {
                    PickColor9.setStyle("-fx-background-color: grey; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p9 = 3;
                }
                if (card.getLabels().getColor().equals("lightseagreen")) {
                    PickColor10.setStyle("-fx-background-color: lightseagreen; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p10 = 3;
                }
                if (card.getLabels().getColor().equals("peachpuff")) {
                    PickColor11.setStyle("-fx-background-color: peachpuff; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p11 = 3;
                }
                if (card.getLabels().getColor().equals("white")) {
                    PickColor12.setStyle("-fx-background-color: white; -fx-border-width: 6px 0 0 0;-fx-border-color: black;");
                    p12 = 3;
                }
            }
        }
    }

    public void setCardController(CardController cardController) {
        this.cardController = cardController;
    }

    public void setNewSceneController(NewSceneController newSceneController) {
        this.newSceneController = newSceneController;
    }

    public void setSceneNhanController(SceneNhanController sceneNhanController) {
        this.sceneNhanController = sceneNhanController;
    }

    @FXML
    void BackNhan(MouseEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan.fxml"));

        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        SceneNhanController sceneNhanController = loader.getController();
        sceneNhanController.setCard(card);
        sceneNhanController.setNewSceneController(newSceneController);
        sceneNhanController.setCardController(cardController);
        sceneNhanController.reLabel(card.getNewDem(), card.getLabelColor());
        stage.show();
    }

    public void NhanDaTao() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        PickColor1.setStyle("-fx-background-color:blue;");
        PickColor2.setStyle("-fx-background-color:red;");
        PickColor3.setStyle("-fx-background-color:purple;");
        PickColor4.setStyle("-fx-background-color:yellow;");
        PickColor5.setStyle("-fx-background-color:brown;");
        PickColor6.setStyle("-fx-background-color:hotpink;");
        PickColor7.setStyle("-fx-background-color:coral;");
        PickColor8.setStyle("-fx-background-color:greenyellow;");
        PickColor9.setStyle("-fx-background-color:grey;");
        PickColor10.setStyle("-fx-background-color:lightseagreen;");
        PickColor11.setStyle("-fx-background-color:peachpuff;");
        PickColor12.setStyle("-fx-background-color:white;");
        PickColor1.setOnMouseClicked(event -> {
            if (p1 == 1) {
                PickColor1.setStyle("-fx-background-color: blue;");
                p1 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p1 == 2) {
                ReviewNhan.setStyle("-fx-background-color:blue;");
                PickColor1.setStyle("-fx-background-color: blue;-fx-border-width: 4px;; -fx-border-color: black;");
                p1 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor2.setOnMouseClicked(event -> {

            if (p2 == 1) {
                PickColor2.setStyle("-fx-background-color: red;");
                ReviewNhan.setStyle("-fx-background-color: transparent;");
                p2 = 2;
            } else if (p2 == 2) {
                ReviewNhan.setStyle("-fx-background-color:red;");
                PickColor2.setStyle("-fx-background-color: red;-fx-border-width: 4px;; -fx-border-color: black;");
                p2 = 1;
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor3.setOnMouseClicked(event -> {

            if (p3 == 1) {
                PickColor3.setStyle("-fx-background-color: purple;");
                p3 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p3 == 2) {
                ReviewNhan.setStyle("-fx-background-color:purple;");
                PickColor3.setStyle("-fx-background-color: purple;-fx-border-width: 4px;; -fx-border-color: black;");
                p3 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor4.setOnMouseClicked(event -> {

            if (p4 == 1) {
                PickColor4.setStyle("-fx-background-color: yellow;");
                p4 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p4 == 2) {
                ReviewNhan.setStyle("-fx-background-color:yellow;");
                PickColor4.setStyle("-fx-background-color: yellow;-fx-border-width: 4px;; -fx-border-color: black;");

                p4 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor5.setOnMouseClicked(event -> {

            if (p5 == 1) {
                PickColor5.setStyle("-fx-background-color: brown;");
                p5 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p5 == 2) {
                ReviewNhan.setStyle("-fx-background-color:brown;");
                PickColor5.setStyle("-fx-background-color: brown;-fx-border-width: 4px;; -fx-border-color: black;");

                p5 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor6.setOnMouseClicked(event -> {

            if (p6 == 1) {
                PickColor6.setStyle("-fx-background-color: hotpink;");
                p6 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p6 == 2) {
                ReviewNhan.setStyle("-fx-background-color:hotpink;");
                PickColor6.setStyle("-fx-background-color: hotpink;-fx-border-width: 4px;; -fx-border-color: black;");

                p6 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor7.setOnMouseClicked(event -> {

            if (p7 == 1) {
                PickColor7.setStyle("-fx-background-color: coral;");
                p7 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p7 == 2) {
                ReviewNhan.setStyle("-fx-background-color:coral;");
                PickColor7.setStyle("-fx-background-color: coral;-fx-border-width: 4px;; -fx-border-color: black;");

                p7 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor8.setOnMouseClicked(event -> {

            if (p8 == 1) {
                PickColor8.setStyle("-fx-background-color: greenyellow;");
                p8 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p8 == 2) {
                ReviewNhan.setStyle("-fx-background-color:greenyellow;");
                PickColor8.setStyle("-fx-background-color: greenyellow;-fx-border-width: 4px;; -fx-border-color: black;");

                p8 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor9.setOnMouseClicked(event -> {

            if (p9 == 1) {
                PickColor9.setStyle("-fx-background-color: grey;");
                p9 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p9 == 2) {
                ReviewNhan.setStyle("-fx-background-color:grey;");
                PickColor9.setStyle("-fx-background-color: grey;-fx-border-width: 4px;; -fx-border-color: black;");

                p9 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor10.setOnMouseClicked(event -> {

            if (p10 == 1) {
                PickColor10.setStyle("-fx-background-color: lightseagreen;");
                p10 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p10 == 2) {
                ReviewNhan.setStyle("-fx-background-color:lightseagreen;");
                PickColor10.setStyle("-fx-background-color: lightseagreen;-fx-border-width: 4px;; -fx-border-color: black;");

                p10 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor11.setOnMouseClicked(event -> {

            if (p11 == 1) {
                PickColor11.setStyle("-fx-background-color: peachpuff;");
                p11 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p11 == 2) {
                ReviewNhan.setStyle("-fx-background-color:peachpuff;");
                PickColor11.setStyle("-fx-background-color: peachpuff;-fx-border-width: 4px;; -fx-border-color: black;");

                p11 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
                if (p12 != 3) {
                    PickColor12.setStyle("-fx-background-color:white;");
                    p12 = 2;
                }
            }
        });
        PickColor12.setOnMouseClicked(event -> {

            if (p12 == 1) {
                PickColor12.setStyle("-fx-background-color: white;");
                p12 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p12 == 2) {
                ReviewNhan.setStyle("-fx-background-color:white;");
                PickColor12.setStyle("-fx-background-color: white;-fx-border-width: 4px;; -fx-border-color: black;");

                p12 = 1;
                if (p2 != 3) {
                    PickColor2.setStyle("-fx-background-color:red;");
                    p2 = 2;
                }
                if (p3 != 3) {
                    PickColor3.setStyle("-fx-background-color:purple;");
                    p3 = 2;
                }
                if (p4 != 3) {
                    PickColor4.setStyle("-fx-background-color:yellow;");
                    p4 = 2;
                }
                if (p5 != 3) {
                    PickColor5.setStyle("-fx-background-color:brown;");
                    p5 = 2;
                }
                if (p6 != 3) {
                    PickColor6.setStyle("-fx-background-color:hotpink;");
                    p6 = 2;
                }
                if (p7 != 3) {
                    PickColor7.setStyle("-fx-background-color:coral;");
                    p7 = 2;
                }
                if (p8 != 3) {
                    PickColor8.setStyle("-fx-background-color:greenyellow;");
                    p8 = 2;
                }
                if (p9 != 3) {
                    PickColor9.setStyle("-fx-background-color:grey;");
                    p9 = 2;
                }
                if (p10 != 3) {
                    PickColor10.setStyle("-fx-background-color:lightseagreen;");
                    p10 = 2;
                }
                if (p11 != 3) {
                    PickColor11.setStyle("-fx-background-color:peachpuff;");
                    p11 = 2;
                }
                if (p1 != 3) {
                    PickColor1.setStyle("-fx-background-color:blue;");
                    p1 = 2;
                }
            }
        });
    }

}
