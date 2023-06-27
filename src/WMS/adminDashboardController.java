/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WMS;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

/**
 *
 * @author dangh
 */
public class adminDashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Label username;

    @FXML
    private Button board_btn;

    @FXML
    private Button employees_btn;

    @FXML
    private Button calendar_btn;

    @FXML
    private Button dau_3_cham;

    @FXML
    private Button tao_them_bang;

    @FXML
    private Button BangDemo_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane board_form;

    @FXML
    private ComboBox<String> sap_xep_theo_btn;
    ObservableList<String> list = FXCollections.observableArrayList("Hoạt động gần đây nhất", "Ít hoạt động nhất", "Theo bảng chữ cái A-Z", "Theo bảng chữ cái Z-A");

    @FXML
    private ComboBox<String> Chon_bo_suu_tap_btn;

    @FXML
    private TextField search_fied;

    @FXML
    private Label hien_thi_so_bang_da_tim_duoc;

    @FXML
    private Label tong_so_bang;

    @FXML
    private Button create_new_table;

    @FXML
    private Button show_close_boards;

    @FXML
    private AnchorPane employees_form;

    @FXML
    private TableView<employeeData> employees_tableView;

    @FXML
    private TableColumn<employeeData, String> employees_col_employeesID;

    @FXML
    private TableColumn<employeeData, String> employees_col_password;

    @FXML
    private TableColumn<employeeData, String> employees_col_firstName;

    @FXML
    private TableColumn<employeeData, String> employees_col_lastName;

    @FXML
    private TableColumn<employeeData, String> employees_col_gender;

    @FXML
    private TableColumn<employeeData, String> employees_col_gmail;

    @FXML
    private TextField employees_employeeID;

    @FXML
    private TextField employees_password;

    @FXML
    private TextField employees_firstName;

    @FXML
    private TextField employees_lastName;

    @FXML
    private ComboBox<?> employees_gender;

    @FXML
    private TextField employees_gmail;

    @FXML
    private Button employees_clear;

    @FXML
    private Button employees_delete;

    @FXML
    private Button employees_update;

    @FXML
    private Button employees_save;

    @FXML
    private AnchorPane bangDemo_form;

    @FXML
    private AnchorPane Calendar_form;

    @FXML
    private Label month_num;

    @FXML
    private Label year_num;

    @FXML
    private Button homqua_btn;

    @FXML
    private Button homnay_btn;

    @FXML
    private Button ngaymai_btn;

    @FXML
    private MenuButton xemtuan_btn;

    @FXML
    private Button minimize;

    @FXML
    private Button close_Btn;

    //Database tools
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public void employeesSave() {
        String insertEmployee = "INSERT INTO employee "
                + "(employee_id,password,firstName,lastName,gender,gmail)"
                + "VALUES(?,?,?,?,?,?)";
        connect = ConnectionDB.connectDb();

        try {
            Alert alert;

            if (employees_employeeID.getText().isEmpty()
                    || employees_password.getText().isEmpty()
                    || employees_firstName.getText().isEmpty()
                    || employees_lastName.getText().isEmpty()
                    || employees_gender.getSelectionModel().getSelectedItem() == null
                    || employees_gmail.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {

                String checkExist = "SELECT employee_id FROM employee WHERE employee_id = '"
                        + employees_employeeID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkExist);

                if (result.next()) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee ID: " + employees_employeeID.getText() + " was already exist !");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertEmployee);
                    prepare.setString(1, employees_employeeID.getText());
                    prepare.setString(2, employees_password.getText());
                    prepare.setString(3, employees_firstName.getText());
                    prepare.setString(4, employees_lastName.getText());
                    prepare.setString(5, (String) employees_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(6, employees_gmail.getText());

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Saved!");
                    alert.showAndWait();
                    //updateed the tableview
                    employeesShowListData();

                    //to clear the fields
                    employeesReset();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // private String[]sap_xep_theo_btn ={"Hoạt động gần đây nhất","Ít hoạt động nhất","Theo bảng chữ cái A-Z","Theo bảng chữ cái Z-A"};

    private String[] genderList = {"Male", "Female", "Others"};

    public void employeesGender() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        ObservableList listG = FXCollections.observableArrayList(genderL);
        employees_gender.setItems(listG);

    }

    public void employeesUpdate() {
        String updateEmployee = "UPDATE employee SET password = '"
                + employees_password.getText() + "', firstName ='"
                + employees_firstName.getText() + "', lastName ='"
                + employees_lastName.getText() + "', gender ='"
                + employees_gender.getSelectionModel().getSelectedItem() + "',gmail  ='"
                + employees_gmail.getText()
                + "'WHERE employee_id = '" + employees_employeeID.getText() + "'";
        connect = ConnectionDB.connectDb();

        try {
            Alert alert;

            if (employees_employeeID.getText().isEmpty()
                    || employees_password.getText().isEmpty()
                    || employees_firstName.getText().isEmpty()
                    || employees_lastName.getText().isEmpty()
                    || employees_gender.getSelectionModel().getSelectedItem() == null
                    || employees_gmail.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to update Employee ID:" + employees_employeeID.getText() + " ?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateEmployee);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Update successfully");
                    alert.showAndWait();
                    employeesShowListData();
                    employeesReset();
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void employeesDelete() {
        String deleteEmployee = "DELETE FROM employee WHERE employee_id = '"
                + employees_employeeID.getText() + "'";

        connect = ConnectionDB.connectDb();

        try {
            Alert alert;
            if (employees_employeeID.getText().isEmpty()
                    || employees_password.getText().isEmpty()
                    || employees_firstName.getText().isEmpty()
                    || employees_lastName.getText().isEmpty()
                    || employees_gender.getSelectionModel().getSelectedItem() == null
                    || employees_gmail.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to delete Employee ID:" + employees_employeeID.getText() + " ?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteEmployee);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Delete successfully !");
                    alert.showAndWait();

                    employeesShowListData();
                    employeesReset();
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void employeesReset() {
        employees_employeeID.setText("");
        employees_password.setText("");
        employees_firstName.setText("");
        employees_lastName.setText("");
        employees_gender.getSelectionModel().clearSelection();
        employees_gmail.setText("");
    }

    public ObservableList<employeeData> employeeListData() {

        ObservableList<employeeData> emData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM employee";

        connect = ConnectionDB.connectDb();

        try {

            employeeData employeeD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                employeeD = new employeeData(result.getString("employee_id"),
                        result.getString("password"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("gender"),
                        result.getString("gmail"));

                emData.add(employeeD);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emData;
    }

    private ObservableList<employeeData> employeesList;

    public void employeesShowListData() {
        employeesList = employeeListData();

        employees_col_employeesID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));

        employees_col_password.setCellValueFactory(new PropertyValueFactory<>("passwordMasked"));

        employees_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        employees_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        employees_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        employees_col_gmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));

        employees_tableView.setItems(employeesList);

    }

    public void employeesSelect() {
        employeeData employeeD = employees_tableView.getSelectionModel().getSelectedItem();
        int num = employees_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        employees_employeeID.setText(employeeD.getEmployeeId());
        employees_password.setText(employeeD.getPassword());
        employees_firstName.setText(employeeD.getFirstName());
        employees_lastName.setText(employeeD.getLastName());
        employees_gmail.setText(employeeD.getGmail());

    }

    private double x = 0;
    private double y = 0;

    public void logout() {

        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout ?");

            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });
                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);
                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);

                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dantoibang(ActionEvent event) throws IOException {
//    if (event.getSource()== BangDemo_btn){
//        board_form.setVisible(false);
//        employees_form.setVisible(false);
//        Calendar_form.setVisible(false);
//        bangDemo_form.setVisible(true);
//
//    }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/FXMLDocument.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("../image/trello.png")));
        stage.setResizable(false);

        stage.show();

    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == board_btn) {
            board_form.setVisible(true);
            employees_form.setVisible(false);
            Calendar_form.setVisible(false);
            bangDemo_form.setVisible(false);

            board_btn.setStyle("-fx-background-color:linear-gradient(to top right,#8825a1,#cf40f6);");
            employees_btn.setStyle("-fx-background-color:transparent");
            calendar_btn.setStyle("-fx-background-color:transparent");
        } else if (event.getSource() == employees_btn) {
            board_form.setVisible(false);
            employees_form.setVisible(true);
            Calendar_form.setVisible(false);
            bangDemo_form.setVisible(false);

            board_btn.setStyle("-fx-background-color:transparent");
            employees_btn.setStyle("-fx-background-color:linear-gradient(to top right,#8825a1,#cf40f6);");
            calendar_btn.setStyle("-fx-background-color:transparent");

            employeesShowListData();

        } else if (event.getSource() == calendar_btn) {
            board_form.setVisible(false);
            employees_form.setVisible(false);
            Calendar_form.setVisible(true);
            bangDemo_form.setVisible(false);

            board_btn.setStyle("-fx-background-color:transparent");
            employees_btn.setStyle("-fx-background-color:transparent");
            calendar_btn.setStyle("-fx-background-color:linear-gradient(to top right,#8825a1,#cf40f6);");
        }

    }

    public void displayUsername() {
        username.setText(getData.username);
    }

    public void close(ActionEvent event) {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sap_xep_theo_btn.setItems(list);
        displayUsername();
        employeesShowListData();
        employeesGender();

    }

}
