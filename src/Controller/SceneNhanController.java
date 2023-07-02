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
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextField;
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
import List.List1;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class SceneNhanController implements Initializable {

    @FXML
    private TextField TimNhan;

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
    private List1 list;

    public void setList(List1 list) {
        this.list = list;
    }
    @FXML
    private AnchorPane PaneNhan;
    List<CheckBox> checkBoxList = new ArrayList<>();

    @FXML
    void NewNhan(MouseEvent event) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/SceneNhan2.fxml"));

        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        SceneNhan2Controller sceneNhan2Controller = loader.getController();
        sceneNhan2Controller.setList(list);
        sceneNhan2Controller.setSceneNhanController(this);
        sceneNhan2Controller.setCard(card);
        sceneNhan2Controller.setCardController(cardController);
        sceneNhan2Controller.setNewSceneController(newSceneController);
        int x = card.getNewDem(list.getListID());
        sceneNhan2Controller.idd("button" + 0, x, list);
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

    public void insertLabel(String color, int i, String name) throws SQLException {
        LabelCard label = new LabelCard();
        label.setColor(color);
        label.setIDDem(i);
        label.setName(name);
        card.setLabels(label);
        card.InsertLabel(list.getListID());
    }

    public void TaoNhan(String color, String name, int i, String H) throws SQLException {

        // Tạo HBox mới
        LabelCard label = new LabelCard();
        label.setColor(color);
        label.setIDDem(i);
        label.setName(name);
        card.setLabels(label);
        card.InsertLabel(list.getListID());
        HBox hbox = new HBox();
        hbox.setPrefSize(246, 60);
        // Thêm các phần tử vào HBox

        CheckBox checkBox = new CheckBox();
        checkBoxList.add(checkBox);

        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {

                // Đặt trạng thái cho tất cả các CheckBox khác
                for (CheckBox cb : checkBoxList) {

                    cb.setDisable(true);

                }
                checkBox.setDisable(false);
                newSceneController.PaneLabel(color);
                cardController.setLabelCard(color);
                try {

                    card.InsertCheckBox(color, i, list.getListID());
                } catch (SQLException ex) {
                    Logger.getLogger(SceneNhanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                newSceneController.PaneLabel2();
                cardController.setLabelCard2();
                for (CheckBox cb : checkBoxList) {

                    cb.setDisable(false);

                }
                checkBox.setDisable(false);
                try {
                    card.UnCheckBox(color, i, list.getListID());
                } catch (SQLException ex) {
                    Logger.getLogger(SceneNhanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        checkBox.setDisable(true);
        if (H.equals(color)) {
            checkBox.setSelected(true);
            checkBox.setDisable(false);
        } else if (H.equals("khong")) {

            checkBox.setDisable(false);
        }

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
                sceneNhan2Controller.setList(list);
                sceneNhan2Controller.setSceneNhanController(this);
                sceneNhan2Controller.setCard(card);
                sceneNhan2Controller.setNewSceneController(newSceneController);
                sceneNhan2Controller.setCardController(cardController);
                sceneNhan2Controller.setTextField(name);

                try {
                    sceneNhan2Controller.idd(button.getId(), card.getNewDem(list.getListID()), list);

                } catch (SQLException ex) {
                    Logger.getLogger(SceneNhanController.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        if (color.equals("hotpink")) {
            nhan1.setStyle("-fx-background-color: hotpink;");
        }
        if (color.equals("coral")) {
            nhan1.setStyle("-fx-background-color: coral;");
        }
        if (color.equals("greenyellow")) {
            nhan1.setStyle("-fx-background-color: greenyellow;");
        }
        if (color.equals("grey")) {
            nhan1.setStyle("-fx-background-color: grey;");
        }
        if (color.equals("lightseagreen")) {
            nhan1.setStyle("-fx-background-color: lightseagreen;");
        }

        if (color.equals("peachpuff")) {
            nhan1.setStyle("-fx-background-color: peachpuff;");
        }
        if (color.equals("white")) {
            nhan1.setStyle("-fx-background-color: white;");
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
    public void Tao5Nhan(boolean Y, int x, String H) throws SQLException {
        if (Y) {

            TaoNhan("blue", "", x + 1, H);
            TaoNhan("red", "", x + 2, H);
            TaoNhan("purple", "", x + 3, H);
            TaoNhan("yellow", "", x + 4, H);
            TaoNhan("brown", "", x + 5, H);
            card.UpdateDem(list.getListID());
        } else if (!Y) {

            for (int i = 1; i < x + 1; i++) {
                LabelCard label1 = new LabelCard();
                card.setLabels(label1);
                card.getLabel(i, list.getListID());
                label1.setIDDem(i);
                TaoNhan2(label1.getColor(), label1.getName(), i, H, x);
            }
        }

    }

    public void reLabel(int x, String H, List1 list) throws SQLException {
        for (int i = 1; i < x + 1; i++) {
            LabelCard label1 = new LabelCard();
            card.setLabels(label1);
            card.getLabel(i, list.getListID());

            label1.setIDDem(i);
            TaoNhan2(label1.getColor(), label1.getName(), i, H, x);
        }
    }

    public void TaoNhan2(String color, String name, int i, String H, int x) throws SQLException {
        // Tạo HBox mới

        HBox hbox = new HBox();
        hbox.setPrefSize(246, 60);
        // Thêm các phần tử vào HBox

        CheckBox checkBox = new CheckBox();
        checkBoxList.add(checkBox);

        checkBox.setOnAction(event -> {
            if (checkBox.isSelected()) {

                // Đặt trạng thái cho tất cả các CheckBox khác
                for (CheckBox cb : checkBoxList) {

                    cb.setDisable(true);

                }
                checkBox.setDisable(false);
                newSceneController.PaneLabel(color);
                cardController.setLabelCard(color);
                try {

                    card.InsertCheckBox(color, i, list.getListID());
                } catch (SQLException ex) {
                    Logger.getLogger(SceneNhanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                newSceneController.PaneLabel2();
                cardController.setLabelCard2();
                for (CheckBox cb : checkBoxList) {

                    cb.setDisable(false);

                }
                checkBox.setDisable(false);
                try {
                    card.UnCheckBox(color, i, list.getListID());
                } catch (SQLException ex) {
                    Logger.getLogger(SceneNhanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        checkBox.setDisable(true);
        if (H.equals(color)) {
            checkBox.setSelected(true);
            checkBox.setDisable(false);
        } else if (H.equals("khong")) {

            checkBox.setDisable(false);
        }

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
                sceneNhan2Controller.setList(list);
                sceneNhan2Controller.setCard(card);
                sceneNhan2Controller.setNewSceneController(newSceneController);
                sceneNhan2Controller.setCardController(cardController);
                sceneNhan2Controller.setTextField(name);
                try {
                    sceneNhan2Controller.idd(button.getId(), x, list);
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
        if (color.equals("hotpink")) {
            nhan1.setStyle("-fx-background-color: hotpink;");
        }
        if (color.equals("coral")) {
            nhan1.setStyle("-fx-background-color: coral;");
        }
        if (color.equals("greenyellow")) {
            nhan1.setStyle("-fx-background-color: greenyellow;");
        }
        if (color.equals("grey")) {
            nhan1.setStyle("-fx-background-color: grey;");
        }
        if (color.equals("lightseagreen")) {
            nhan1.setStyle("-fx-background-color: lightseagreen;");
        }

        if (color.equals("peachpuff")) {
            nhan1.setStyle("-fx-background-color: peachpuff;");
        }
        if (color.equals("white")) {
            nhan1.setStyle("-fx-background-color: white;");
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
        TimNhan.setOnKeyReleased(event -> {
            String newText = TimNhan.getText(); //

            // Tạo danh sách tạm thời
            List<HBox> tempCells = new ArrayList<>();

            // Duyệt qua từng cell trong ListView
            for (int i = 0; i < ViewNhan.getItems().size(); i++) {
                Object cellObject = ViewNhan.getItems().get(i); // Lấy cell từ ListView

                if (cellObject instanceof HBox) {
                    HBox cell = (HBox) cellObject; // Cast cell sang kiểu HBox

                    Pane nhan1 = (Pane) cell.getChildren().get(2); // Thay đổi chỉ số 2 nếu cần thiết
                    Label label = (Label) nhan1.getChildren().get(0);
                    // Kiểm tra điều kiện để tìm các cell có label giống nhất
                    if (label.getText().equals(newText)) {
                        tempCells.add(cell); // Thêm cell vào danh sách tạm thời
                        ViewNhan.getItems().remove(i); // Xóa cell khỏi ListView
                        i--; // Giảm chỉ số vì đã xóa một phần tử khỏi ListView
                    }
                }
            }

            // Thêm các cell từ danh sách tạm thời vào đầu ListView
            ViewNhan.getItems().addAll(0, tempCells);

            // Chọn cell đầu tiên trong ListView
            ViewNhan.getSelectionModel().selectFirst();
        });
    }
}
