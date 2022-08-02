package bje.menu;

import bje.Main_bje;
import mini.util.InputUtil;

public class Menu {

	public int showMenu() {
		
		if(Main_bje.loginMember != null) {
			//로그인 상태
			System.out.println(Main_bje.loginMember.getNick() + " 님 환영합니다.");
			System.out.println("3. 게시판글 작성");
			System.out.println("4. 게시글 목록 조회");;
		}else {
			//로그인 X
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 게시판글 작성");
			System.out.println("4. 게시글 목록 조회");
		}
		
		System.out.println("9. 프로그램 종료");
		
		return InputUtil.getInt();	//사용자가 숫자말고 다른거 입력할 시 조치방법 작성필요
	}//showMenu
	
	/*
	 * 게시판 상세조회 관련 메뉴
	 */
	public int showBoardDetailMenu() {
		System.out.println("조회할 글 번호 (0번은 메인메뉴) : ");
		return InputUtil.getInt();
	}
	
	
	
	
	
	
	
}//class




















