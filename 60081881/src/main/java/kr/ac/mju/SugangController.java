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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SugangController {
private static final Logger logger = LoggerFactory.getLogger(SugangController.class);
	
	@RequestMapping(value = "/SugangController/chooseSubject", method = RequestMethod.GET)
	public ModelAndView choose(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("choose_sugang");
		String path = User.class.getResource("").getPath();
		CourseDAO cdao = new CourseDAO();
		ArrayList<Course> courseList = cdao.read();

		mav.addObject("courseArray", courseList);
		return mav;
	}
	
	@RequestMapping(value = "/SugangController/submitSubject", method = RequestMethod.POST)
	public ModelAndView make(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("sugang");
		String temp = request.getParameter("radio");
		
		User user = (User) request.getSession().getAttribute("userSession");
		
		SugangDAO sdao = new SugangDAO();
		
		sdao.write(temp, user.getID());
		
		mav.addObject("errorMessage", "수강신청 성공!");
		
		return mav;
	}
	
	@RequestMapping(value = "/SugangController/deleteSubject", method = RequestMethod.POST)
	public ModelAndView delete(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("sugang");
		String temp = request.getParameter("radio");
		
		int cnum = Integer.parseInt(temp);
		String path = User.class.getResource("").getPath();
		
		User user = (User) request.getSession().getAttribute("userSession");
		
		SugangDAO sudao = new SugangDAO();
		Sugang sugang;
		ArrayList<Sugang> sugangList = new ArrayList<Sugang>();
		int cnt=0;
		Scanner sc = new Scanner(new File(path+ "..\\..\\..\\model\\sugangData.txt"));
		sudao.rewrite();
		sc.close();
		
		
		mav.addObject("errorMessage", "수강과목 삭제 성공!");
		
		return mav;
	}
	
}