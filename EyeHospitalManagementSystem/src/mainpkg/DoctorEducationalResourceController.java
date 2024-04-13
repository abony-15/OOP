/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AZAAN
 */
public class DoctorEducationalResourceController implements Initializable {

    @FXML
    private ComboBox<String> selectTopicCb;
    @FXML
    private Label topicLable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> topics = FXCollections.observableArrayList(
    "Eye Health: Tips for Maintaining Optimal Vision", "Vision and Aging: How Eyesight Changes Over Time", "The Anatomy of Vision: Exploring the Complexities of the Eye");
    selectTopicCb.setItems(topics);
    }

    @FXML
    private void showTopicButtonOnMouseClicked(MouseEvent event) {
    String selectedTopic = selectTopicCb.getValue();
    topicLable.setText(selectedTopic);
    }

    @FXML
    private void homeButttonOnMouseClicked(MouseEvent event) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource("DoctorDashboardScene.fxml"));
    Scene scene = new Scene(parent);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene);
    window.show();
    }
}