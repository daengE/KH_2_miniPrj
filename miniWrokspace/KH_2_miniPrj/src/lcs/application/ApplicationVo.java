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
		return "Application_Vo [no=" + no + ", userNo=" + userNo + ", atcName=" + atcName + ", animalType=" + animalType
				+ ", phone=" + phone + ", aplyDate=" + aplyDate + ", psbDate=" + psbDate + ", postType=" + postType
				+ "]";
	}
	
	
	
	
}
