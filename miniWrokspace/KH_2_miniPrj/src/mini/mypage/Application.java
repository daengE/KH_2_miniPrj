package mini.mypage;

import java.sql.Timestamp;
import java.util.List;

import krw.notificationboard.NotiVo;
import mini.util.StringTest;
import sar.Util.AdVo;

public class Application {

	public void showAdoptionList() {

		List<AdVo> adoptionList = new ApplicationService().showMyApply();

		if (adoptionList.size() == 0) {
			System.out.println("입양 신청 목록이 없습니다.");
		} else {
			// VO를 토대로 리스트업 !!
			System.out.println("=============================== 입양 신청 목록=================================\n");

			// 게시판 목록에 나올 필드들 뽑아오기

			for (int i = 0; i < adoptionList.size(); ++i) {

				AdVo adVo = adoptionList.get(i);
				
				String animal = adVo.getAnimal();
				String type = adVo.getType();
				String shelter = adVo.getShelter();
				String address = adVo.getAddress();

//				int titleLength = new StringTest().getStrLength(35, title);
//				int writerLength = new StringTest().getStrLength(15, writer);

//				System.out.println(
//						"|" + String.format("%6s", notiNo + " ") + "|" + String.format("%-" + titleLength + "s", title)
//								+ "|" + String.format("%-" + writerLength + "s", writer) + "|" + enrollDate + "|");
				System.out.println(i +" : "+ animal +"|"+ type +"|"+ shelter +"|"+ address);
//				System.out
//						.println("+------+-----------------------------------+---------------+---------------------+");

			}
		}

	}

}
