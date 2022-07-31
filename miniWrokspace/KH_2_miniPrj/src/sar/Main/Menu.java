package sar.Main;

import sar.Util.JDBCTemplate_ad;

public class Menu {

	public int showMenu() {
		if(Main.loginMember != null) {
			System.out.println(Main.loginMember.getNick() + " 님 환영합니다");
			System.out.println("3. 게시글 작성");
			System.out.println("4. 게시글 목록 조회");
		}else {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 게시글 작성");
			System.out.println("4. 게시글 목록 조회");
		}
		return JDBCTemplate_ad.getInt();	
	}
}
