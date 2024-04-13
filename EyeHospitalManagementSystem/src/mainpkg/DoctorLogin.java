/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author AZAAN
 */
public class DoctorLogin {
    private Integer Password;
    private String Username;

    public DoctorLogin(Integer Password, String Username) {
        this.Password = Password;
        this.Username = Username;
    }

    public Integer getPassword() {
        return Password;
    }

    public void setPassword(Integer Password) {
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    @Override
    public String toString() {
        return "Doctor{" + "Password=" + Password + ", Username=" + Username + '}';
    }
    
}
