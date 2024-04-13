/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author AZAAN
 */
public class Consultation {
    protected String doctorId;
    protected String consultantPartner;
    protected String consultationTopic;

    public Consultation(String doctorId, String consultantPartner, String consultationTopic) {
        this.doctorId = doctorId;
        this.consultantPartner = consultantPartner;
        this.consultationTopic = consultationTopic;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getConsultantPartner() {
        return consultantPartner;
    }

    public void setConsultantPartner(String consultantPartner) {
        this.consultantPartner = consultantPartner;
    }

    public String getConsultationTopic() {
        return consultationTopic;
    }

    public void setConsultationTopic(String consultationTopic) {
        this.consultationTopic = consultationTopic;
    }
}
