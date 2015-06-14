package kr.ac.mju;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserDAO {
	private Scanner scanner;

	public UserInfo read() {
		try {
			String path = User.class.getResource("").getPath();
			scanner = new Scanner(new File(path+"..\\..\\..\\model\\userData.txt"));
			UserInfo ui = new UserInfo();
			while(scanner.hasNextLine()) {
				ui.addUser(scanner.next(), scanner.next(), scanner.next(), scanner.next());
			}
			return ui;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
