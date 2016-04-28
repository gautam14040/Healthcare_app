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

public class sch_control {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text slot_schedule;

    @FXML
    private Text avail_schedule;

    @FXML
    private Button back_schedule;

    @FXML
    private Button logout_schedule;

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
    void initialize() {
        assert slot_schedule != null : "fx:id=\"slot_schedule\" was not injected: check your FXML file 'Schedule.fxml'.";
        assert avail_schedule != null : "fx:id=\"avail_schedule\" was not injected: check your FXML file 'Schedule.fxml'.";
        assert back_schedule != null : "fx:id=\"back_schedule\" was not injected: check your FXML file 'Schedule.fxml'.";
        assert logout_schedule != null : "fx:id=\"logout_schedule\" was not injected: check your FXML file 'Schedule.fxml'.";
        
        String sh = new String(Controller.employee.slot);
        System.out.println(sh);
        String res = new String();
        int t = 0 ;
        for (int i = 0; i < sh.length(); i++) {
			if(sh.charAt(i) == '1' ){	
				String day=new String();
				day="AM";
				if(i>=12)
				{
					day="PM";
				}
				t = i + 1 ;
				String h=new String();
				h=day;
				if(t>=12)
				{
					h="PM";
				}
				int temr=t+3;
				res = res + t +day+ " - " + temr + h + "\n";
				i = i + 3 ;
				}
		}
        slot_schedule.setText(res);
    }
}
