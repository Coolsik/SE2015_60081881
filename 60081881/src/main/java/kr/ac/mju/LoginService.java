package kr.ac.mju;

import java.beans.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class LoginService {
	private final static String URL = "jdbc:mysql://localhost:3306/sogong";
	private final static String ID = "sogong";
	private final static String PASSWORD = "mju12345";
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	
	private void closeConnection(Connection connection,
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
	
	public ModelAndView login(String userID, String userPassword)
			throws FileNotFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		/*Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from user";
		User user = null;
		
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		while(resultSet.next()){
			String id = resultSet.getString("id");
			String password = resultSet.getString("password");
			
			if(id.equals(userID) && password.equals(userPassword)){
				user = new User();
				user.setID(id);
				user.setName(resultSet.getString("name"));
				user.setPassword(password);
				closeConnection(connection, statement, resultSet);
				return user;
			}
		}
		closeConnection(connection, statement, resultSet);
		return null;
		*/
		LoginInfo info = new LoginInfo();
		ModelAndView mav;
		mav = info.login(userID, userPassword);

		if (mav.getModel().get("errorMessage")
				.equals(Const.Msg.SUCCESS.getErrorStr())) {
			String path = User.class.getResource("").getPath();
			System.out.println("path : "+ path);
			User user = (User) mav.getModel().get("userSession");
			if (user.getType().equals("교수")) {
				CourseDAO cdao = new CourseDAO();
				Scanner sc = new Scanner(new File(path
						+ "..\\..\\..\\model\\courseData.txt"));
				ArrayList<Course> courseList = cdao.read();

				/*for(Course course : courseList){
					if (course.getProfId().equals(user.getID())) {
						courseList.add(course);
					}
				}*/
				sc.close();
				mav.addObject("courseArray", courseList);
			}
			else if(user.getType().equals("학생")){
				SugangDAO sdao = new SugangDAO();
				Sugang sugang;
				Scanner sc = new Scanner(new File(path
						+ "..\\..\\..\\model\\sugangData.txt"));
				ArrayList<Sugang> sugangList = new ArrayList<Sugang>();
				
				sc.close();
				mav.addObject("sugangArray", sugangList);
			}
		}
		return mav;
	}
	public ModelAndView register(String userID, String userPassword, String userName, String type) throws SQLException{
		ModelAndView mav = new ModelAndView("home");
		
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
		
		statement = connection.prepareStatement("INSERT INTO USER VALUES(?, ?, ?, ?)");
		statement.setString(1, userID);
		statement.setString(2, userPassword);
		statement.setString(3, userName);
		statement.setString(4, type);
		statement.execute();
		
		mav.addObject("errorMessage", "가입완료");
		
		return mav;
	}
}
