package lcs;


import lcs.application.ApplicationController;
import lcs.member.MemberController;
import lcs.member.MemberVo;
import lcs.menu.Menu;

public class Main_lcs {

	public static MemberVo loginMember;
	
	
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
					/*동물 훈련팁 */
					
					break;
				case 4:
					/*동물보호소 입소신청 등*/
					new ApplicationController().write();
					//게시글 선택
					
					//댓글 작성
				
					
					//댓글 조회
					break;	
				}//switch
				
			}//while
			
	}

}
