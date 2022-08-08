package bje.community_board;

import java.sql.Timestamp;
import java.util.List;

import bje.BcommentController;
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

		System.out.println("------------------ 게시글 작성 ------------------");
		
		String tag = new Menu().writeMenu();

		System.out.print("제목 : ");
		String title = InputUtil.sc.nextLine();
		System.out.print("내용 : ");
		String content = InputUtil.sc.nextLine();

		int memberNo = Main.loginMember.getNo();
		String nick = Main.loginMember.getNick();

		// 데이터 뭉치기
		BoardVo vo = new BoardVo();
		vo.setTag(tag);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setM_no(memberNo);
		vo.setWriter(nick);

		// DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
		int result = new BoardService().write(vo);

		if (result == 1) {
			// 글 작성 성공
			System.out.println("게시글 작성 성공 !");
		} else {
			// 글 작성 실패
			System.out.println("게시글 작성 실패...");
		}
	}// write

	public void showList() {

		List<BoardVo> boardVoList = new BoardService().showList();

		System.out.println(
				"=========================================== 커뮤니티 게시판 ============================================\n");
		System.out.println(
				"+----------------+------+----------------------------------------+---------------+---------------------+");
		System.out
				.println("|------태그------|글번호|-------------  제      목  -------------|----작 성 자---|-----작 성 시 간-----|");
		System.out.println(
				"+----------------+------+----------------------------------------+---------------+---------------------+");

		for (int i = 0; i < boardVoList.size(); ++i) {

			BoardVo temp = boardVoList.get(i);

			String tag = temp.getTag();
			int no = temp.getB_no();
			String title = temp.getTitle();
			String writer = temp.getWriter();
			Timestamp enrollDate = temp.getEnrollDate();

			int titleLength = new StringTest().getStrLength(40, title);
			int writerLength = new StringTest().getStrLength(15, writer);
			int tagLength = new StringTest().getStrLength(16, tag);

			System.out.println("|" + String.format("%-" + tagLength + "s", tag) + "|" + String.format("%6s", no) + "|"
					+ String.format("%-" + titleLength + "s", title) + "|"
					+ String.format("%-" + writerLength + "s", writer) + "|" + enrollDate + "|");
			System.out.println(
					"+----------------+------+----------------------------------------+---------------+---------------------+");

			// 상세글보기

		}
	}// showList

	public void showTagList() {

		String tag = new Menu().choiceBoardTag();
		List<BoardVo> boardVoList = new BoardService().choiceBoardTag(tag);

		System.out.println(
				"=========================================== 커뮤니티 게시판 ============================================\n");
		System.out.println(
				"+----------------+------+----------------------------------------+---------------+---------------------+");
		System.out
				.println("|------태그------|글번호|-------------  제      목  -------------|----작 성 자---|-----작 성 시 간-----|");
		System.out.println(
				"+----------------+------+----------------------------------------+---------------+---------------------+");

		for (int i = 0; i < boardVoList.size(); ++i) {
			BoardVo temp = boardVoList.get(i);

			tag = temp.getTag();
			int no = temp.getB_no();
			String title = temp.getTitle();
			String writer = temp.getWriter();
			Timestamp enrollDate = temp.getEnrollDate();

			int titleLength = new StringTest().getStrLength(40, title);
			int writerLength = new StringTest().getStrLength(15, writer);
			int tagLength = new StringTest().getStrLength(16, tag);

			System.out.println("|" + String.format("%-" + tagLength + "s", tag) + "|" + String.format("%6s", no) + "|"
					+ String.format("%-" + titleLength + "s", title) + "|"
					+ String.format("%-" + writerLength + "s", writer) + "|" + enrollDate + "|");
			System.out.println(
					"+----------------+------+----------------------------------------+---------------+---------------------+");
		}
	}// showTagList

	public void showBoardDetailMenu(int num) {

		// 글번호 받으면 ? -> 해당 글 상세조회 //새로운 service 호출
		BoardVo vo = new BoardService().showDetailByNo(num);

		String title = vo.getTitle();
		String writer = vo.getWriter();
		String tag = vo.getTag();

		int titleLength = new StringTest().getStrLength(35, title);
		int writerLength = new StringTest().getStrLength(15, writer);
		int tagLength = new StringTest().getStrLength(16, tag);

		System.out.println(
				"+------+----------------+-----------------------------------+---------------+---------------------+");
		System.out.println("|글번호|     태  그     |             글  제  목            |    닉 네 임   |      작 성 시 간    |");
		System.out.println(
				"+------+----------------+-----------------------------------+---------------+---------------------+");
		System.out.println("|" + String.format("%6s", vo.getB_no() + " ") + "|"
				+ String.format("%-" + tagLength + "s", tag) + "|" + String.format("%-" + titleLength + "s", title)
				+ "|" + String.format("%-" + writerLength + "s", writer) + "|" + vo.getEnrollDate() + "|");
		System.out.println(
				"+------+----------------+-----------------------------------+---------------+---------------------+");
		System.out.println(" " + vo.getContent());
		System.out.println(
				"+-------------------------------------------------------------------------------------------------+");

		Main.boardvovo = vo;
		// 댓글조회
		new BcommentController().showCommentList(num);

	}// showBoardDetailMenu

}// class
