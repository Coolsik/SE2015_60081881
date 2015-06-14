package kr.ac.mju;

public class Course {
	private String courseNumber;
	private String profId;
	private String courseName;
	private int year;
	private int grade;
	private int limit;
	private int credit;
	private String score;
	private String id;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Course(String cnum, String pid, String cname, int y, int g, int l, int c){
		courseNumber = cnum;
		profId = pid;
		courseName = cname;
		year = y;
		grade = g;
		limit = l;
		credit = c;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getProfId() {
		return profId;
	}

	public void setProfId(String profId) {
		this.profId = profId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
}
