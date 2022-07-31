package bje.community_board;

import static bje.common.JDBCTemplate.*;

import java.sql.Connection;

public class BoardService {

	/*
	 * 게시글 작성
	 * 
	 * 데이터 받기 (컨트롤러)
	 * 
	 * 비지니스 로직 (서비스)
	 * 
	 * DB에 insert (DAO)
	 */
	public int write(BoardVo vo) {

		//비지니스 로직 (제목, 내용 1글자 이상인지)
		if(vo.getTitle().length() < 1) {
			//제목이 비어있음. 다음단계 진행 X
			return -1;
		}
		
		if(vo.getContent().length() < 1) {
			//내용이 비어있음. 다음단계 진행 X
			return -2;
		}
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			result = new BoardDao().write(vo, conn);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
		
	}//write
	
}//class


















