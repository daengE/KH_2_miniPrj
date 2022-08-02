package bje;

import mini.util.InputUtil;

public class BcommentController {

	/*
	 * 댓글 작성
	 * 
	 * 데이터 받기 (컨트롤러)
	 * 
	 * 비지니스 로직 (서비스)
	 * 
	 * DB에 insert (DAO)
	 */
	public void write() {//여기! 디폴트 아닌것들 모두 작성받는것으로 수정해야함
		
		//글 선택했는지 체크
		if(Main_bje.bcomment == null) {
			System.out.println("댓글을 작성할 글을 먼저 선택해주세요");
			return; //다음 진행 하면 안되니까 return
		}
		
		System.out.println("----- 댓글 작성 -----");
		
		System.out.print("내용 : ");
		String content = InputUtil.sc.nextLine();
		
		int bcommentNo = Main_bje.bcomment.getB_no();
		
		//데이터 뭉치기
		BcommentVo vo = new BcommentVo();
		vo.setContent(content);
		
		//DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
		int result = new BcommentService().write(vo);
		
		if(result == 1) {
			//댓글 작성 성공
			System.out.println("댓글 작성 성공 !");
		}else {
			//댓글 작성 실패
			System.out.println("댓글 작성 실패...");
		}
	}
	
}//class



















