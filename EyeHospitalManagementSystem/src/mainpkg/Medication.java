/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author AZAAN
 */
public class Medication implements Serializable{
    protected String doctorId;
    protected String patientId;
    protected String medicationName;
    protected String medicationDose;

    public Medication(String doctorId, String patientId, String medicationName, String medicationDose) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.medicationName = medicationName;
        this.medicationDose = medicationDose;
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

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationDose() {
        return medicationDose;
    }

    public void setMedicationDose(String medicationDose) {
        this.medicationDose = medicationDose;
    }

    @Override
    public String toString() {
        return "Medication{" + "doctorId=" + doctorId + ", patientId=" + patientId + ", medicationName=" + medicationName + ", medicationDose=" + medicationDose + '}';
    }
}
