package krw.notificationboard;

import java.sql.Timestamp;
import java.util.List;

import krw.qnaboard.QnaService;
import krw.qnaboard.QnaVo;
import mini.main.Main;
import mini.menu.Menu;
import mini.util.InputUtil;
import mini.util.StringTest;

public class NotiController {

	public void handleNotiMenu() {

		// 메뉴 보여주기
		int inputNot = new Menu().showNotiMenu();

		switch (inputNot) {
		case 1:
			listUpNoti();
			break;
		case 2:
			writeNoti();
			break;
		default:
			System.out.println("잘못 입력 하셨습니다.");
			break;
		}

	}

	// 게시글 리스트업
	public void listUpNoti() {
		// DAO를 통해 VO를 받아와서
		List<NotiVo> notiBoardList = new NotiService().listUpNoti();

		// VO를 토대로 리스트업 !!
		System.out.println("=============================== 공지사항 게시판 =================================\n");
		System.out.println("+------+-----------------------------------+---------------+---------------------+");
		System.out.println("|글번호|-----------  제     목  -----------|--- 작 성 자 --|---- 작 성 시 간 ----|");
		System.out.println("+------+-----------------------------------+---------------+---------------------+");

		// 게시판 목록에 나올 필드들 뽑아오기

		for (int i = 0; i < notiBoardList.size(); ++i) {

			NotiVo notiVo = notiBoardList.get(i);

			int notiNo = notiVo.getNotiNo();
			String title = notiVo.getTitle();
			String writer = notiVo.getWriter();
			Timestamp enrollDate = notiVo.getEnrollDate();

			int titleLength = new StringTest().getStrLength(35, title);
			int writerLength = new StringTest().getStrLength(15, writer);

			System.out.println(
					"|" + String.format("%6s", notiNo + " ") + "|" + String.format("%-" + titleLength + "s", title)
							+ "|" + String.format("%-" + writerLength + "s", writer) + "|" + enrollDate + "|");
			System.out.println("+------+-----------------------------------+---------------+---------------------+");

		}

		// 상세조회
		// 출력문, 입력받기
		int num = new Menu().showNotiContentMenu();

		// 0번 입력 받으면 메인메뉴로 return
		if (num == 0) {
			System.out.println("메인메뉴로 돌아갑니다.\n");
			return;
		}

		// 글번호 받기
		NotiVo vo = new NotiService().showNotiContentByNo(num);

		// 잘못된 글번호
		if (vo == null) {
			System.out.println("게시글이 없습니다.\n");
			return;
		}

		// 실행 결과 보여주기

		String title = vo.getTitle();
		String writer = vo.getWriter();

		int titleLength = new StringTest().getStrLength(35, title);
		int writerLength = new StringTest().getStrLength(15, writer);
		System.out.println("+------+-----------------------------------+---------------+---------------------+");
		System.out.println("|" + String.format("%6s", vo.getNotiNo()+" ") + "|"
				+ String.format("%-" + titleLength + "s", title) + "|"
				+ String.format("%-" + writerLength + "s", writer) + "|" + vo.getEnrollDate() + "|");
		System.out.println("+------+-----------------------------------+---------------+---------------------+");
		System.out.println(vo.getContent());
		System.out.println("+------+-----------------------------------+---------------+---------------------+");
		
		// 상세보기 후

		if (Main.loginMember == null || Main.loginMember.getMbRight() == 0) {
			System.out.println("1. 게시글로 가기");
			System.out.println("0. 메인 메뉴로\n");
			int input = InputUtil.getInt();
			if (input == 1) {
				listUpNoti();
			} else {
				return;
			}
		} else if (Main.loginMember.getMbRight() == 1) {
			System.out.println("1. 게시글로 가기");
			System.out.println("2. 공지사항 삭제하기");
			System.out.println("0. 메인 메뉴로\n");
			int input = InputUtil.getInt();
			if (input == 1) {
				listUpNoti();
			} else if (input == 2) {

				int result = deleteNoti(vo.getNotiNo());

				if (result == 1) {
					System.out.println("공지사항을 삭제 하였습니다.\n");
				} else {
					System.out.println("삭제실패....\n");
				}

				listUpNoti();

			}

		}

	}

	// 게시글 작성
	public void writeNoti() {
		// 로그인 확인
		if (Main.loginMember == null) {
			System.out.println("로그인을 먼저 해주세요.\n");
			return;
		}

		// 권한 확인 //이게 스트링이던가..
		if (Main.loginMember.getNo() != 99999) {
			System.out.println("권한이 없습니다.\n");
			return;
		}
		// 커넥트
		System.out.println("===== 공지사항 게시글 작성 =====");

		System.out.println("제목 : ");
		String title = InputUtil.sc.nextLine();
		System.out.println("내용 : ");
		String content = InputUtil.sc.nextLine();

		int memberNo = Main.loginMember.getNo();
		String writer = Main.loginMember.getNick();

		// 데이터 뭉치기

		NotiVo vo = new NotiVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMemberNo(memberNo);
		vo.setWriter(writer);

		// DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
		int result = new NotiService().writeNoti(vo);

		// insert 결과에 따라 로직 처리
		if (result == 1) {
			// 글 작성 성공
			System.out.println("게시글 작성 성공!\n");
		} else {
			// 글 작성 실패
			System.out.println("게시글 작성 실패...!\n");
		}
	}

	// 게시글 삭제, 게시글 상세보기를 통해 하던지..
	public int deleteNoti(int input) {

		int result = new NotiService().deleteNoti(input);

		return result;

	}
}
