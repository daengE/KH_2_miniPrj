package lcs.application;

import lcs.Main_lcs;
import mini.util.InputUtil;

public class ApplicationController {
	
	
	public void write() {
		
		System.out.println("훈련소 입소 신청서를 작성해주세요");
		
		if(Main_lcs.loginMember == null) {
			System.out.println("로그인 먼저 해주세요");
			return; //다음 진행 하면 안되니까 return 
		}
		
		//회원번호로 닉네임 받고 닉네임님 작성해주세요.
		
		
		
		System.out.println(Main_lcs.loginMember.getNick()+"님 입소신청서를 작성해주세요");
		System.out.println();
		System.out.println("----- 훈련소 입소 신청서 ----");
		System.out.println("신청하실 훈련소 이름을 입력해주세요.");
		System.out.print("동물훈련소 이름 : ");
		String atcNAme = InputUtil.sc.nextLine();
		System.out.println("신청하실 동물은 어떤 종류인가요?");
		System.out.print("동물의 종류 : ");
		String animalType = InputUtil.sc.nextLine();
		System.out.println("연락가능한 핸드폰 번호를 작성해주세요(훈련소와 연결 시 필요합니다.)");
		System.out.print("핸드폰번호 : ");
		String phone = InputUtil.sc.nextLine();
		System.out.println("입소가능한 날짜를 알려주세요(형식 예 : 220802");
		System.out.print("입소가능일자 : ");
		String psbDate = InputUtil.sc.nextLine();
		
		ApplicationVo aplyVo = new ApplicationVo();
		aplyVo.setUserNo(Main_lcs.loginMember.getNo());
		aplyVo.setAtcName(atcNAme);
		aplyVo.setAnimalType(animalType);
		aplyVo.setPhone(phone);
		aplyVo.setPsbDate(psbDate);
		
		//DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
		 int result = new ApplicationService().write(aplyVo);
	
		 if(result == 1) {
			 System.out.println("게시글 성공~");
		 }
	}
	
}
