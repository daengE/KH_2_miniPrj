package sar.Ad_Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mini.common.JDBCTemplate;
import mini.util.InputUtil;
import mini.main.Main;
import mini.menu.Menu;
import sar.Util.AdVo;

public class Adoption {

	public void apply(int no) {

		System.out.println("입양하실 분의 이름을 입력하세요 : ");
		String name = InputUtil.sc.nextLine();

		System.out.println("입양하실 분의 연락처를 입력하세요 (하이픈(-) 제외) : ");
		String phone = InputUtil.sc.nextLine();

		System.out.println("입양가능일을 입력하세요 (ex : 220810): ");
		String day = InputUtil.sc.nextLine();

		AdVo vo = new AdVo();
		vo.setM_no(no);
		vo.setAd_adopt(day);
		vo.setAd_name(name);
		vo.setAd_phone(phone);

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO ADOPTION (AD_AP_NO, AD_NAME, AD_PHONE, ADOPT, AD_DATE, M_NO,AD_NO) VALUES (SEQ_AD_AP_NO.NEXTVAL,?,?,?,SYSDATE,?,?)";

		try {
			conn = JDBCTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getAd_adopt());
			pstmt.setString(2, vo.getAd_name());
			pstmt.setString(3, vo.getAd_phone());
			pstmt.setInt(4, vo.getM_no());
			pstmt.setInt(5, mini.main.Main.selected.getAd_no());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				new Adoption().AdoptOk(Main.loginMember.getNo());
				conn.commit();
			} else {
				System.out.println("신청서 작성 실패...");
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);

		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}

	}

	private void AdoptOk(int no) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE ADANDONED_BOARD SET AD_ADOPT = ? WHERE AD_NO = ?";

		try {
			conn = JDBCTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Y");
			pstmt.setInt(2, mini.main.Main.selected.getAd_no());

			int result = pstmt.executeUpdate();

			if (result >= 1) {
				System.out.println("신청서 작성 완료!");
				System.out.println("입양 신청 후 철회가 불가능합니다. 정말 입양 하시겠습니까?");
				System.out.println("1. 확인");
				System.out.println("2. 취소");
				int num2 = InputUtil.getInt();

				if (num2 == 1) {
					System.out.println("입양 신청이 완료되었습니다.");
					conn.commit();

				} else {
					conn.rollback();
				}
			} else {
				System.out.println("입양 업뎃오류");
				conn.rollback();
			}

			System.out.println("돌아가실 메뉴를 선택하세요");
			System.out.println("1. 유기동물 게시판");
			System.out.println("2. 처음으로 돌아가기");
//			System.out.println("3. 프로그램 종료");

			int num3 = InputUtil.getInt();
			if (num3 == 1) {
				new Adandoned().list();
			} else if (num3 == 2) {
				mini.main.Main.main(null);
				
				}
//			} else if (num3 == 3) {
//	
//				System.out.println("시스템을 종료 합니다...!");
////				return;
////			mini.main.Main.main(null);
//			}

		}catch (Exception e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);

		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
	}

}
