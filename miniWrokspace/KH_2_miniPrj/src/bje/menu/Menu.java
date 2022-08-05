package bje.menu;

import bje.Main_bje;
import mini.util.InputUtil;

public class Menu {

   public int showMenu6() {
	      
	      if(Main_bje.loginMember != null) {
	         //로그인 상태
	         System.out.println(Main_bje.loginMember.getNick() + " 님 환영합니다.");
	         System.out.println("1. 게시판글 작성");
	         System.out.println("2. 게시글 목록 조회");;
	      }else {
	         //로그인 X
	    	  System.out.println("로그인 먼저 해주세요");
		      //다음 진행 하면 안되니까 return
	      }
	
      System.out.println("9. 프로그램 종료");
      
      return InputUtil.getInt();   //사용자가 숫자말고 다른거 입력할 시 조치방법 작성필요
   }//showMenu6
   
   /*
    * 게시판 상세조회 관련 메뉴
    */
   public int showBoardDetailMenu() {
	  
      System.out.println("조회할 글 번호 (0번은 메인메뉴) : ");
      return InputUtil.getInt();
   }
   
   public int choiceBcommentMenu() {
	   System.out.println("\n1. 댓글을 조회하시겠습니까?  or 2. 댓글을 작성하시겠습니까?");
	   return InputUtil.getInt();
   }
   
   
   
   
   
   
   
   
}//class



















