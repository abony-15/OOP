/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author AZAAN
 */
public class Appointment implements Serializable{
    private String doctorId;
    private String patientId;
    private LocalDate date;
    private String time;
    private int serialNo;

    public Appointment(String patientId, LocalDate date, String time) {
        this.patientId = patientId;
        this.date = date;
        this.time = time;
    }

    public Appointment(String doctorId, LocalDate date, String time, int serialNo) {
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.serialNo = serialNo;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }
}
