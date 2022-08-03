package mini.menu;

import mini.util.InputUtil;

public class Menu {

	public int ShowMenu() {

		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("7. 공지사항 게시판");
		System.out.println("8. QnA 게시판");
		
		System.out.println("9. 프로그램 종료");

		int input = InputUtil.getInt();

		return input;

	}
	
	
	
	
	
	
	

	
	
	//량우 공지 메뉴 메소드....
	public int ShowNotiMenu() {

		int input = 0;
		while (true) {

			System.out.println("1. 공지사항 게시글 보기");
			System.out.println("2. 공지사항 작성");

			input = InputUtil.getInt();

			if (1 == input || 2 == input) {
				break;
			}
			else {
				System.out.println("잘못 입력 했다..!");
			}
			
		}
		return input;
	}

	public int ShowQnaMenu() {

		System.out.println("1. QnA 게시글 보기");
		System.out.println("2. QnA 게시글 작성");
		System.out.println("3. 내 문의 내역 보기");

		int input = InputUtil.getInt();

		return input;
	}

}
