package kr.ac.mju;

public class Const {
	public enum Msg {
		SUCCESS("로그인에 성공하였습니다."),
		ID("존재하지 않는 아이디 입니다."),
		PASSWORD("비밀번호가 틀렸습니다.");
		
		private String errorStr;
		private Msg(String errorStr) {
			this.errorStr = errorStr;
		}
		public String getErrorStr() {return this.errorStr;}
	}
}
