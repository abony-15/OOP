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
public class MedicalReport implements Serializable{
    private String diagnoses;
    private String treatment;
    private String progress;
    private String doctorReview;
    private String patientId;
    private int reportId;
    private String eMail;
    private String address;

    public MedicalReport(String diagnoses, String treatment, String progress, String doctorReview) {
        this.diagnoses = diagnoses;
        this.treatment = treatment;
        this.progress = progress;
        this.doctorReview = doctorReview;
    }

    public MedicalReport(String patientId, int reportId, String eMail, String address) {
        this.patientId = patientId;
        this.reportId = reportId;
        this.eMail = eMail;
        this.address = address;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getDoctorReview() {
        return doctorReview;
    }

    public void setDoctorReview(String doctorReview) {
        this.doctorReview = doctorReview;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
