/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
//import java.util.ArrayList;
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
public class DoctorMedicalReportController implements Initializable {

    //ArrayList<MedicalReport>reportList;

    @FXML
    private TableView<MedicalReport> medicalReportTableView;
    @FXML
    private TableColumn<MedicalReport, String> diagnosesTableColumn;
    @FXML
    private TableColumn<MedicalReport, String> treatmentTableColumn;
    @FXML
    private TableColumn<MedicalReport, String> progressTableColumn;
    @FXML
    private TableColumn<MedicalReport, String> doctorReviewTableColumn;
    @FXML
    private TextField diagnosesTextField;
    @FXML
    private TextField treatmentTextField;
    @FXML
    private TextField progressTextField;
    @FXML
    private TextField doctorReviewTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //reportList = new ArrayList<MedicalReport>();

    diagnosesTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalReport,String>("diagnoses"));
    treatmentTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalReport,String>("treatment"));
    progressTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalReport,String>("progress"));
    doctorReviewTableColumn.setCellValueFactory(new PropertyValueFactory<MedicalReport,String>("doctorReview"));
    
    }

    @FXML
    private void saveReportButtonOnMouseClicked(MouseEvent event) {
    FileOutputStream fos;
    ObjectOutputStream oos;
    
    MedicalReport report = new MedicalReport(diagnosesTextField.getText(),
                                            treatmentTextField.getText(),
                                            progressTextField.getText(),
                                            doctorReviewTextField.getText());
        
    medicalReportTableView.getItems().add(report);
    
    diagnosesTextField.setText(null);
    treatmentTextField.setText(null);
    progressTextField.setText(null);
    doctorReviewTextField.setText(null);
    
     try {
            File f = new File("report.bin");   
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(report);
            System.out.println(oos.toString());
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void showReportButtonOnMouseClicked(MouseEvent event) {
        medicalReportTableView.getItems().clear();
        medicalReportTableView.refresh();
        ObjectInputStream ois=null;
        try {
             MedicalReport report;
             ois = new ObjectInputStream(new FileInputStream("report.bin"));
             while(true){
             report = (MedicalReport) ois.readObject();
             //report.display();
             medicalReportTableView.getItems().add(report);
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
             medicalReportTableView.refresh();
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