package mini.menu;

import mini.main.Main;
import mini.member.MemberController;
import mini.util.InputUtil;
import sar.Ad_Board.Adandoned;
import sar.Ad_Board.Adoption;

public class Menu {

	public int showMenu() {

		if (Main.loginMember == null) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 유기동물 게시판 조회");
			System.out.println("4. 찬선님");
			System.out.println("5. 화이팅");
			System.out.println("6. 커뮤니티 게시판 조회");
			System.out.println("7. 공지사항 게시판");
			System.out.println("8. QnA 게시판");
			System.out.println("9. 프로그램 종료");
		} else {
			System.out.println("1. 로그아웃");
			System.out.println("2. 마이페이지");
			System.out.println("3. 유기동물 게시판 조회");
			System.out.println("4. 찬선님");
			System.out.println("5. 화이팅");
			System.out.println("6. 커뮤니티 게시판 조회");
			System.out.println("7. 공지사항 게시판");
			System.out.println("8. QnA 게시판");
			System.out.println("9. 프로그램 종료");
		}

		int input = InputUtil.getInt();
		return input;

	}

	public int showNotiMenu() {

		int input = 0;
		while (true) {

			System.out.println("1. 공지사항 게시글 보기");
			System.out.println("2. 공지사항 작성");

			input = InputUtil.getInt();

			if (1 == input || 2 == input) {
				break;
			} else {
				System.out.println("잘못 입력 하셨습니다..!");
			}

		}
		return input;
	}

	public int showQnaMenu() {

		int input = 0;
		while (true) {

			System.out.println("1. QnA 게시글 보기");
			System.out.println("2. QnA 게시글 작성");
			System.out.println("3. 내 문의 내역 보기");

			input = InputUtil.getInt();

			if (1 == input || 2 == input || 3 == input) {
				break;
			} else {
				System.out.println("잘못 입력 하셨습니다..!");
			}
		}
		return input;
	}
	
	public int showNotiContentMenu() {
		System.out.println("조회할 글 번호(0번은 메인메뉴) : ");
		
		return InputUtil.getInt();
	}

	public int showMyPageMenu() {
		
		int input = 0;
		
		while (true) {
			System.out.println("1. 내 정보 보기");
			System.out.println("2. 내가 작성한 글");
			System.out.println("3. 나의 관심 글");
			System.out.println("4. 내 반려동물 보기");
			System.out.println("5. 탈퇴하기");
			
			input = InputUtil.getInt();

			if (1 == input || 2 == input || 3 == input || 4 == input || 5 == input) {
				break;
			} else {
				System.out.println("잘못 입력 하셨습니다..!");
			}
		}
		
		return input;
		
	}
	
	public void showMenu1() {
		
		System.out.println("\n\n0. 지역별 검색");
		System.out.print("==== 상세내용을 보시려면 글번호를 선택하세요 ====" );
		System.out.print( " : " );
		
		int num = InputUtil.getInt();
		
		if(num == 0) {
			System.out.println("\n\n==== 지역별 검색 ====");
			System.out.println(" 서울 | 경기도 | 경상도 | 전라도 | 제주도 | 충청도 | 강원도 ");
		
				new Adandoned().search();
				showMenu1();
			
		}else 
				{new Adandoned().detail(num);
			
		}		
//		InputUtil.sc.nextLine();
//		return InputUtil.getInt();
		
	}
	
	public int showMenu2() {
		
		while(true) {
		System.out.println("\n\n0. 지역별 검색");
		System.out.println("1. 뒤로가기");
		System.out.println("2. 해당 동물 입양하기");
	
		int num2 = InputUtil.getInt();
		
		switch(num2) {
		case 0 : 
			System.out.println("\n\n==== 지역별 검색 ====");
			System.out.println(" 서울 | 경기도 | 경상도 | 전라도 | 제주도 | 충청도 | 강원도 ");
			try {
				new Adandoned().search();
				showMenu1();
			} catch (Exception e) {
				System.out.println("지역검색 오류 [num2]");
				e.printStackTrace();
			}
		
		case 1 : 
				new Adandoned().list();
				showMenu1();
				continue;
			
		case 2 : 
			new Adoption().apply(Main.loginMember.getNo());

		}//switch
		return InputUtil.getInt();	
		}//while
		
	}//showMenu2
	
   public void showMenu6() {
         
		System.out.println("\n\n0. 태그별 검색");
		System.out.print("==== 상세내용을 보시려면 글번호를 선택하세요 ====" );
		System.out.print( " : " );
		
		int num = InputUtil.getInt();
		
		if(num == 0) {
			System.out.println("\n\n==== 태그별 검색 ====");
			System.out.println(" 후원요청 | 자랑 | 질문 | 자유 | 뉴스데스크 ");
		
				new Adandoned().search();
				showMenu1();
			
		}else 
				{new Adandoned().detail(num);
			
		}		
   }//showMenu6

}