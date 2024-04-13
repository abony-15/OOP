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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class PatientRequestMedicationController implements Initializable {
    Alert Send = new Alert(Alert.AlertType.INFORMATION, "Succesfully Send");
    Alert Unfilled = new Alert(Alert.AlertType.WARNING, "Please Enter Everything");
    @FXML
    private ComboBox<String> selectDoctorIdCb;
    @FXML
    private ComboBox<String> selectPatientIdCb;
    @FXML
    private Label requestMedicationLable;
    @FXML
    private TextField medicationNameTextField;
    @FXML
    private TextField medicationDoseTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    selectPatientIdCb.getItems().addAll("Patient ID 1", "Patient ID 2", "Patient ID 3");
    selectDoctorIdCb.getItems().addAll("Doctor ID 1", "Doctor ID 2", "Doctor ID 3");
}

    @FXML
    private void addToLableButtonOnMouseClicked(MouseEvent event) {
    String doctorId = selectDoctorIdCb.getValue();
    String patientId = selectPatientIdCb.getValue();
    String medicationName = medicationNameTextField.getText();
    String medicationDose = medicationDoseTextField.getText();

    Medication medication = new Medication(doctorId, patientId, medicationName, medicationDose);
    requestMedicationLable.setText(requestMedicationLable.getText() +"Medication:\n"
                                                                    + "DoctorID: " + doctorId + "\n"
                                                                    + "PatientID: " + patientId + "\n"
                                                                    + "Medication Name: " + medicationName + "\n"
                                                                    + "Medication Dose: " + medicationDose );
    }

    @FXML
    private void sendRequestButtonOnMouseClicked(MouseEvent event) {
    String doctorId = selectDoctorIdCb.getValue();
    if(doctorId.isEmpty()){
    Unfilled.show();
    return;
}
    String patientId = selectPatientIdCb.getValue();
    if(doctorId.isEmpty()){
    Unfilled.show();
    return;
}
    String medicationName = medicationNameTextField.getText();
    if(medicationName.isEmpty()){
    Unfilled.show();
    return;
}
    String medicationDose = medicationDoseTextField.getText();
    if(medicationName.isEmpty()){
    Unfilled.show();
    return;
}
    String lable = requestMedicationLable.getText();
    Medication medication = new Medication(doctorId, patientId, medicationName, medicationDose);
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