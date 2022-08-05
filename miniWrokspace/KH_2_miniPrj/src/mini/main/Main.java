package mini.main;

import bje.community_board.BoardController;
import krw.notificationboard.NotiController;
import krw.qnaboard.QnaController;
import lcs.atc.ATCController;
import lcs.ps.PSController;
import mini.member.MemberController;
import mini.member.MemberVo;
import mini.menu.Menu;
import sar.Ad_Board.Adandoned;
import sar.Util.AdVo;
import lcs.menu.LcsMenu;


public class Main {

	public static MemberVo loginMember;
	public static AdVo selected;

	public static void main(String[] args) {

		System.out.println("대충.. 애니멀어지지마 메인 화면..");
		System.out.println("===== 환영합니다 =====");

		// 메뉴 객체 생성
		Menu menu = new Menu();

		// 로그인 전 메뉴

		while (true) {

			int input = menu.showMenu();

			switch (input) {

			case 1:
				if (loginMember == null) {
					//로그인
					new MemberController().login();
				} else {
					//로그아웃
					loginMember = null;
					System.out.println("정상적으로 로그아웃 되었습니다..!");
				}
				break;
				
			case 2:
				if (loginMember == null) {
					//회원가입
					new MemberController().join();
				} else {
					//마이페이지
					new MemberController().myPage();
				}
				break;
				
			case 3:
				if (loginMember == null) {
					System.out.println("로그인먼저해주세요");
					new MemberController().login();
				} else {
					try {
						new Adandoned().list();
						menu.showMenu1();
						menu.showMenu2();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
				
			case 4:
               /*동물문제 & 해결 보여준다*/
               while(true) {
            	   
               
			   new PSController().showPSList();
               
               //문제행동을 고칠 수 있는 보호소를 보여주는지 물어본다.
               String connect = new PSController().connectATC();
               
               //Y라고 하면 동물훈련소 메소드 그대로 실행
               if(connect.equalsIgnoreCase("Y")) {
            	   
            	   new ATCController().sum();
            	   break;
               }
               else {
            	   System.out.println("문제행동으로 돌아갑니다.");
               }
               }
               
               
            case 5:
               //동물 보호소를 전체볼래? 지역별로 볼래?
               int selectATCMenu = new LcsMenu().showATCSelectMenu();
               
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
               
           case 6:
        	   new BoardController().showList();
        	   new BoardController().showBoardDetailMenu();
        	   break;
				
			case 7:
				new NotiController().handleNotiMenu();
				// TODO 공지 수정 및 삭제(물론 권한은 관리자만)
				break;
				
			case 8:
				new QnaController().handleQnaMenu();
				// TODO 질문 글 들어가서 답변하기(답변 할 때 정해진 포멧)
				break;
				
			case 9:
				System.out.println("시스템을 종료 합니다...!");
				return;
				
			case 0:
				// TODO 관리자할까말까();
				System.out.println("잘못 입력 하셨군요..!!");
				break;
				
			default:
				System.out.println("잘못 입력 하셨군요..!!");
				break;
			}
		}
	}
}
