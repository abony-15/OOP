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
public class PatientHistory implements Serializable {
    private String name;
    private String disease;
    private String gender;
    private String status;

    public PatientHistory(String name, String disease, String gender, String status) {
        this.name = name;
        this.disease = disease;
        this.gender = gender;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PatientHistory{" + "name=" + name + ", disease=" + disease + ", gender=" + gender + ", status=" + status + '}';
    }
}
