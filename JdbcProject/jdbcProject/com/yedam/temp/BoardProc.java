package jdbcProject.com.yedam.temp;

import java.util.List;
import java.util.Scanner;

import com.yedam.user.UserDao;

public class BoardProc {

	private static String menuErrMsg = "잘못된 값을 입력했습니다.";
	private BoardDao dao = BoardDao.getInstance();
	private UserDao uDao = new UserDao();
	private BoardVO brd;
	private Scanner scn = new Scanner(System.in);
	private String loginId;

	public void loginCheck() {
		while (true) {
			String id = promptString("아이디를 입력하세요");
			String pw = promptString("비밀번호를 입력하세요");

			if (uDao.login(id, pw)) {
				loginId = id;
				return;
			}
			System.out.println("입력정보를 확인하세요.");
		}
	}

	// 추가1.
	public void addBoard() {

		String title = promptString("제목을 입력하세요");
		String writer = promptString("작성자를 입력하세요");
		String content = promptString("내용을 입력하세요");

		brd = new BoardVO(title, writer, content);
		if (dao.insert(brd)) {
			prompt("정상처리.");
		} else {
			prompt("처리오류");
		}
	}

	// 삭제2.
	public void delBoard() {
		int no = promptInt("삭제할 번호를 입력하세요");
		if (dao.delete(no)) {
			prompt("정상처리.");
		} else {
			prompt("처리오류");
		}
	}

	// 수정3.
	public void editBoard() {
		int no = promptInt("수정할 번호를 입력하세요");
		String content = promptString("내용을 입력하세요");
		brd = new BoardVO(no, content);
		if (dao.update(brd)) {
			prompt("정상처리.");
		} else {
			prompt("처리오류");
		}
	}

	// 조회4.
	public void getBoard() {
		int no = promptInt("조회할 번호를 입력하세요");
		brd = dao.select(no);
		if (brd == null) {
			prompt("조회할 내용이 없습니다");
		} else {
			dao.updateCnt(no);
			prompt(brd.detailInfo());
		}
	}

	// 목록5.
	public void listBoard() {
		List<BoardVO> list = dao.list();
		if (list.size() == 0) {
			prompt("조회할 내용이 없습니다.");
			return;
		}
		for (BoardVO board : list) {
			prompt(board.briefInfo());
		}
	}

	// 종료6.
	public void endBoard() throws ExitException {
		throw new ExitException("프로그램을 종료합니다.");
	}

	// 출력기능.
	private void prompt(String msg) {
		System.out.println(msg);
	}

	// 메세지와 문자열 반환값.
	private String promptString(String msg) {
		System.out.print(msg + "> ");
		return scn.nextLine();
	}

	// 메세지와 int반환값.
	private int promptInt(String msg) {
		int result = 0;
		while (true) {
			try {
				System.out.print(msg + "> ");
				result = scn.nextInt();
				scn.nextLine();
				break;
			} catch (Exception e) {
				System.out.println(menuErrMsg);
				scn.nextLine();
			}
		}
		return result;
	}
}
