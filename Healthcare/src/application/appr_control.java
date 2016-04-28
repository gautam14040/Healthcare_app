package application;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	ResultSet rs = null;
	ResultSet rs2 = null;
    Connection connection = null;
    Statement statement = null; 

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
		String p  = pid.getText();
		String query = new String() ;
		String name = new String();
		String dname = new String();
		String q2 = "SELECT person_name From Patient WHERE p_id="+p;
		query = "SELECT * from Appointments WHERE p_id="+p;
		try {
			rs = statement.executeQuery(q2);
			rs.next();
			name = rs.getString(1);
			rs = statement.executeQuery(query);
			
		} catch (SQLException e) {
			error.setText("No such patient exists");
			e.printStackTrace();
		}
		
		try {
			if(rs.isLast()){
				error.setText("Error 101 :No such patient exists");
			}
			
			do{
	    		rs.next(); 
	    		
	    		Statement statement2 = null; 
	    		statement2 = connection.createStatement();
	    		String q3 =  new String();
	    		q3 = "SELECT person_name from Employee WHERE emp_id="+rs.getInt("emp_id");
				rs2 = statement2.executeQuery(q3); 
				rs2.next();
				dname = rs2.getString(1);
	    		
				record.setText("Appointment id : "+rs.getString(1) + " | Patient name : " + name + " | Doctor name : " 
	    		+ dname + " | Slot : " +rs.getString(4)+ " | Date : " +rs.getString(5)+"\n");
	    	}while(!rs.isLast());
			
		} catch (SQLException e) {
			error.setText("Error 202 : No such patient exists");
			e.printStackTrace();
		}
		
	}

    @FXML
    void initialize() {
    	connection = JDBCMySQLConnection.getConnection();
        try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	error.setText("");
    	record.setText("");
        assert record != null : "fx:id=\"record\" was not injected: check your FXML file 'Appointment_Record.fxml'.";
        assert pid != null : "fx:id=\"pid\" was not injected: check your FXML file 'Appointment_Record.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'Appointment_Record.fxml'.";
        assert error != null : "fx:id=\"error\" was not injected: check your FXML file 'Appointment_Record.fxml'.";

    }
}
