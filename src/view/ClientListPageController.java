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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TableColumn;

public class ClientListPageController implements Initializable {
	@FXML
	private Button calendar_btn;
	@FXML
	private Button invoice_btn;
	@FXML
	private Button serviceOrders_btn;
	@FXML
	private Button quotes_btn;
	@FXML
	private Button settings_btn;
	@FXML
	private Button newClient_btn;
	@FXML
	private TableView<Client> tableView;
	@FXML
	private TableColumn<Client, Integer> tableID;
	@FXML
	private TableColumn<Client, String> tableFirstName;
	@FXML
	private TableColumn<Client, String> tableLastName;
	@FXML
	private TableColumn<Client, String> tableAddress;
	@FXML
	private TableColumn<Client, String> tablePhoneNumber;
	@FXML
	private TableColumn<Client, String> tableNotes;

	DBConnection connection;

	ObservableList<Client> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeColumn();
		loadDataIntoTable();
	}

	private void loadDataIntoTable() {
		connection = new DBConnection();
		String sql = "SELECT * FROM Client";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				Integer id = new Integer(rs.getInt("client_id"));
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String number = rs.getString("number");
				String address = rs.getString("address");
				String notes = rs.getString("notes");

				list.add(new Client(id, firstName, lastName, address, number, notes));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		tableView.getItems().setAll(list);
	}

	private void initializeColumn() {
		tableID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		tableLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		tableAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
		tablePhoneNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
		tableNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));

	}

	public static class Client {
		private final SimpleIntegerProperty id;
		private final SimpleStringProperty firstName;
		private final SimpleStringProperty lastName;
		private final SimpleStringProperty address;
		private final SimpleStringProperty number;
		private final SimpleStringProperty notes;

		Client(Integer id, String firstName, String lastName, String address, String number, String notes) {
			this.id = new SimpleIntegerProperty(id);
			this.firstName = new SimpleStringProperty(firstName);
			this.lastName = new SimpleStringProperty(lastName);
			this.address = new SimpleStringProperty(address);
			this.number = new SimpleStringProperty(number);
			this.notes = new SimpleStringProperty(notes);
		}

		public Integer getID() {
			return new Integer(id.get());
		}

		public String getFirstName() {
			return firstName.get();
		}

		public String getLastName() {
			return lastName.get();
		}

		public String getAddress() {
			return address.get();
		}

		public String getNumber() {
			return number.get();
		}

		public String getNotes() {
			return notes.get();
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

	// Event Listener on Button[#serviceOrder_btn].onAction
	@FXML
	public void switchToServiceOrders(ActionEvent event) throws IOException {
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

	// Event Listener on Button[#settings_btn].onAction
	@FXML
	public void switchToSettings(ActionEvent event) throws IOException {
		Parent mainParent = FXMLLoader.load(getClass().getResource("SettingsPage.fxml"));
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

	// Event Listener on Button[#newInvoice_btn].onAction
	@FXML
	void loadWindow(ActionEvent action) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddClient.fxml"));
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (IOException ex) {
			// Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
