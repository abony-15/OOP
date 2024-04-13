/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author AZAAN
 */
public class TestReport {
    protected String patientId;
    protected String reportName;
    protected String reportReview;

    public TestReport(String patientId, String reportName, String reportReview) {
        this.patientId = patientId;
        this.reportName = reportName;
        this.reportReview = reportReview;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportReview() {
        return reportReview;
    }

    public void setReportReview(String reportReview) {
        this.reportReview = reportReview;
    }

}