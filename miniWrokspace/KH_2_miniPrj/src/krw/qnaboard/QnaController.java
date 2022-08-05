package krw.qnaboard;

import java.sql.Timestamp;
import java.util.List;

import krw.notificationboard.NotiService;
import mini.main.Main;
import mini.menu.Menu;
import mini.util.InputUtil;

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
			// qna 질문 답변
			// 글번호 받고
			// 답변 등록 하고 !

		}

	}

	// 게시글 리스트업
	public void listUpQna() {
		// DAO를 통해 VO를 받아와서
		List<QnaVo> qnaBoardList = new QnaService().listUpQna();

		// VO를 토대로 리스트업 !!
		System.out.println("===== QnA 게시판 =====");

		// 게시판 목록에 나올 필드들 뽑아오기

		for (int i = 0; i < qnaBoardList.size(); ++i) {

			QnaVo qnaVo = qnaBoardList.get(i);

			int qnaNo = qnaVo.getQnaNo();
			String title = qnaVo.getTitle();
			String writer = qnaVo.getWriter();
			Timestamp enrollDate = qnaVo.getEnrollDate();
			if (qnaVo.getType().equals("Q")) {
				System.out.println(qnaNo + "|" + title + "|" + writer + "|" + enrollDate);
			} else {
				System.out.println("( ˙▿˙ )" + title + "|" + writer + "|" + enrollDate);
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
			System.out.println(vo.getQnaNo() + "|" + "제목 : " + vo.getTitle() + "|" + "작성 시간 : " + vo.getEnrollDate());
			System.out.println("작성자 : " + vo.getWriter());
			System.out.println("내용 : " + vo.getContent());
		} else {
			System.out.println("게시글이 없습니다.");
			return;

		}

		// 출력후 메뉴(질문 답변 타입에 따라, 회원 권한에 따라..)

		if (vo.getType().equals("A") || Main.loginMember.getMbRight() == 0) {
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
				System.out.println("대충.. 답변등록하는 메소드");
				System.out.print("제목 : ");
				String title = InputUtil.sc.nextLine();
				System.out.print("내용 : ");
				String content = InputUtil.sc.nextLine();
				//
				
//				QnaVo qnaVo = new QnaVo();
//				
//				new QnaService().replyQna(vo.getQnaNo());
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

		// 권한 확인
//			if (Main.loginMember.getNo() != 99999 ) {
//				System.out.println("권한이 없습니다.");
//				return;
//			}
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
