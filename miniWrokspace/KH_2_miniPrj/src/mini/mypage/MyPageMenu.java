package mini.mypage;

import mini.util.InputUtil;

public class MyPageMenu {
	
	public int showMyPetMenu() {

		System.out.println("1. 내 반려동물 추가하기");
		System.out.println("2. 내 반려동물 삭제하기");
		System.out.println("0. 메인메뉴로");

		int input = InputUtil.getInt();

		return input;
	}

	public int showUpdateMyInfo() {
		
		System.out.println("수정 하실 정보를 선택 하세요.");
		
		System.out.println("1. 닉네임");
		System.out.println("2. 이메일");
		System.out.println("3. 주소");
		System.out.println("4. 폰번호");
		System.out.println("0. 메인메뉴로");
		
		int input = InputUtil.getInt();
		
		return input;
	}

}
