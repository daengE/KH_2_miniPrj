package sar.Main;

import bje.member.MemberController;
import mini.member.MemberVo;
import mini.menu.showMenu;
import mini.util.InputUtil;
import sar.Ad_Board.Adandoned;
import sar.Ad_Board.Adoption;
import sar.Member.MemberVo_ad;
import sar.Util.AdVo;
import sar.Util.JDBCTemplate_ad;

public class Main {

	public static MemberVo loginMember;
	
	public static void main(String[] args) {
		AdVo vo = null;
		Menu menu = new Menu();
	
		while(true) {
			int input = menu.showMenu();
//			int input= InputUtil.sc.nextInt();

			switch(input) {
			case 1:
				new MemberController().login();
				break;
			case 2:
				new MemberController().join();
				break;
			case 3 : 
				try {
					new Adandoned().list();
				} catch (Exception e) {
					System.out.println("유기동물 게시판 접속 오류!");
					e.printStackTrace();
				}
				
			}//switch
			
			int num = menu.showMenu1();
			
			if(num == 0) {
				System.out.println("\n\n==== 지역별 검색 ====");
				System.out.println(" 서울 | 경기도 | 경상도 | 전라도 | 제주도 | 충청도 | 강원도 ");
				try {
					new Adandoned().search();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				try {
					new Adandoned().detail(num);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
			
			int num2 = menu.showMenu2();
			
			switch(num2) {
			case 0 : 
				System.out.println("\n\n==== 지역별 검색 ====");
				System.out.println(" 서울 | 경기도 | 경상도 | 전라도 | 제주도 | 충청도 | 강원도 ");
				try {
					new Adandoned().search();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			case 1 : 
				try {
					new Adandoned().list();
				} catch (Exception e) {
					System.out.println("유기동물 게시판 접속 오류!");
					e.printStackTrace();
				}
//				continue;
				
			case 2 : 
				if(Main.loginMember != null) {
			System.out.println("먼저 로그인을 해주세요");}
				else {
					new Adoption().apply(no);
				}
			continue;
			
		}//while
		
		
	}
	}
}

