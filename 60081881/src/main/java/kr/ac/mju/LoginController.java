package kr.ac.mju;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private LoginService service;

	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request)
			throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");

		ModelAndView mav = service.login(userID, userPassword);
		request.getSession().setAttribute("userSession",
				mav.getModel().get("userSession"));
		
		return mav;
	}

	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.GET)
	public ModelAndView relogin(HttpServletRequest request)
			throws UnsupportedEncodingException, FileNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		User user = (User) request.getSession().getAttribute("userSession");
		String path = User.class.getResource("").getPath();
		if (user.getType().equals("교수")) {
			CourseDAO cdao = new CourseDAO();
			Course course;
			Scanner sc = new Scanner(new File(path
					+ "..\\..\\..\\model\\courseData.txt"));
			ArrayList<Course> courseList = cdao.read();
			
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
		mav.setViewName("sugang");
		return mav;
	}

	@RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		request.getSession().removeAttribute("userSession");

		return "redirect:/";

	}
	
	@RequestMapping(value = "/loginController/register.do", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("register");
		return mav;

	}
	@RequestMapping(value = "/loginController/register.do", method = RequestMethod.POST)
	public ModelAndView register_submit(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {
		request.setCharacterEncoding("utf-8");
		
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userType = request.getParameter("radio");
		ModelAndView mav;
		mav=service.register(userID, userPassword, userName, userType);
		
		return mav;

	}
}
