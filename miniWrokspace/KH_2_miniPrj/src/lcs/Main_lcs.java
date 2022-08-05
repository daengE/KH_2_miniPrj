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
					/*동물문제 & 해결 보여준다*/
					new PSController().showPSList();
					
					//문제행동을 고칠 수 있는 보호소를 보여주는지 물어본다.
					String connect = new PSController().connectATC();
					
					//Y라고 하면 동물훈련소 메소드 그대로 실행
					new ATCController().sum();
					break;
			
				case 5:
					
				   //동물 보호소를 전체볼래? 지역별로 볼래?
					int selectATCMenu = new Menu().showATCSelectMenu();
					
					//동물보호소 전체를 보여준다.
					if(selectATCMenu == 1) {
						new ATCController().showATCList();						
					}
					
					//지역별 동물 보호소를 보여준다.
					else if(selectATCMenu == 2) {
						
						new ATCController().showCityATCList();
					}
					else {
						System.out.println();
						System.out.println("메인메뉴로 돌아갑니다.");
						continue;
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


