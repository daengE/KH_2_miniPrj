package lcs.application;

import mini.main.Main;
import lcs.atc.ATCVo;
import mini.util.InputUtil;

public class ApplicationController {
	
	
	public void write(ATCVo atcvo) {
		
		System.out.println("훈련소 입소 신청서를 작성해주세요");
		
		//회원번호로 닉네임 받고 닉네임님 작성해주세요.
		
		
		
		System.out.println(mini.main.Main.loginMember.getNick()+"님 입소신청서를 작성해주세요");
		System.out.println();
		System.out.println("----- 훈련소 입소 신청서 ----");
		System.out.println("신청하실 훈련소 이름");
		System.out.print("동물훈련소 이름 : " + atcvo.getName());
		System.out.println("신청하실 동물은 어떤 종류인가요?");
		System.out.print("동물의 종류 : ");
		String animalType = InputUtil.sc.nextLine();
		System.out.println("연락가능한 핸드폰 번호를 작성해주세요(훈련소와 연결 시 필요합니다.)");
		System.out.println("하이픈 제외하고 숫자만 작성해주세요.");
		System.out.print("핸드폰번호 : ");
		String phone = InputUtil.sc.nextLine();
		System.out.println("입소가능한 날짜를 알려주세요(형식 예 : 220802");
		System.out.print("입소가능일자 : ");
		String psbDate = InputUtil.sc.nextLine();
		
		ApplicationVo aplyVo = new ApplicationVo();
		aplyVo.setUserNo(mini.main.Main.loginMember.getNo());
		aplyVo.setAtcName(atcvo.getName());
		aplyVo.setAnimalType(animalType);
		aplyVo.setPhone(phone);
		aplyVo.setPsbDate(psbDate);
		System.out.println(aplyVo);
		//DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
		 int result = new ApplicationService().write(aplyVo);
	
		 if(result == 1) {
			 System.out.println("입소 신청서를 완료하셨습니다.");
		 }
		
	}
	
}
