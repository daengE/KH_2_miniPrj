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
	public void write() {//여기! 디폴트 아닌것들 모두 작성받는것으로 수정해야함
		
		//로그인 체크
		if(Main_bje.loginMember == null) {
			System.out.println("로그인 먼저 해주세요");
			return; //다음 진행 하면 안되니까 return
		}
		
		System.out.println("----- 게시글 작성 -----");
		
		System.out.print("제목 : ");
		String title = InputUtil.sc.nextLine();
		System.out.print("내용 : ");
		String content = InputUtil.sc.nextLine();
		
		int memberNo = Main_bje.loginMember.getNo();
		
		//데이터 뭉치기
		BoardVo vo = new BoardVo();
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

	//망하면 이걸로 다시 살리자~
//	public void showList() {
//		
//		List<BoardVo> boardVoList = new BoardService().showList();
//		
//		System.out.println("----- 게시판 글 목록-----");
//		
//		for(int i = 0 ; i < boardVoList.size(); ++i) {
//			BoardVo temp = boardVoList.get(i);
//		
//			int no = temp.getB_no();
//			String title = temp.getTitle();
//			String writer = temp.getWriter();
//			Timestamp enrollDate = temp.getEnrollDate();
//			
//			System.out.println(no + " | " + title + " | " + writer + " | " + enrollDate);
//		}
//		
//		//상세조회 할건지 물어보기
//		//출력문, 입력받기
//		int num = new Menu().showBoardDetailMenu();
//		
//		//0번 입력받으면 ? -> 메인메뉴로 // return
//		if(num == 0) {
//			System.out.println("메인메뉴로 돌아갑니다.");
//			return;
//		}
//		
//		//글번호 받으면 ? -> 해당 글 상세조회 //새로운 service 호출
//		BoardVo vo = new BoardService().showDetailByNo(num);
//		
//		//실행결과(게시글 객체) 화면에 보여주기
//		System.out.println("\n----- 게시글 상세조회 -----");
//		System.out.print("제목 : " + vo.getTitle() + " | ");
//		System.out.print("작성자 : " + vo.getWriter() + " | ");
//		System.out.print("작성일 : " + vo.getEnrollDate());
//		System.out.println();//줄바꿈
//		System.out.println("내용 : " + vo.getContent());
//		
//		Main_bje.boardvovo = vo;
//		
//		String comment = new Menu().showBcommentMenu();
//		
//		//'Y'라고 하면 해당 글에 댓글 작성
////		Main_bje.bcomment.setB_no(Main_bje.boardvovo.getB_no());
//		if(comment.equals("0")) {
//			System.out.println("메인메뉴로 돌아갑니다.");
//			return;
//		}
//
//		//댓글쓴다고 하면 ? ->
//		if(comment.equals("Y")) {
//			new BcommentController().write();
//		}
//		
//		else {
//			return;
//		}
//		
//		
//	}//showList
	
	public void showList() {
		
		List<BoardVo> boardVoList = new BoardService().showList();
		
		System.out.println("----- 게시판 글 목록-----");
		
		for(int i = 0 ; i < boardVoList.size(); ++i) {
			BoardVo temp = boardVoList.get(i);
		
			int no = temp.getB_no();
			String title = temp.getTitle();
			String writer = temp.getWriter();
			Timestamp enrollDate = temp.getEnrollDate();
			
			System.out.println(no + " | " + title + " | " + writer + " | " + enrollDate);
		}
		
		//상세조회 할건지 물어보기
		//출력문, 입력받기
		int num = new Menu().showBoardDetailMenu();
		
		//0번 입력받으면 ? -> 메인메뉴로 // return
		if(num == 0) {
			System.out.println("메인메뉴로 돌아갑니다.");
			return;
		}
		
		//글번호 받으면 ? -> 해당 글 상세조회 //새로운 service 호출
		BoardVo vo = new BoardService().showDetailByNo(num);
		
		//실행결과(게시글 객체) 화면에 보여주기
		System.out.println("\n----- 게시글 상세조회 -----");
		System.out.print("제목 : " + vo.getTitle() + " | ");
		System.out.print("작성자 : " + vo.getWriter() + " | ");
		System.out.print("작성일 : " + vo.getEnrollDate());
		System.out.println();//줄바꿈
		System.out.println("내용 : " + vo.getContent());
		
		Main_bje.boardvovo = vo;
		
		String comment = new Menu().showBcommentMenu();
		
		//'Y'라고 하면 해당 글에 댓글 작성
//		Main_bje.bcomment.setB_no(Main_bje.boardvovo.getB_no());
		if(comment.equals("0")) {
			System.out.println("메인메뉴로 돌아갑니다.");
			return;
		}

		//댓글쓴다고 하면 ? ->
		if(comment.equals("Y")) {
			new BcommentController().write();
		}
		
		else {
			return;
		}
		
		
	}//showList	
	
}//class



















