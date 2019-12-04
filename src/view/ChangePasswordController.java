package view;

import javafx.fxml.FXML;
import database.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

public class ChangePasswordController {
	@FXML
	private PasswordField passwordField;
	@FXML
	private PasswordField confirmPasswordField;
	
	DBConnection connection;

	// Event Listener on Button.onAction
		@FXML
		public void changePassword(ActionEvent event) {
			if(passwordField.getText().isEmpty()||confirmPasswordField.getText().isEmpty()) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Please Enter Both Fields");
				alert.showAndWait();
			}
			if(!passwordField.getText().equals(confirmPasswordField.getText())) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Please make sure both fields have the same password");
				alert.showAndWait();
			}
			
			if(passwordField.getText().equals(confirmPasswordField.getText())) {
				String password = passwordField.getText();
				connection = DBConnection.getInstance();
				String sqlInsert = "UPDATE Login SET password = '" + password + "' " + "where id = 1";
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
			
		}
		// Event Listener on Button.onAction
		@FXML
		public void cancel(ActionEvent event) {
			passwordField.getScene().getWindow().hide();
		}
}
