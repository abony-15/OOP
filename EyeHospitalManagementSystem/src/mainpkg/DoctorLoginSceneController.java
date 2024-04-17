
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    private void LoginButtonOnMouseClicked(MouseEvent event) throws IOException {
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
    
    Login newdoc = new Login (Password, username);
    Login.show();
    
    Parent parent = FXMLLoader.load(getClass().getResource("DoctorDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();}

    @FXML
    private void userButtonOnMouseClicked(MouseEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("UserScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();}
}
