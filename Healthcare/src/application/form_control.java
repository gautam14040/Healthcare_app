package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class form_control {
	
	public static HashMap<String,Integer> hash = new HashMap<>();
	ResultSet rs = null;
    Connection connection = null;
    Statement statement = null; 
    String query ;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text error_new;

    @FXML
    private TextField kname_new;

    @FXML
    private TextField kcontact_new;

    @FXML
    private Button show;

    @FXML
    private TextField gender_new;

    @FXML
    private ChoiceBox<String> doctor_box;

    @FXML
    private Button logout_form;

    @FXML
    private DatePicker dob_new;

    @FXML
    private Button back_form;

    @FXML
    private TextField name_new;

    @FXML
    private ComboBox<String> department_new;

    @FXML
    private Button done_new;

    @FXML
    private DatePicker appointment_new;

    @FXML
    private ChoiceBox<Integer> slot_new;

    @FXML
    private TextField contact;
    
    

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
    void show(ActionEvent event) {
    	 doctor_box.setVisible(true);
    	 ArrayList<String> doctor = new ArrayList<String>();
         
         if(department_new.getValue()!=null)
         	 query = "SELECT person_name , emp_id FROM Employee natural join Department WHERE dept_id < 30 and dept_name=\""+department_new.getValue() +"\"" ;
         else
             query = "SELECT person_name , emp_id FROM Employee natural join Department WHERE dept_id < 30" ;

         rs = null;
    	 	try {
 			rs = statement.executeQuery(query);
 			do{
             	rs.next();
             	String d = (rs.getString(1));
             	doctor.add(d);
             	int id = rs.getInt(2);
             	hash.put(d,id);
                 System.out.println(rs.getString(1));

             }while(!rs.isLast());
 			
 		} catch (SQLException e) {
 			e.printStackTrace();
 			error_new.setText("Error"); 
 		}
    	 	
    	 doctor_box.setItems(FXCollections.observableArrayList(doctor));
    }

    @FXML
    void new_patient_form(ActionEvent event) {
    	done_new.setDisable(true);
    	int r ;
    	Date d = new Date ();
    	int pid = 0 ;
    	String name = name_new.getText();
    	String kname = kname_new.getText() ;
    	String kcontact = kcontact_new.getText();
    	char gender = gender_new.getText().charAt(0);
    	int emp_id = hash.get(doctor_box.getValue());
    	LocalDate dt = dob_new.getValue();
    	LocalDate dt2 = appointment_new.getValue();
    	int slot = slot_new.getValue();
    	String query2 = new String() ;
	 	int kid = 0 ;
	 	int cont = Integer.parseInt(contact.getText());
    	query2 = "SELECT max(kin_id) FROM Kin_data";
    	query = "Insert into Kin_data values (\""+kname+"\",\""+kcontact+"\",null)";
    	try {
			r = statement.executeUpdate(query);
			rs = statement.executeQuery(query2);
			rs.next();
			kid = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			error_new.setText("Error"); 

		}
    	
    	
	 	query = "Insert into Patient values (null,\""+name+"\",\""+gender+"\",\""+dt.toString()+"\",\""+cont+"\","+kid+",1)";
	 	query2 = "SELECT max(p_id) FROM Patient";
	 	try {
			r = statement.executeUpdate(query);
			rs = statement.executeQuery(query2);
			rs.next();
			pid = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 	query = "Insert into Appointments values (null" + ","+ pid + "," + emp_id + "," + slot +"," + "\""+ dt2.toString() + "\""+ ",null)" ;
	 	try {
			r = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			error_new.setText("Error"); 

		}
	 	
	 	try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			error_new.setText("Error"); 
		}
    	    	
    }
    
    @FXML
    void initialize() {
        assert error_new != null : "fx:id=\"error_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert kname_new != null : "fx:id=\"kname_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert kcontact_new != null : "fx:id=\"kcontact_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert show != null : "fx:id=\"show\" was not injected: check your FXML file 'Form.fxml'.";
        assert gender_new != null : "fx:id=\"gender_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert doctor_box != null : "fx:id=\"doctor_box\" was not injected: check your FXML file 'Form.fxml'.";
        assert logout_form != null : "fx:id=\"logout_form\" was not injected: check your FXML file 'Form.fxml'.";
        assert dob_new != null : "fx:id=\"dob_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert back_form != null : "fx:id=\"back_form\" was not injected: check your FXML file 'Form.fxml'.";
        assert name_new != null : "fx:id=\"name_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert department_new != null : "fx:id=\"department_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert done_new != null : "fx:id=\"done_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert appointment_new != null : "fx:id=\"appointment_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert slot_new != null : "fx:id=\"slot_new\" was not injected: check your FXML file 'Form.fxml'.";
        assert contact != null : "fx:id=\"contact\" was not injected: check your FXML file 'Form.fxml'.";
        done_new.setDisable(false);
        error_new.setText("");        
        ArrayList<Integer> x1 = new ArrayList<Integer>();
        
        for(int i=0 ; i < 18 ; i++)
        	x1.add(i+1);
        
        slot_new.setItems(FXCollections.observableArrayList(x1));
        
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
        	 error_new.setText("Error"); 
        }
        
        department_new.setItems(FXCollections.observableArrayList(dept));
        doctor_box.setVisible(false);

       
        
    }
}
