package lcs.ps;

import java.util.List;

import mini.menu.Menu;
import mini.util.InputUtil;

public class PSController {
	
	public int showPSList() {
		
		System.out.println("어떤 문제가 있으신가요? ");
		System.out.println("궁금하신 문제의 번호를 작성해주세요.(0번 메인메뉴로갑니다.)\n");
		
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
		while(true){
			int num = InputUtil.getInt();
			
			if(num == 0) {
//				메인으으로 보내고싶은데 방법이 없어요,,,어떡하죠 ?
				return -1;
				
			}
			else if(num <= PSVoList.size()) {
				PSVo selectpsvo = new PSService().showDetailPS(num);
			
				System.out.println("--------------문제점 상세조회--------------");
				System.out.println("문제점 :::" + selectpsvo.getQ());
				System.out.println("해결법 :::" + selectpsvo.getA());
				System.out.println();
				break;
			}
			else {
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
		return 0;
		
	}

	public String connectATC() {
		System.out.println();
		System.out.println("문제행동을 고칠 수 있는 보호소를 추천드릴까요? ( Y / N 답변 부탁드립니다.)");
		
		return InputUtil.sc.nextLine();
	}
	
}

