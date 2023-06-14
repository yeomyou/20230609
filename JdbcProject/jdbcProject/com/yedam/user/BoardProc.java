package jdbcProject.com.yedam.user;

import java.util.Scanner;

public class BoardProc {
	private static String menuErrMsg = "잘못된 값을 입력했습니다.";
	private BoardDao dao = BoardDao.getInstance();
	private UserDao uDao = new UserDao();
	private BoardVO brd;
	private Scanner sc = new Scanner(System.in);
	private String loginId;
	
	public void loginCheck() {
		
		String id = promptString("아이디를 입력");
		String pw = promptString("비밀번호를 입력");
		
		if(uDao.login(id, pw)) {
			loginId = id;
			return;
		}
		else {
			System.out.println(menuErrMsg);
			return;
		}
		
	}
	
	public 
}
