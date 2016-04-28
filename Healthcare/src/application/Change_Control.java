package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

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
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Change_Control {

	public static Employee e1;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> slot2_change_schedule;

    @FXML
    private Text error_change_schedule;

    @FXML
    private Button back_change_schedule;

    @FXML
    private Button logout_change_schedule;

    @FXML
    private ComboBox<Integer> slot3_change_schedule;

    @FXML
    private Button done_change_schedule;

    @FXML
    private ComboBox<Integer> slot1_change_schedule;


    //public static Employee e1; 

    public static Stage stage; 
    @FXML
    void enter(ActionEvent event) {
    	if(slot1_change_schedule.getValue()==null || slot3_change_schedule.getValue()==null || slot2_change_schedule.getValue()==null ||slot1_change_schedule.getValue()==slot2_change_schedule.getValue()||  
    			slot2_change_schedule.getValue()==slot3_change_schedule.getValue() || slot1_change_schedule.getValue()==slot3_change_schedule.getValue())
    		{
    		error_change_schedule.setText("Please choose the correct slots");
    			return;
    		}
    	System.out.println("hereupdea");
    	int slot1=slot1_change_schedule.getValue();
    	int slot2=slot2_change_schedule.getValue();
    	int slot3=slot3_change_schedule.getValue();
    	String avail="111";
    	String no="000";
    	Connection connection = null;
        Statement statement = null; 
    	
    	String slot=new String();
    	for(int i=1;i<=6;i++)
    	{
    		if(i==slot1 || i==slot2 || i==slot3 )
    		{
    			slot=slot+avail;
    		}
    		else
    		{
    			slot=slot+no;
    		}
    	}
    	
    	String query="UPDATE Employee SET slot="+slot+" WHERE emp_id="+e1.emp_id;
    	try {           
    	       connection = JDBCMySQLConnection.getConnection();
    	       statement = connection.createStatement();
    	        statement.executeUpdate(query);
    	        System.out.println("Connection successful");
    	}
    	catch (SQLException e) {
             e.printStackTrace();
          } finally {
              if (connection != null) {
                  try {
                	  done_change_schedule.setDisable(true);
                    connection.close();
                  } catch (SQLException e) {
                    e.printStackTrace();
                  }
              }}
    }
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
    void initialize() {
        assert slot2_change_schedule != null : "fx:id=\"slot2_change_schedule\" was not injected: check your FXML file 'Change_schedule.fxml'.";
        assert error_change_schedule != null : "fx:id=\"error_change_schedule\" was not injected: check your FXML file 'Change_schedule.fxml'.";
        assert back_change_schedule != null : "fx:id=\"back_change_schedule\" was not injected: check your FXML file 'Change_schedule.fxml'.";
        assert logout_change_schedule != null : "fx:id=\"logout_change_schedule\" was not injected: check your FXML file 'Change_schedule.fxml'.";
        assert slot3_change_schedule != null : "fx:id=\"slot3_change_schedule\" was not injected: check your FXML file 'Change_schedule.fxml'.";
        assert done_change_schedule != null : "fx:id=\"done_change_schedule\" was not injected: check your FXML file 'Change_schedule.fxml'.";
        assert slot1_change_schedule != null : "fx:id=\"slot1_change_schedule\" was not injected: check your FXML file 'Change_schedule.fxml'.";
        ArrayList<Integer> x1 = new ArrayList<Integer>();
        for(int i=0 ; i <= 5; i++)
        	x1.add(i+1);
        error_change_schedule.setText("");
        slot1_change_schedule.setItems(FXCollections.observableArrayList(x1));
        slot2_change_schedule.setItems(FXCollections.observableArrayList(x1));
        slot3_change_schedule.setItems(FXCollections.observableArrayList(x1));

    }
}
