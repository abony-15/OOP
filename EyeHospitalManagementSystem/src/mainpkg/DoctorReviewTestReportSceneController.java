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
public class DoctorReviewTestReportSceneController implements Initializable {
    Alert Send = new Alert(Alert.AlertType.INFORMATION, "Succesfully Send");
    Alert Unfilled = new Alert(Alert.AlertType.WARNING, "Please Enter Everything");

    @FXML
    private ComboBox<String> selectPatientIdCb;
    @FXML
    private ComboBox<String> selectReportNameCb;
    @FXML
    private TextField reviewTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    selectPatientIdCb.getItems().addAll("Patient ID 1", "Patient ID 2", "Patient ID 3");
    selectReportNameCb.getItems().addAll("Report 1", "Report 2", "Report 3");
    }

    @FXML
    private void submitButtonOnMouseClicked(MouseEvent event) {
    String patientId = selectPatientIdCb.getValue();
    if (patientId == null || patientId.isEmpty()) {
    Unfilled.show();
    return;
}

    String reportName = selectReportNameCb.getValue();
    if (reportName == null || reportName.isEmpty()) {
    Unfilled.show();
    return;
}
    String reportReview = reviewTextField.getText();
    TestReport review = new TestReport(patientId,reportName,reportReview);
    Send.show();
    }

    @FXML
    private void homeButtonOnMouseClicked(MouseEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("DoctorDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();
    }
}