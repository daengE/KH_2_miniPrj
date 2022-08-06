package krw.qnaboard;

import java.sql.Timestamp;
import java.util.List;

import mini.main.Main;
import mini.menu.Menu;
import mini.util.InputUtil;
import mini.util.StringTest;

public class QnaController {

	private int adminInput;

	public void handleQnaMenu() {

		// 메뉴 보여주기
		int inputNot = new Menu().showQnaMenu();

		switch (inputNot) {
		case 1:
			listUpQna();
			break;
		case 2:
			writeQna();
			break;
		case 3:
			if (Main.loginMember == null) {
				System.out.println("로그인을 먼저 해주세요.");
			} else {
				listUpMyQna();
			}
		default:
			System.out.println("잘못 입력 하셨습니다.");
			break;
		// 내 문의내역
		// 리스트 받아오기
		}

	}

	private void listUpMyQna() {
		List<QnaVo> qnaBoardList = new QnaService().listUpMyQna();

		// VO를 토대로 리스트업 !!
		System.out.println("============================= QnA 게시판 ==============================\n");
		System.out.println("+------+----------+-------------------------+---------------------+");
		System.out.println("|글번호| 답변여부 |------  제     목  ------|---- 작 성 시 간 ----|");
		System.out.println("+------+----------+-------------------------+---------------------+");

		// 게시판 목록에 나올 필드들 뽑아오기
		for (int i = 0; i < qnaBoardList.size(); ++i) {

			QnaVo qnaVo = qnaBoardList.get(i);

			int qnaNo = qnaVo.getQnaNo();
			String title = qnaVo.getTitle();
			String writer = qnaVo.getWriter();
			Timestamp enrollDate = qnaVo.getEnrollDate();

			int titleLength = new StringTest().getStrLength(25, title);

			if (qnaVo.getComplete().equals("Y")) {
				System.out.println("|" + String.format("%6s", qnaNo) + "| 답변완료 |"
						+ String.format("%-" + titleLength + "s", title) + "|" + enrollDate + "|");
				System.out.println("+------+----------+-------------------------+---------------------+");

			} else {
				System.out.println("|" + String.format("%6s", qnaNo) + "|  대기중  |"
						+ String.format("%-" + titleLength + "s", title) + "|" + enrollDate + "|");
				System.out.println("+------+----------+-------------------------+---------------------+");
			}

		}

		int num = showQnaContentMenu();

		if (num == 0) {
			System.out.println("메인메뉴로 돌아갑니다.");
			return;
		}
		// 게시글 상세보기
		System.out.println("게시글 타입을 선택해주세요.");
		System.out.println("1. 질문 2. 답변");
		int typeInput = InputUtil.getInt();
		String type = null;
		if (typeInput == 1) {
			type = "Q";
		} else {
			type = "A";
		}

		// 글번호랑 타입 전달후 객체 받기
		QnaVo vo = new QnaService().showQnaContenByNo(num, type);

		// 객체 통해 상세글 출력
		if (vo != null) {
			String title = vo.getTitle();
			String writer = vo.getWriter();

			int titleLength = new StringTest().getStrLength(25, title);
			int writerLength = new StringTest().getStrLength(15, writer);

			System.out.println("+-----+----------------------------------+-----------------+");
			System.out.println("|" + String.format("%5s", vo.getQnaNo()) + "|"
					+ String.format("%-" + titleLength + "s", title) + "|" + "작성 시간 : " + vo.getEnrollDate() + "|");
			System.out.println("+-----+----------------------------------+-----------------+");
			System.out.println(String.format("%" + writerLength + "s", "| 작성자 : " + writer));
			System.out.println("===========================================================");
			System.out.println(vo.getContent());
			System.out.println("===========================================================");
		} else {
			System.out.println("게시글이 없습니다.");
			return;

		}

	}

