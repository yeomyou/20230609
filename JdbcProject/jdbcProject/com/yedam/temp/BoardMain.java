package jdbcProject.com.yedam.temp;

import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int choice;
		BoardProc proc = new BoardProc();
		// 로그인 기능. 아이디&비번.

		proc.loginCheck();

		while (true) {
			try {
				System.out.println("1.추가 2.삭제 3.수정 4.조회 5.목록 6.종료");
				System.out.print("선택> ");
				// 사용자선택 메뉴.
				choice = scn.nextInt();
				scn.nextLine();
				// 처리작업.
				switch (choice) {
				case Menu.ADD:
					proc.addBoard();
					break;
				case Menu.DEL:
					proc.delBoard();
					break;
				case Menu.EDIT:
					proc.editBoard();
					break;
				case Menu.GET:
					proc.getBoard();
					break;
				case Menu.LIST:
					proc.listBoard();
					break;
				case Menu.EXIT:
					proc.endBoard();
				}
			} catch (ExitException e) {
				e.getMsg();
				break;
			}
		}
		System.out.println("end of prog.");
		scn.close();
	} // end of main().
}
