/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileWriter;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class DoctorColleagueConsultationController implements Initializable {

    @FXML
    private ComboBox<String> selectDoctorIdCb;
    @FXML
    private ComboBox<String> consultationWithCb;
    @FXML
    private TextField consultationNeedForTexField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    selectDoctorIdCb.getItems().addAll("Doctor ID 1", "Doctor ID 2", "Doctor ID 3");
    consultationWithCb.getItems().addAll("Colleague ID 1", "Colleague ID 2", "Colleague ID 3");
    }

    @FXML
    private void sendButtonOnMouseClicked(MouseEvent event) {
    String content = consultationNeedForTexField.getText() ;
    File outputFile = new File("Consultation.txt");

    try {
        FileWriter writer = new FileWriter(outputFile);
        writer.write(content);
        writer.close();
        System.out.println("Sending done");
    } catch (IOException e) {
        e.printStackTrace();
        }
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
