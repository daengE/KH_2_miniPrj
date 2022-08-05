package mini.mypage;

import java.util.List;

import mini.main.Main;
import mini.member.MemberController;
import mini.member.MemberDao;
import mini.member.MemberPetVo;
import mini.member.MemberService;
import mini.util.InputUtil;

public class MyPage {

	public void showMyInfo() {

		System.out.println("아이디 : " + Main.loginMember.getId());
		System.out.println("닉네임 : " + Main.loginMember.getNick());
		System.out.println("이름 : " + Main.loginMember.getName());
		System.out.println("생일 : " + Main.loginMember.getBirth());
		System.out.println("이메일 : " + Main.loginMember.getEmail());
		System.out.println("주소 : " + Main.loginMember.getAddress());
		System.out.println("폰번호 : " + Main.loginMember.getCell());
		System.out.println("가입일자 : " + Main.loginMember.getCreateDate());
		System.out.println("\n");

	}

	public void showMyPet() {
		List<MemberPetVo> myPetList = new MemberService().showMyPet();

		System.out.println("===== 내 반려동물 List =====");

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

				System.out.println(
						i + 1 + ". " + "타입 : " + type + " |성별 : " + gender + " |이름 : " + name + " |생일 : " + birth);
			}
		}
		// 반려동물 추가, 삭제
		while (true) {
			int petInput = new MyPageMenu().showMyPetMenu();
			if (1 == petInput) {
				// 반려동물 추가 하는 메소드
				// TODO
				System.out.println("반려동물 추가 메소드 만들거임...");
				return;
			} else if (2 == petInput) {
				System.out.println("반려동물 삭제 메소드 만들거임...");
				return;
			} else if (0 == petInput) {
				System.out.println("메인메뉴로 돌아갑니다.");
				return;
			} else {
				System.out.println("잘못 입력 하셨습니다.");
			}
		}
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

	}



}