	// 게시글 리스트업
	public void listUpQna() {
		// DAO를 통해 VO를 받아와서
		List<QnaVo> qnaBoardList = new QnaService().listUpQna();

		// VO를 토대로 리스트업 !!
		System.out.println("============================= QnA 게시판 ==============================\n");
		System.out.println("+------+-------------------------+---------------+---------------------+");
		System.out.println("|글번호|------  제     목  ------|--- 작 성 자 --|---- 작 성 시 간 ----|");
		System.out.println("+------+-------------------------+---------------+---------------------+");

		// 게시판 목록에 나올 필드들 뽑아오기
		for (int i = 0; i < qnaBoardList.size(); ++i) {

			QnaVo qnaVo = qnaBoardList.get(i);

			int qnaNo = qnaVo.getQnaNo();
			String title = qnaVo.getTitle();
			String writer = qnaVo.getWriter();
			Timestamp enrollDate = qnaVo.getEnrollDate();

			int titleLength = new StringTest().getStrLength(25, title);
			int writerLength = new StringTest().getStrLength(15, writer);

			if (qnaVo.getType().equals("Q")) {
				System.out.println(
						"|" + String.format("%6s", qnaNo) + "|" + String.format("%-" + titleLength + "s", title) + "|"
								+ String.format("%-" + writerLength + "s", writer) + "|" + enrollDate + "|");

			} else {
				System.out.println("|" + String.format("%6s", "Reply") + "|"
						+ String.format("%-" + titleLength + "s", ">>" + title) + "|"
						+ String.format("%-" + writerLength + "s", writer) + "|" + enrollDate + "|");
			}

		}
		System.out.println("+------+-------------------------+---------------+---------------------+");

		int num = showQnaContentMenu();

		if (num == 0) {
			System.out.println("메인메뉴로 돌아갑니다.");
			return;
		}
		// 게시글 상세보기
		System.out.println("게시글 타입을 선택해주세요.");
		System.out.println("1. 질문 2. 답변");
		int typeInput = InputUtil.getInt();
		String type = null;
		if (typeInput == 1) {
			type = "Q";
		} else {
			type = "A";
		}

		// 글번호랑 타입 전달후 객체 받기
		QnaVo vo = new QnaService().showQnaContenByNo(num, type);

		// 객체 통해 상세글 출력
		if (vo != null) {
			System.out.println(vo.getQnaNo() + "|" + "제목 : " + vo.getTitle() + "|" + "작성 시간 : " + vo.getEnrollDate());
			System.out.println("작성자 : " + vo.getWriter());
			System.out.println("내용 : " + vo.getContent());
		} else {
			System.out.println("게시글이 없습니다.");
			return;

		}

		// 출력후 메뉴(질문 답변 타입에 따라, 회원 권한에 따라..)

		if (Main.loginMember == null || vo.getType().equals("A") || Main.loginMember.getMbRight() == 0) {
			System.out.println("1. 게시글로 가기");
			System.out.println("0. 메인 메뉴로");
			int input = InputUtil.getInt();
			if (input == 1) {
				listUpQna();
			} else {
				return;
			}
		} else if (vo.getType().equals("Q") && Main.loginMember.getMbRight() == 1) {
			System.out.println("1. 게시글로 가기");
			System.out.println("2. 답변 등록하기");
			System.out.println("0. 메인 메뉴로");
			adminInput = InputUtil.getInt();
			if (adminInput == 1) {
				listUpQna();
			} else if (adminInput == 2) {
				System.out.print("제목 : ");
				String title = InputUtil.sc.nextLine();
				System.out.print("내용 : ");
				String content = InputUtil.sc.nextLine();

				QnaVo qnaVo = new QnaVo();

				qnaVo.setQnaNo(vo.getQnaNo());
				qnaVo.setMemberNo(Main.loginMember.getNo());
				qnaVo.setType("A");
				qnaVo.setWriter(Main.loginMember.getNick());
				qnaVo.setTitle(title);
				qnaVo.setContent(content);
//				
				int result = new QnaService().replyQna(qnaVo);

				if (result == 1) {
					System.out.println("답변이 작성 되었습니다.");
				} else {
					System.out.println("답변 작성 실패..");
				}

			} else {
				return;
			}
		} else {
			return;
		}

	}

	private int showQnaContentMenu() {
		// TODO 메뉴로 옮길거야..
		System.out.println("글 번호를 입력해 주세요 (0번은 메인메뉴로 돌아갑니다)");
		int input = InputUtil.getInt();
		return input;
	}

	// 게시글 작성
	public void writeQna() {
		// 로그인 확인
		if (Main.loginMember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}

		// 커넥트
		System.out.println("===== QnA 게시글 작성 =====");

		System.out.println("제목 : ");
		String title = InputUtil.sc.nextLine();
		System.out.println("내용 : ");
		String content = InputUtil.sc.nextLine();

		int memberNo = Main.loginMember.getNo();
		String writer = Main.loginMember.getNick();

		// 데이터 뭉치기

		QnaVo vo = new QnaVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMemberNo(memberNo);
		vo.setWriter(writer);

		// DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
		int result = new QnaService().writeQna(vo);

		System.out.println(result);

		// insert 결과에 따라 로직 처리
		if (result == 1) {
			// 글 작성 성공
			System.out.println("게시글 작성 성공!");
		} else {
			// 글 작성 실패
			System.out.println("게시글 작성 실패...!");
		}
	}
}
