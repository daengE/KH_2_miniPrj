package lcs;


import lcs.atc.ATCController;
import lcs.menu.Menu;
import lcs.ps.PSController;
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
				case 4:
					/*동물 훈련팁 */
					new PSController().showPSList();
					
					break;
				case 5:
//					동물 보호소 보여주고 보호소 들어가서 입소신청을 할 수 있음
					int selectATCMenu = new Menu().showATCSelectMenu();
					//동물보호소 전체를 보여준다.
					if(selectATCMenu == 1) {
						new ATCController().showATCList();						
					}
					//지역별 동물 보호소를 보여준다.
					else if(selectATCMenu == 2) {
						
						new ATCController().showCityATCList();
					}
					break;
				case 9:
//					
					System.out.println("시스템을 종료 합니다...!");
					return;
		
				}//switch
				
			}
		}//while	
	}


