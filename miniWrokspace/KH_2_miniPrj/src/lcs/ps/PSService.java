package lcs.ps;

import java.sql.Connection;
import java.util.List;

import lcs.atc.ATCDao;
import lcs.atc.ATCVo;
import mini.common.JDBCTemplate;

public class PSService {

	public List<PSVo> showPSList() {
		Connection conn = null;
		List<PSVo> PSVoList = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			
			PSVoList = new PSDao().showPSList(conn);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(conn);
		}

		return PSVoList;
	}

	
	
	public PSVo showDetailPS(int num) {
		Connection conn = null;
		PSVo psvo = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			psvo = new PSDao().showDetailPS(conn, num);
			
		} catch (Exception e) {
			System.out.println("글 상세 조회중 오류발생함");
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(conn);
		}
		return psvo;
	}

}
