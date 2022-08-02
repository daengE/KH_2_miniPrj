package lcs.menu;

import util.InputUtil;

public class Menu {
	
	
	public int showLcs() {
		
		
		System.out.println("임찬선 - 동물훈련팁 부분입니다.");
		
		System.out.println("1. 동물훈련 팁");
		System.out.println("2. 동물훈련소 보기");
		System.out.println("3. 맨 처음 메뉴로 돌아가기");
		
		return InputUtil.getInt();
		
	}
}
