package lcs.menu;

import mini.util.InputUtil;

public class Menu {
	
	
	public int showMenu() {
		
		
		System.out.println("임찬선 - 동물훈련팁 부분입니다.");
		

		System.out.println("3. 동물훈련 팁");
		System.out.println("4. 동물훈련소 보기");
		System.out.println("5. 맨 처음 메뉴로 돌아가기");
		
		return InputUtil.getInt();
		
	}
	
	public int showATCDetailMenu() {
		System.out.println("조회할 글 번호 (0번은 메인메뉴) : ");
		return InputUtil.getInt();
	}
	
}
