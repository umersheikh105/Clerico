package view;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import database.DBConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class PartsTableController implements Initializable {
	@FXML
	private TableView<Part> tableView;
	@FXML
	private TableColumn<Part, String> tablePartName;
	@FXML
	private TableColumn<Part, String> tablePartCost;
	@FXML
	private TableColumn<Part, String> tablePartDescription;

	DBConnection connection;

	ObservableList<Part> list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeColumn();
		loadDataIntoTable();
	}

	private void initializeColumn() {
		tablePartName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tablePartCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
		tablePartDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
	}

	private void loadDataIntoTable() {
		connection = DBConnection.getInstance();
		String sql = "SELECT * FROM Part";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				String name = rs.getString("part_name");
				String cost = String.valueOf(rs.getInt("cost"));
				String description = rs.getString("description");

				list.add(new Part(name, cost, description));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		tableView.getItems().setAll(list);

	}

	public static class Part {
		private final SimpleStringProperty name;
		private final SimpleStringProperty cost;
		private final SimpleStringProperty description;

		Part(String name, String cost, String description) {
			this.name = new SimpleStringProperty(name);
			this.cost = new SimpleStringProperty(cost);
			this.description = new SimpleStringProperty(description);

		}

		public String getName() {
			return name.get();
		}

		public String getCost() {
			return cost.get();
		}

		public String getDescription() {
			return description.get();
		}
	}

}
