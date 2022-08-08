package mini.main;

import bje.community_board.BoardController;
import bje.community_board.BoardVo;
import krw.notificationboard.NotiController;
import krw.qnaboard.QnaController;
import lcs.atc.ATCController;
import lcs.menu.LcsMenu;
import lcs.ps.PSController;
import mini.member.MemberController;
import mini.member.MemberVo;
import mini.menu.Menu;
import sar.Ad_Board.Adandoned;
import sar.Util.AdVo;

public class Main {

	public static MemberVo loginMember;
	public static AdVo selected;
	public static BoardVo boardvovo;

	public static void main(String[] args) {

		// 메뉴 객체 생성
		Menu menu = new Menu();

		// 로그인 전 메뉴

		while (true) {

			int input = menu.showMenu();

			switch (input) {

			case 1:
				if (loginMember == null) {
					new MemberController().login();
				} else {
					loginMember = null;
					System.out.println("정상적으로 로그아웃 되었습니다..!\n");
				}
				break;

			case 2:
				if (loginMember == null) {
					new MemberController().join();
				} else {
					new MemberController().myPage();
				}
				break;

			case 3:
				new Adandoned().list();
				menu.showMenu1();
				menu.showMenu2();

				break;

			case 4:

				/* 동물문제 & 해결 보여준다 */
				while (true) {

					int gotoMain = new PSController().showPSList();

					if (gotoMain == -1) {
						break;
					}

					// 문제행동을 고칠 수 있는 보호소를 보여주는지 물어본다.
					String connect = new PSController().connectATC();

					// Y라고 하면 동물훈련소 메소드 그대로 실행
					if (connect.equalsIgnoreCase("Y")) {

						new ATCController().sum();
						break;
					} else {
						System.out.println("문제행동으로 돌아갑니다.");
					}
				}
				break;

			case 5:
				// 동물 보호소를 전체볼래? 지역별로 볼래?
				int selectATCMenu = new LcsMenu().showATCSelectMenu();

				// 동물보호소 전체를 보여준다.
				if (selectATCMenu == 1) {
					new ATCController().showATCList();
				}

				// 지역별 동물 보호소를 보여준다.
				else if (selectATCMenu == 2) {

					int gotoMain = new ATCController().showCityATCList();
					if (gotoMain == -1) {
						break;
					}
				} else {
					System.out.println();
					System.out.println("메인메뉴로 돌아갑니다.");
					continue;
				}
				break;

			case 6:
				BoardController bc = new BoardController();
				
				while (true) {
					// 커뮤니티 리스트
					bc.showList();
					// 리스트아래 메뉴출력
					new Menu().showMenu6();

					if (new Menu().returnMain() == 1) {
						break;
					} else {
						bc.showList();
					}

				} // while
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
				System.out.println("잘못 입력 하셨군요..!!\n");
				break;

			default:
				System.out.println("잘못 입력 하셨군요..!!\n");
				break;
			}
		}
	}
}
