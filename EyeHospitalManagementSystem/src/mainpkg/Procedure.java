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
public class Procedure implements Serializable{
    private String patientId;
    private String procedure;
    private String day;
    private String time;

    public Procedure(String patientId, String procedure, String day, String time) {
        this.patientId = patientId;
        this.procedure = procedure;
        this.day = day;
        this.time = time;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Procedure{" + "patientId=" + patientId + ", procedure=" + procedure + ", day=" + day + ", time=" + time + '}';
    }
}
