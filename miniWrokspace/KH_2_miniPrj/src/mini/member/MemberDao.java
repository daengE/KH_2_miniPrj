package mini.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import mini.common.JDBCTemplate;
import mini.main.Main;

public class MemberDao {
	
	public MemberVo login(String inputId, String inputPwd) throws Exception {
		//DB 가서 , id pwd 일치하는 행 조회
		
		// CONNECTION 준비
		Connection conn = JDBCTemplate.getConnection();
		
		// SQL 작성
		String sql = "SELECT * FROM MEMBER WHERE M_ID = ? AND M_PWD = ? AND DISABLED = 0";
		
		// SQL 객체에 담기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputId);
		pstmt.setString(2, inputPwd);
		
		// SQL 실행
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo vo = null;
		
		if(rs.next()) {
			
			int no = rs.getInt("M_NO");
			String id = rs.getString("M_ID");
			String name = rs.getString("M_NAME");
			String nick = rs.getString("M_NICK");
			String email = rs.getString("M_EMAIL");
			String birth = rs.getString("M_BIRTH");
			String address = rs.getString("M_ADDRESS");
			String cell = rs.getString("M_CELL");
			String animal = rs.getString("ISANIMAL");
			
			Timestamp createDate = rs.getTimestamp("CREATE_DATE");
			Timestamp modifyDate = rs.getTimestamp("MODIFY_DATE");
			
			int disabled = rs.getInt("DISABLED");
			int mbRight = rs.getInt("MB_RIGHT");
			
			vo = new MemberVo();
			vo.setNo(no);
			vo.setId(id);
			vo.setName(name);
			vo.setNick(nick);
			vo.setEmail(email);
			vo.setBirth(birth);
			vo.setAddress(address);
			vo.setCell(cell);
			vo.setAnimal(animal);
			vo.setCreateDate(createDate);
			vo.setModifyDate(modifyDate);
			vo.setDisaled(disabled);
			vo.setMbRight(mbRight);

//			System.out.println(vo); //객체 저장 확인용
			
		}
		
		return vo;
	}

	
	public int join(MemberVo vo, MemberPetVo petVo, Connection conn) throws Exception {
		//DB insert
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			//SQL 준비
			String sql = "INSERT INTO MEMBER(M_NO, M_ID, M_PWD, M_NAME, M_NICK, M_EMAIL, M_BIRTH, M_ADDRESS, M_CELL)\n"
					+ " VALUES(MEMBER_SEQ.NEXTVAL , ?, ?, ?, ?, ? ,?, ?, ?)";
			
			//SQL 담을 객체 만들기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getBirth());
			pstmt.setString(7, vo.getAddress());
			pstmt.setString(8, vo.getCell());
			
			//SQL 실행 및 결과 저장
			result = pstmt.executeUpdate();
			
			//펫 SQL (null 아닐때)
			if(petVo != null) {
				//SQL 준비
				String petSql = "INSERT INTO ANIMAL \r\n"
						+ "VALUES(MEMBER_SEQ.CURRVAL, ?, ?, ?, ?)";
				
				//SQL 객체 만들기
				pstmt = conn.prepareStatement(petSql);
				pstmt.setString(1, petVo.getType());
				pstmt.setString(2, petVo.getName());
				pstmt.setString(3, petVo.getBirth());
				pstmt.setString(4, petVo.getGender());
				
				//SQL 실행
				pstmt.executeUpdate();
			
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}//method


	public List<MemberPetVo> showMyPet(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM ANIMAL WHERE USER_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberPetVo> myPetList = new ArrayList<MemberPetVo>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Main.loginMember.getNo());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				int memberNo = rs.getInt("USER_NO");
				String aniType = rs.getString("ANI_TYPE");
				String aniGender = rs.getString("ANI_GENDER");
				String aniName = rs.getString("ANI_NAME");
				String aniBirth = rs.getString("ANI_BIRTH");
				
				MemberPetVo petVo = new MemberPetVo();
				
				petVo.setMemberNo(memberNo);
				petVo.setType(aniType);
				petVo.setGender(aniGender);
				petVo.setName(aniName);
				petVo.setBirth(aniBirth);
				
				//담은 객체 리스트에 넣기
				
				myPetList.add(petVo);
				
//				System.out.println(petVo); //객체확인
				
			}
			
			
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		
		return myPetList;
	}
	

}//class













