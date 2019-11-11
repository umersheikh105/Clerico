package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.event.ActionEvent;

public class Main3Controller {
	@FXML
	private Button calendar_btn;
	@FXML
	private Button invoice_btn;
	@FXML
	private Button serviceOrder_btn;
	@FXML
	private Button quotes_btn;
	@FXML
	private Button clientList_btn;
	@FXML
	private Button settings_btn;

	@FXML
	public void switchToCalendar(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#invoice_btn].onAction
	@FXML
	public void switchToInvoice(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("Main2.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#serviceOrder_btn].onAction
	@FXML
	public void switchToServiceOrder(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("Main3.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#quotes_btn].onAction
	@FXML
	public void switchToQuotes(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("Main4.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#clientList_btn].onAction
	@FXML
	public void switchToClientList(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("Main5.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
	// Event Listener on Button[#settings_btn].onAction
	@FXML
	public void switchToSettings(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("Main6.fxml"));
    	Scene invoiceScene = new Scene(mainParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(invoiceScene);
    	window.show();

	}
}
