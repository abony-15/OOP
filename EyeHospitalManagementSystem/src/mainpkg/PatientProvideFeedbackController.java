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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class PatientProvideFeedbackController implements Initializable {
    Alert Unfilled = new Alert(Alert.AlertType.WARNING,"Please EnterEverything");
    Alert Send = new Alert(Alert.AlertType.INFORMATION,"Feedback Send Succesfully");

    @FXML
    private ComboBox<String> selectPatientIdCb;
    @FXML
    private TextField enterFeedbackTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    selectPatientIdCb.getItems().addAll("Patient ID 1","Patient ID 2","Patient ID 3");
    }

    @FXML
    private void sendFeedbackButtonOnMouseClicked(MouseEvent event) {
    String patientId = selectPatientIdCb.getValue();
    if (patientId == null || patientId.isEmpty()){
    Unfilled.show();
    return;
    }
    String messageFeedback = enterFeedbackTextField.getText();
    if (messageFeedback == null || messageFeedback.isEmpty()){
    Unfilled.show();
    return;
    }
    Feedback feedback = new Feedback(patientId, messageFeedback);
    Send.show();
    }

    @FXML
    private void homeButtonOnMouseClicked(MouseEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("PatientDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();
    }
}
