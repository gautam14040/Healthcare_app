package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
	
	public static Employee employee = null;
	
	public static Stage stage ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private TextField username;
    @FXML
    private Text error;

    @FXML
    void login(ActionEvent event) {
    	error.setText("");
    	System.out.println("Test");
    	 ResultSet rs = null;
         Connection connection = null;
         Statement statement = null; 
         String pass = null ;
         String input = password.getText() ;
         
         String query = "SELECT * FROM Employee WHERE emp_id=" + username.getText();
         try {           
             connection = JDBCMySQLConnection.getConnection();
             statement = connection.createStatement();
             rs = statement.executeQuery(query);
             	
             if (rs.next()) {
                 employee = new Employee();
                 pass = rs.getString("user_password");
                 if(input.equals(pass))
	                 {
                	 	
                	 	employee.emp_id = Integer.parseInt(rs.getString("emp_id"));
                	 	employee.dept_id = Integer.parseInt(rs.getString("dept_id"));
                	 	employee.emp_name = rs.getString("person_name");
                	 	employee.post = rs.getString("post");
                	 	employee.gender = rs.getString("gender");
                	 	employee.rights = Integer.parseInt(rs.getString("rights"));
                	 	employee.dob = Date.valueOf(rs.getString("dob"));
                	 	employee.slot = rs.getString("slot");
                	 	employee.availible_slot = rs.getString("avilable_slot");
                	 	employee.password = rs.getString("user_password");
                	 	employee.contact = rs.getString("contact");

                	 	
                			 
	                 }
                 }

         } catch (SQLException e) {
           //  e.printStackTrace();
         } finally {
             if (connection != null) {
                 try {
                     connection.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
         }
         
         
         System.out.println(input + " = " +pass);
         if(input.equals(pass))
         {
        	 System.out.println("here");
        	 error.setText("Welcome");
        	 try {
            	Parent root ;
            	view_control.e1=employee;
            	Change_Control.e1=employee;
				root = FXMLLoader.load(getClass().getResource("view.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				view_control.stage=stage;
			} catch (IOException e) {
				e.printStackTrace();
			}
         } 
         else 
        	 error.setText("Incorrect Credentials");
         
        
    }

    @FXML
    void initialize() {
    	error.setText("");
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'Login.fxml'.";
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
