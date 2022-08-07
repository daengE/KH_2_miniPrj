package bje.community_board;

import java.sql.Timestamp;
import java.util.List;

import bje.BcommentController;
import bje.BcommentService;
import bje.BcommentVo;
import bje.Main_bje;
import bje.menu.Menu;
import mini.main.Main;
import mini.util.InputUtil;
import mini.util.StringTest;

public class BoardController {

   private String tag;

/*
    * 게시글 작성
    * 
    * 데이터 받기 (컨트롤러)
    * 
    * 비지니스 로직 (서비스)
    * 
    * DB에 insert (DAO)
    */
   public void write() {
      
      System.out.println("----- 게시글 작성 -----");
      
      System.out.print("태그 : 1. 후원요청, 2. 자랑, 3. 질문, 4. 자유, 5. 뉴스데스크");
      int intTag = InputUtil.getInt();
      String tag = "";
      while(true) {
    	  if(intTag == 1) {
    		  tag = "후원요청"; break;
    	  }else if(intTag == 2) {
    		  tag = "자랑"; break;
    	  }else if(intTag == 3) {
    		  tag = "질문"; break;
    	  }else if(intTag == 4) {
    		  tag = "자유"; break;
    	  }else if(intTag == 5) {
    		  tag = "뉴스데스크"; break;
    	  }else {
    		  System.out.println("번호를 잘못입력했습니다."); continue;
    	  }
      }//while
      
      System.out.print("제목 : ");
      String title = InputUtil.sc.nextLine();
      System.out.print("내용 : ");
      String content = InputUtil.sc.nextLine();
      
      int memberNo = mini.main.Main.loginMember.getNo();
      String nick = mini.main.Main.loginMember.getNick();
      
      //데이터 뭉치기
      BoardVo vo = new BoardVo();
      vo.setTag(tag);
      vo.setTitle(title);
      vo.setContent(content);
      vo.setM_no(memberNo);
      vo.setWriter(nick);
      
      //DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
      int result = new BoardService().write(vo);
      
      if(result == 1) {
         //글 작성 성공
         System.out.println("게시글 작성 성공 !");
      }else {
         //글 작성 실패
         System.out.println("게시글 작성 실패...");
      }
   }//write

   
   public void showList() {
      
      List<BoardVo> boardVoList = new BoardService().showList();
      
		System.out.println("=========================================== 커뮤니티 게시판 ============================================\n");
		System.out.println("+----------------+------+----------------------------------------+---------------+---------------------+");
		System.out.println("|------태그------|글번호|-------------  제      목  -------------|----작 성 자---|-----작 성 시 간-----|");
		System.out.println("+----------------+------+----------------------------------------+---------------+---------------------+");

		for(int i = 0 ; i < boardVoList.size(); ++i) {
			
			BoardVo temp = boardVoList.get(i);
	      
			String tag = temp.getTag();
			int no = temp.getB_no();
	        String title = temp.getTitle();
	        String writer = temp.getWriter();
	        Timestamp enrollDate = temp.getEnrollDate();
	         
	        int titleLength = new StringTest().getStrLength(40, title);
			int writerLength = new StringTest().getStrLength(15, writer);
			int tagLength = new StringTest().getStrLength(16, tag);
			
			System.out.println("|" + String.format("%-" + tagLength + "s", tag) + "|" + String.format("%6s", no)
								+ "|" + String.format("%-" + titleLength + "s", title) + "|"
								+ String.format("%-" + writerLength + "s", writer) + "|" + enrollDate + "|");
			System.out.println("+----------------+------+----------------------------------------+---------------+---------------------+");
		}
   }//showList
   
   
   public void showTagList() {
	      
	   String tag = new Menu().choiceBoardTag();
	   List<BoardVo> boardVoList = new BoardService().choiceBoardTag(tag);
      
       System.out.println("=========================================== 커뮤니티 게시판 ============================================\n");
       System.out.println("+----------------+------+----------------------------------------+---------------+---------------------+");
       System.out.println("|------태그------|글번호|-------------  제      목  -------------|----작 성 자---|-----작 성 시 간-----|");
       System.out.println("+----------------+------+----------------------------------------+---------------+---------------------+");

       for(int i = 0 ; i < boardVoList.size(); ++i) {
    	   BoardVo temp = boardVoList.get(i);
	      
    	   tag = temp.getTag();
    	   int no = temp.getB_no();
	       String title = temp.getTitle();
	       String writer = temp.getWriter();
	       Timestamp enrollDate = temp.getEnrollDate();
	         
	       int titleLength = new StringTest().getStrLength(40, title);
	       int writerLength = new StringTest().getStrLength(15, writer);
	       int tagLength = new StringTest().getStrLength(16, tag);
			
	       System.out.println("|" + String.format("%-" + tagLength + "s", tag) + "|" + String.format("%6s", no)
								+ "|" + String.format("%-" + titleLength + "s", title) + "|"
								+ String.format("%-" + writerLength + "s", writer) + "|" + enrollDate + "|");
	       System.out.println("+----------------+------+----------------------------------------+---------------+---------------------+");
		}
   }//showTagList   
   

   public void showBoardDetailMenu(int num) {
	   
      //글번호 받으면 ? -> 해당 글 상세조회 //새로운 service 호출
      BoardVo vo = new BoardService().showDetailByNo(num);
      
      String title = vo.getTitle();
      String writer = vo.getWriter();
      String tag = vo.getTag();

      int titleLength = new StringTest().getStrLength(24, title);
      int writerLength = new StringTest().getStrLength(15, writer);
      int tagLength = new StringTest().getStrLength(16, tag);
      int contentLength = new StringTest().getStrLength(79, vo.getContent());
      System.out.println("+------+----------------+------------------------+---------------+---------------------+");
      System.out.println("|글번호+      태그      +         글제목         +     닉네임    +       작성시간      |");
      System.out.println("+------+----------------+------------------------+---------------+---------------------+");
      System.out.println("|" + String.format("%6s", vo.getB_no()+" ") + "|" 
    		+ String.format("%-" + tagLength + "s", tag) + "|"
            + String.format("%-" + titleLength + "s", title) + "|"
            + String.format("%-" + writerLength + "s", writer) + "|" + vo.getEnrollDate() + "|");
      System.out.println("+------+----------------+------------------------+---------------+---------------------+");
      System.out.println("|내용 : " +  String.format("%-" + contentLength + "s", vo.getContent()) + "|");
      System.out.println("+--------------------------------------------------------------------------------------+");
      
      
      Main_bje.boardvovo = vo;
      //댓글조회
      new BcommentController().showCommentList(num);
      
         return;
   }//showBoardDetailMenu   
   
}//class


















