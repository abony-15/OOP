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
//import java.util.ArrayList;
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
public class DoctorManageProcedureController implements Initializable {
    //ArrayList <Procedure> manageList;

    @FXML
    private ComboBox<String> selectPatientIdCb;
    @FXML
    private ComboBox<String> selectProcedeurCb;
    @FXML
    private TableView<Procedure> manageProcedureTableView;
    @FXML
    private TableColumn<Procedure, String> patientIdTableColumn;
    @FXML
    private TableColumn<Procedure, String> procedureTableColumn;
    @FXML
    private TableColumn<Procedure, String> dayTableColumn;
    @FXML
    private TableColumn<Procedure, String> timeTableColumn;
    @FXML
    private Label selectDayLable;
    @FXML
    private Label selectTimeLable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //manageList = new ArrayList<Procedure>();

    selectPatientIdCb.getItems().addAll("Patient ID 1", "Patient ID 2", "Patient ID 3");
    selectProcedeurCb.getItems().addAll("Procedure 1", "Procedure 2", "Procedure 3");

    patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<Procedure,String>("patientId"));
    procedureTableColumn.setCellValueFactory(new PropertyValueFactory<Procedure,String>("procedure"));
    dayTableColumn.setCellValueFactory(new PropertyValueFactory<Procedure,String>("day"));
    timeTableColumn.setCellValueFactory(new PropertyValueFactory<Procedure,String>("time"));}

    @FXML
    private void selectProcedureCbOnMouseCLicked(ActionEvent event) {
    String selectedProcedure = selectProcedeurCb.getValue();
            if (selectedProcedure != null) {
                if (selectedProcedure.equals("Procedure 1")) {
                    selectDayLable.setText("Monday");
                    selectTimeLable.setText("9:00 AM");
                } else if (selectedProcedure.equals("Procedure 2")) {
                    selectDayLable.setText("Tuesday");
                    selectTimeLable.setText("10:00 AM");
                } else if (selectedProcedure.equals("Procedure 3")) {
                    selectDayLable.setText("Wednesday");
                    selectTimeLable.setText("11:00 AM");
                }
            }
        }

    @FXML
    private void showInfoButtonOnMouseClicked(MouseEvent event) {
    manageProcedureTableView.getItems().clear();
    manageProcedureTableView.refresh();
    ObjectInputStream ois = null;
    try {
         Procedure procedure;
         ois = new ObjectInputStream(new FileInputStream("procedure.bin"));
         while(true){
         procedure = (Procedure) ois.readObject();
         //procedure.display();
         manageProcedureTableView.getItems().add(procedure);
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
             manageProcedureTableView.refresh();
         }
    }

    @FXML
    private void addInfoButtonOnMouseClicked(MouseEvent event) {
    FileOutputStream fos;
    ObjectOutputStream oos;        
    
    Procedure procedure = new Procedure (selectPatientIdCb.getValue(),
                                         selectProcedeurCb.getValue(),
                                         selectDayLable.getText(),
                                         selectTimeLable.getText());
    
    manageProcedureTableView.getItems().add(procedure);
    
    selectPatientIdCb.setValue(null);
    selectProcedeurCb.setValue(null);
    selectDayLable.setText(null);
    selectTimeLable.setText(null);
    
    try {
            File f = new File("procedure.bin");   
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(procedure);
            System.out.println(oos.toString());
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void homeButtonOnMouseClicked(MouseEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("DoctorDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();}
}