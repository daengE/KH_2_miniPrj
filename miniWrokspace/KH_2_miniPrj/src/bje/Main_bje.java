package bje;

import bje.community_board.BoardController;
import bje.community_board.BoardVo;
import bje.member.MemberController;
import bje.member.MemberVo;
import bje.menu.Menu;
import sar.Ad_Board.Adandoned;

public class Main_bje {

   public static MemberVo loginMember;
//   public static BcommentVo bcomment;
   public static BoardVo boardvovo;
   
   /*
    * 회원
    * 게시판
    */
   
   public static void main(String[] args) {
      
      System.out.println("===== 환영합니다 =====");
      
      Menu menu = new Menu();
      
      while(true) {
         //메뉴 보여주기
         int input = menu.showMenu6();
         
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
            new BoardController().showList();
            
            /*이어서 선택한 글 + 댓글 모두 조회*/
//            new BcommentController().showCommentList();
            
            //메인으로 들어갑니다
//		case 3:
//			if(loginMember == null) {
//			new MemberController().join();
//			}else {
//				new Adandoned().list();
//				new BoardController().write();
//				new BoardController().showList();
//			}
//            
//            break;   
         case 9:
            /*프로그램 종료*/
            System.out.println("프로그램을 종료합니다.");
            return ;
         }//switch
         
      }//while
      
   }//main

}//class
