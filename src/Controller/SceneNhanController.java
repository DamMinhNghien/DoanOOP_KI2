/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Card.LabelCard;
import Card.MainCard;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import static de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons.PENCIL;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class SceneNhanController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private MainCard card;
    private CardController cardController;
    private NewSceneController newSceneController;
    @FXML
    private ListView ViewNhan;
    @FXML
    private Button NewNhan;

    @FXML
    private AnchorPane PaneNhan;

    @FXML
    void NewNhan(MouseEvent event) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan2.fxml"));

        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        SceneNhan2Controller sceneNhan2Controller = loader.getController();
        sceneNhan2Controller.setSceneNhanController(this);
        sceneNhan2Controller.setCard(card);
        sceneNhan2Controller.setCardController(cardController);
        sceneNhan2Controller.setNewSceneController(newSceneController);
        int x = card.getNewDem();
        sceneNhan2Controller.idd("button" + 0, x);
        stage.show();
    }

    public void setNewSceneController(NewSceneController newSceneController) {
        this.newSceneController = newSceneController;
    }

    public void setCardController(CardController cardController) {
        this.cardController = cardController;
    }

    public void setCard(MainCard card) {
        this.card = card;
    }

    public void TaoNhan(String color, String name) throws SQLException {
        // Tạo HBox mới
        LabelCard label = new LabelCard();
        label.setColor(color);
        label.setIDDem(card.getNewDem());
        label.setName(name);
        card.setLabels(label);
        card.InsertLabel();
        HBox hbox = new HBox();
        hbox.setPrefSize(246, 60);
        // Thêm các phần tử vào HBox

        CheckBox checkBox = new CheckBox();
        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {
                newSceneController.PaneLabel(color);
                cardController.setLabelCard(color);
            } else {
                System.out.println("Checkbox đã bị bỏ chọn");
            }
        });
        Pane pane2 = new Pane();
        pane2.setPrefSize(18, 45);
        Pane nhan1 = new Pane();
        nhan1.setPrefSize(167, 60);
        Button button = new Button(" ");
        FontAwesomeIcon iconView = new FontAwesomeIcon();
        iconView.setIcon(PENCIL);
        iconView.setSize("10");
//        button.setOnMouseClicked(this::IconMouse);
        button.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan2.fxml"));

                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                SceneNhan2Controller sceneNhan2Controller = loader.getController();
                sceneNhan2Controller.setSceneNhanController(this);
                sceneNhan2Controller.setCard(card);
                sceneNhan2Controller.setNewSceneController(newSceneController);
                sceneNhan2Controller.setCardController(cardController);
                stage.show();
            } catch (IOException e) {
                // Xử lý ngoại lệ IOException ở đây
            }
        });
        button.setGraphic(iconView);
        if (color.equals("blue")) {
            nhan1.setStyle("-fx-background-color: blue;");
        }
        if (color.equals("red")) {
            nhan1.setStyle("-fx-background-color: red;");
        }
        if (color.equals("yellow")) {
            nhan1.setStyle("-fx-background-color: yellow;");
        }
        if (color.equals("purple")) {
            nhan1.setStyle("-fx-background-color: purple;");
        }
        if (color.equals("brown")) {
            nhan1.setStyle("-fx-background-color: brown;");
        }

        BorderStroke borderStroke = new BorderStroke(
                Color.WHITE, // Đặt màu đỏ cho đường viền
                BorderStrokeStyle.SOLID, // Đặt kiểu đường viền là đường liền
                new CornerRadii(0), // Không có bo tròn cho đường viền
                new BorderWidths(5) // Đặt độ rộng của đường viền là 2 pixel
        );
        Border border = new Border(borderStroke);
        nhan1.setBorder(border);

        hbox.getChildren().addAll(checkBox, pane2, nhan1, button);
        Label label2 = new Label();
        label2.setText(name);
        label2.setPrefSize(60, 20);
        label2.setLayoutX(12);
        label2.setLayoutY(21);
        nhan1.getChildren().add(label2);
        ViewNhan.getItems().add(hbox);
    }

