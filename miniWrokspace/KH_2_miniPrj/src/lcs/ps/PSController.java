package lcs.ps;

import java.util.List;

import mini.util.InputUtil;
import mini.util.StringTest;

public class PSController {
	
	public int showPSList() {
		
		
		
		List<PSVo> PSVoList = new PSService().showPSList();
		
		PSVo psvo = null;
		int cnt = 0;
		
		System.out.println("====================== 어떤 문제를 해결하고 싶나요?  =======================");
		System.out.println("      *궁금한 문제를 선택해주세요.(0번 입력시 메인으로 돌아갑니다.)*\n");
		System.out.println("+-----+---------------------------------------+");
		System.out.println("|번 호|------------- 문 제 이 름 -------------|");
		System.out.println("+-----+---------------------------------------+");
		
		for(int i = 0 ; i < PSVoList.size(); ++i) {
			 psvo = PSVoList.get(i);
			

			int no = psvo.getNo();
			String q = psvo.getQ();
			String a = psvo.getA();
			
			int qLength = new StringTest().getStrLength(38, q);
			
			System.out.println(
					  "|" + String.format("%3s", no) + "  "
					+ "|" + " "+ String.format("%-" + qLength + "s", q) 
					+ "|");
			System.out.println("+-----+---------------------------------------+");
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
				
				int qLength = new StringTest().getStrLength(58, selectpsvo.getQ());
				
			
				System.out.println("+-----+------------------------------------------------------------+");
				System.out.println("|번 호|-------------------- 문  제  이  름  -----------------------|");
				System.out.println("+-----+------------------------------------------------------------+");
				System.out.println("|  "+num+"  |"+String.format("%-" + qLength + "s", selectpsvo.getQ())+"  |"); // string set 써야할것같음
				System.out.println("+-----+------------------------------------------------------------+");
				System.out.println("|--------------------------  T  I  P  -----------------------------|");
				System.out.println("+------------------------------------------------------------------+");
				System.out.println(  selectpsvo.getA());
				System.out.println("+------------------------------------------------------------------+");
				
				
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

