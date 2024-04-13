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
public class DoctorViewPatientHistorySceneController implements Initializable {

    @FXML
    private TableView<PatientHistory> patientHistoryTableView;
    @FXML
    private TableColumn<PatientHistory, String> patientNameTableColumn;
    @FXML
    private TableColumn<PatientHistory, String> diseaseTableColumn;
    @FXML
    private TableColumn<PatientHistory, String> genderTableColumn;
    @FXML
    private TableColumn<PatientHistory, String> statusTableColumn;
    @FXML
    private TextField patientNameTextField;
    @FXML
    private TextField genderTextField;
    @FXML
    private TextField statusTextField;
    @FXML
    private TextField diseaseTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<PatientHistory,String>("name"));
    diseaseTableColumn.setCellValueFactory(new PropertyValueFactory<PatientHistory,String>("disease"));
    genderTableColumn.setCellValueFactory(new PropertyValueFactory<PatientHistory,String>("gender"));
    statusTableColumn.setCellValueFactory(new PropertyValueFactory<PatientHistory,String>("status"));
    }
    
    @FXML
    private void saveHistoryButtonOnMouseClicked(MouseEvent event) {
    FileOutputStream fos;
    ObjectOutputStream oos;
    
    PatientHistory history = new PatientHistory(patientNameTextField.getText(),
                                                diseaseTextField.getText(),
                                                genderTextField.getText(),
                                                statusTextField.getText());
        
    patientHistoryTableView.getItems().add(history);
    
    patientNameTextField.setText(null);
    diseaseTextField.setText(null);
    genderTextField.setText(null);
    statusTextField.setText(null);
    
     try {
            File f = new File("history.bin");   
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(history);
            System.out.println(oos.toString());
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void showHistoryButtonOnMouseClicked(MouseEvent event) {
        patientHistoryTableView.getItems().clear();
        patientHistoryTableView.refresh();
        ObjectInputStream ois=null;
        try {
                PatientHistory history;
                ois = new ObjectInputStream(new FileInputStream("history.bin"));
                while(true){
                history = (PatientHistory) ois.readObject();
                //history.display();
                patientHistoryTableView.getItems().add(history);
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
             patientHistoryTableView.refresh();
         }    }

    @FXML
    private void homeButtonOnMouseClicked(MouseEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("DoctorDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();
    }
}