//    public void IconMouse(MouseEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan2.fxml"));
//            Parent root = loader.load();
//
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void Tao5Nhan() throws SQLException {
        if (card.CheckLabelDem()) {
            TaoNhan("blue", "");
            TaoNhan("red", "");
            TaoNhan("purple", "");
            TaoNhan("yellow", "");
            TaoNhan("brown", "");
            card.UpdateDem();
        } else if (!card.CheckLabelDem()) {
            int x = card.getNewDem();
            for (int i = 1; i < x; i++) {
                LabelCard label1 = new LabelCard();
                card.setLabels(label1);
                card.getLabel(i);
                label1.setIDDem(i);
                TaoNhan2(label1.getColor(), label1.getName(), i, x
                );
            }
        }

    }

    public void reLabel() throws SQLException {
        int x = card.getNewDem();
        for (int i = 1; i < x; i++) {
            LabelCard label1 = new LabelCard();
            card.setLabels(label1);
            card.getLabel(i);
            label1.setIDDem(i);
            TaoNhan2(label1.getColor(), label1.getName(), i, x);
        }
    }

    public void TaoNhan2(String color, String name, int i, int x) throws SQLException {
        // Tạo HBox mới

        HBox hbox = new HBox();
        hbox.setPrefSize(246, 60);
        // Thêm các phần tử vào HBox
        CheckBox checkBox = new CheckBox();
        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {
                newSceneController.PaneLabel(color);
                cardController.setLabelCard(color);
            } else {
                System.out.println("Checkbox đã bị bỏ chọn");
            }
        });
        Pane pane2 = new Pane();
        pane2.setPrefSize(18, 45);
        Pane nhan1 = new Pane();
        nhan1.setPrefSize(167, 60);
        Button button = new Button(" ");
        FontAwesomeIcon iconView = new FontAwesomeIcon();
        iconView.setIcon(PENCIL);
        iconView.setSize("10");
//        button.setOnMouseClicked(this::IconMouse);
        button.setId("button" + i);
        button.setOnMouseClicked(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan2.fxml"));

                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                SceneNhan2Controller sceneNhan2Controller = loader.getController();
                sceneNhan2Controller.setSceneNhanController(this);
                sceneNhan2Controller.setCard(card);
                sceneNhan2Controller.setNewSceneController(newSceneController);
                sceneNhan2Controller.setCardController(cardController);
                try {
                    sceneNhan2Controller.idd(button.getId(), x);
                } catch (SQLException ex) {
                    Logger.getLogger(SceneNhanController.class.getName()).log(Level.SEVERE, null, ex);
                }
//                sceneNhan2Controller.PickColor(color);
                stage.show();
            } catch (IOException e) {
                // Xử lý ngoại lệ IOException ở đây
            }
        });
        button.setGraphic(iconView);
        if (color.equals("blue")) {
            nhan1.setStyle("-fx-background-color: blue;");
        }
        if (color.equals("red")) {
            nhan1.setStyle("-fx-background-color: red;");
        }
        if (color.equals("yellow")) {
            nhan1.setStyle("-fx-background-color: yellow;");
        }
        if (color.equals("purple")) {
            nhan1.setStyle("-fx-background-color: purple;");
        }
        if (color.equals("brown")) {
            nhan1.setStyle("-fx-background-color: brown;");
        }

        BorderStroke borderStroke = new BorderStroke(
                Color.WHITE, // Đặt màu đỏ cho đường viền
                BorderStrokeStyle.SOLID, // Đặt kiểu đường viền là đường liền
                new CornerRadii(0), // Không có bo tròn cho đường viền
                new BorderWidths(5) // Đặt độ rộng của đường viền là 2 pixel
        );
        Border border = new Border(borderStroke);
        nhan1.setBorder(border);

        hbox.getChildren().addAll(checkBox, pane2, nhan1, button);
        Label label2 = new Label();
        label2.setText(name);
        label2.setPrefSize(60, 20);
        label2.setLayoutX(12);
        label2.setLayoutY(21);
        nhan1.getChildren().add(label2);
        ViewNhan.getItems().add(hbox);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
