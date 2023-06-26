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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
    private Button TaoNhanMoi;
    private int p1 = 1;
    private int p2 = 1;
    private int p3 = 1;
    private int p4 = 1;
    private int p5 = 1;
    private int p6 = 1;
    private int p7 = 1;
    private int p8 = 1;
    private int p9 = 1;
    private int p10 = 1;
    private int p11 = 1;
    private int p12 = 1;

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

    @FXML
    private Pane PickColor8;

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
    public void TaoNhanMoi(MouseEvent event) {
        if (card.getLabels().getIDDem() == 1) {
            System.out.println("1");
        }

    }

    public void idd(String id) {
        idd = id.substring(id.lastIndexOf("button") + "button".length());
        card.getLabels().setIDDem(Integer.parseInt(idd));
        System.out.println(card.getLabels().getIDDem());
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
        sceneNhanController.reLabel();
        stage.show();
    }

    public void PickColor(String color) {
        if (color.equals("blue")) {
            PickColor1.setStyle("-fx-background-color: blue;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 1;
            p2 = 2;
            p3 = 2;
            p4 = 2;
            p5 = 2;
            p6 = 2;
            p7 = 2;
            p8 = 2;
            p9 = 2;
            p10 = 2;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:blue;");
        }
        if (color.equals("red")) {
            PickColor2.setStyle("-fx-background-color: red;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 1;
            p3 = 2;
            p4 = 2;
            p5 = 2;
            p6 = 2;
            p7 = 2;
            p8 = 2;
            p9 = 2;
            p10 = 2;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:red;");
        }
        if (color.equals("purple")) {
            PickColor3.setStyle("-fx-background-color: purple;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 1;
            p4 = 2;
            p5 = 2;
            p6 = 2;
            p7 = 2;
            p8 = 2;
            p9 = 2;
            p10 = 2;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:purple;");

        }
        if (color.equals("yellow")) {
            PickColor4.setStyle("-fx-background-color: yellow;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 2;
            p4 = 1;
            p5 = 2;
            p6 = 2;
            p7 = 2;
            p8 = 2;
            p9 = 2;
            p10 = 2;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:yellow;");

        }
        if (color.equals("brown")) {
            PickColor5.setStyle("-fx-background-color: brown;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 2;
            p4 = 2;
            p5 = 1;
            p6 = 2;
            p7 = 2;
            p8 = 2;
            p9 = 2;
            p10 = 2;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:brown;");

        }

        if (color.equals("hotpink")) {
            PickColor5.setStyle("-fx-background-color: hotpink;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 2;
            p4 = 2;
            p5 = 2;
            p6 = 1;
            p7 = 2;
            p8 = 2;
            p9 = 2;
            p10 = 2;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:hotpink;");

        }
        if (color.equals("coral")) {
            PickColor5.setStyle("-fx-background-color: coral;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 2;
            p4 = 2;
            p5 = 2;
            p6 = 2;
            p7 = 1;
            p8 = 2;
            p9 = 2;
            p10 = 2;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:coral;");

        }
        if (color.equals("greenyellow")) {
            PickColor5.setStyle("-fx-background-color: greenyellow;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 2;
            p4 = 2;
            p5 = 2;
            p6 = 2;
            p7 = 2;
            p8 = 1;
            p9 = 2;
            p10 = 2;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:greenyellow;");

        }
        if (color.equals("grey")) {
            PickColor5.setStyle("-fx-background-color: grey;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 2;
            p4 = 2;
            p5 = 2;
            p6 = 2;
            p7 = 2;
            p8 = 2;
            p9 = 1;
            p10 = 2;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:grey;");

        }
        if (color.equals("lightseagreen")) {
            PickColor5.setStyle("-fx-background-color: lightseagreen;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 2;
            p4 = 2;
            p5 = 2;
            p6 = 2;
            p7 = 2;
            p8 = 2;
            p9 = 2;
            p10 = 1;
            p11 = 2;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:lightseagreen;");

        }
        if (color.equals("peachpuff")) {
            PickColor5.setStyle("-fx-background-color: peachpuff;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 2;
            p4 = 2;
            p5 = 2;
            p6 = 2;
            p7 = 2;
            p8 = 2;
            p9 = 2;
            p10 = 2;
            p11 = 1;
            p12 = 2;
            ReviewNhan.setStyle("-fx-background-color:peachpuff;");

        }
        if (color.equals("white")) {
            PickColor5.setStyle("-fx-background-color: brown;-fx-border-width: 4px;; -fx-border-color: black;");
            p1 = 2;
            p2 = 2;
            p3 = 2;
            p4 = 2;
            p5 = 2;
            p6 = 2;
            p7 = 2;
            p8 = 2;
            p9 = 2;
            p10 = 2;
            p11 = 2;
            p12 = 1;
            ReviewNhan.setStyle("-fx-background-color:white;");

        }
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
                p2 = 2;
                p3 = 2;
                p4 = 2;
                p5 = 2;
                p6 = 2;
                p7 = 2;
                p8 = 2;
                p9 = 2;
                p10 = 2;
                p11 = 2;
                p12 = 2;
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
                p1 = 2;
                p2 = 1;
                p3 = 2;
                p4 = 2;
                p5 = 2;
                p6 = 2;
                p7 = 2;
                p8 = 2;
                p9 = 2;
                p10 = 2;
                p11 = 2;
                p12 = 2;
                PickColor1.setStyle("-fx-background-color:blue;");
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
                p1 = 2;
                p2 = 2;
                p3 = 1;
                p4 = 2;
                p5 = 2;
                p6 = 2;
                p7 = 2;
                p8 = 2;
                p9 = 2;
                p10 = 2;
                p11 = 2;
                p12 = 2;
                PickColor1.setStyle("-fx-background-color:blue;");
                PickColor2.setStyle("-fx-background-color:red;");
                PickColor4.setStyle("-fx-background-color:yellow;");
                PickColor5.setStyle("-fx-background-color:brown;");
                PickColor6.setStyle("-fx-background-color:hotpink;");
                PickColor7.setStyle("-fx-background-color:coral;");
                PickColor8.setStyle("-fx-background-color:greenyellow;");
                PickColor9.setStyle("-fx-background-color:grey;");
                PickColor10.setStyle("-fx-background-color:lightseagreen;");
                PickColor11.setStyle("-fx-background-color:peachpuff;");
                PickColor12.setStyle("-fx-background-color:white;");
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
                p1 = 2;
                p2 = 2;
                p3 = 2;
                p4 = 1;
                p5 = 2;
                p6 = 2;
                p7 = 2;
                p8 = 2;
                p9 = 2;
                p10 = 2;
                p11 = 2;
                p12 = 2;
                PickColor1.setStyle("-fx-background-color:blue;");
                PickColor2.setStyle("-fx-background-color:red;");
                PickColor3.setStyle("-fx-background-color:purple;");
                PickColor5.setStyle("-fx-background-color:brown;");
                PickColor6.setStyle("-fx-background-color:hotpink;");
                PickColor7.setStyle("-fx-background-color:coral;");
                PickColor8.setStyle("-fx-background-color:greenyellow;");
                PickColor9.setStyle("-fx-background-color:grey;");
                PickColor10.setStyle("-fx-background-color:lightseagreen;");
                PickColor11.setStyle("-fx-background-color:peachpuff;");
                PickColor12.setStyle("-fx-background-color:white;");
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
                p1 = 2;
                p2 = 2;
                p3 = 2;
                p4 = 2;
                p5 = 1;
                p6 = 2;
                p7 = 2;
                p8 = 2;
                p9 = 2;
                p10 = 2;
                p11 = 2;
                p12 = 2;
                PickColor1.setStyle("-fx-background-color:blue;");
                PickColor2.setStyle("-fx-background-color:red;");
                PickColor3.setStyle("-fx-background-color:purple;");
                PickColor4.setStyle("-fx-background-color:yellow;");
                PickColor6.setStyle("-fx-background-color:hotpink;");
                PickColor7.setStyle("-fx-background-color:coral;");
                PickColor8.setStyle("-fx-background-color:greenyellow;");
                PickColor9.setStyle("-fx-background-color:grey;");
                PickColor10.setStyle("-fx-background-color:lightseagreen;");
                PickColor11.setStyle("-fx-background-color:peachpuff;");
                PickColor12.setStyle("-fx-background-color:white;");
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
                p1 = 2;
                p2 = 2;
                p3 = 2;
                p4 = 2;
                p5 = 2;
                p6 = 1;
                p7 = 2;
                p8 = 2;
                p9 = 2;
                p10 = 2;
                p11 = 2;
                p12 = 2;
                PickColor1.setStyle("-fx-background-color:blue;");
                PickColor2.setStyle("-fx-background-color:red;");
                PickColor3.setStyle("-fx-background-color:purple;");
                PickColor4.setStyle("-fx-background-color:yellow;");
                PickColor5.setStyle("-fx-background-color:brown;");
                PickColor7.setStyle("-fx-background-color:coral;");
                PickColor8.setStyle("-fx-background-color:greenyellow;");
                PickColor9.setStyle("-fx-background-color:grey;");
                PickColor10.setStyle("-fx-background-color:lightseagreen;");
                PickColor11.setStyle("-fx-background-color:peachpuff;");
                PickColor12.setStyle("-fx-background-color:white;");
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
                p1 = 2;
                p2 = 2;
                p3 = 2;
                p4 = 2;
                p5 = 2;
                p6 = 2;
                p7 = 1;
                p8 = 2;
                p9 = 2;
                p10 = 2;
                p11 = 2;
                p12 = 2;
                PickColor1.setStyle("-fx-background-color:blue;");
                PickColor2.setStyle("-fx-background-color:red;");
                PickColor3.setStyle("-fx-background-color:purple;");
                PickColor4.setStyle("-fx-background-color:yellow;");
                PickColor5.setStyle("-fx-background-color:brown;");
                PickColor6.setStyle("-fx-background-color:hotpink;");
                PickColor8.setStyle("-fx-background-color:greenyellow;");
                PickColor9.setStyle("-fx-background-color:grey;");
                PickColor10.setStyle("-fx-background-color:lightseagreen;");
                PickColor11.setStyle("-fx-background-color:peachpuff;");
                PickColor12.setStyle("-fx-background-color:white;");
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
                p1 = 2;
                p2 = 2;
                p3 = 2;
                p4 = 2;
                p5 = 2;
                p6 = 2;
                p7 = 2;
                p8 = 1;
                p9 = 2;
                p10 = 2;
                p11 = 2;
                p12 = 2;
                PickColor1.setStyle("-fx-background-color:blue;");
                PickColor2.setStyle("-fx-background-color:red;");
                PickColor3.setStyle("-fx-background-color:purple;");
                PickColor4.setStyle("-fx-background-color:yellow;");
                PickColor5.setStyle("-fx-background-color:brown;");
                PickColor6.setStyle("-fx-background-color:hotpink;");
                PickColor7.setStyle("-fx-background-color:coral;");
                PickColor9.setStyle("-fx-background-color:grey;");
                PickColor10.setStyle("-fx-background-color:lightseagreen;");
                PickColor11.setStyle("-fx-background-color:peachpuff;");
                PickColor12.setStyle("-fx-background-color:white;");
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
                p1 = 2;
                p2 = 2;
                p3 = 2;
                p4 = 2;
                p5 = 2;
                p6 = 2;
                p7 = 2;
                p8 = 2;
                p9 = 1;
                p10 = 2;
                p11 = 2;
                p12 = 2;
                PickColor1.setStyle("-fx-background-color:blue;");
                PickColor2.setStyle("-fx-background-color:red;");
                PickColor3.setStyle("-fx-background-color:purple;");
                PickColor4.setStyle("-fx-background-color:yellow;");
                PickColor5.setStyle("-fx-background-color:brown;");
                PickColor6.setStyle("-fx-background-color:hotpink;");
                PickColor7.setStyle("-fx-background-color:coral;");
                PickColor8.setStyle("-fx-background-color:greenyellow;");
                PickColor10.setStyle("-fx-background-color:lightseagreen;");
                PickColor11.setStyle("-fx-background-color:peachpuff;");
                PickColor12.setStyle("-fx-background-color:white;");
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
                p1 = 2;
                p2 = 2;
                p3 = 2;
                p4 = 2;
                p5 = 2;
                p6 = 2;
                p7 = 2;
                p8 = 2;
                p9 = 2;
                p10 = 1;
                p11 = 2;
                p12 = 2;
                PickColor1.setStyle("-fx-background-color:blue;");
                PickColor2.setStyle("-fx-background-color:red;");
                PickColor3.setStyle("-fx-background-color:purple;");
                PickColor4.setStyle("-fx-background-color:yellow;");
                PickColor5.setStyle("-fx-background-color:brown;");
                PickColor6.setStyle("-fx-background-color:hotpink;");
                PickColor7.setStyle("-fx-background-color:coral;");
                PickColor8.setStyle("-fx-background-color:greenyellow;");
                PickColor9.setStyle("-fx-background-color:grey;");
                PickColor11.setStyle("-fx-background-color:peachpuff;");
                PickColor12.setStyle("-fx-background-color:white;");
            }
        });
        PickColor11.setOnMouseClicked(event -> {

            if (p11 == 1) {
                PickColor11.setStyle("-fx-background-color: peachpuff;");
                p10 = 2;
                ReviewNhan.setStyle("-fx-background-color: transparent;");
            } else if (p11 == 2) {
                ReviewNhan.setStyle("-fx-background-color:peachpuff;");
                PickColor11.setStyle("-fx-background-color: peachpuff;-fx-border-width: 4px;; -fx-border-color: black;");
                p1 = 2;
                p2 = 2;
                p3 = 2;
                p4 = 2;
                p5 = 2;
                p6 = 2;
                p7 = 2;
                p8 = 2;
                p9 = 2;
                p10 = 2;
                p11 = 1;
                p12 = 2;
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
                PickColor12.setStyle("-fx-background-color:white;");
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
                p1 = 2;
                p2 = 2;
                p3 = 2;
                p4 = 2;
                p5 = 2;
                p6 = 2;
                p7 = 2;
                p8 = 2;
                p9 = 2;
                p10 = 2;
                p11 = 2;
                p12 = 1;
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
            }
        });
    }

}
