import java.util.Vector;


public class Lecture {
	private String name;
	private Vector<Student> m_stuArray;
	public Lecture(String name){
		this.name = name;
		m_stuArray = new Vector<Student>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setStudent(Student s){
		m_stuArray.add(s);
	}
	public void showStudent(){
		for(int i=0; i<m_stuArray.size(); i++){
			Student s = m_stuArray.elementAt(i);
			System.out.println(s.getName());
		}
	}
}
