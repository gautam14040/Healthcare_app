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
import javafx.stage.Stage;

public class reception_control {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button existing_patient;

    @FXML
    private Button payment_patient;

    @FXML
    private Button logout_reception;

    @FXML
    private Button view_patient;

    @FXML
    private Button new_patient;

    @FXML
    private Button back_reception;

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
			root = FXMLLoader.load(getClass().getResource("view.fxml"));
			Scene scene = new Scene(root);
			Controller.stage = stage ;
		    stage.setTitle("FXML Welcome");
		    view_control.e1=e1;
		    stage.setScene(scene);
		    stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Fail");
		}
    }
    @FXML
    void fees_pay(ActionEvent event)
    {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Payment.fxml"));
			Scene scene = new Scene(root);
			Controller.stage = stage ;
		    stage.setTitle("FXML Welcome");
		    stage.setScene(scene);
		    stage.show();
		    pay_control.stage=stage;
		    pay_control.e1=e1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fail");
		}
		

    }

 
    @FXML
    void new_pat(ActionEvent event) 
    {

    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Form.fxml"));
			Scene scene = new Scene(root);
			form_control.stage = stage ;
			form_control.e1=e1;
		    stage.setTitle("FXML Welcome");
		    stage.setScene(scene);
		    stage.show();
		    
		    appr_control.e1=e1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fail");
		}

    }

    @FXML
    void appointment(ActionEvent event)
    {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Appointment_Record.fxml"));
			Scene scene = new Scene(root);
			appr_control.stage = stage ;
		    stage.setTitle("FXML Welcome");
		    stage.setScene(scene);
		    stage.show();
		    
		    appr_control.e1=e1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fail");
		}
    }
    @FXML
    void payment_record(ActionEvent event) 
    {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Payment_record.fxml"));
			Scene scene = new Scene(root);
			Controller.stage = stage ;
		    stage.setTitle("FXML Welcome");
		    stage.setScene(scene);
		    stage.show();
		    payr_control.stage=stage;
		    payr_control.e1=e1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fail");
		}

    }
    @FXML
    void existing_pat(ActionEvent event)
    {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Appointment.fxml"));
			Scene scene = new Scene(root);
			Controller.stage = stage ;
		    stage.setTitle("FXML Welcome");
		    stage.setScene(scene);
		    stage.show();
		    app_control.stage=stage;
		    app_control.e1=e1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fail");
		}
		

    }


 

    @FXML
    void initialize() {
        assert existing_patient != null : "fx:id=\"existing_patient\" was not injected: check your FXML file 'Patient.fxml'.";
        assert payment_patient != null : "fx:id=\"payment_patient\" was not injected: check your FXML file 'Patient.fxml'.";
        assert logout_reception != null : "fx:id=\"logout_reception\" was not injected: check your FXML file 'Patient.fxml'.";
        assert view_patient != null : "fx:id=\"view_patient\" was not injected: check your FXML file 'Patient.fxml'.";
        assert new_patient != null : "fx:id=\"new_patient\" was not injected: check your FXML file 'Patient.fxml'.";
        assert back_reception != null : "fx:id=\"back_reception\" was not injected: check your FXML file 'Patient.fxml'.";

    }
}
