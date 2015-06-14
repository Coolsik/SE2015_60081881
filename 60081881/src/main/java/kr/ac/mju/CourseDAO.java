package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAO {
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
	public ArrayList<Course> read() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		connection = getConnection();
		statement = connection.prepareStatement("select * from subject;");
		resultSet = statement.executeQuery();
		
		ArrayList<Course> list = new ArrayList<Course>();
		
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
	public void write(Course c) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		connection = getConnection();
		statement = connection.prepareStatement("INSERT INTO subject VALUES(?, ?, ?, ?, ?, ?, ?)");
		statement.setString(1, c.getCourseNumber());
		statement.setString(2, c.getProfId());
		statement.setString(3, c.getCourseName());
		statement.setInt(4, c.getYear());
		statement.setInt(5, c.getGrade());
		statement.setInt(6, c.getLimit());
		statement.setInt(7, c.getCredit());
		statement.execute();
		
		closeConnection(connection, statement, resultSet);
	}
}
