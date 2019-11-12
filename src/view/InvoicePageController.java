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

public class InvoicePageController {
	@FXML
	private Button newInvoice_btn;

	@FXML
	public void switchToCalendar(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("HomeCalendarPage.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#invoice_btn].onAction
	@FXML
	public void switchToInvoice(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("InvoicePage.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#serviceOrder_btn].onAction
	@FXML
	public void switchToServiceOrder(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("ServiceOrdersPage.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#quotes_btn].onAction
	@FXML
	public void switchToQuotes(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("QuotesPage.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#clientList_btn].onAction
	@FXML
	public void switchToClientList(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("ClientListPage.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#settings_btn].onAction
	@FXML
	public void switchToSettings(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("SettingsPage.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#newInvoice_btn].onAction
	@FXML
	void loadWindow(ActionEvent action)
    {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("AddInvoice.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
           // Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
