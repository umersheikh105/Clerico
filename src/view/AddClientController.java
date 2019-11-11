package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import database.*;
import javafx.event.ActionEvent;

public class AddClientController implements Initializable{
	@FXML
	private TextField textFieldFirstName;
	@FXML
	private TextField textFieldLastName;
	@FXML
	private TextField textFieldAddress;
	@FXML
	private TextField textFieldNumber;
	@FXML
	private Button clientAddButton;
	@FXML
	private Button clientCancelButton;
	
	DBConnection connection;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		connection = new DBConnection();
	}
	// Event Listener on Button[#clientAddButton].onAction
	@FXML
	public void addClient(ActionEvent event) {
		String firstName = textFieldFirstName.getText();
		String lastName = textFieldLastName.getText();
		String address = textFieldAddress.getText();
		String number1 = textFieldNumber.getText();
		String notes = "";
		/*if (!(StringUtils.isStrictlyNumeric(number1))) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please enter a number");
			alert.showAndWait();
			return;
		} */
		
		if(firstName.isEmpty()||lastName.isEmpty()||address.isEmpty()||number1.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please Enter all of the fields");
			alert.showAndWait();
			return;
		}
			String sqlInsert = "INSERT INTO Client (firstname, lastname, number, address, notes) VALUES (" 
					+ "'"+ firstName + "'," 
					+ "'"+ lastName + "'," 
					+ "'"+ number1 + "'," 
					+ "'"+ address + "'," 
					+ "'"+ notes + "'"
					+ ")";
					
			if(connection.executeAction(sqlInsert)) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("Success");
				alert.showAndWait();
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Failed");
				alert.showAndWait();
			}
		
		
	}
	// Event Listener on Button[#clientCancelButton].onAction
	@FXML
	public void cancelClient(ActionEvent event) {
		textFieldFirstName.getScene().getWindow().hide();
	}
}
