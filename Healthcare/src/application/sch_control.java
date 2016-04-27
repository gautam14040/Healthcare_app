package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

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

    @FXML
    void initialize() {
        assert slot_schedule != null : "fx:id=\"slot_schedule\" was not injected: check your FXML file 'Schedule.fxml'.";
        assert avail_schedule != null : "fx:id=\"avail_schedule\" was not injected: check your FXML file 'Schedule.fxml'.";
        assert back_schedule != null : "fx:id=\"back_schedule\" was not injected: check your FXML file 'Schedule.fxml'.";
        assert logout_schedule != null : "fx:id=\"logout_schedule\" was not injected: check your FXML file 'Schedule.fxml'.";
        
        String sh = new String(Controller.employee.slot);
        String res = new String();
        int t = 0 ;
        for (int i = 0; i < sh.length(); i++) {
			if(sh.charAt(i) == '1' ){
				t = i + 1 ;
				res = res + t + 'h' + "\n";
				i = i + 3 ;
				}
		}
        slot_schedule.setText(res);
    }
}
