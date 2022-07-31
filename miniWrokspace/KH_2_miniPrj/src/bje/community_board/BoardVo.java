package bje.community_board;

import java.sql.Timestamp;

public class BoardVo {

	//DB 테이블 칼럼들 필드로 작성
	
	//제목, 내용, 작성자(번호), 작성시각, 삭제여부, 수정시각 등등 여기! 도 수정해야함 ㅠㅠ
	
	public BoardVo() {
		
	}

	public BoardVo(int b_no, int m_no, String post_type, String tag, String title, String content, Timestamp enrollDate,
			String writer, String delete_yn, String modity, Timestamp modifyDate) {
		this.b_no = b_no;
		this.m_no = m_no;
		this.post_type = post_type;
		this.tag = tag;
		this.title = title;
		this.content = content;
		this.enrollDate = enrollDate;
		this.writer = writer;
		this.delete_yn = delete_yn;
		this.modity = modity;
		this.modifyDate = modifyDate;
	}

	private int b_no;
	private int m_no;
	private String post_type;
	private String tag;
	private String title;
	private String content;
	private Timestamp enrollDate;
	private String writer;
	private String delete_yn;
	private String modity;
	private Timestamp modifyDate;
	
	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getPost_type() {
		return post_type;
	}

	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDelete_yn() {
		return delete_yn;
	}

	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}

	public String getModity() {
		return modity;
	}

	public void setModity(String modity) {
		this.modity = modity;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "BoardVo [b_no=" + b_no + ", m_no=" + m_no + ", post_type=" + post_type + ", tag=" + tag + ", title="
				+ title + ", content=" + content + ", enrollDate=" + enrollDate + ", writer=" + writer + ", delete_yn="
				+ delete_yn + ", modity=" + modity + ", modifyDate=" + modifyDate + "]";
	}

}//class




















