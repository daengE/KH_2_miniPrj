package lcs.atc;

import java.sql.Connection;
import java.util.List;

import lcs.menu.Menu;
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

	public List<ATCVo> showCityATCList(int writeCity) {
		
		String cityName = null;
		if(writeCity == 1) {
			cityName = "서울시";
		}
		else if(writeCity == 2) {
			 cityName = "경기도";
		}
		else if(writeCity == 3) {
			 cityName = "강원도";
		}
		else if(writeCity == 4) {
			 cityName = "충청도";
		}
		else if(writeCity == 5) {
			 cityName = "전라도";
		}
		else if(writeCity == 6) {
			 cityName = "경상도";
		}
		else if(writeCity == 7) {
			 cityName = "제주도";
		}
		else {
			System.out.println("번호입력을 잘못하셨습니다.");
		}
		System.out.println(cityName);
		List<ATCVo> ATCVoList = null;
		Connection conn = null;
		try {
			conn = JDBCTemplate.getConnection();
			ATCVoList = new ATCDao().showCityATCList(cityName, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(conn);
		}
		return ATCVoList;
		
		
	}

	
	
	
	
	
	
	
	
	
}
