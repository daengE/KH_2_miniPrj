package sar.Main;

import sar.Ad_Board.Adandoned;
import sar.Member.MemberController_ad;
import sar.Member.MemberVo_ad;
import sar.Util.JDBCTemplate_ad;
import util.InputUtil;

public class Main {

	public static MemberVo_ad loginMember;
	
	public static void main(String[] args) {
		
//		Menu menu = new Menu();
		System.out.println("번호를 선택하세요");
		
		while(true) {
//			int input = menu.showMenu();
			int input= JDBCTemplate_ad.sc.nextInt();

			switch(input) {
			case 3 : 
			System.out.println("====[유기동물 게시판]====");
			System.out.println("====[전체 글 조회]====");

				try {
					new Adandoned().list();
				} catch (Exception e) {
					System.out.println("오류!");
					e.printStackTrace();
				}
				
			}//switch
			
			System.out.println("\n\n 0. 지역별 검색");
			System.out.print("==== 상세내용을 보시려면 글번호를 선택하세요 ====" );
			System.out.print( " : " );
			
			int num = InputUtil.getInt();
			
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
			InputUtil.getInt();
			
			continue;
			
		}//while
		
		
	}

}
