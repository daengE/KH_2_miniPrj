package mini.menu;

import bje.BcommentController;
import bje.community_board.BoardController;
import mini.main.Main;
import mini.member.MemberController;
import mini.util.InputUtil;
import sar.Ad_Board.Adandoned;
import sar.Ad_Board.Adoption;

public class Menu {

	public int showMenu() {
		System.out.println("=====================================");
		System.out.println("유기동물 구조 프로젝트");
		System.out.println(
		  "⠀⠀⠀⠀⣸⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
		+ "⢀⣀⣰⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣶⣶⣶⣦⡀\r\n"
		+ "⠙⠛⠛⠻⣿⣿⣿⣿⣿⣷⣦⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠟⠉⠙⢿⣿⣿\r\n"
		+ "⠀ ⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣴⡿⠟⠁\r\n"
		+ "⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀\r\n"
		+ "⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⡿⠀⠀\r\n"
		+ "⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⡏⠉⠉⠉⠁⠀⠀ ⠀⠈⠻⣿⣿⣿⣿⣿⣧⡀⠀\r\n"
		+ "⠀⠀⠀⠀⠀ ⠀⠀⢸⡟⠸⣿⡇⠀⠀⠀ ⠀⠀ ⠀⠀ ⠀⠀⠈⢹⣿⠉⠙⢿⣷⠀\r\n"
		+ "⠀ 애니 ⠠⠾⠇⠠⠿⠇멀어지지마⠀⠀⠤⠿⠇⠀⠀⠼⠟⠀");
		
		System.out.println("=====================================");

		if (Main.loginMember == null) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 유기동물 게시판 조회");
			System.out.println("4. 동물관련 TIP");
			System.out.println("5. 동물훈련소 보기");
			System.out.println("6. 커뮤니티 게시판 조회");
			System.out.println("7. 공지사항 게시판");
			System.out.println("8. QnA 게시판");
			System.out.println("9. 프로그램 종료");
			System.out.println("=====================================");
		} else {
			System.out.println("1. 로그아웃");
			System.out.println("2. 마이페이지");
			System.out.println("3. 유기동물 게시판 조회");
			System.out.println("4. 동물관련 TIP");
			System.out.println("5. 동물훈련소 보기");
			System.out.println("6. 커뮤니티 게시판 조회");
			System.out.println("7. 공지사항 게시판");
			System.out.println("8. QnA 게시판");
			System.out.println("9. 프로그램 종료");
			System.out.println("=====================================");
		}

