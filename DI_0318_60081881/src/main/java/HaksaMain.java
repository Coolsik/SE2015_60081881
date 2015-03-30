import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public abstract class HaksaMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Professor professor = new Professor("choi");
		//Lecture lecture1 = new Lecture("소프트웨어 공학");
		// 학생을 Lecture에 등록시키는 것을 만들고 출력한다.
		ApplicationContext factory = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		Professor professor = (Professor)factory.getBean("professor");
		Lecture lecture2 = (Lecture)factory.getBean("lecture2");
		Student student = (Student)factory.getBean("student");
		professor.addLecture(lecture2);
		professor.showLecture();
		
		lecture2.setStudent(student);
		lecture2.showStudent();
		
	}
}
