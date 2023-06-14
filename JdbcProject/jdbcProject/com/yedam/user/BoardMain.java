package jdbcProject.com.yedam.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDao dao = new BoardDao();
		int menuNo = 0;
		UserDao userDao = new UserDao();
		BoardProc proc = new BoardProc();
		//로그인 기능, 아이디&비번.
		proc.loginCheck();

		loop: while (true) {
			System.out.println("1.글등록  2.삭제  3.글 내용수정 4.글목록 보기 5.상세보기 6.종료.");
			menuNo = Integer.parseInt(sc.nextLine());

			if (menuNo == 1) {
				System.out.println("글 제목을 입력해주세요.");
				String title = sc.nextLine();
				System.out.println("글 내용을 입력해주세요.");
				String cont = sc.nextLine();
				System.out.println("글 작성자를 입력해주세요.");
				String writer = sc.nextLine();
				BoardVO vo = new BoardVO();
				vo.setBrdTitle(title);
				vo.setBrdContent(cont);
				vo.setBrdWriter(writer);
				if (dao.write(vo)) {
					System.out.println("정상적으로 등록되었습니다.");
				} else {
					System.out.println("등록을 실패했습니다.");
				}

			} else if (menuNo == 2) {
				System.out.println("삭제할 글의 번호를 입력해주세요.");
				int brdNo = Integer.parseInt(sc.nextLine());

				if (dao.delete(brdNo)) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}

			} else if (menuNo == 3) {
				System.out.println("수정할 글의 번호를 입력해주세요.");
				int brdNo = Integer.parseInt(sc.nextLine());
				System.out.println("수정할 글의 내용을 입력해주세요.");
				String newCon = sc.nextLine();

				if (dao.reWrite(brdNo, newCon)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}

			} else if (menuNo == 4) {
				List<BoardVO> list = new ArrayList<>();

				list = dao.showBoard();

				if (list != null) {
					System.out.println("글번호\t|\t제목");
					for (BoardVO boards : list) {
						int tmpNo = boards.getBrdNo();
						String tmpTitle = boards.getBrdTitle();
						System.out.println(tmpNo + "\t|\t" + tmpTitle);

					}
				} else {
					System.out.println("글 목록이 없습니다.");
				}

			} else if (menuNo == 5) {
				System.out.println("조회할 글의 번호를 입력해주세요.");
				int brdNo = Integer.parseInt(sc.nextLine());
				BoardVO board = new BoardVO();
				
				board = dao.showContent(brdNo);
				if(board != null) {
					System.out.println(board.toString());
				}else {
					System.out.println("조회한 글이 없습니다.");
				}
				

			} else if (menuNo == 6) {
				System.out.println("종료합니다.");
				break loop;
			}

		}
		System.out.println("end.");
	}
}
