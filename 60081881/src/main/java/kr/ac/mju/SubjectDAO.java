package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SubjectDAO {
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
	public ArrayList<Course> read(String id) throws SQLException {
		ArrayList<Course> list = new ArrayList<Course>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		connection = getConnection();
		statement = connection.prepareStatement("select * from subject where pid = ?");
		statement.setString(1, id);
		resultSet = statement.executeQuery();
		
		while(resultSet.next()){
			String cnum = resultSet.getString("coursenum");
			String pid = resultSet.getString("pid");
			String cname = resultSet.getString("coursename");
			int y = resultSet.getInt("year");
			int g = resultSet.getInt("grade");
			int l = resultSet.getInt("limit");
			int c = resultSet.getInt("credit");

			Course course = new Course(cnum, pid, cname, y, g, l, c);
			
			list.add(course);
		}
		
		closeConnection(connection, statement, resultSet);
		
		return list;
	}
	
	public void write(String id, String cnum, String score) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		connection = getConnection();
		statement = connection.prepareStatement("update score set score.score = ? where id=? and coursenum = ?;");
		statement.setString(1, score);
		statement.setString(2, id);
		statement.setString(3, cnum);
		statement.execute();
		
		closeConnection(connection, statement, resultSet);
	}
}
