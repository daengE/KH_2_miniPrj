package lcs.atc;

import java.util.List;

import lcs.application.ApplicationController;
import lcs.menu.LcsMenu;
import lcs.ps.PSController;
import mini.util.InputUtil;

public class ATCController {
	
	//동물보호소 리스트를 간단한 항목만 보여준다 (순서, 이름, 특징, 지역)
	public void showATCList() {
		
		List<ATCVo> ATCVoList = new ATCService().showATCList();
		
		System.out.println("==== 동물 훈련소 목록 ====");
		
		
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
			int num = new LcsMenu().showATCDetailMenu();
			if(num == 0) {
				System.out.println();
				System.out.println("이전 메뉴로 돌아갑니다.");
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
				
				String input = new lcs.menu.LcsMenu().showATCAply();
				
				if(input.equalsIgnoreCase("Y")) {
					
					new ApplicationController().write(atcvo);
				}
				else if(input.equalsIgnoreCase("N")) {
					System.out.println();
					System.out.println("이전 선택으로 돌아갑니다.");
					showATCList();
					
				}
			}
		}

	public void showCityATCList() {
		int writeCity = 10;
		do {
			
			writeCity = new LcsMenu().showCityMenu();
			if(writeCity > 7) {
				System.out.println("번호를 잘못 선택하셨습니다. 재입력 부탁드립니다.");
			}
		}
		while(writeCity > 7);
			
		
		
		
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
			int num = new LcsMenu().showATCDetailMenu();
			if(num == 0) {
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
			
			String input = new lcs.menu.LcsMenu().showATCAply();
			if(input.equalsIgnoreCase("Y")) {
				
				new ApplicationController().write(atcvo);
			}
			else if(input.equalsIgnoreCase("N")) {
				System.out.println("\n 훈련소 목록으로 돌아갑니다.");
				showCityATCList();
			}
	}

	public void sum() {
		//
		int selectATCMenu = new LcsMenu().showATCSelectMenu();
		//동물보호소 전체를 보여준다.
		if(selectATCMenu == 1) {
			new ATCController().showATCList();						
		}
		//지역별 동물 보호소를 보여준다.
		else if(selectATCMenu == 2) {
			
			new ATCController().showCityATCList();
		}
		else if(selectATCMenu == 0) {
			
			System.out.println();
			System.out.println("문제행동목록을 보여드립니다.");
			 new PSController().showPSList();
		}
		
		
	}	
	
	
}
