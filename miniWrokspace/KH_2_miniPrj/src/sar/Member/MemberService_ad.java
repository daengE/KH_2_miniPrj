package sar.Member;

import java.sql.Connection;

import sar.Util.JDBCTemplate_ad;

public class MemberService_ad {

	public int join(MemberVo_ad vo) {
		//아이디 4글자 이상인지
				if(vo.getId().length() < 4) {
					// 다음단계 진행하면 안됨. 실패라고 알려줘야함.
					return -1;
				}
				
				//패스워드 4글자 이상인지
				if(vo.getPwd().length() < 4) {
					// 다음단계 진행하면 안됨. 실패라고 알려줘야함.
					return -2;
				}
				
				//패스워드 일치하는지 (비밀번호 확인)
				if(vo.getPwd().equals(vo.getPwd2()) == false) {
					// 다음단계 진행하면 안됨. 실패라고 알려줘야함.
					return -3;
				}
		
	Connection conn = null;
	int result = 0;

	try{
		conn = JDBCTemplate_ad.getConnection();
		result = new MemberDao_ad().join(vo,conn);
	
		if(result == 1) {
			JDBCTemplate_ad.commit(conn);
		}else {
			JDBCTemplate_ad.rollback(conn);
		}
	}catch(Exception e) {
			JDBCTemplate_ad.rollback(conn);
	}finally {
			JDBCTemplate_ad.close(conn);
	}
	
		return result;
}
}
