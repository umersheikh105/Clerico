package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBConnection {
	private static DBConnection handler = null;
	
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/clericoproject";
	private Statement statement;

	private DBConnection() {
		createConnection();
	}
	
	public static DBConnection getInstance() {
		if(handler==null) {
			handler = new DBConnection();
		}
		return handler;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void createConnection() {
		try {
			connection = DriverManager.getConnection(url, "root", "mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return connection;
	}

	public ResultSet executeQuery(String query) {
		ResultSet result;
		try {
			// connection = this.getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("An exception occurred at DBConnection.executeQuery " + e.getLocalizedMessage());
			return null;
		} finally {
		}
		return result;
	}

	// this executes an action
	public boolean executeAction(String str) {
		try {
			// connection = this.getConnection();
			statement = connection.createStatement();
			statement.execute(str);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
			System.out.println("An exception occured at DBConnection.executeAction " + e.getLocalizedMessage());
			return false;
		} finally {
		}
	}
}