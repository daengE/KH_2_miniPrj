package bje;

import java.sql.Timestamp;
import java.util.List;

import bje.community_board.BoardService;
import bje.community_board.BoardVo;
import mini.main.Main;
import mini.util.InputUtil;
import mini.util.StringTest;

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
	public void write(int num) {

		System.out.println("---------- 댓글 작성 ---------");

		System.out.print("내용 : ");
		String content = InputUtil.sc.nextLine();

		int boardnum = Main.boardvovo.getB_no();
		String nick = Main.boardvovo.getWriter();

		// 데이터 뭉치기
		BcommentVo vo = new BcommentVo();
		vo.setB_no(boardnum);
		vo.setWriter(nick);
		vo.setContent(content);

		// DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
		int result = new BcommentService().write(vo, boardnum);

		// insert 결과에 따라 로직 처리
		if (result == 1) {
			// 댓글 작성 성공
			System.out.println("댓글 작성 성공 !");
		} else {
			// 댓글 작성 실패
			System.out.println("댓글 작성 실패...");
		}
	}// write

	public void showCommentList(int num) {
		List<BcommentVo> BcommentVoList = new BcommentService().showList(num);

		System.out.println(
				"+------+----------------------------------------------------+---------------+---------------------+");
		for (int i = 0; i < BcommentVoList.size(); ++i) {
			BcommentVo temp = BcommentVoList.get(i);

			int no = temp.getB_no();
			String concontents = temp.getContent();
			String nick = temp.getWriter();
			Timestamp comenrolldate = temp.getEnrollDate();

			int writerLength = new StringTest().getStrLength(15, nick);
			int contentLength = new StringTest().getStrLength(52, concontents);

			System.out.println("|" + String.format("%6s", no + " ") + "|"
					+ String.format("%-" + contentLength + "s", temp.getContent()) + "|"
					+ String.format("%-" + writerLength + "s", nick) + "|" + temp.getEnrollDate() + "|");
			System.out.println(
					"+------+----------------------------------------------------+---------------+---------------------+");

		}
	}// showCommentList

}// class