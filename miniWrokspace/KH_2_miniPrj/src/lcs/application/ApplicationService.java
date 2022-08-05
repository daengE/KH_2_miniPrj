package lcs.application;

import static mini.common.JDBCTemplate.*;

import java.sql.Connection;

public class ApplicationService {

	public int write(ApplicationVo aplyVo) {
	
		if(aplyVo.getAnimalType().length() < 1)
		return -1;
		
		if(aplyVo.getPhone().length() < 1)
		return -2;
		
		Connection conn = null;
		int result = 0;
	try {
		
		conn = getConnection();
		result = new ApplicationDao().write(aplyVo, conn);
		if(result == 1) {
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
