package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class appr_control {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text record;

    @FXML
    private TextField pid;

    @FXML
    private Button check;
    @FXML
    private Button logout;
    @FXML
    private Button back;
    @FXML
    private Text error;

    public static Stage stage; 
    public static Employee e1;
    @FXML
    void logout(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			Controller.stage = stage ;
		    stage.setTitle("FXML Welcome");
		    stage.setScene(scene);
		    stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Fail");
		}
    }
    @FXML
    void back(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Patient.fxml"));
			Scene scene = new Scene(root);
			reception_control.stage = stage ;
		    stage.setTitle("FXML Welcome");
		    reception_control.e1=e1;
		    stage.setScene(scene);
		    stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Fail");
		}
    }

    @FXML
    void check(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	error.setText("");
    	record.setText("");
        assert record != null : "fx:id=\"record\" was not injected: check your FXML file 'Appointment_Record.fxml'.";
        assert pid != null : "fx:id=\"pid\" was not injected: check your FXML file 'Appointment_Record.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'Appointment_Record.fxml'.";
        assert error != null : "fx:id=\"error\" was not injected: check your FXML file 'Appointment_Record.fxml'.";

    }
}
