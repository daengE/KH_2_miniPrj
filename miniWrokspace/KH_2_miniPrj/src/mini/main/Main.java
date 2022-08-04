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

			int input = menu.showMenu();

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
					new MemberController().join();
				}else {
					//TODO 마이페이지();
					new MemberController().myPage();
				}
				break;
			case 3:
//				애림님 - 유기동물
				break;
			case 4:
//				찬선님 - 동물훈련소 조회 및 신청
				break;
			case 5:
//				찬선님 - 동물훈련팁
				break;
			case 6:
//				재은님 - 커뮤니티
				break;
			case 7:
				new NotiController().handleNotiMenu();
				//TODO 공지 삭제(게시글 리스트에서), 공지 수정(게시글 들어가서)
				break;
			case 8:
				new QnaController().handleQnaMenu();
				//TODO 질문 글 들어가서 답변하기(답변 할 때 정해진 포멧)
				break;
			case 9:
				System.out.println("시스템을 종료 합니다...!");
				return;
			case 0:
				//TODO 관리자할까말까();
				System.out.println("잘못 입력 하셨군요..!!");
				break;
			default:
				System.out.println("잘못 입력 하셨군요..!!");
				break;
			}
		}
	}
}
