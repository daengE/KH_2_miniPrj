package sar.Ad_Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mini.common.JDBCTemplate;
import mini.util.InputUtil;
import mini.main.Main;
import sar.Util.AdVo;

public class Adoption {

	public void apply(int no) throws Exception {
		
		System.out.println("입양하실 분의 이름을 입력하세요 : ");
		String name = InputUtil.sc.nextLine();
		
		System.out.println("입양하실 분의 연락처를 입력하세요 (하이픈(-) 제외) : ");
		String phone = InputUtil.sc.nextLine();
		
		System.out.println("입양가능일을 입력하세요 : ");
		String day = InputUtil.sc.nextLine();
		
		AdVo vo = new AdVo();
		vo.setM_no(no);
		vo.setAd_adopt(day);
		vo.setAd_name(name);
		vo.setAd_phone(phone);
		
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO ADOPTION (AD_AP_NO, AD_NAME, AD_PHONE, ADOPT, AD_DATE, M_NO,AD_NO) VALUES (SEQ_AD_AP_NO.NEXTVAL,?,?,?,SYSDATE,?,?)";

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getAd_adopt());
			pstmt.setString(2, vo.getAd_name());
			pstmt.setString(3, vo.getAd_phone());
			pstmt.setInt(4, vo.getM_no());
			pstmt.setInt(5, mini.main.Main.selected.getAd_no());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("신청서 작성 완료!");
				new Adoption().AdoptOk(Main.loginMember.getNo()); 
				conn.commit();
			}else {
				System.out.println("신청서 작성 실패...");
				conn.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		
	}

	private void AdoptOk(int no) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE ADANDONED_BOARD SET AD_ADOPT = ? WHERE AD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Y");
			pstmt.setInt(2, mini.main.Main.selected.getAd_no());
			
			int result = pstmt.executeUpdate();
			System.out.println(result);
			if(result >= 1) {
				System.out.println("입양 업뎃완료!");
				conn.commit();
			}else {
				System.out.println("입양 업뎃실패");
				conn.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		
		}finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
	}
	
}
	


