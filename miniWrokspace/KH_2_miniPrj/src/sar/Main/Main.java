package sar.Main;

import sar.Ad_Board.Adandoned;
import sar.Member.MemberController_ad;
import sar.Member.MemberVo_ad;
import sar.Util.JDBCTemplate_ad;

public class Main {

	public static MemberVo_ad loginMember;
	
	public static void main(String[] args) {
		
//		Menu menu = new Menu();
		System.out.println("번호를 선택하세요");
		
		while(true) {
//			int input = menu.showMenu();
			int input= JDBCTemplate_ad.sc.nextInt();

			switch(input) {
			case 1 : 
				new MemberController_ad().login();
				break;
			case 2 :
				new MemberController_ad().join();
				break;
			case 3 : 
			System.out.println("====[유기동물 게시판]====");
			System.out.println("====[전체 글 조회]====");

				try {
					new Adandoned().list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
		
					
			}//switch
			
		}//while
	}

}
