package jdbcProject.com.yedam;

import java.util.Scanner;

public class UserDao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		UserDao userdao = new UserDao();

		while (true) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.print("선택> ");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				System.out.print("id> ");
				String id = sc.nextLine();
				System.out.print("pw> ");
				String pw = sc.nextLine();
				System.out.print("name> ");
				String name = sc.nextLine();
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;

			}

		}
	}
}
