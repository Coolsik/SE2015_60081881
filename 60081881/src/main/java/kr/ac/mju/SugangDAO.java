package kr.ac.mju;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SugangDAO {
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
		statement = connection.prepareStatement("select subject.coursenum, pid, coursename, pid, year, grade, credit, subject.limit,score from subject, score where id=? and subject.coursenum=score.coursenum;");
		statement.setString(1, id);
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
			String score = resultSet.getString("score");
			
			Course course = new Course(cnum, pid, cname, y, g, l, c);
			course.setScore(score);
			
			list.add(course);
		}
		
		closeConnection(connection, statement, resultSet);
		
		return list;
	}
	
	public ArrayList<Course> scoreRead(String cnum) throws SQLException {
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
		statement = connection.prepareStatement("select subject.coursenum, pid, id, coursename, pid, year, grade, credit, subject.limit,score from subject, score where score.coursenum=? and subject.coursenum=score.coursenum;");
		statement.setString(1, cnum);
		resultSet = statement.executeQuery();
		
		ArrayList<Course> list = new ArrayList<Course>();
		
		while(resultSet.next()){
			String pid = resultSet.getString("pid");
			String id = resultSet.getString("id");
			String cname = resultSet.getString("coursename");
			int y = resultSet.getInt("year");
			int g = resultSet.getInt("grade");
			int l = resultSet.getInt("limit");
			int c = resultSet.getInt("credit");
			String score = resultSet.getString("score");
			
			Course course = new Course(cnum, pid, cname, y, g, l, c);
			course.setScore(score);
			course.setId(id);
			list.add(course);
		}
		
		closeConnection(connection, statement, resultSet);
		
		return list;
	}
	

	public void write(String cnum, String id) throws SQLException {
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
		statement = connection.prepareStatement("INSERT INTO score VALUES(?, ?, ?)");
		statement.setString(1, cnum);
		statement.setString(2, id);
		statement.setString(3, "unwritten");
		statement.execute();
		
		closeConnection(connection, statement, resultSet);
	}
	public void rewrite() {
		try {
			String path = User.class.getResource("").getPath();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(path
							+ "..\\..\\..\\model\\sugangData.txt"),
					"UTF8"));
			writer.close();
		} catch (Exception e) {

		}
	}
}
