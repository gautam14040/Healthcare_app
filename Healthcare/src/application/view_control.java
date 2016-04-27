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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class view_control {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logout_view;

    @FXML
    private Text n_view;

    @FXML
    private Button view_patient_view;

    @FXML
    private Button view_emp_view;

    @FXML
    private Button sch_show_view;

    @FXML
    private Text patr_view;

    @FXML
    private Button detail_view;

    @FXML
    private Button sch_change_view;

    @FXML
    private Text empr_view;

    @FXML
    void show_details(ActionEvent event) {
    	
    	Stage stage = new Stage();
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Detail.fxml"));
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
    void show_schedule(ActionEvent event) {
    	
    	Stage stage = new Stage();
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Schedule.fxml"));
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
    void apply_change(ActionEvent event) {
    	Stage stage = new Stage();
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Change_schedule.fxml"));
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
    void view_patient(ActionEvent event) {

    }

    @FXML
    void view_employee(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert logout_view != null : "fx:id=\"logout_view\" was not injected: check your FXML file 'view.fxml'.";
        assert n_view != null : "fx:id=\"n_view\" was not injected: check your FXML file 'view.fxml'.";
        assert view_patient_view != null : "fx:id=\"view_patient_view\" was not injected: check your FXML file 'view.fxml'.";
        assert view_emp_view != null : "fx:id=\"view_emp_view\" was not injected: check your FXML file 'view.fxml'.";
        assert sch_show_view != null : "fx:id=\"sch_show_view\" was not injected: check your FXML file 'view.fxml'.";
        assert patr_view != null : "fx:id=\"patr_view\" was not injected: check your FXML file 'view.fxml'.";
        assert detail_view != null : "fx:id=\"detail_view\" was not injected: check your FXML file 'view.fxml'.";
        assert sch_change_view != null : "fx:id=\"sch_change_view\" was not injected: check your FXML file 'view.fxml'.";
        assert empr_view != null : "fx:id=\"empr_view\" was not injected: check your FXML file 'view.fxml'.";

    }
}

