package sar.Main;

import mini.util.InputUtil;

public class Menu {

	public int showMenu() {
		
		if(mini.main.Main.loginMember != null) {
			//로그인 상태
			System.out.println(mini.main.Main.loginMember.getNick() + " 님 환영합니다.");
			System.out.println("3. 유기동물 게시판 조회");
		}else {
			//로그인 X
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 유기동물 게시판 조회");
		}
		
		return InputUtil.getInt();	//사용자가 숫자말고 다른거 입력할 시 조치방법 작성필요
	}//showMenu
		
	public int showMenu1() {
		
		System.out.println("\n\n0. 지역별 검색");
		System.out.print("==== 상세내용을 보시려면 글번호를 선택하세요 ====" );
		System.out.print( " : " );
		return InputUtil.getInt();	
	}

		
	
	public int showMenu2() {
		
		System.out.println("\n\n0. 지역별 검색");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 해당 동물 입양하기");
		return InputUtil.getInt();	
	}
	
	
}
