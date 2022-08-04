package lcs.atc;

import java.util.List;

import lcs.menu.Menu;
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
			int num = new Menu().showATCDetailMenu();
			if(num == 0) {
				System.out.println("메인메뉴로 돌아갑니다.");
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
				
				
			}
		}
		
		
	
	
}
