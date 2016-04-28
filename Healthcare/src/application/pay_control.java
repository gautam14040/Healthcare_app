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

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class pay_control {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text amount_payment;

    @FXML
    private Button logout_payment;

    @FXML
    private ComboBox<String> method_selector_payment;

    @FXML
    private TextField pid_payment;

    @FXML
    private Text error1_payment;

    @FXML
    private Button back_payment;

    @FXML
    private Button pay_payment;

    @FXML
    private Button pid_check_payment;

    @FXML
    private Text error2_payment;
    @FXML
    private ComboBox<String> description;

    public String pid;
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
    void check_payment(ActionEvent event)
    {
    	
    	String id=pid_payment.getText();
    	 ResultSet rs = null;
         Connection connection = null;
         Statement statement = null; 
         String query = "SELECT * FROM Patient WHERE p_id=" + id;
         try {           
             connection = JDBCMySQLConnection.getConnection();
             statement = connection.createStatement();
             rs = statement.executeQuery(query);
         	
             if (rs.next()) {
            	 pid_check_payment.setDisable(true); 
            	 pid = rs.getString("p_id");
                 pay_payment.setDisable(false);
                 description.setDisable(false);
                 method_selector_payment.setDisable(false);
                 error1_payment.setText("");
                 
             }
             else
             {
            	 error1_payment.setText( "Please enter a valid Patient ID"); 
             }
         }
             
         catch (SQLException e) {
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
             	
    }

    @FXML
    void pay(ActionEvent event) 
    {
    	if(description.getValue()==null || method_selector_payment.getValue()==null)
    	{
    		error2_payment.setText("Please choose valid options");
    		return;
    	}
    	pay_payment.setDisable(true);
    	error2_payment.setText("Payment Successful");
    	//String 
    	Connection connection = null;
        Statement statement = null; 
        
        String query = "Insert into Payment values (null,2000,"+ e1.emp_id + ",\""+ description.getValue()+"\"" + ",\"" + method_selector_payment.getValue() + "\"," + "true,"+pid+ ")" ;
        
        try {           
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query); 	
        }
        catch (SQLException e) {
            e.printStackTrace();
         } 
        finally
        {
             if (connection != null) 
             {     
            	 try { 
                   connection.close();
                 }
            	 catch (SQLException e) 
            	 {
                   e.printStackTrace();
                
                 }
            	 }
             }
    }

  

    @FXML
    void initialize() {
    	error2_payment.setText("");
    	error1_payment.setText("");
    	amount_payment.setText("");
    	pay_payment.setDisable(true);
    	description.setDisable(true);
    	method_selector_payment.setDisable(true);
        assert amount_payment != null : "fx:id=\"amount_payment\" was not injected: check your FXML file 'Payment.fxml'.";
        assert logout_payment != null : "fx:id=\"logout_payment\" was not injected: check your FXML file 'Payment.fxml'.";
        assert method_selector_payment != null : "fx:id=\"method_selector_payment\" was not injected: check your FXML file 'Payment.fxml'.";
        assert pid_payment != null : "fx:id=\"pid_payment\" was not injected: check your FXML file 'Payment.fxml'.";
        assert error1_payment != null : "fx:id=\"error1_payment\" was not injected: check your FXML file 'Payment.fxml'.";
        assert back_payment != null : "fx:id=\"back_payment\" was not injected: check your FXML file 'Payment.fxml'.";
        assert pay_payment != null : "fx:id=\"pay_payment\" was not injected: check your FXML file 'Payment.fxml'.";
        assert pid_check_payment != null : "fx:id=\"pid_check_payment\" was not injected: check your FXML file 'Payment.fxml'.";
        assert error2_payment != null : "fx:id=\"error2_payment\" was not injected: check your FXML file 'Payment.fxml'.";

    }
}
