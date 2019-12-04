package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.event.ActionEvent;

import javafx.scene.control.ChoiceBox;

public class AddInvoiceController implements Initializable {
	@FXML
	private ChoiceBox<String> clientChoiceBox;
	@FXML
	private ChoiceBox<String> partChoiceBox;
	@FXML
	private TextField textFieldLaborCost;
	@FXML
	private TextField textFieldSignature;
	@FXML
	private TextField textFieldNotes;
	@FXML
	private Button invoiceAddButton;
	@FXML
	private Button invoiceCancelButton;

	DBConnection connection;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		connection = new DBConnection();
		ResultSet rs = connection.executeQuery("select * from Client");
		try {
			while (rs.next()) {
				clientChoiceBox.getItems().add(rs.getString("firstname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs = connection.executeQuery("select * from Part");
		try {
			while (rs.next()) {
				partChoiceBox.getItems().add(rs.getString("part_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#invoiceAddButton].onAction
	@FXML
	public void addInvoice(ActionEvent event) throws SQLException {
		connection = new DBConnection();
		String laborCost = textFieldLaborCost.getText();
		String signature = textFieldSignature.getText();
		String notes = textFieldNotes.getText();

		if (laborCost.isEmpty() || signature.isEmpty() || partChoiceBox.getValue().equals(null)
				|| clientChoiceBox.getValue().equals(null) || notes.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please Enter all of the fields");
			alert.showAndWait();
			return;
		}

		ResultSet rs = connection
				.executeQuery("select part_id FROM Part WHERE part_name = " + "'" + partChoiceBox.getValue() + "'");
		int partID = 0;
		try {
			rs.next();
			partID = rs.getInt("part_id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String today = formatter.format(date);

		String sqlInsert = "INSERT INTO Form (part_id, labor_cost, date, notes) VALUES (" + "'" + partID + "'," + "'"
				+ Integer.parseInt(laborCost) + "'," + "'" + today + "'," + "'" + notes + "'" + ")";

		connection.executeAction(sqlInsert);

		rs = connection.executeQuery("select form_id from Form order by form_id desc");
		rs.next();
		int formID = rs.getInt("form_id");

		rs = connection.executeQuery(
				"select client_id from Client where firstname = " + "'" + clientChoiceBox.getValue() + "'");
		rs.next();
		int clientID = rs.getInt("client_id");

		String clientFormInsert = "INSERT INTO ClientForm (form_id, client_id, signature) VALUES (" + "'" + formID
				+ "'," + "'" + clientID + "'," + "'" + signature + "'" + ")";

		rs = connection.executeQuery("select cost FROM Part WHERE part_name = " + "'" + partChoiceBox.getValue() + "'");
		rs.next();
		if (connection.executeAction(clientFormInsert)) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Success " + " Total Cost: "
					+ String.valueOf(Integer.parseInt(textFieldLaborCost.getText()) + rs.getInt("cost")));
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Failed");
			alert.showAndWait();
		}

	}

	// Event Listener on Button[#invoiceCancelButton].onAction
	@FXML
	public void cancelInvoice(ActionEvent event) {
		textFieldLaborCost.getScene().getWindow().hide();
	}
}
