package lcs.menu;

import lcs.application.ApplicationController;
import lcs.atc.ATCController;
import mini.util.InputUtil;

public class Menu {
	
	
	public int showMenu() {
		
		
		System.out.println("임찬선 - 동물훈련팁 부분입니다.");
		
		System.out.println("1. 로그인");
		System.out.println("3. 동물훈련 팁");
		System.out.println("4. 동물훈련소 보기");
		System.out.println("5. 맨 처음 메뉴로 돌아가기");
		System.out.println("9. 맨 처음 메뉴로 돌아가기");
		
		return InputUtil.getInt();
		
	}
	
	public int showATCDetailMenu() {
		System.out.println("\n \n 조회할 글 번호를 입력해주세요 (0번은 메인메뉴) : ");
		return InputUtil.getInt();
	}

	public String showATCAply() {
		
		
		System.out.println("\n \n 위의 훈련소에 입소상담을 신청하시겠습니까?");
		System.out.println("Y / N");
		
		return InputUtil.sc.nextLine();

	}
	public int showATCSelectMenu() {
		System.out.println("1. 모든 동물 보호소 보기");
		System.out.println("2. 지역별 동물 보호소 보기");
		
		return InputUtil.getInt();
	}

	public int showCityMenu() {
		System.out.println("\n \n 원하시는 지역을 선택해 주세요");
		System.out.println("1. 서울시");
		System.out.println("2. 경기도");
		System.out.println("3. 강원도");
		System.out.println("4. 충청도");
		System.out.println("5. 전라도");
		System.out.println("6. 경상도");
		System.out.println("7. 제주도");

		return InputUtil.getInt();
	}
	
	
}
