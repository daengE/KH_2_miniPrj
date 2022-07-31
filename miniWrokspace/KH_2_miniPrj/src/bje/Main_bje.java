package bje;

import bje.community_board.BoardController;
import bje.member.MemberController;
import bje.member.MemberVo;
import bje.menu.Menu;

public class Main_bje {

	public static MemberVo loginMember;
	public static BcommentVo bcomment;
	
	/*
	 * 회원
	 * 게시판
	 */
	
	public static void main(String[] args) {
		
		System.out.println("===== 환영합니다 =====");
		
		Menu menu = new Menu();
		
		while(true) {
			//메뉴 보여주기
			int input = menu.showMenu();
			
			//선택한 값에 따라 동작
			switch(input) {
			case 1:
				new MemberController().login();
				break;
			case 2:
				new MemberController().join();
				break;
			case 3:
				/*게시판 글 작성*/
				new BoardController().write();
				break;
			case 4:
				/*게시판 리스트 조회*/
				
				//게시글 선택
				
				//댓글 작성
				new BcommentController().write();
				
				//댓글 조회
				break;	
			}//switch
			
		}//while
		
	}//main

}//class

