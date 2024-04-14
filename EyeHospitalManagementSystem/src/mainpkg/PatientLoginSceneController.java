/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class PatientLoginSceneController implements Initializable {
    Alert Login = new Alert(Alert.AlertType.INFORMATION, "Succesfully Login");
    Alert Wrong = new Alert(Alert.AlertType.INFORMATION, "Information Incorrect");
    
    @FXML
    private TextField usernameTextFiield;
    @FXML
    private PasswordField passwordPasswordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void LoginButtonOnClick(ActionEvent event) throws IOException {
    String password = passwordPasswordField.getText();
    if (!password.equals("123")) {
        Wrong.show();
        return;
    }
    passwordPasswordField.clear();

    Integer Password = Integer.parseInt(password);
    
    String username = usernameTextFiield.getText();
    if (!username.equals("Patient")) {
        Wrong.show();
        return;
}
    usernameTextFiield.clear();
    
    Login newpat = new Login (Password, username);
    Login.show();
    
    Parent parent = FXMLLoader.load(getClass().getResource("PatientDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();
    }
    
}
