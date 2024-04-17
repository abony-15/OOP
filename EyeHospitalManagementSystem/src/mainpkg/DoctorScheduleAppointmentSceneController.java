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
import java.time.LocalDate;
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
public class DoctorScheduleAppointmentSceneController implements Initializable {
    @FXML
    private TableColumn<Appointment, String> patientIdTableColumn;
    @FXML
    private TableColumn<Appointment, LocalDate> dateTableColumn;
    @FXML
    private TableColumn<Appointment, String> timeTableColumn;
    @FXML
    private ComboBox<String> selectPatientIdCb;
    @FXML
    private TableView<Appointment> doctorScheduleAppointmentTableView;
    @FXML
    private DatePicker selectDateDatePicker;
    @FXML
    private ComboBox<String> selectTimeCb;
    @FXML
    private TableColumn<Appointment, String> serialNoTableColumn;
    @FXML
    private TableColumn<Appointment, String> doctorIdTableColumn;
    @FXML
    private TableView<Appointment> patientScheduleAppointmentTableView;
    @FXML
    private TableColumn<Appointment, LocalDate> doctorDateTableColumn;
    @FXML
    private TableColumn<Appointment, String> doctorTimeTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //selectPatientIdCb.getItems().addAll("Patient ID 1", "Patient ID 2", "Patient ID 3");
    //selectTimeCb.getItems().addAll("09:00am", "11:00am", "01:00pm", "03:00pm");

    patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("patientId"));
    doctorDateTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDate>("date"));
    doctorTimeTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("time"));
    
    selectPatientIdCb.getItems().addAll("Patient ID 1", "Patient ID 2", "Patient ID 3");
    selectTimeCb.getItems().addAll("09:00am", "11:00am", "01:00pm", "03:00pm");
    
    serialNoTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("serialNo"));
    dateTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDate>("date"));
    timeTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("time"));
    doctorIdTableColumn.setCellValueFactory(new PropertyValueFactory<Appointment,String>("doctorId"));
    }

    @FXML
    private void showAppointmentInfoButtonOnMouseClicked(MouseEvent event) {
    doctorScheduleAppointmentTableView.getItems().clear();
    doctorScheduleAppointmentTableView.refresh();
    ObjectInputStream ois = null;
    try {
         Appointment appoint;
         ois = new ObjectInputStream(new FileInputStream("Appointment.bin"));
         while(true){
         appoint = (Appointment) ois.readObject();
         doctorScheduleAppointmentTableView.getItems().add(appoint);
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
             doctorScheduleAppointmentTableView.refresh();
         }
}
    @FXML
    private void createAppointmentInfoButtonOnMouseClicked(MouseEvent event) {
    FileOutputStream fos;
    ObjectOutputStream oos;
    
    Appointment appoint = new Appointment (selectPatientIdCb.getValue(),
                                           selectDateDatePicker.getValue(),
                                           selectTimeCb.getValue());
    
    doctorScheduleAppointmentTableView.getItems().add(appoint);
    
    selectPatientIdCb.setValue(null);
    selectDateDatePicker.setValue(null);
    selectTimeCb.setValue(null);
    
    try {
            File f = new File("Appointment.bin");   
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(appoint);
            System.out.println(oos.toString());
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void showAppointmentRequestButtonOnMouseClicked(MouseEvent event) throws IOException {
    patientScheduleAppointmentTableView.getItems().clear();
    patientScheduleAppointmentTableView.refresh();
    ObjectInputStream ois = null;
    try {
         Appointment appoint;
         ois = new ObjectInputStream(new FileInputStream("Appointment Request.bin"));
         while(true){
         appoint = (Appointment) ois.readObject();
         patientScheduleAppointmentTableView.getItems().add(appoint);
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
    private void homeButtonOnMouseClicked(MouseEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("DoctorDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();
    }
}