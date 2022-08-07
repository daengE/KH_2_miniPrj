package mini.member;

import java.util.List;

import mini.main.Main;
import mini.menu.Menu;
import mini.mypage.MyPage;
import mini.util.InputUtil;

public class MemberController {

	public void login() {

//		if (Main.loginMember != null) {
//			// 이미 로그인 O
//			System.out.println("이미 로그인 되어있습니다.");
//			return;
//		}

		System.out.println("============== 로그인 ===============");
		System.out.print("아이디 : ");
		String id = InputUtil.sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = InputUtil.sc.nextLine();

		try {
			MemberVo vo = new MemberDao().login(id, pwd);
			if (vo != null && vo.getDisaled() == 0) {
				// 로그인 성공
				System.out.println("로그인 성공 !\n\n");
				System.out.println("=====================================");
				System.out.println("    " + vo.getNick() + "님 환영합니다 !!");
				System.out.println("=====================================\n");
				Main.loginMember = vo;
			} else if (vo != null && vo.getDisaled() == 1) {
				// 로그인 실패(탈퇴한회원)
				System.out.println("탈퇴한 회원입니다.\n\n");
			} else {
				// 로그인 실패
				System.out.println("아이디와 비밀번호를 확인하세요..! !\n\n");
			}
		} catch (Exception e) {
			// 로그인 실패
			System.out.println("[에러] 로그인 실패 !\n\n");
			e.printStackTrace();
		}

	}// login

	public void join() {

		System.out.println("============= 회원가입 ==============");

		String id = null;
		String nick = null;
		boolean resultName = false;
		boolean resultNick = false;
		boolean isFinishName = true;
		boolean isFinishNick = true;

		MemberDao md = new MemberDao();

		// 기본정보
		while (isFinishName) {
			System.out.print("아이디 : ");
			id = InputUtil.sc.nextLine();

			// 중복 검사
			try {
				resultName = md.checkDupId(id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (resultName == true) {
				id = null;
				System.out.println("이미 존재하는 아이디 입니다.");
			} else {
				isFinishName = false;
			}

		}

		System.out.print("비밀번호 : ");
		String pwd = InputUtil.sc.nextLine();

		System.out.print("비밀번호 확인 : ");
		String pwd2 = InputUtil.sc.nextLine();

		System.out.print("이름 : ");
		String name = InputUtil.sc.nextLine();
		while (nick == null) {
			System.out.print("닉네임 : ");
			nick = InputUtil.sc.nextLine();

			// 중복검사
			try {
				resultNick = md.checkDupNick(nick);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (resultNick == true) {
				nick = null;
				System.out.println("이미 존재하는 닉네임 입니다.");
			} else {
				isFinishNick = false;
			}
		}
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
				// 반려동물 정보 입력 받기
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

		if (result == 1) {
			System.out.println("회원가입 성공 !");
		} else {
			System.out.println("[ERROR:" + result + "] 회원가입 실패 ...");
		}
	}

	public void myPage() {

		System.out.println("마이페이지 아직 완성 안됨..");
		// myPage 메뉴 출력
		MyPage mp = new MyPage();
		int result = new Menu().showMyPageMenu();
		switch (result) {
		case 1:
			// 정보보기 및 수정
			mp.showMyInfo();

			break;
		case 2:
			// TODO
			// 내가 작성한글 조회
			break;
		case 3:
			// TODO
			// 나의 관심글 조회
			// 게시판 선택 해서 글번호만 조회 할지
			// 모두 조회하고 게시판, 글 번호 조회 할지
			break;
		case 4:
			// 내 반려동물 보기 및 추가, 삭제
			mp.showMyPet();

			break;
		case 5:
			// 탈퇴
			withdraw();
			break;
		default:
			System.out.println("잘못 입력 하셨습니다.");
			break;
		}

	}

	public void withdraw() {

		System.out.println("저장된 정보가 다 사라집니다. 탈퇴하시겠습니까?(y/n)");
		String input = InputUtil.sc.nextLine();
		int cnt = 0;
		String pwdInput = null;

		if ("y".equals(input)) {
			// 비번받고 확인하는 메소드

			while (cnt != 3) {
				System.out.println("비밀번호를 입력 해주세요.");
				pwdInput = InputUtil.sc.nextLine();

				if (pwdInput.equals(Main.loginMember.getPwd())) {

					try {
						new MemberDao().withdraw();
						Main.loginMember = null;
						cnt = 3;
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					cnt++;
					if (cnt == 3) {
						System.out.println("비밀번호를 3번 틀렸습니다. 메인메뉴로 돌아갑니다.\n");
					}
				}

			}
		} else if ("n".equals(input)) {
			return;
		} else {
			System.out.println("잘못 입력 했습니다..!/n");
		}
	}
}// class