		int input = InputUtil.getInt();
		return input;

	}

	public int showNotiMenu() {

		int input = 0;
		while (true) {

			System.out.println("1. 공지사항 게시글 보기");
			System.out.println("2. 공지사항 작성");
			System.out.println("0. 메인메뉴로 가기");

			input = InputUtil.getInt();

			if (1 == input || 2 == input || 0 == input) {
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
			System.out.println("0. 메인메뉴로 가기");

			input = InputUtil.getInt();

			if (1 == input || 2 == input || 3 == input || 0 == input) {
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
			System.out.println("1. 내 정보 보기 및 수정");
			System.out.println("2. 내가 작성한 글");
			System.out.println("3. 나의 신청 목록");
			System.out.println("4. 내 반려동물 보기");
			System.out.println("5. 탈퇴하기");
			
			input = InputUtil.getInt();

			if (1 == input || 2 == input || 3 == input || 4 == input || 5 == input) {
				break;
			} else {
				System.out.println("잘못 입력 하셨습니다..!");
			}
		}//while
		return input;
	}//showMyPageMenu
	
	
	public void showMenu1() {
        
        System.out.println("\n\n0. 검색하기");
        System.out.print("==== 상세내용을 보시려면 글번호를 선택하세요 ====" );
        System.out.print( " : " );
        
        int num = InputUtil.getInt();
        
        if(num == 0) {
           System.out.println("\n\n1.입양상태로 검색하기");
           System.out.println("2.지역으로 검색하기");
           int num1 = InputUtil.getInt();
           if(num1 == 1) {
              new Adandoned().ADOPT_YN();
              
           }else if(num1 == 2) {
              new Adandoned().search();
            
           }else if (num1 >= 3) {
           System.out.println("잘못 누르셨습니다");
           
           }
           showMenu1();
        }else if(num >= 24) {
           System.out.println("잘못 누르셨습니다");
           showMenu1();
        }
        else {
           new Adandoned().detail(num);
        }   
     }//showMenu1
	
	
    public int showMenu2() {

        while (true) {
           if (Main.selected.getAd_adopt().equalsIgnoreCase("y")) {
              System.out.println("\n\n0. 검색하기");
              System.out.println("1. 뒤로가기");
           } else {
              System.out.println("\n\n0. 검색하기");
              System.out.println("1. 뒤로가기");
              System.out.println("2. 해당 동물 입양하기");
           }

           int num2 = InputUtil.getInt();

           switch (num2) {
           case 0:
              System.out.println("\n\n1.입양상태로 검색하기");
              System.out.println("2.지역으로 검색하기");
              int num = InputUtil.getInt();
              if (num == 1) {
                 new Adandoned().ADOPT_YN();
              } else if (num == 2) {
                 new Adandoned().search();
              } else if (num >= 3) {
                 System.out.println("잘못 누르셨습니다");
              }
              continue;

           case 1:
              new Adandoned().list();
              showMenu1();
              continue;

           case 2:
              if (Main.loginMember == null) {
                 System.out.println("로그인 먼저 해주세요");
                 new MemberController().login();
                 new Adoption().apply(Main.loginMember.getNo());

              } else {
                 new Adoption().apply(Main.loginMember.getNo());
                 break;
              }

           default:
              System.out.println("잘못 누르셨습니다");
              continue;
           }// switch
        } // while
     }// showMenu2
	
	
	   public void showMenu6() {
	         
	         System.out.println("\n\n0. 태그별 검색");
	         System.out.println("1. 글 작성");
	         System.out.print("2. 상세 글 조회(글번호를 입력하세요)" );
	         System.out.print( " : " );
	         
	         int num = InputUtil.getInt();
	         
	         if(num == 0) {
	            new BoardController().showTagList();
	            new BoardController().showList();
	            showMenu6();
	         }
	         if(num == 1) {
	            if(Main.loginMember == null) {
	               System.out.println("로그인을 해주세요.");
	               new MemberController().login();
	               new BoardController().write();
	               new BoardController().showList();
	               showMenu6();
//	               return;
	            }else {
	               new BoardController().write();
	               new BoardController().showList();
	               showMenu6();
	            }
	         }
	         else {
	            new BoardController().showBoardDetailMenu(num);
	         }
	         
	         System.out.println("\n 댓글을 작성하시겠습니까?");
	         System.out.println("1. 네 작성작하겠습니다.");
	         System.out.println("2. 아니요 작성하지않겠습니다.");
	         
	         int numcom = InputUtil.getInt();
	         if(numcom == 1) {
	             new BcommentController().write(numcom);
	             new BoardController().showBoardDetailMenu(num);
	          }
	         else {
	             return;
	           }
	      }//showMenu6
   
   
   public int returnMain() {
	   
	   System.out.println("메인메뉴로 돌아가시겠습니까?");
	   System.out.println("1. 네 돌아갑니다.");
	   System.out.println("2. 아니요. ");
	   int returnMain = InputUtil.getInt();
	   if(returnMain == 1) {
		   return 1;
	   }
	   return 0;
	   
   }//returnMain
   
   
   public void allComments() {
	   
		int num = InputUtil.getInt();
		
		if(num == 0) {
			new BoardController().showTagList();
				showMenu6();
		}else {
			new BoardController().showBoardDetailMenu(num);
		}		
   }//showMenu6  
   
   
   public void showMenuComment() {
	   
		System.out.println("\n\n댓글");
		System.out.print("==== 상세내용을 보시려면 글번호를 선택하세요 ====" );
		System.out.print( " : " );
		
		int num = InputUtil.getInt();
		
		if(num == 0) {
			new BoardController().showTagList();
				showMenu6();
		}else {
			new BoardController().showBoardDetailMenu(num);
		}		
   }//showMenu6 

}//class














