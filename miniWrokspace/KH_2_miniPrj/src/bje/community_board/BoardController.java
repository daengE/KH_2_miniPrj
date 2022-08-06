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
      
      //데이터 뭉치기
      BoardVo vo = new BoardVo();
      vo.setTag(tag);
      vo.setTitle(title);
      vo.setContent(content);
      vo.setM_no(memberNo);
      
      //DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
      int result = new BoardService().write(vo);
      
      if(result == 1) {
         //글 작성 성공
         System.out.println("게시글 작성 성공 !");
      }else {
         //글 작성 실패
         System.out.println("게시글 작성 실패...");
      }
   }

   public void showList() {
      
      List<BoardVo> boardVoList = new BoardService().showList();
      
		System.out.println("=================================== 커뮤니티  게시판 ====================================\n");
		System.out.println("+----------------+------+-------------------------+---------------+---------------------+");
		System.out.println("|------태그------|글번호|------  제     목  ------|----작 성 자---|-----작 성 시 간-----|");
		System.out.println("+----------------+------+-------------------------+---------------+---------------------+");    

		for(int i = 0 ; i < boardVoList.size(); ++i) {
			
			BoardVo temp = boardVoList.get(i);
	      
			String tag = temp.getTag();
			int no = temp.getB_no();
	        String title = temp.getTitle();
	        String writer = temp.getWriter();
	        Timestamp enrollDate = temp.getEnrollDate();
	         
	        int titleLength = new StringTest().getStrLength(25, title);
			int writerLength = new StringTest().getStrLength(15, writer);
			int tagLength = new StringTest().getStrLength(16, tag);
			
			System.out.println("|" + String.format("%-" + tagLength + "s", tag) + "|" + String.format("%6s", no)
								+ "|" + String.format("%-" + titleLength + "s", title) + "|"
								+ String.format("%-" + writerLength + "s", writer) + "|" + enrollDate + "|");
			System.out.println("+----------------+------+-------------------------+---------------+---------------------+");
		}
   
   }
   
//망하면 이걸로 복귀   
//   public void showBoardDetailMenu(int num) {
//	   
//      //상세조회 할건지 물어보기
//      //출력문, 입력받기
////      int num = new Menu().showBoardDetailMenu();
//      
//      //0번 입력받으면 ? -> 메인메뉴로 // return
////      if(num == 0) {
////         System.out.println("메인메뉴로 돌아갑니다.");
////         return;
////      }
//      
//      //글번호 받으면 ? -> 해당 글 상세조회 //새로운 service 호출
//      BoardVo vo = new BoardService().showDetailByNo(num);
//      
//      //실행결과(게시글 객체) 화면에 보여주기
//      System.out.println("\n----- 게시글 상세조회 -----");
//      System.out.print("제목 : " + vo.getTitle() + " | ");
//      System.out.print("작성자 : " + vo.getWriter() + " | ");
//      System.out.print("작성일 : " + vo.getEnrollDate());
//      System.out.println();//줄바꿈
//      System.out.println("내용 : " + vo.getContent());
//      
//      Main_bje.boardvovo = vo;
//      
//      int comment = new Menu().choiceBcommentMenu();
//      
//      //1:댓글조회 
////      Main_bje.bcomment.setB_no(Main_bje.boardvovo.getB_no());
//      if(comment == 1) {
//    	  new BcommentController().showCommentList(num);
//      }
//
//      //2:댓글작성
//      if(comment == 2) {
//         new BcommentController().write(num);
//      }
//      
//      else {
//         return;
//      }
//   }//showBoardDetailMenu
   
   public void showBoardDetailMenu(int num) {
	   
      //글번호 받으면 ? -> 해당 글 상세조회 //새로운 service 호출
      BoardVo vo = new BoardService().showDetailByNo(num);
      
//      //실행결과(게시글 객체) 화면에 보여주기
//      System.out.println("\n----- 게시글 상세조회 -----");
//      System.out.print("제목 : " + vo.getTitle() + " | ");
//      System.out.print("작성자 : " + vo.getWriter() + " | ");
//      System.out.print("작성일 : " + vo.getEnrollDate());
//      System.out.println();//줄바꿈
//      System.out.println("내용 : " + vo.getContent());
      
      String title = vo.getTitle();
      String writer = vo.getWriter();
      String tag = vo.getTag();

      int titleLength = new StringTest().getStrLength(24, title);
      int writerLength = new StringTest().getStrLength(15, writer);
      int tagLength = new StringTest().getStrLength(16, tag);
      System.out.println("+------+----------------+------------------------+---------------+---------------------+");
      System.out.println("|" + String.format("%6s", vo.getB_no()+" ") + "|" 
    		+ String.format("%-" + tagLength + "s", tag) + "|"
            + String.format("%-" + titleLength + "s", title) + "|"
            + String.format("%-" + writerLength + "s", writer) + "|" + vo.getEnrollDate() + "|");
      System.out.println("+------+----------------+------------------------+---------------+---------------------+");
      System.out.println("내용 : " + vo.getContent());
      System.out.println("+--------------------------------------------------------------------------------------+");
      
      
      Main_bje.boardvovo = vo;
      //댓글조회
      new BcommentController().showCommentList(num);
      
//      int comment = new Menu().choiceBcommentMenu();
      
      //2:댓글작성
//      if(comment == 2) {
//         new BcommentController().write(num);
//      }
      
//      else {
         return;
//      }
   }//showBoardDetailMenu   
   
   
   public void showTagList() {
	   
      //태그조회
      //출력문, 입력받기
      String tag = new Menu().choiceBoardTag();
      
      //태그를 받으면 ? -> 해당 글 상세조회 //새로운 service 호출
      BoardVo vo = new BoardService().choiceBoardTag(tag);
      
      //실행결과(게시글 객체) 화면에 보여주기
      System.out.println("\n----- 게시글 상세조회 -----");
      System.out.print("태그 : [" + vo.getTag() + "] | ");
      System.out.print("글번호 : " + vo.getB_no() + " | ");
      System.out.print("제목 : " + vo.getTitle() + " | ");
      System.out.print("작성자 : " + vo.getWriter() + " | ");
      System.out.print("작성일 : " + vo.getEnrollDate());
      System.out.println();//줄바꿈
      System.out.println("내용 : " + vo.getContent());
      
   }//showTagList
   
}//class


















