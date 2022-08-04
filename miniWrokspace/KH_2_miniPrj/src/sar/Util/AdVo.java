package sar.Util;

public class AdVo {
	
	public AdVo() {
		
	}
	
	public AdVo(String ad_no, String post_type, String ad_adopt, String animal, String type, String city, String gender,
			String age, String kill, String shelter, String address, String feature, String nt) {
		this.ad_no = ad_no;
		this.post_type = post_type;
		this.ad_adopt = ad_adopt;
		this.animal = animal;
		this.type = type;
		this.city = city;
		this.gender = gender;
		this.age = age;
		this.kill = kill;
		this.shelter = shelter;
		this.address = address;
		this.feature = feature;
		this.nt = nt;
	}

	public AdVo(String ap_no, String adpot, String ad_name, String ad_phone, String ad_date, String m_no) {
		super();
		this.ap_no = ap_no;
		this.adpot = adpot;
		this.ad_name = ad_name;
		this.ad_phone = ad_phone;
		this.ad_date = ad_date;
		this.m_no = m_no;
	}

	private String ad_no;
	private String post_type;
	private String ad_adopt ;
	private String animal;
	private String type;
	private String city;  
	private String gender; 
	private String age;
	private String kill;
	private String shelter;
	private String address;
	private String feature;
	private String nt;
	
	private String ap_no;
	private String adpot;
	private String ad_name;
	private String ad_phone;
	private String ad_date;
	private String m_no;
	
	public String getAd_no() {
		return ad_no;
	}
	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}
	public String getPost_type() {
		return post_type;
	}
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	public String getAd_adopt() {
		return ad_adopt;
	}
	public void setAd_adopt(String ad_adopt) {
		this.ad_adopt = ad_adopt;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getKill() {
		return kill;
	}
	public void setKill(String kill) {
		this.kill = kill;
	}
	public String getShelter() {
		return shelter;
	}
	public void setShelter(String shelter) {
		this.shelter = shelter;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getNt() {
		return nt;
	}
	public void setNt(String nt) {
		this.nt = nt;
	}
	public String getAp_no() {
		return ap_no;
	}
	public void setAp_no(String ap_no) {
		this.ap_no = ap_no;
	}
	public String getAdpot() {
		return adpot;
	}
	public void setAdpot(String adpot) {
		this.adpot = adpot;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_phone() {
		return ad_phone;
	}
	public void setAd_phone(String ad_phone) {
		this.ad_phone = ad_phone;
	}
	public String String() {
		return ad_date;
	}
	public void setAd_date(String ad_date) {
		this.ad_date = ad_date;
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	@Override
	public String toString() {
		return  ad_no + "| post_type=" + post_type + ", 입양여부 : " + ad_adopt + ", 축종 : " + animal
				+ ", 세부 종류 : " + type + ", 지역 : " + city + ", 성별 : " + gender + ", 나이 : " + age + ", 안락사 일정 : " + kill
				+ ", 보호소명 : " + shelter + ", 보호소 주소 : " + address + ", 특이 사항 : " + feature + ", 중성화 여부 : " + nt + "";
	}
	
	
}
