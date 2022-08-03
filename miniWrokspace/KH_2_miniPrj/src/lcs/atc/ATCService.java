package lcs.atc;

import java.sql.Connection;
import java.util.List;

import bje.community_board.BoardVo;
import mini.common.JDBCTemplate;

public class ATCService {

	public List<ATCVo> showATCList() {
		
		
		Connection conn = null;
		List<ATCVo> ATCVoList = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			
			ATCVoList = new ATCDao().showATCList(conn);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(conn);
		}

		return ATCVoList;
	}

	public ATCVo showDetailByNo(int num) {
		
		Connection conn = null;
		ATCVo atcvo = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			atcvo = new ATCDao().showDetailByNo(conn, num);
			
		} catch (Exception e) {
			System.out.println("글 상세 조회중 오류발생함");
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(conn);
		}
		
		
		
		
		return atcvo;
	}

	
	
	
	
	
	
	
	
	
}
