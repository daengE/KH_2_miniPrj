package mini.menu;

import mini.main.Main;
import mini.util.InputUtil;

public class Menu {

	public int showMenu() {

		if (Main.loginMember == null) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("7. 공지사항 게시판");
			System.out.println("8. QnA 게시판");
			System.out.println("9. 프로그램 종료");
		} else {
			System.out.println("1. 로그아웃");
			System.out.println("2. 마이페이지");
			System.out.println("7. 공지사항 게시판");
			System.out.println("8. QnA 게시판");
			System.out.println("9. 프로그램 종료");
		}

		int input = InputUtil.getInt();
		return input;

	}

	public int showNotiMenu() {

		int input = 0;
		while (true) {

			System.out.println("1. 공지사항 게시글 보기");
			System.out.println("2. 공지사항 작성");

			input = InputUtil.getInt();

			if (1 == input || 2 == input) {
				break;
			} else {
				System.out.println("잘못 입력 하셨습니다..!");
			}

		}
		return input;
	}

	public int showQnaMenu() {

		int input = 0;
		while (true) {

			System.out.println("1. QnA 게시글 보기");
			System.out.println("2. QnA 게시글 작성");
			System.out.println("3. 내 문의 내역 보기");

			input = InputUtil.getInt();

			if (1 == input || 2 == input || 3 == input) {
				break;
			} else {
				System.out.println("잘못 입력 하셨습니다..!");
			}
		}
		return input;
	}
	
	public int showNotiContentMenu() {
		System.out.println("조회할 글 번호(0번은 메인메뉴) : ");
		
		return InputUtil.getInt();
	}

	public int showMyPageMenu() {
		
		int input = 0;
		
		while (true) {
			System.out.println("1. 내 정보 보기");
			System.out.println("2. 내가 작성한 글");
			System.out.println("3. 나의 관심 글");
			System.out.println("4. 내 반려동물 보기");
			System.out.println("5. 탈퇴하기");
			
			input = InputUtil.getInt();

			if (1 == input || 2 == input || 3 == input || 4 == input || 5 == input) {
				break;
			} else {
				System.out.println("잘못 입력 하셨습니다..!");
			}
		}
		
		return input;
		
	}

}
