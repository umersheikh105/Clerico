package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.util.StringUtils;

import database.DBConnection;
import javafx.event.ActionEvent;

public class AddPartController implements Initializable {
	@FXML
	private TextField textFieldPartName;
	@FXML
	private TextField textFieldPartCost;
	@FXML
	private TextField textFieldDescription;

	DBConnection connection;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		connection = DBConnection.getInstance();
	}

	// Event Listener on Button.onAction
	@FXML
	public void addPart(ActionEvent event) {

		if (!StringUtils.isStrictlyNumeric(textFieldPartCost.getText()) && !textFieldPartCost.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please Enter a number for the 'Part Cost' field");
			alert.showAndWait();
			return;
		}

		if (textFieldPartName.getText().isEmpty() || textFieldPartCost.getText().isEmpty()
				|| textFieldDescription.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please Enter all of the fields");
			alert.showAndWait();
			return;
		}

		String partName = textFieldPartName.getText();
		int cost = Integer.parseInt(textFieldPartCost.getText());
		String description = textFieldDescription.getText();

		String sqlInsert = "INSERT INTO Part (part_name, cost, description) VALUES (" + "'" + partName + "'," + "'"
				+ cost + "'," + "'" + description + "'" + ")";

		if (connection.executeAction(sqlInsert)) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Success");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Failed");
			alert.showAndWait();
		}

	}

	// Event Listener on Button.onAction
	@FXML
	public void cancelPart(ActionEvent event) {
		textFieldPartName.getScene().getWindow().hide();
	}
}
