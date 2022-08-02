package krw.notificationboard;

import java.sql.Timestamp;
import java.util.List;

import mini.main.Main;
import mini.menu.Menu;
import mini.util.InputUtil;

public class NotiController {

	public void handleNotiMenu() {

		// 메뉴 보여주기
		int inputNot = new Menu().ShowNotiMenu();

		switch (inputNot) {
		case 1:
			listUpNoti();
			break;
		case 2:
			writeNoti();
			break;
		case 3:
			updateNoti();
			break;
		case 4:
			deleteNoti();
			break;
		}

	}

	// 게시글 리스트업
	public void listUpNoti() {
		// DAO를 통해 VO를 받아와서
		List<NotiVo> notiBoardList = new NotiService().listUpNoti();

		// VO를 토대로 리스트업 !!
		System.out.println("===== 공지사항 게시판 =====");

		// 게시판 목록에 나올 필드들 뽑아오기

		for (int i = 0; i < notiBoardList.size(); ++i) {

			NotiVo notiVo = notiBoardList.get(i);

			int notiNo = notiVo.getNotiNo();
			String title = notiVo.getTitle();
			String writer = notiVo.getWriter();
			Timestamp enrollDate = notiVo.getEnrollDate();

			System.out.println(notiNo + "|" + title + "|" + writer + "|" + enrollDate);

		}

	}

	// 게시글 작성
	public void writeNoti() {
		// 로그인 확인
		if (Main.loginMember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}

		// 권한 확인 //이게 스트링이던가..
		if (Main.loginMember.getNo() != 99999) {
			System.out.println("권한이 없습니다.");
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
			System.out.println("게시글 작성 성공!");
		} else {
			// 글 작성 실패
			System.out.println("게시글 작성 실패...!");
		}
	}



	// 게시글 수정, 게시글 상세보기를 통해 하던지..
	public void updateNoti() {

		// DAO를 통해 UPDATE

		// UPDATE 후 결과조회!!

	}

	// 게시글 삭제, 게시글 상세보기를 통해 하던지..
	public void deleteNoti() {
		// DAO를 통해 DELETE

		// DELETE 후 결과조회!!

	}
}
