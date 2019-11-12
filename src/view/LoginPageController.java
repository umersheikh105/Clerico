package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

public class LoginPageController {
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML
	private Button login_btn;
	
	private String username = "username";
	private String password = "password";

	// Event Listener on Button[#login_btn].onAction
	@FXML
	public void switchToCalendar(ActionEvent event) throws IOException {
		if(!usernameTextField.getText().equals(username)||!passwordTextField.getText().equals(password)) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Username or Password is Incorrect");
			alert.showAndWait();
			return;
		}
		if(usernameTextField.getText().isEmpty()||passwordTextField.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please Enter all of the fields");
			alert.showAndWait();
			return;
		}
		
		if(usernameTextField.getText().equals(username)&&passwordTextField.getText().equals(password)) {
			Parent mainParent = FXMLLoader.load(getClass().getResource("HomeCalendarPage.fxml"));
	    	Scene invoiceScene = new Scene(mainParent);
	    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	
	    	window.setScene(invoiceScene);
	    	window.show();
		}
		

	}
}
