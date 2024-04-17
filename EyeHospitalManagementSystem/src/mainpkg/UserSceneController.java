/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class UserSceneController implements Initializable {

    @FXML
    private ComboBox<String> selectUsernameLoginCb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    selectUsernameLoginCb.getItems().addAll("DOCTOR" , "PATIENT");
    }

    @FXML
    private void selectUsernameLoginCbButtonOnMouseClicked(MouseEvent event) throws IOException {
    String selectUsernameLogin = selectUsernameLoginCb.getValue();
            if(selectUsernameLogin != null){
                if(selectUsernameLogin . equals ("DOCTOR")){
                    Parent parent = FXMLLoader.load(getClass().getResource("DoctorLoginScene.fxml"));
                    Scene scene = new Scene(parent);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                }
                else if(selectUsernameLogin . equals ("PATIENT")){
                    Parent parent = FXMLLoader.load(getClass().getResource("PatientLoginScene.fxml"));
                    Scene scene = new Scene(parent);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                }
            }
        }
}