package mini.main;

import krw.notificationboard.NotiController;
import krw.qnaboard.QnaController;
import mini.member.MemberController;
import mini.member.MemberVo;
import mini.menu.Menu;
import sar.Ad_Board.Adandoned;
import sar.Util.AdVo;


public class Main {

	public static MemberVo loginMember;
	public static AdVo selected;

	public static void main(String[] args) {

		System.out.println("대충.. 애니멀어지지마 메인 화면..");
		System.out.println("===== 환영합니다 =====");

		// 메뉴 객체 생성
		Menu menu = new Menu();

		// 로그인 전 메뉴

		while (true) {

			int input = menu.showMenu();

			switch (input) {

			case 1:
				if (loginMember == null) {
					//로그인
					new MemberController().login();
				} else {
					//로그아웃
					loginMember = null;
					System.out.println("정상적으로 로그아웃 되었습니다..!");
				}
				break;
			case 2:
				if (loginMember == null) {
					//회원가입
					new MemberController().join();
				} else {
					//마이페이지
					new MemberController().myPage();
				}
				break;

			case 3:
				if (loginMember == null) {
					new MemberController().join();
				} else {
					try {
						new Adandoned().list();
						menu.showMenu1();
						menu.showMenu2();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				break;
			case 4:

				break;

			case 5:
				
				break;

			case 6:
//				재은님 - 커뮤니티
				break;
			case 7:
				new NotiController().handleNotiMenu();
				// TODO 공지 수정 및 삭제(물론 권한은 관리자만)
				break;
			case 8:
				new QnaController().handleQnaMenu();
				// TODO 질문 글 들어가서 답변하기(답변 할 때 정해진 포멧)
				break;
			case 9:
				System.out.println("시스템을 종료 합니다...!");
				return;
			case 0:
				// TODO 관리자할까말까();
				System.out.println("잘못 입력 하셨군요..!!");
				break;
			default:
				System.out.println("잘못 입력 하셨군요..!!");
				break;
			}
		}
	}
}
