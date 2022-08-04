package mini.member;

import mini.main.Main;
import mini.util.InputUtil;

public class MemberController {
	
	
	public void login() {
		
		if(Main.loginMember != null) {
			//이미 로그인 O
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
			if(vo != null) {
				//로그인 성공
				System.out.println("로그인 성공 !\n\n");
				System.out.println(vo.getNick() + "님 환영합니다 !!");
				Main.loginMember = vo;
			}else {
				//로그인 실패
				System.out.println("로그인 실패 !\n\n");
			}
		} catch (Exception e) {
			//로그인 실패
			System.out.println("[에러] 로그인 실패 !\n\n");
			e.printStackTrace();
		}
		
	}//login
	
	
	public void join() {
		
		System.out.println("===== 회원가입 =====");
		
		System.out.print("아이디 : ");
		String id = InputUtil.sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwd = InputUtil.sc.nextLine();
		
		System.out.print("비밀번호 확인 : ");
		String pwd2 = InputUtil.sc.nextLine();
		
		System.out.println("이름 : ");
		String name = InputUtil.sc.nextLine();
		
		System.out.print("닉네임 : ");
		String nick = InputUtil.sc.nextLine();
		
		System.out.println("이메일 : ");
		String email = InputUtil.sc.nextLine();
		
		System.out.println("생일 : ");
		String birth = InputUtil.sc.nextLine();
		
		System.out.println("주소 : ");
		String address = InputUtil.sc.nextLine();
		
		System.out.println("폰 번호 : ");
		String cell = InputUtil.sc.nextLine();
		
		System.out.println("내 반려동물을 추가 하시겠습니까?(y/n)");
		String petYn = InputUtil.sc.nextLine();
		//잘못 입력 했을경우 TODO
		
		if(petYn.equals("y")) {
			//TODO
			
			//반려동물 정보받고
			
			//반려동물 객체 만들어서 정보 저장
			
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
		
		int result = new MemberService().join(vo);
		
		//실행 결과에 따른 응답
		if(result == 1) {
			System.out.println("회원가입 성공 !");
		}else {
			System.out.println("[ERROR:" + result + "] 회원가입 실패 ...");
		}
	}


	public void myPage() {
		// TODO Auto-generated method stub
		System.out.println("마이페이지 아직 완성 안됨..");
		return;
		//myPage 메뉴 출력
		
		//정보수정
		
		//탈퇴하기
		
		//작성한 글 조회
		
		//관심 글 조회
		
		//반려동물 추가 및 변경(정보수정에 넣을지 말지)
		
	}

}//class