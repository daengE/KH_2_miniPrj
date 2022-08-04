package mini.member;

import java.util.List;

import mini.main.Main;
import mini.menu.Menu;
import mini.util.InputUtil;

public class MemberController {

	public void login() {

		if (Main.loginMember != null) {
			// 이미 로그인 O
			System.out.println("이미 로그인 되어있습니다.");
			return;
		}

		System.out.println("----- 로그인 -----");
		System.out.print("아이디 : ");
		String id = InputUtil.sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = InputUtil.sc.nextLine();

		try {
			MemberVo vo = new MemberDao().login(id, pwd);
			if (vo != null) {
				// 로그인 성공
				System.out.println("로그인 성공 !\n\n");
				System.out.println("========================");
				System.out.println(vo.getNick() + "님 환영합니다 !!");
				System.out.println("========================\n\n");
				Main.loginMember = vo;
			} else {
				// 로그인 실패
				System.out.println("로그인 실패 !\n\n");
			}
		} catch (Exception e) {
			// 로그인 실패
			System.out.println("[에러] 로그인 실패 !\n\n");
			e.printStackTrace();
		}

	}// login

	public void join() {

		System.out.println("===== 회원가입 =====");

		// 기본정보
		System.out.print("아이디 : ");
		String id = InputUtil.sc.nextLine();

		System.out.print("비밀번호 : ");
		String pwd = InputUtil.sc.nextLine();

		System.out.print("비밀번호 확인 : ");
		String pwd2 = InputUtil.sc.nextLine();

		System.out.print("이름 : ");
		String name = InputUtil.sc.nextLine();

		System.out.print("닉네임 : ");
		String nick = InputUtil.sc.nextLine();

		System.out.print("이메일 : ");
		String email = InputUtil.sc.nextLine();

		System.out.print("생일 : ");
		String birth = InputUtil.sc.nextLine();

		System.out.print("주소 : ");
		String address = InputUtil.sc.nextLine();

		System.out.print("폰 번호 : ");
		String cell = InputUtil.sc.nextLine();

		// 반려동물 추가

		MemberPetVo petVo = null;

		while (true) {
			System.out.println("내 반려동물을 추가 하시겠습니까?(y/n)");
			String petYn = InputUtil.sc.nextLine();

			if (petYn.equals("y")) {
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
				System.out.println("반려동물 성별을 선택 하세요 : ");
				System.out.println("1. 남 2. 여");
				String aniGender = null;
				int genderInput = InputUtil.getInt();
				if (genderInput == 1) {
					aniGender = "남";
				} else if (genderInput == 2) {
					aniGender = "여";
				}
				System.out.println("반려동물 이름 : ");
				String aniName = InputUtil.sc.nextLine();
				System.out.println("반려동물 생일 : ");
				String aniBirth = InputUtil.sc.nextLine();

				// 반려동물 객체에 담기
				petVo = new MemberPetVo();
				petVo.setType(aniType);
				petVo.setGender(aniGender);
				petVo.setName(aniName);
				petVo.setBirth(aniBirth);
				break;
			} else if (petYn.equals("n")) {
				break;
			} else {
				// 잘못 입력 했을경우 TODO
				System.out.println("잘못 입력하셨습니다.");
			}

		}

		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setNick(nick);
		vo.setPwd(pwd);
		vo.setPwd2(pwd2);
		vo.setName(name);
		vo.setNick(nick);
		vo.setEmail(email);
		vo.setBirth(birth);
		vo.setAddress(address);
		vo.setCell(cell);

		int result = new MemberService().join(vo, petVo);

		// 실행 결과에 따른 응답
		if (result == 1) {
			System.out.println("회원가입 성공 !");
		} else {
			System.out.println("[ERROR:" + result + "] 회원가입 실패 ...");
		}
	}

	public void myPage() {

		System.out.println("마이페이지 아직 완성 안됨..");
		// myPage 메뉴 출력
		int result = new Menu().showMyPageMenu();
		switch (result) {
		case 1:
			System.out.println(Main.loginMember);
			System.out.println("보는 방식은 좀더 다듬을 예정... ㅅㄱ");
			break;
		case 2:
			// TODO
			// 내가 작성한글 조회
			// 게시판 선택 해서 글번호만 조회 할지
			// 모두 조회하고 게시판, 글 번호 조회 할지
			break;
		case 3:
			// TODO
			// 나의 관심글 조회
			// 게시판 선택 해서 글번호만 조회 할지
			// 모두 조회하고 게시판, 글 번호 조회 할지
			break;
		case 4:
			// TODO 반려동물 보는거 완료, 보고 수정 하기 (추가, 삭제)
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
			int petInput = myPetMenu();
			if (1 == petInput) {
				// 반려동물 추가 하는 메소드
				//TODO
				System.out.println("반려동물 추가 메소드 만들거임...");

			} else if (2 == petInput) {
				System.out.println("반려동물 삭제 메소드 만들거임...");

			} else {
				System.out.println("잘못 입력 하셨습니다.");
			}

			break;
		case 5:
			// 대충 유저의 disabled 칼럼을 n으로 바꾸는 고런...... 고런..... 메소드를 만들거다
			System.out.println("대충.. 탈퇴하는 메소드..");
			break;
		default:
			System.out.println("잘못 입력 하셨습니다.");
			break;
		}

	}

	private int myPetMenu() {

		int petInput = 0;

		System.out.println("1. 내 반려동물 추가하기");
		System.out.println("2. 내 반려동물 삭제하기");

		petInput = InputUtil.getInt();

		return petInput;

	}

}// class
