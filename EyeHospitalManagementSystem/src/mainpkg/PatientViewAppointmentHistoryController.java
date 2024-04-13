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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class PatientViewAppointmentHistoryController implements Initializable {

    @FXML private ComboBox<String> selectPatientIdCb;
    @FXML private Label appointmentDetailsLable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    selectPatientIdCb.getItems().addAll("Patient ID 1", "Patient ID 2", "Patient ID 3");}    

    @FXML
    private void selectPatientIdCbOnMouseClicked(ActionEvent event) {
    String selectedPatient = selectPatientIdCb.getValue();
    if (selectedPatient != null) {
        String day = "";
        String time = "";
        String date = ""; 
        String doctorName = "";
        if (selectedPatient.equals("Patient ID 1")) {
            day = "Tuesday";
            time = "09:00 AM";
            date = "2024-04-01";
            doctorName = "Doctor ID 01";
        } else if (selectedPatient.equals("Patient ID 2")) {
            day = "Wednesday";
            time = "10:00 AM";
            date = "2024-04-01";
            doctorName = "Doctor ID 01";
        } else if (selectedPatient.equals("Patient ID 3")) {
            day = "Thursday";
            time = "11:00 AM";
            date = "2024-04-01";
            doctorName = "Doctor ID 01";
}
        String appointmentDetails = "Appointment Details:\n"
                                    + "Date: " + date + "\n"
                                    + "Day: " + day + "\n"
                                    + "Time: " + time + "\n"
                                    + "Doctor: " + doctorName;
        appointmentDetailsLable.setText(appointmentDetails);
                }
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