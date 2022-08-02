package mini.main;

import krw.notificationboard.NotiController;
import mini.member.MemberController;
import mini.member.MemberVo;
import mini.menu.Menu;

public class Main {

	public static MemberVo loginMember;

	public static void main(String[] args) {

		System.out.println("대충.. 애니멀어지지마 메인 화면..");
		System.out.println("===== 환영합니다 =====");

		// 메뉴 보여주기

		Menu menu = new Menu();

		while (true) {

			int input = menu.ShowMenu();

			switch (input) {

			case 1:
				new MemberController().login();
				break;
			case 2:
//				회원가입();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				new NotiController().handleNotiMenu();
				break;
			case 8:
//				QnA게시판();
				break;
			case 9:
				System.out.println("시스템을 종료 합니다...!");
				return;
			default:
				System.out.println("잘못 입력 하셨군요 !");
				break;
			}

		}

	}

}
