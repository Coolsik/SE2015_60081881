package kr.ac.mju;

public class User {
	private String ID;
	private String name;
	private String type;
	private String password;
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
}
