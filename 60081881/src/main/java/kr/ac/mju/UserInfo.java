package kr.ac.mju;

import java.util.ArrayList;

public class UserInfo extends User{
	private String password;
	ArrayList<UserInfo> userList;
	public UserInfo(){
		userList = new ArrayList<UserInfo>();
	}
	public void addUser(String id, String password, String name, String type){
		UserInfo user = new UserInfo();
		user.setID(id);
		user.setName(name);
		user.setType(type);
		user.setPassword(password);
		
		userList.add(user);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<UserInfo> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<UserInfo> userList) {
		this.userList = userList;
	}
}
