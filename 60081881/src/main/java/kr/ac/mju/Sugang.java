package kr.ac.mju;

public class Sugang {
	private String stuID;
	private int cNum;
	private int sNum;
	private String sName;
	private String pName;
	private int score;
	
	public Sugang(String sid, int cn, int sn, String subname, String pname, int sco){
		stuID = sid;
		cNum = cn;
		sNum = sn;
		sName = subname;
		pName = pname;
		score = sco;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
