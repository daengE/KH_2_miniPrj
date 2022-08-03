package mini.main;

import krw.notificationboard.NotiController;
import krw.qnaboard.QnaController;
import mini.member.MemberController;
import mini.member.MemberVo;
import mini.menu.Menu;

public class Main {

	public static MemberVo loginMember;

	public static void main(String[] args) {

		System.out.println("대충.. 애니멀어지지마 메인 화면..");
		System.out.println("===== 환영합니다 =====");

		// 메뉴 객체 생성
		Menu menu = new Menu();

		// 로그인 전 메뉴

		while (true) {

			int input = menu.ShowMenu();

			switch (input) {

			case 1:
				if (loginMember == null) {
					new MemberController().login();
				} else {
					loginMember = null;
					System.out.println("정상적으로 로그아웃 되었습니다..!");
				}
				break;
			case 2:
				if(loginMember == null) {
//					회원가입();
				}else {
//					마이페이지();
				}
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
				new QnaController().handleQnaMenu();
				break;
			case 9:
				System.out.println("시스템을 종료 합니다...!");
				return;
			case 0:
//				관리자할까말까();
				System.out.println("잘못 입력 하셨군요..!!");
				break;
			default:
				System.out.println("잘못 입력 하셨군요..!!");
				break;
			}
		}
	}
}
