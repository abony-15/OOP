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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class PatientBillController implements Initializable {

    @FXML
    private ComboBox<String> selectPatientIdCb;
    @FXML
    private ComboBox<String> selectProcedeurCb;
    @FXML
    private TableView<Bill> patientBillTableView;
    @FXML
    private TableColumn<Bill, String> patientIdTableColumn;
    @FXML
    private TableColumn<Bill, String> procedureTableColumn;
    @FXML
    private TableColumn<Bill, String> costTableColumn;
    @FXML
    private TableColumn<Bill, String> dueDateTableColumn;
    @FXML
    private Label showCostLable;
    @FXML
    private Label showDueDateLable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    selectPatientIdCb.getItems().addAll("Patient ID 1", "Patient ID 2", "Patient ID 3");
    selectProcedeurCb.getItems().addAll("Procedure 1", "Procedure 2", "Procedure 3");
    
    patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("patientId"));
    procedureTableColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("procedure"));
    costTableColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("cost"));
    dueDateTableColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("dueDate"));
    }

    @FXML
    private void selectProcedureCbOnMouseCLicked(ActionEvent event) {
        String selectedProcedure = selectProcedeurCb.getValue();
            if (selectedProcedure != null) {
                if (selectedProcedure.equals("Procedure 1")) {
                    showCostLable.setText("1000");
                    showDueDateLable.setText("Till 3 days");
                } else if (selectedProcedure.equals("Procedure 2")) {
                    showCostLable.setText("2000");
                    showDueDateLable.setText("Till 3 days");
                } else if (selectedProcedure.equals("Procedure 3")) {
                    showCostLable.setText("1500");
                    showDueDateLable.setText("Till 3 days");
                }
            }
    }

    @FXML
    private void showInfoButtonOnMouseClicked(MouseEvent event) {
    patientBillTableView.getItems().clear();
    patientBillTableView.refresh();
    ObjectInputStream ois = null;
    try {
         Bill bill;
         ois = new ObjectInputStream(new FileInputStream("Bill.bin"));
         while(true){
         bill = (Bill) ois.readObject();
         //bill.display();
         patientBillTableView.getItems().add(bill);
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
             patientBillTableView.refresh();
         }
    }

    @FXML
    private void addInfoButtonOnMouseClicked(MouseEvent event) {
    FileOutputStream fos;
    ObjectOutputStream oos;        
    
    Bill bill = new Bill (selectPatientIdCb.getValue(),
                          selectProcedeurCb.getValue(),
                          showCostLable.getText(),
                          showDueDateLable.getText());
    
    patientBillTableView.getItems().add(bill);
    
    selectPatientIdCb.setValue(null);
    selectProcedeurCb.setValue(null);
    showCostLable.setText(null);
    showDueDateLable.setText(null);
    
    try {
            File f = new File("Bill.bin");   
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(bill);
            System.out.println(oos.toString());
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void homeButtonOnMouseClicked(MouseEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("PatientDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();}
}
