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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class PatientScheduleAppointmentController implements Initializable {
    //ArrayList <Appointment> reqappointList;

    @FXML
    private ComboBox<String> selectDoctorIdCb;
    @FXML
    private ComboBox<String> selectTimeCb;
    @FXML
    private TableView<Appointment> patientScheduleAppointmentTableView;
    @FXML
    private TableColumn<Appointment, String> doctorIdTableColumn;
    @FXML
    private TableColumn<Appointment, LocalDate> dateTableColumn;
    @FXML
    private TableColumn<Appointment, String> timeTableColumn;
    @FXML
    private ComboBox<Integer> selectSerialNoCb;
    @FXML
    private TableColumn<Appointment, Integer> serialNoTableColumn;
    @FXML
    private DatePicker selectDateDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    selectSerialNoCb.getItems().addAll(01, 02, 03);
    selectDoctorIdCb.getItems().addAll("Doctor ID 1", "Doctor ID 2", "Doctor ID 3");
    selectTimeCb.getItems().addAll("09:00am", "11:00am", "01:00pm", "03:00pm");
    
    //reqappointList = new ArrayList<Appointment>();
    
    serialNoTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("serialNo"));
    doctorIdTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("doctorId"));
    dateTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDate>("date"));
    timeTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("time"));
    }

    @FXML
    private void showAppointmentInfoButtonOnMouseClicked(MouseEvent event) {
    patientScheduleAppointmentTableView.getItems().clear();
    patientScheduleAppointmentTableView.refresh();
    ObjectInputStream ois = null;
    try {
         Appointment reqappoint;
         ois = new ObjectInputStream(new FileInputStream("Appointment Request.bin"));
         while(true){
         reqappoint = (Appointment) ois.readObject();
         patientScheduleAppointmentTableView.getItems().add(reqappoint);
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
             patientScheduleAppointmentTableView.refresh();
         }
    }

    @FXML
    private void addAppointmentInfoButtonOnMouseClicked(MouseEvent event) {
    FileOutputStream fos;
    ObjectOutputStream oos;
    
    
    Appointment reqappoint = new Appointment (selectDoctorIdCb.getValue(),
                                              selectDateDatePicker.getValue(),
                                              selectTimeCb.getValue(),
                                              selectSerialNoCb.getValue());
    
    patientScheduleAppointmentTableView.getItems().add(reqappoint);
    
    selectDoctorIdCb.setValue(null);
    selectDateDatePicker.setValue(null);
    selectTimeCb.setValue(null);
    selectSerialNoCb.setValue(null);
    
    try {
            File f = new File("Appointment Request.bin");
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(reqappoint);
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
    window.show();
    }
}
