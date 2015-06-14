package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

public class LoginInfo {
	@Autowired
	LoginService service;
     public LoginInfo() {
	}
 	private final static String URL = "jdbc:mysql://localhost:3306/sogong";
 	private final static String ID = "sogong";
 	private final static String PASSWORD = "mju12345";
 	
 	public Connection getConnection() throws SQLException{
 		return DriverManager.getConnection(URL, ID, PASSWORD);
 	}
	public ModelAndView login(String userID, String userPassword) throws SQLException {
		// TODO Auto-generated method stub
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
		
		statement = connection.prepareStatement("select * from user where id = ?");
		statement.setString(1, userID);
		resultSet = statement.executeQuery();
		String match="";

		
		UserDAO userDAO = new UserDAO();
		UserInfo ui = userDAO.read();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		
		if(resultSet.next()){
			match = resultSet.getString("pwd");
		}else{
			mav.addObject("errorMessage", Const.Msg.ID.getErrorStr());
			return mav;
		}
		if (userPassword.equals(match)) {
			mav.addObject("errorMessage", Const.Msg.SUCCESS.getErrorStr());
			mav.setViewName("sugang");
			User user = new User();
			user.setID(userID);
			user.setName(resultSet.getString("name"));
			user.setType(resultSet.getString("type"));

			mav.addObject("userSession", user);

			return mav;
		} else {
			mav.addObject("errorMessage", Const.Msg.PASSWORD.getErrorStr());
		}
		
		return mav;
	}
     
}
