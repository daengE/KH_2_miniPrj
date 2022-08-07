package lcs.application;

import mini.main.Main;
import mini.member.MemberController;
import lcs.atc.ATCVo;
import mini.util.InputUtil;
import mini.util.StringTest;

public class ApplicationController {
	
	
	public void write(ATCVo atcvo) {
		
	
		if (Main.loginMember == null) {
			System.out.println();
			System.out.println("먼저 로그인을 해주세요.");
			new MemberController().login();
		}
		
		//회원번호로 닉네임 받고 닉네임님 작성해주세요.
		
	
		System.out.println(mini.main.Main.loginMember.getNick()+"님 입소신청서를 작성해주세요");
		
		System.out.println();
		System.out.println("------------- 훈련소 입소 신청서 ------------\n");
		System.out.println("신청하실 훈련소 이름이 맞는지 확인 부탁드립니다.");
		System.out.println("동물훈련소 이름 : " + atcvo.getName());
		System.out.println();
		
		System.out.println("신청하실 동물은 어떤 종류인가요?");
		System.out.print("동물의 종류 : ");
		String animalType = InputUtil.sc.nextLine();
		System.out.println();
		
		System.out.println("연락가능한 핸드폰 번호를 작성해주세요(훈련소와 연결 시 필요합니다.)");
		System.out.println("하이픈 제외하고 숫자만 작성해주세요.");
		System.out.print("핸드폰번호 : ");
		String phone = InputUtil.sc.nextLine();
		System.out.println();
		
		System.out.println("입소가능한 날짜를 알려주세요(형식 예 : 220802)");
		System.out.print("입소가능일자 : ");
		String psbDate = InputUtil.sc.nextLine();
		System.out.println();
		
		ApplicationVo aplyVo = new ApplicationVo();
		aplyVo.setUserNo(mini.main.Main.loginMember.getNo());
		aplyVo.setAtcName(atcvo.getName());
		aplyVo.setAnimalType(animalType);
		aplyVo.setPhone(phone);
		aplyVo.setPsbDate(psbDate);
		
		int atcNameLength = new StringTest().getStrLength(38, aplyVo.getAtcName());
		int animalLength = new StringTest().getStrLength(38, aplyVo.getAnimalType());
		int phoneLength = new StringTest().getStrLength(38, aplyVo.getPhone());
		
		System.out.println("**********  작성하신 입소신청서를 확인해주세요  *********");
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|훈련소 이    름 :: "+ String.format("%-" + atcNameLength + "s", aplyVo.getAtcName())+"|");
		System.out.println("|신청한 동    물 :: "+ String.format("%-" + animalLength + "s", aplyVo.getAnimalType())+"|");
		System.out.println("|신청한 전화번호 :: "+ String.format("%-" + phoneLength + "s", aplyVo.getPhone())+"|");
		System.out.println("+---------------------------------------------------------+");
		
		
		//DB에 인서트 하기 위해서, DB insert 하는 서비스 메소드 호출
		
			int result = new ApplicationService().write(aplyVo);
			
			if(result == 1) {
				System.out.println("입소상담 신청서를 완료하였습니다. \n");
				System.out.println("<"+atcvo.getName()+">에서 <" + aplyVo.getPhone()+ ">으로 연락드리겠습니다.");
				System.out.println();
				System.out.println("메인메뉴로 돌아가겠습니다. \n");
			}
		
		
			
		
		
	}
	
}
