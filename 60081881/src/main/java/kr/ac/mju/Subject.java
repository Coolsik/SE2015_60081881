package kr.ac.mju;

public class Subject {
	private int subjectNumber;
	private String subjectName;
	private int subjectGrade;
	public Subject(int number, String name, int grade){
		subjectNumber = number;
		subjectName = name;
		subjectGrade = grade;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectGrade() {
		return subjectGrade;
	}
	public void setSubjectGrade(int subjectGrade) {
		this.subjectGrade = subjectGrade;
	}
	public int getSubjectNumber() {
		return subjectNumber;
	}
	public void setSubjectNumber(int subjectNumber) {
		this.subjectNumber = subjectNumber;
	}
}
