package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import javafx.event.ActionEvent;

public class SettingsPageController {
	@FXML
	private Button calendar_btn;
	@FXML
	private Button invoice_btn;
	@FXML
	private Button serviceOrders_btn;
	@FXML
	private Button clientList_btn;
	@FXML
	private Button settings_btn;

	// Event Listener on Button[#calendar_btn].onAction
	@FXML
	public void switchToCalendar(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("HomeCalendarPage.fxml"));
		Scene invoiceScene = new Scene(mainParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(invoiceScene);
		window.show();

	}

	// Event Listener on Button[#invoice_btn].onAction
	@FXML
	public void switchToInvoice(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("InvoicePage.fxml"));
		Scene invoiceScene = new Scene(mainParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(invoiceScene);
		window.show();

	}

	// Event Listener on Button[#serviceOrders_btn].onAction
	@FXML
	public void switchToServiceOrders(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("ServiceOrdersPage.fxml"));
		Scene invoiceScene = new Scene(mainParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(invoiceScene);
		window.show();

	}

	// Event Listener on Button[#clientList_btn].onAction
	@FXML
	public void switchToQuotes(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("QuotesPage.fxml"));
		Scene invoiceScene = new Scene(mainParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(invoiceScene);
		window.show();

	}

	// Event Listener on Button[#settings_btn].onAction
	@FXML
	public void switchToClientList(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("ClientListPage.fxml"));
		Scene invoiceScene = new Scene(mainParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(invoiceScene);
		window.show();

	}

	// Event Listener on Button[#newInvoice_btn].onAction
	@FXML
	void loadWindow(ActionEvent action) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (IOException ex) {
			// Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	@FXML
	void loadAddPartWindow(ActionEvent action) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (IOException ex) {
			// Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	@FXML
	void loadPartsTableWindow(ActionEvent action) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("PartsTable.fxml"));
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (IOException ex) {
			// Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
}
