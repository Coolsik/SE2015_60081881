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
public class SubjectController {
private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
	
	@RequestMapping(value = "/SubjectController/chooseSubject", method = RequestMethod.GET)
	public ModelAndView choose(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("create_subject");
		String path = User.class.getResource("").getPath();
		SubjectDAO sdao = new SubjectDAO();
		Scanner sc = new Scanner(new File(path+ "..\\..\\..\\model\\subjectData.txt"));
		Subject sub;
		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		mav.addObject("subjectArray", subjectList);
		return mav;
	}
	@RequestMapping(value = "/SubjectController/makeSubject", method = RequestMethod.POST)
	public ModelAndView make(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		
			
		User user = (User) request.getSession().getAttribute("userSession");
		
		String courseNumber=request.getParameter("courseNum");
		String courseName=request.getParameter("courseName");
		String year=request.getParameter("year");
		String grade=request.getParameter("grade");
		String limit=request.getParameter("limit");
		String credit=request.getParameter("credit");
		
		CourseDAO cdao = new CourseDAO();
		Course course;
		System.out.println(user.getID());
		course = new Course(courseNumber, user.getID(), courseName, Integer.parseInt(year),Integer.parseInt(grade),Integer.parseInt(limit),Integer.parseInt(credit));
		cdao.write(course);
		
		ModelAndView mav = new ModelAndView("sugang");
		
		mav.addObject("errorMessage", "makeSuccess");
		
		return mav;
	}
	@RequestMapping(value = "/SubjectController/submitScore", method = RequestMethod.GET)
	public ModelAndView submitScore(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("showLecture");
		
		User user = (User) request.getSession().getAttribute("userSession");
		SubjectDAO sdao = new SubjectDAO();
		ArrayList<Course> list=sdao.read(user.getID());
		
		mav.addObject("courseArray", list);
		return mav;
	}
	
	@RequestMapping(value = "/SubjectController/submitScore", method = RequestMethod.POST)
	public ModelAndView submitstuScore(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("giveScore");
		
		String score=request.getParameter("score");
		String cnum = request.getParameter("cnum");
		String id = request.getParameter("id");
		
		System.out.println(id+" "+cnum+" "+score);
		
		SubjectDAO dao = new SubjectDAO();
		dao.write(id, cnum, score);
		
		User user = (User) request.getSession().getAttribute("userSession");
		
		SugangDAO sdao = new SugangDAO();
		ArrayList<Course> list=sdao.scoreRead(cnum);
		
		
		mav.addObject("courseArray", list);
		return mav;
	}
	@RequestMapping(value = "/SubjectController/giveScore", method = RequestMethod.POST)
	public ModelAndView giveScore(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("giveScore");
		User user = (User) request.getSession().getAttribute("userSession");
		SugangDAO sdao = new SugangDAO();
		String cnum = request.getParameter("courseNumber");
		ArrayList<Course> list=sdao.scoreRead(cnum);
		
		mav.addObject("courseArray", list);
		return mav;
	}
	@RequestMapping(value = "/SubjectController/checkScore", method = RequestMethod.GET)
	public ModelAndView checkScore(HttpServletRequest request) throws UnsupportedEncodingException, FileNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView("check_score");
		User user = (User) request.getSession().getAttribute("userSession");
		SugangDAO sdao = new SugangDAO();
		ArrayList<Course> list=sdao.read(user.getID());
		
		mav.addObject("courseArray", list);
		return mav;
	}
	
	
}
