package bje.menu;

import mini.main.Main;
import mini.util.InputUtil;

public class Menu {

	public int showMenu6() {

		if (Main.loginMember != null) {
			// 로그인 상태
			System.out.println(Main.loginMember.getNick() + " 님 환영합니다.");
			System.out.println("1. 게시판글 작성");
			System.out.println("2. 게시글 목록 조회");
			;
		} else {
			// 로그인 X
			System.out.println("로그인 먼저 해주세요");
			// 다음 진행 하면 안되니까 return
		}

		System.out.println("9. 프로그램 종료");

		return InputUtil.getInt(); // 사용자가 숫자말고 다른거 입력할 시 조치방법 작성필요
	}// showMenu6

	/*
	 * 게시판 상세조회 관련 메뉴
	 */
	public int showBoardDetailMenu() {
//      System.out.println("조회할 글 번호 (0번은 메인메뉴) : ");
		return InputUtil.getInt();
	}

	public int choiceBcommentMenu() {
		System.out.println("\n 댓글을 작성하시겠습니까?");
		System.out.println("1. 네 작성작하겠습니다.");
		System.out.println("2. 아니요 작성하지않겠습니다.");
		return InputUtil.getInt();
	}

	public String choiceBoardTag() {
		String tag = null;
		int tagNum = 0;
		boolean isFinish = true;
		System.out.print("\n어떤 태그의 글을 보고싶으십니까?");
		System.out.print("\n1. 후원요청 2. 자랑 3. 질문 4. 자유 5. 뉴스데스크");

		while (isFinish) {
			tagNum = InputUtil.getInt();
			if (tagNum == 1) {
				tag = "후원요청";
				isFinish = false;
			} else if (tagNum == 2) {
				tag = "자랑";
				isFinish = false;
			} else if (tagNum == 3) {
				tag = "질문";
				isFinish = false;
			} else if (tagNum == 4) {
				tag = "자유";
				isFinish = false;
			} else if (tagNum == 5) {
				tag = "뉴스데스크";
				isFinish = false;
			} else {
				System.out.println("잘못 입력 하셨습니다.");
			}

		}
		return tag;
	}

	public String writeMenu() {

		boolean isFinish = true;
		String tag = null;

		while (isFinish) {

			System.out.println("태그 : 1. 후원요청, 2. 자랑, 3. 질문, 4. 자유, 5. 뉴스데스크");
			int intTag = InputUtil.getInt();

			if (intTag == 1) {
				tag = "후원요청";
				isFinish = false;

			} else if (intTag == 2) {
				tag = "자랑";
				isFinish = false;

			} else if (intTag == 3) {
				tag = "질문";
				isFinish = false;

			} else if (intTag == 4) {
				tag = "자유";
				isFinish = false;

			} else if (intTag == 5) {
				tag = "뉴스데스크";
				isFinish = false;

			} else {
				System.out.println("잘못 입력 하셨습니다.");

			}
		}
		return tag;
	}

}// class
