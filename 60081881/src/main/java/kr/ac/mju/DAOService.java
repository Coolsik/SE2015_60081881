package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class DAOService {
	private final static String URL = "jdbc:mysql://localhost:3306/sogong";
	private final static String ID = "sogong";
	private final static String PASSWORD = "mju12345";
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	
	public void closeConnection(Connection connection,
			PreparedStatement statement, ResultSet resultSet)
			throws SQLException {
		if (connection == null) {
			return;
		} else {
			if (connection != null)
				connection.close();
			if (statement != null)
				statement.close();
			if (resultSet != null)
				resultSet.close();
		}
	}
}