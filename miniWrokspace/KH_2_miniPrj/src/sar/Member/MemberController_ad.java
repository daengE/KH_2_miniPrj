package sar.Member;

import sar.Main.Main;
import sar.Util.JDBCTemplate_ad;

public class MemberController_ad {

	public void login() {
		
		if(Main.loginMember != null) {
			System.out.println("이미 로그인 되어있습니다");
			return;
		}
		
		System.out.println("====로그인====");
		
		System.out.print("아이디 : ");
		String id = JDBCTemplate_ad.sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwd = JDBCTemplate_ad.sc.nextLine();
		
		try {
			
			MemberVo_ad vo = new MemberDao_ad().login(id,pwd);
			if(vo != null) {
				System.out.println("로그인 성공! \n");
			}else {
				System.out.println("로그인 실패... \n");
			}
			
		}catch(Exception e) {
			System.out.println("[에러] 로그인 실패! \n");
			e.printStackTrace();
		}
	}

	public void join() {
		System.out.println("====회원가입====");
		
		System.out.print("아이디 : ");
		String id = JDBCTemplate_ad.sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwd = JDBCTemplate_ad.sc.nextLine();

		System.out.print("비밀번호 확인 : ");
		String pwd2 = JDBCTemplate_ad.sc.nextLine();

		System.out.print("닉네임 : ");
		String nick = JDBCTemplate_ad.sc.nextLine();

		MemberVo_ad vo = new MemberVo_ad();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setPwd2(pwd2);
		vo.setNick(nick);
		
		int result = new MemberService_ad().join(vo);
		
		if(result == 1) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("[error : " + result + "] 회원가입 실패...");
		}
		
	}

}
