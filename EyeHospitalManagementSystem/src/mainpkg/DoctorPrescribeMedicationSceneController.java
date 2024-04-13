/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class DoctorPrescribeMedicationSceneController implements Initializable {
    //ArrayList <Medication> mediList;
    
    @FXML
    private ComboBox<String> selectPatientIdCb;
    @FXML
    private TextField mediNameTextField;
    @FXML
    private TextField mediDoseTextField;
    @FXML
    private TableView<Medication> medicationPrescribeTableView;
    @FXML
    private TableColumn<Medication, String> patientIdTableColumn;
    @FXML
    private TableColumn<Medication, String> medicationNameTableColumn;
    @FXML
    private TableColumn<Medication, String> medicationDoseTableColumn;
    @FXML
    private TableColumn<Medication, String> doctorIdTableColumn;
    @FXML
    private ComboBox<String> selectDoctorIdCb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    selectDoctorIdCb.getItems().addAll("Doctor ID 1", "Doctor ID 2", "Doctor ID 3");
    selectPatientIdCb.getItems().addAll("Patient ID 1", "Patient ID 2", "Patient ID 3");
    
    //mediList = new ArrayList<Medication>();
    
    doctorIdTableColumn.setCellValueFactory(new PropertyValueFactory<Medication,String>("doctorId"));
    patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<Medication,String>("patientId"));
    medicationNameTableColumn.setCellValueFactory(new PropertyValueFactory<Medication,String>("medicationName"));
    medicationDoseTableColumn.setCellValueFactory(new PropertyValueFactory<Medication,String>("medicationDose"));
    }

    @FXML
    private void addToTableButtonOnMouseClicked(MouseEvent event) {
    FileOutputStream fos;
    ObjectOutputStream oos;
    
    Medication medicine = new Medication(selectDoctorIdCb.getValue(),
                                         selectPatientIdCb.getValue(),
                                         mediNameTextField.getText(),
                                         mediDoseTextField.getText());
        
    medicationPrescribeTableView.getItems().add(medicine);
    
    selectDoctorIdCb.setValue(null);
    selectPatientIdCb.setValue(null);
    mediNameTextField.setText(null);
    mediDoseTextField.setText(null);
    
     try {
            File f = new File("Medicine.bin");   
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(medicine);
            System.out.println(oos.toString());
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void showToTableButtonOnMouseClicked(MouseEvent event) {
        medicationPrescribeTableView.getItems().clear();
        medicationPrescribeTableView.refresh();
        ObjectInputStream ois=null;
        try {
             Medication medicine;
             ois = new ObjectInputStream(new FileInputStream("Medicine.bin"));
             while(true){
             medicine = (Medication) ois.readObject();
             medicationPrescribeTableView.getItems().add(medicine);
            }
           
        } catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }    finally {
             medicationPrescribeTableView.refresh();
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