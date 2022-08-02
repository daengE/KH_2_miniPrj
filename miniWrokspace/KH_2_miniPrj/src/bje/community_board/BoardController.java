package bje.community_board;

import bje.Main_bje;
import main.Main;
import util.InputUtil;

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
		
		String memberNo = Main_bje.loginMember.getNo();
		
		//데이터 뭉치기
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(memberNo);
		
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
	
	
	
}//class



















