package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class app_control {
	
	ResultSet rs = null;
    Connection connection = null;
    Statement statement = null; 
    String query ;

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;
    
    @FXML
    private Text error_existing;
    
    @FXML
    private ChoiceBox<Integer> slot_existing;
    
    @FXML
    private DatePicker date_existing;
    
    @FXML
    private TextField pid_existing;
    
    @FXML
    private ChoiceBox<String> department_existing;
    
    @FXML
    private Button done_existing;
    
    @FXML
    private ChoiceBox<String> doctor_box;
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
    void done(ActionEvent event) {
    	int pid = Integer.parseInt(pid_existing.getText());
    	String name = doctor_box.getValue();
    	int slot = slot_existing.getValue();
    	String date = date_existing.getValue().toString() ;
    	String dept = department_existing.getValue();
    	
    	 	query = "SELECT person_name FROM Employee WHERE dept_id < 30" ;
    	 	rs = null;
    	 	try {
 			rs = statement.executeQuery(query);
    	 	}
    	 	catch(Exception e)
    	 	{
    	 		e.printStackTrace();
    	 	}
    }
    

    @FXML
    void initialize() {
        assert error_existing != null : "fx:id=\"error_existing\" was not injected: check your FXML file 'Appointment.fxml'.";
        assert slot_existing != null : "fx:id=\"slot_existing\" was not injected: check your FXML file 'Appointment.fxml'.";
        assert date_existing != null : "fx:id=\"date_existing\" was not injected: check your FXML file 'Appointment.fxml'.";
        assert pid_existing != null : "fx:id=\"pid_existing\" was not injected: check your FXML file 'Appointment.fxml'.";
        assert department_existing != null : "fx:id=\"department_existing\" was not injected: check your FXML file 'Appointment.fxml'.";
        assert done_existing != null : "fx:id=\"done_existing\" was not injected: check your FXML file 'Appointment.fxml'.";
        assert doctor_box != null : "fx:id=\"doctor_box\" was not injected: check your FXML file 'Appointment.fxml'.";
        
        ArrayList<Integer> x1 = new ArrayList<Integer>();
        
        for(int i=0 ; i < 18 ; i++)
        	x1.add(i+1);
        
        slot_existing.setItems(FXCollections.observableArrayList(x1));
        
        ArrayList<String> dept = new ArrayList<String>();
   	 	
        
        query = "SELECT dept_name FROM Department" ;
        try {           
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            do{
            	rs.next();
            	dept.add(rs.getString(1));
                System.out.println(rs.getString(1));

            }while(!rs.isLast());
            
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        department_existing.setItems(FXCollections.observableArrayList(dept));

        ArrayList<String> doctor = new ArrayList<String>();
        query = "SELECT person_name FROM Employee WHERE dept_id < 30" ;
   	 	rs = null;
   	 	try {
			rs = statement.executeQuery(query);
			do{
            	rs.next();
            	doctor.add(rs.getString(1));
                System.out.println(rs.getString(1));

            }while(!rs.isLast());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
   	 	
   	 doctor_box.setItems(FXCollections.observableArrayList(doctor));
        
    }
}
