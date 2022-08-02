package lcs.application;

import java.sql.Connection;

import static common.JDBCTemplate.*;

public class ApplicationService {

	public int write(ApplicationVo aplyVo) {
		
		if(aplyVo.getAtcName().length() < 1)
		return -1;
		
		if(aplyVo.getAnimalType().length() < 1)
		return -2;
		
		if(aplyVo.getPhone().length() < 1)
		return -3;
		
		Connection conn = null;
		int result = 0;
	try {
		
		conn = getConnection();
		result = new ApplicationDao().write(aplyVo, conn);
		if(result == 1) {
			System.out.println("입력성공");
		}
	}
	catch(Exception e) {
		
	}
	finally {
		close(conn);
	}
	
	
	
	return result;
	
	}
	
	
	
	
}
