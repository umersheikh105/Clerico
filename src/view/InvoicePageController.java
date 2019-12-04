package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InvoicePageController implements Initializable {
	@FXML
	private Button newInvoice_btn;
	@FXML
	private TableView<Invoice> tableView;
	@FXML
	private TableColumn<Invoice, String> tableDescription;
	@FXML
	private TableColumn<Invoice, String> tableLaborCosts;
	@FXML
	private TableColumn<Invoice, String> tableDate;

	DBConnection connection;

	ObservableList<Invoice> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeColumn();
		loadDataIntoTable();
	}

	private void loadDataIntoTable() {
		tableDescription.setCellValueFactory(new PropertyValueFactory<>("notes"));
		tableLaborCosts.setCellValueFactory(new PropertyValueFactory<>("laborCosts"));
		tableDate.setCellValueFactory(new PropertyValueFactory<>("date"));
	}

	private void initializeColumn() {
		connection = new DBConnection();
		String sql = "SELECT * FROM Form";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				String laborCosts = String.valueOf(rs.getInt("labor_cost"));
				String date = String.valueOf(rs.getDate("date"));
				String notes = rs.getString("notes");

				list.add(new Invoice(notes, laborCosts, date));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		tableView.getItems().setAll(list);

	}

	public static class Invoice {
		private final SimpleStringProperty notes;
		private final SimpleStringProperty laborCosts;
		private final SimpleStringProperty date;

		Invoice(String notes, String laborCosts, String date) {
			this.notes = new SimpleStringProperty(notes);
			this.laborCosts = new SimpleStringProperty(laborCosts);
			this.date = new SimpleStringProperty(date);

		}

		public String getNotes() {
			return notes.get();
		}

		public String getLaborCosts() {
			return laborCosts.get();
		}

		public String getDate() {
			return date.get();
		}

	}

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
	public void switchToServiceOrder(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("ServiceOrdersPage.fxml"));
		Scene invoiceScene = new Scene(mainParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(invoiceScene);
		window.show();

	}

	// Event Listener on Button[#quotes_btn].onAction
	@FXML
	public void switchToQuotes(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("QuotesPage.fxml"));
		Scene invoiceScene = new Scene(mainParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(invoiceScene);
		window.show();

	}

	// Event Listener on Button[#clientList_btn].onAction
	@FXML
	public void switchToClientList(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("ClientListPage.fxml"));
		Scene invoiceScene = new Scene(mainParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(invoiceScene);
		window.show();

	}

	// Event Listener on Button[#settings_btn].onAction
	@FXML
	public void switchToSettings(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("SettingsPage.fxml"));
		Scene invoiceScene = new Scene(mainParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(invoiceScene);
		window.show();

	}

	// Event Listener on Button[#newInvoice_btn].onAction
	@FXML
	void loadWindow(ActionEvent action) {
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
