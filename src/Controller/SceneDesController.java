/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Card.Description;
import Card.MainCard;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class SceneDesController implements Initializable {

    private boolean InDam;
    private Connection conn = null;
    private PreparedStatement pat = null;

    @FXML
    private CheckBox ton1;

    private MainCard card;
    @FXML
    private Label labeldes = new Label();
    @FXML
    TextArea textArea = new TextArea();
    private NewSceneController newSceneController;
    @FXML
    private Button CloseButton;
    @FXML
    private ComboBox BoxChoice2 = new ComboBox();
    private String[] size2 = {"italic", "Calibri", "Courier New", "Georgia", "Times New Roman", "Verdana"};
    @FXML
    private ComboBox BoxChoice1 = new ComboBox();
    private int toggleCount = 0;
    private String[] size = {"Văn bản bình thường", "Heading 1", "Heading 2", "Heading 3", "Heading 4", "Heading 5", "Heading 6"};

    public void setCard(MainCard card) {
        this.card = card;
    }

    @FXML

    private void handleCloseButtonAction(ActionEvent event) throws SQLException {

        if (textArea.getText().isEmpty()) {
            newSceneController.panevi1();
            Description description = new Description(card.getNewID(), labeldes.getText(), 0, "", InDam);
            card.setDescription(description);
            card.DesDB1();
            newSceneController.setIconText();
            card.Deletedes();
            newSceneController.setChinhSua1();
        } else {

            if (card.CheckDes()) {
                newSceneController.panevi();
                double lineheight = textArea.getFont().getSize() * 1.5;
                double linecount = textArea.getText().split("\n").length;
                double labeldesheight = lineheight * linecount;
                newSceneController.checklabeldes();
                labeldes.setText(textArea.getText());
                labeldes.setFont(textArea.getFont());
                labeldes.setPrefSize(378, labeldesheight);
                newSceneController.setLabeldes(labeldes);
                Description description = new Description(card.getNewID(), labeldes.getText(), textArea.getFont().getSize(), "", InDam);
                card.setDescription(description);
                card.DesDB1();
                card.UpdateDes();

            } else if (!card.CheckDes()) {

                newSceneController.panevi();
                double lineheight = textArea.getFont().getSize() * 1.5;
                double linecount = textArea.getText().split("\n").length;
                double labeldesheight = lineheight * linecount;
                newSceneController.checklabeldes();

                labeldes.setText(textArea.getText());
                labeldes.setFont(textArea.getFont());
                labeldes.setPrefSize(378, labeldesheight);
                newSceneController.setLabeldes(labeldes);
                Description description = new Description(card.getNewID(), labeldes.getText(), textArea.getFont().getSize(), "", InDam);
                card.setDescription(description);
                card.DesDB1();
                card.DesDB();

            }
            newSceneController.setviChinhSua();
        }
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();

    }

    public void setTextArea(Label label) {
        textArea.setText(label.getText());
        textArea.setFont(label.getFont());
        if (label.getFont().getStyle().equals("Bold")) {
            ton1.setSelected(true);
            InDam = true;

        }

    }

    /**
     * Initializes the controller class.
     */
    public void setNewSceneController(NewSceneController newSceneController) {
        this.newSceneController = newSceneController;
    }

    @FXML
    public void Ton1(MouseEvent e) {

        if (ton1.isSelected()) {
            Font font = new Font(textArea.getFont().getName(), textArea.getFont().getSize());
            font = Font.font(font.getFamily(), FontWeight.BOLD, font.getSize());
            textArea.setFont(font);
            textArea.setStyle("-fx-text-fill: black;");
            InDam = true;
        } else {
            Font font = new Font(textArea.getFont().getName(), textArea.getFont().getSize());
            font = Font.font(font.getFamily(), FontWeight.NORMAL, font.getSize());
            textArea.setFont(font);
            textArea.setStyle("-fx-text-fill: black;");
            InDam = false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BoxChoice1.setPromptText("Aa");

        BoxChoice1.getItems().addAll(size);
        textArea.setWrapText(true);
        BoxChoice2.getItems().addAll(size2);
        BoxChoice2.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item);
                            if (item.equals("italic")) {
                                setStyle("-fx-font-style: italic;");
                                textArea.setStyle("-fx-font-style: italic;");
                            } else if (item.startsWith("Calibri")) {
                                setStyle("-fx-font-family: Calibri;");
                                textArea.setStyle("-fx-font-family: Calibri;");
                            } else if (item.startsWith("Courier New")) {
                                setStyle("-fx-font-family: Courier New;");
                                textArea.setStyle("-fx-font-family: Courier New;");
                            } else if (item.startsWith("Georgia")) {
                                setStyle("-fx-font-family: Georgia;");
                                textArea.setStyle("-fx-font-family: Georgia;");
                            } else if (item.startsWith("Times New Roman")) {
                                setStyle("-fx-font-family: Times New Roman;");
                                textArea.setStyle("-fx-font-family: Times New Roman;");
                            } else if (item.startsWith("Verdana")) {
                                setStyle("-fx-font-family: Verdana;");
                                textArea.setStyle("-fx-font-family: Verdana;");
                            }
                        }
                    }
                };
            }
        });
        BoxChoice1.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item);
                            if (item.equals("Văn bản bình thường")) {
                                setStyle("-fx-font-size: 12px;");
                                textArea.setStyle("-fx-font-size: 12px;");
                            } else if (item.startsWith("Heading 1")) {
                                setStyle("-fx-font-size: 30px;");
                                textArea.setStyle("-fx-font-size: 30px;");
                            } else if (item.startsWith("Heading 2")) {
                                setStyle("-fx-font-size: 26px;");
                                textArea.setStyle("-fx-font-size: 26px;");
                            } else if (item.startsWith("Heading 3")) {
                                setStyle("-fx-font-size: 22px;");
                                textArea.setStyle("-fx-font-size: 22px;");
                            } else if (item.startsWith("Heading 4")) {
                                setStyle("-fx-font-size: 18px;");
                                textArea.setStyle("-fx-font-size: 18px;");
                            } else if (item.startsWith("Heading 5")) {
                                setStyle("-fx-font-size: 14px;");
                                textArea.setStyle("-fx-font-size: 14px;");
                            } else if (item.startsWith("Heading 6")) {
                                setStyle("-fx-font-size: 10px;");
                                textArea.setStyle("-fx-font-size: 10px;");
                            }
                        }
                    }
                };
            }
        });

        textArea.setOnMouseClicked(e -> {
            if (ton1.isSelected()) {
                Font font = new Font(textArea.getFont().getName(), textArea.getFont().getSize());
                font = Font.font(font.getFamily(), FontWeight.BOLD, font.getSize());
                textArea.setFont(font);
                textArea.setStyle("-fx-text-fill: black;");
                InDam = true;
            }
        });

    }

}
