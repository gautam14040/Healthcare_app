package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class details_control {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logout_detail;

    @FXML
    private Text department_detail;

    @FXML
    private Button back_detail;

    @FXML
    private Text post_detail;

    @FXML
    private Text patient_detail;

    @FXML
    private Text employee_detail;

    @FXML
    private Text name_detail;

    @FXML
    private Button change_password_detail;

    @FXML
    private Text gender_detail;

    @FXML
    void initialize() {
        assert logout_detail != null : "fx:id=\"logout_detail\" was not injected: check your FXML file 'Detail.fxml'.";
        assert department_detail != null : "fx:id=\"department_detail\" was not injected: check your FXML file 'Detail.fxml'.";
        assert back_detail != null : "fx:id=\"back_detail\" was not injected: check your FXML file 'Detail.fxml'.";
        assert post_detail != null : "fx:id=\"post_detail\" was not injected: check your FXML file 'Detail.fxml'.";
        assert patient_detail != null : "fx:id=\"patient_detail\" was not injected: check your FXML file 'Detail.fxml'.";
        assert employee_detail != null : "fx:id=\"employee_detail\" was not injected: check your FXML file 'Detail.fxml'.";
        assert name_detail != null : "fx:id=\"name_detail\" was not injected: check your FXML file 'Detail.fxml'.";
        assert change_password_detail != null : "fx:id=\"change_password_detail\" was not injected: check your FXML file 'Detail.fxml'.";
        assert gender_detail != null : "fx:id=\"gender_detail\" was not injected: check your FXML file 'Detail.fxml'.";
        
        name_detail.setText(Controller.employee.emp_name);
        gender_detail.setText(Controller.employee.gender);
        post_detail.setText(Controller.employee.post);
        department_detail.setText(Controller.employee.dept_id + "");
        employee_detail.setText(Controller.employee.rights%2 + "" );
        patient_detail.setText(Controller.employee.rights%3 + "");
        change_password_detail.setVisible(false);
    }
}

