
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class DoctorLoginSceneController implements Initializable {
    Alert Login = new Alert(Alert.AlertType.INFORMATION, "Succesfully Login");
    Alert Wrong = new Alert(Alert.AlertType.INFORMATION, "Information Incorrect");

    @FXML private TextField UsernameTextFiield;
    @FXML private PasswordField PasswordPasswordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
}
    @FXML
    private void LoginButtonOnClick(ActionEvent event) {
    String password = PasswordPasswordField.getText();
    if (!password.equals("123")) {
        Wrong.show();
        return;
    }
    PasswordPasswordField.clear();

    Integer Password = Integer.parseInt(password);
    
    String username = UsernameTextFiield.getText();
    if (!username.equals("DR.")) {
        Wrong.show();
        return;
}
    UsernameTextFiield.clear();
    
    DoctorLogin newdoc = new DoctorLogin (Password, username);
    Login.show();
}
}
