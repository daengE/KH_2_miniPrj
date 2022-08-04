package lcs.atc;

import java.util.List;

import lcs.application.ApplicationController;
import lcs.menu.Menu;
import mini.util.InputUtil;

public class ATCController {
	
	//동물보호소 리스트를 간단한 항목만 보여준다 (순서, 이름, 특징, 지역)
	public void showATCList() {
		
		List<ATCVo> ATCVoList = new ATCService().showATCList();
		
		System.out.println("==== 동물 훈련소 목록 ====");
		
		if(mini.main.Main.loginMember == null) {
			System.out.println("로그인 먼저 해주세요");
			return; //다음 진행 하면 안되니까 return 
		}
		
		for(int i = 0 ; i < ATCVoList.size(); ++i) {
			ATCVo atcvo = ATCVoList.get(i);
			
			
			int no = atcvo.getNo();
			String name = atcvo.getName();
			String call = atcvo.getCall();
			String skill = atcvo.getSkill();
			String loc = atcvo.getLoc();
			String animal = atcvo.getAnimal();
			String city = atcvo.getCity();
		
			
			System.out.println(no + " | " + name + " | " + city + " | " + skill);
		}
			//상세조회 할건지 물어보기
			//출력문, 입력받기
			int num = new Menu().showATCDetailMenu();
			if(num == 0) {
				System.out.println("\n 메인메뉴로 돌아갑니다.");
				return;
			}
			else {
				ATCVo atcvo = new ATCService().showDetailByNo(num);
			
				System.out.println("--------------게시글 상세조회--------------");
				System.out.println("훈련소 이  름 :::" + atcvo.getName());
				System.out.println("훈련소 전화번호 :::" + atcvo.getCall());
				System.out.println("훈련소 위   치 :::" + atcvo.getLoc());
				System.out.println("훈련소 주력스킬 :::" + atcvo.getSkill());
				System.out.println("훈련소 신청가능 동물 :::"+ atcvo.getAnimal());
				
				
				//훈련소 신청하시겠습니까? 
				
				String input = new lcs.menu.Menu().showATCAply();
				
				if(input.equalsIgnoreCase("Y")) {
					
					new ApplicationController().write(atcvo);
				}
				else if(input.equalsIgnoreCase("N")) {
					System.out.println("\n 훈련소 목록으로 돌아갑니다.");
					showATCList();
				}
			}
		}

	public void showCityATCList() {
		int writeCity = new Menu().showCityMenu();
		
		List<ATCVo> ATCVoList = new ATCService().showCityATCList(writeCity);
		ATCVo atcvo = null;
		
		for(int i = 0 ; i < ATCVoList.size(); ++i) {
			atcvo = ATCVoList.get(i);
			
			
			int no = atcvo.getNo();
			String name = atcvo.getName();
			String call = atcvo.getCall();
			String skill = atcvo.getSkill();
			String loc = atcvo.getLoc();
			String animal = atcvo.getAnimal();
	
		
			
			System.out.println(no + " | " + name + " | " + loc + " | " + skill);
		}
			//상세조회 할건지 물어보기
			//출력문, 입력받기
			int num = new Menu().showATCDetailMenu();
			if(num == 0) {
				System.out.println("\n 메인메뉴로 돌아갑니다.");
				return;
			}
			else {
				atcvo = new ATCService().showDetailByNo(num);
			
				System.out.println("--------------게시글 상세조회--------------");
				System.out.println("훈련소 이  름 :::" + atcvo.getName());
				System.out.println("훈련소 전화번호 :::" + atcvo.getCall());
				System.out.println("훈련소 위   치 :::" + atcvo.getLoc());
				System.out.println("훈련소 주력스킬 :::" + atcvo.getSkill());
				System.out.println("훈련소 신청가능 동물 :::"+ atcvo.getAnimal());
			}
			//훈련소 신청하시겠습니까? 
			
			String input = new lcs.menu.Menu().showATCAply();
			if(input.equalsIgnoreCase("Y")) {
				
				new ApplicationController().write(atcvo);
			}
			else if(input.equalsIgnoreCase("N")) {
				System.out.println("\n 훈련소 목록으로 돌아갑니다.");
				showCityATCList();
			}
	}	
	
	
}
