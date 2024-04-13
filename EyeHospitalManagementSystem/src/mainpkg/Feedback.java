/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author AZAAN
 */
public class Feedback {
    protected String patientId;
    protected String messageFeedback;

    public Feedback(String patientId, String messageFeedback) {
        this.patientId = patientId;
        this.messageFeedback = messageFeedback;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getMessageFeedback() {
        return messageFeedback;
    }

    public void setMessageFeedback(String messageFeedback) {
        this.messageFeedback = messageFeedback;
    }
}
