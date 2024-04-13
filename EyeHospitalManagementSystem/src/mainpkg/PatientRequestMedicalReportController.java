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
public class PatientRequestMedicalReportController implements Initializable {

    @FXML
    private TableView<RequestReport> medicalReportRequestTableView;
    @FXML
    private TableColumn<RequestReport, String> patientIdTableColumn;
    @FXML
    private TableColumn<RequestReport, String> reportIdTableColumn;
    @FXML
    private TableColumn<RequestReport, String> addressTableColumn;
    @FXML
    private TextField patientIdTextField;
    @FXML
    private TextField reportIdTextField;
    @FXML
    private TextField addressTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<RequestReport,String>("patientId"));
    reportIdTableColumn.setCellValueFactory(new PropertyValueFactory<RequestReport,String>("reportId"));
    addressTableColumn.setCellValueFactory(new PropertyValueFactory<RequestReport,String>("address"));
    }

    @FXML
    private void saveRequestButtonOnMouseClicked(MouseEvent event) {
    FileOutputStream fos;
    ObjectOutputStream oos;
    
    RequestReport request = new RequestReport(patientIdTextField.getText(),
                                              reportIdTextField.getText(),
                                              addressTextField.getText());
        
    medicalReportRequestTableView.getItems().add(request);
    
    patientIdTextField.setText(null);
    reportIdTextField.setText(null);
    addressTextField.setText(null);
    
     try {
            File f = new File("Request report.bin");   
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(request);
            System.out.println(oos.toString());
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void showRequestButtonOnMouseClicked(MouseEvent event) {
        medicalReportRequestTableView.getItems().clear();
        medicalReportRequestTableView.refresh();
        ObjectInputStream ois=null;
        try {
             RequestReport request;
             ois = new ObjectInputStream(new FileInputStream("Request report.bin"));
             while(true){
             request = (RequestReport) ois.readObject();
             //report.display();
             medicalReportRequestTableView.getItems().add(request);
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
             medicalReportRequestTableView.refresh();
         }    }

    @FXML
    private void homeButtonOnMouseClicked(MouseEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("PatientDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();
    }
}
