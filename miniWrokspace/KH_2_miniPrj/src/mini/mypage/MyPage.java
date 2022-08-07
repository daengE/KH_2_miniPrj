package mini.mypage;

import java.util.List;

import mini.main.Main;
import mini.member.MemberController;
import mini.member.MemberDao;
import mini.member.MemberPetVo;
import mini.member.MemberService;
import mini.util.InputUtil;
import mini.util.StringTest;

public class MyPage {

	public void showMyInfo() {

		int nickLength = StringTest.getStrLength(30, Main.loginMember.getNick());
		int nameLength = StringTest.getStrLength(30, Main.loginMember.getName());
		int addressLength = StringTest.getStrLength(30, Main.loginMember.getAddress());

		System.out.println("+--------+-------------------------------+");
		System.out.println("| 아이디 | " + String.format("%-30s", Main.loginMember.getId()) + "|");
		System.out.println("+--------+-------------------------------+");
		System.out.println("| 닉네임 | " + String.format("%-" + nickLength + "s", Main.loginMember.getNick()) + "|");
		System.out.println("+--------+-------------------------------+");
		System.out.println("|  이름  | " + String.format("%-" + nameLength + "s", Main.loginMember.getName()) + "|");
		System.out.println("+--------+-------------------------------+");
		System.out.println("|  생일  | " + String.format("%-30s", Main.loginMember.getBirth()) + "|");
		System.out.println("+--------+-------------------------------+");
		System.out.println("| 이메일 | " + String.format("%-30s", Main.loginMember.getEmail()) + "|");
		System.out.println("+--------+-------------------------------+");
		System.out
				.println("|  주소  | " + String.format("%-" + addressLength + "s", Main.loginMember.getAddress()) + "|");
		System.out.println("+--------+-------------------------------+");
		System.out.println("| 폰번호 | " + String.format("%-30s", Main.loginMember.getCell()) + "|");
		System.out.println("+--------+-------------------------------+");
		System.out.println("|가입일자| " + String.format("%-30s", Main.loginMember.getCreateDate()) + "|");
		System.out.println("+--------+-------------------------------+");
		System.out.println("\n");
		updateMyInfo();
	}

	public void updateMyInfo() {
		// 메뉴 보여주고 번호 받아올거고..
		int updateNum = new MyPageMenu().showUpdateMyInfo();
		String collumn = null;

		if (updateNum == 1) {
			System.out.print("변경 하실 닉네임을 입력해 주세요 : ");
			collumn = "M_NICK";
		} else if (updateNum == 2) {
			System.out.print("변경 하실 이메일을 입력해 주세요 : ");
			collumn = "M_EMAIL";
		} else if (updateNum == 3) {
			System.out.print("변경 하실 주소를 입력해 주세요 : ");
			collumn = "M_ADDRESS";
		} else if (updateNum == 4) {
			System.out.print("변경 하실 폰번호를 입력해 주세요 : ");
			collumn = "M_CELL";
		} else if (updateNum == 0) {
			System.out.println("메인메뉴로 갑니다.");
			return;
		} else {
			System.out.print("잘못 입력 하셨습니다.");
			return;
		}

//		System.out.println(collumn); 칼럼 확인용

		// 변경할 내용 받아서
		String updateStr = InputUtil.sc.nextLine();

		// 칼럼, 내용 넘겨주고 Update
		try {
			new MemberDao().updateMyInfo(collumn, updateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		showMyInfo();

	}

	public void showMyPet() {
		List<MemberPetVo> myPetList = new MemberService().showMyPet();

		System.out.println("========================= 내 반려동물 List ==========================\n");
		System.out.println("-----------------+------------+--------------------+-----------------");
		if (myPetList.size() == 0) {
			System.out.println("등록된 나의 반려동물이 없습니다.");
		} else {
			for (int i = 0; i < myPetList.size(); ++i) {

				MemberPetVo petVo = myPetList.get(i);

				int memberNo = petVo.getMemberNo();
				String type = petVo.getType();
				String gender = petVo.getGender();
				String name = petVo.getName();
				String birth = petVo.getBirth();

				int typeLength = StringTest.getStrLength(6, type);
				int nameLength = StringTest.getStrLength(12, name);

				System.out.println(i + 1 + ". " + "타입 : " + String.format("%-" + typeLength + "s", type) + " |성별 : "
						+ gender + "|이름 : " + String.format("%-" + nameLength + "s", name) + " |생일 : " + birth);
			}
			System.out.println("-----------------+------------+--------------------+-----------------");
		}
		System.out.println();

		// 반려동물 추가, 삭제
		while (true) {
			int petInput = new MyPageMenu().showMyPetMenu();
			if (1 == petInput) {
				new MyPage().addMyPet();
				return;
			} else if (2 == petInput) {
				new MyPage().deleteMyPet();
				return;
			} else if (0 == petInput) {
				System.out.println("메인메뉴로 돌아갑니다.\n");
				return;
			} else {
				System.out.println("잘못 입력 하셨습니다.\n");
			}
		}
	}

	private void addMyPet() {

		MemberPetVo petVo = new MemberPetVo();

		// 반려동물 정보입력받고
		System.out.println("== 반려동물 축종을 선택하세요 ==");
		System.out.println("1. 개 2. 고양이 3. 기타");
		int aniInput = InputUtil.getInt();
		String aniType = null;
		if (aniInput == 1) {
			aniType = "개";
		} else if (aniInput == 2) {
			aniType = "고양이";
		} else {
			aniType = "기타";
		}
		System.out.println("반려동물 성별을 선택 하세요.");
		System.out.println("1. 남 2. 여");
		String aniGender = null;
		int genderInput = InputUtil.getInt();
		if (genderInput == 1) {
			aniGender = "남";
		} else if (genderInput == 2) {
			aniGender = "여";
		}
		System.out.print("반려동물 이름 : ");
		String aniName = InputUtil.sc.nextLine();
		System.out.print("반려동물 생일 : ");
		String aniBirth = InputUtil.sc.nextLine();

		// 반려동물 객체에 담기
		petVo = new MemberPetVo();
		petVo.setType(aniType);
		petVo.setGender(aniGender);
		petVo.setName(aniName);
		petVo.setBirth(aniBirth);

		int result = new MemberService().join(petVo);

		if (result == 1) {
			System.out.println("반려동물이 추가 되었습니다.");
		} else {
			System.out.println("실패...");
		}

		showMyPet();

	}

	private void deleteMyPet() {
		// 이름 입력 받아 서비스로 보내고 유효성 확인
		System.out.println("삭제할 반려동물의 이름을 입력하세요.");
		String petName = InputUtil.sc.nextLine();

		int result = new MemberService().deleteMyPet(petName);

		if (result > 0) {
			System.out.println("반려동물 삭제 성공");
		} else {
			System.out.println("해당 이름의 반려동물이 없습니다.");
		}

		showMyPet();

		// 서비스에서 커넥트하고 DAO에서 DELETE

	}

	public void showMyApply() {
		
		if(Main.loginMember == null) {
			System.out.println("로그인을 먼저 해주세요.");
			return;
		}
		
		System.out.println("신청서 종류를 선택하세요.");
		System.out.println("1. 입양 신청서");
		System.out.println("2. 훈련소 신청서");
		int typeInput = InputUtil.getInt();
		if(typeInput == 1) {
			//adoption
			new Application().showAdoptionList();
			
		}else if(typeInput == 2) {
			//application
			System.out.println("훈련소신청 메소드 만들거임..");
			
			
		}else {
			System.out.println("메인메뉴로 돌아갑니다.");
			return;
		}
		
	}

}
