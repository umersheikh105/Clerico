package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

public class QuotesPageController implements Initializable {
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
	private TableView<Quote> tableView;
	@FXML
	private TableColumn<Quote, String> tableDescription;
	@FXML
	private TableColumn<Quote, String> tableLaborCosts;
	@FXML
	private TableColumn<Quote, String> tableDate;
	@FXML
	private TableColumn<Quote, String> tableFormID;
	@FXML
	private TableColumn<Quote, String> tableClientID;

	DBConnection connection;

	ObservableList<Quote> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeColumn();
		loadDataIntoTable();
	}

	private void initializeColumn() {
		tableFormID.setCellValueFactory(new PropertyValueFactory<>("fid"));
		tableClientID.setCellValueFactory(new PropertyValueFactory<>("cid"));
		tableDescription.setCellValueFactory(new PropertyValueFactory<>("notes"));
		tableLaborCosts.setCellValueFactory(new PropertyValueFactory<>("laborCosts"));
		tableDate.setCellValueFactory(new PropertyValueFactory<>("date"));
	}

	private void loadDataIntoTable() {
		connection = DBConnection.getInstance();
		String sql = "SELECT * FROM Form";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				int formID = rs.getInt("form_id");
				String fid = String.valueOf(formID);
				String laborCosts = String.valueOf(rs.getInt("labor_cost"));
				String date = String.valueOf(rs.getDate("date"));
				String notes = rs.getString("notes");
				String formType = rs.getString("form_type");

				String sqlClientForm = "SELECT * FROM ClientForm where form_id = " + "'" + formID + "'";
				ResultSet rs1 = connection.executeQuery(sqlClientForm);
				rs1.next();
				String cid = String.valueOf(rs1.getInt("client_id"));

				if (formType.equals("Q")) {
					list.add(new Quote(fid, cid, notes, laborCosts, date));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		tableView.getItems().setAll(list);

	}

	public static class Quote {
		private final SimpleStringProperty cid;
		private final SimpleStringProperty fid;
		private final SimpleStringProperty notes;
		private final SimpleStringProperty laborCosts;
		private final SimpleStringProperty date;

		Quote(String fid, String cid, String notes, String laborCosts, String date) {
			this.fid = new SimpleStringProperty(fid);
			this.cid = new SimpleStringProperty(cid);
			this.notes = new SimpleStringProperty(notes);
			this.laborCosts = new SimpleStringProperty(laborCosts);
			this.date = new SimpleStringProperty(date);

		}

		public String getCid() {
			return cid.get();
		}

		public String getFid() {
			return fid.get();
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
	void loadAddQuoteWindow(ActionEvent action) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("AddQuote.fxml"));
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (IOException ex) {
			// Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
