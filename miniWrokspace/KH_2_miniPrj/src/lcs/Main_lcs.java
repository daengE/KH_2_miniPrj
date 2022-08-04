package lcs;


import lcs.atc.ATCController;
import lcs.atc.ATCVo;
import lcs.menu.Menu;
import mini.member.MemberController;
import mini.util.InputUtil;

public class Main_lcs {

	public static mini.member.MemberVo loginMember;
	
	
		public static void main(String[] args) {
			
			System.out.println("===== 환영합니다 =====");
			
			Menu menu = new Menu();
			
			
			
			while(true) {
				//메뉴 보여주기
				int input = menu.showMenu();
				
				//선택한 값에 따라 동작
				switch(input) {
				case 1:
					if (loginMember == null) {
						new MemberController().login();
					} else {
						loginMember = null;
						System.out.println("정상적으로 로그아웃 되었습니다..!");
					}
					break;
				case 2:
				
					break;
				case 3:
					/*동물 훈련팁 */
					
					break;
				case 4:
//					동물 보호소 보여주고 보호소 들어가서 입소신청을 할 수 있음
					new ATCController().showATCList();
					break;
				case 9:
//					
					System.out.println("시스템을 종료 합니다...!");
					return;
		
				}//switch
				
			}
		}//while	
	}


