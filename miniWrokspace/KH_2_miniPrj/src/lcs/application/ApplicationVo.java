package lcs.application;

import java.sql.Date;

public class ApplicationVo {
	
	public ApplicationVo() {
		
	}
	public ApplicationVo(String no, int userNo, String atcName, String animalType, String phone, String aplyDate,
			String psbDate, String postType) {
		
		this.no = no;
		this.userNo = userNo;
		this.atcName = atcName;
		this.animalType = animalType;
		this.phone = phone;
		this.aplyDate = aplyDate;
		this.psbDate = psbDate;
		this.postType = postType;
	}
	
	private String no;
	private int userNo;
	private String atcName;
	private String animalType;
	private String phone;
	private String aplyDate;
	private String psbDate;
	private String postType;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getAtcName() {
		return atcName;
	}
	public void setAtcName(String atcName) {
		this.atcName = atcName;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAplyDate() {
		return aplyDate;
	}
	public void setAplyDate(String aplyDate) {
		this.aplyDate = aplyDate;
	}
	public String getPsbDate() {
		return psbDate;
	}
	public void setPsbDate(String psbDate) {
		this.psbDate = psbDate;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	
	@Override
	public String toString() {
		System.out.println("작성하신 내용 확인 부탁드립니다.");
		return ("훈려소 이름 :" + atcName + ", 신청한 동물=" + animalType + ", 신청한 번호=" + phone + ", 입소가능일자=" + psbDate );
	}
	
	
	
	
}
