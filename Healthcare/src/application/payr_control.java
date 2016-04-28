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

public class payr_control {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logout;

    @FXML
    private Text record;

    @FXML
    private Button back;

    @FXML
    private TextField pid;

    @FXML
    private Button check;

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
    	String id=pid.getText();
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
        String query = "SELECT * FROM Payment WHERE p_id=" + id;
        try {           
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            int i=0;
            if (rs.next())
            {	i++;
            	String display=new String();
            	 if(rs.getBoolean("is_paid"))
            	 {
            		 display= i+". " +rs.getInt("amount") + " paid through " +rs.getString("method") +" for "+ rs.getString("discription")+ "\n";
            	 }
            	 else
            	 {
            		 display=i+". "+rs.getInt("amount") + " not paid " +" for "+ rs.getString("discription")+  "\n";
            	 }
           	 
            	 while(rs.next())
            	 {
            		 i++;
            		 if(i>10)
            		 {
            			 break;
            		 }
            			 
            		 //System.out.println(rs.getBoolean("is_paid"));
            		 if(rs.getBoolean("is_paid"))
            		 {
           			 display=display+ i+". "+rs.getInt("amount") + " paid through " +rs.getString("method") +" for "+ rs.getString("discription")+ "\n";
            		 }
            		 else
            		 {
            			 display=display+ i+". "+rs.getInt("amount") + " not paid " +" for "+ rs.getString("discription")+  "\n";
            		 }
           		 
            	 }
           	 record.setText(display);
           	 check.setDisable(false);
           	 System.out.println("Inside");  
            }
            else
            {
            	System.out.println("Fail");
           	 	error.setText( "Please enter a valid Patient ID"); 
            }
        } catch (SQLException e) {
              e.printStackTrace();
        	System.out.println("Fail");
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
    void initialize() {
    	error.setText("");
    	record.setText("");
        assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'Payment_record.fxml'.";
        assert record != null : "fx:id=\"record\" was not injected: check your FXML file 'Payment_record.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'Payment_record.fxml'.";
        assert pid != null : "fx:id=\"pid\" was not injected: check your FXML file 'Payment_record.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'Payment_record.fxml'.";
        assert error != null : "fx:id=\"error\" was not injected: check your FXML file 'Payment_record.fxml'.";

    }
}


