package lcs.ps;

import java.util.List;

import mini.util.InputUtil;

public class PSController {
	
	public void showPSList() {
		
		System.out.println("어떤 문제가 있으신가요? ");
		System.out.println("궁금하신 문제의 번호를 작성해주세요.");
		
		List<PSVo> PSVoList = new PSService().showPSList();
		
		PSVo psvo = null;
		int cnt = 0;
		for(int i = 0 ; i < PSVoList.size(); ++i) {
			 psvo = PSVoList.get(i);
			

			int no = psvo.getNo();
			String q = psvo.getQ();
			String a = psvo.getA();
			
		
			System.out.println(no + " | " + q  );
		}	
			
			//상세조회
			int num = InputUtil.getInt();
			
			if(num == 0) {
				System.out.println("\n 메인메뉴로 돌아갑니다.");
				return;
			}
			else {
				PSVo selectpsvo = new PSService().showDetailPS(num);
			
				System.out.println("--------------문제점 상세조회--------------");
				System.out.println("문제점 :::" + selectpsvo.getQ());
				System.out.println("해결법 :::" + selectpsvo.getA());
				System.out.println();
		
		}
		
	}

	public String connectATC() {
		System.out.println();
		System.out.print("문제행동을 고칠 수 있는 보호소를 추천드릴까요? -Y / N 작성해주세요");
		
		
		return InputUtil.sc.nextLine();
	}
	
}

