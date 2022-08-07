package mini.mypage;

import java.sql.Timestamp;
import java.util.List;

import lcs.application.ApplicationVo;
import sar.Util.AdVo;

public class Application {

	public void showAdoptionList() {

		List<AdVo> adoptionList = new ApplicationService().showMyApply();

		if (adoptionList.size() == 0) {
			System.out.println("입양 신청 목록이 없습니다.");
		} else {
			System.out.println("========================== 입양 신청 목록 ============================\n");

			for (int i = 0; i < adoptionList.size(); ++i) {

				AdVo adVo = adoptionList.get(i);

				String animal = adVo.getAnimal();
				String type = adVo.getType();
				String shelter = adVo.getShelter();
				String address = adVo.getAddress();
				Timestamp ad_Date = adVo.getAd_date();

				System.out.println(i + 1 + " ) 동물타입 : " + animal + "| 종 : " + type + "| 보호소 : " + shelter + "| 주소 : " + address+ "| 신청날짜 : "+ad_Date);

			}
		}
	}

	public void showTrainingList() {

		List<ApplicationVo> trainingList = new ApplicationService().showMyTraining();

		if (trainingList.size() == 0) {
			System.out.println("훈련 신청 목록이 없습니다.");
		} else {
			System.out.println("========================== 훈련 신청 목록 ============================\n");

			for (int i = 0; i < trainingList.size(); ++i) {

				ApplicationVo apVo = trainingList.get(i);

				String atcName = apVo.getAtcName();
				String animalType = apVo.getAnimalType();
				String aplyDate = apVo.getAplyDate();

				System.out.println(i + 1 + " ) 훈련소 : " + atcName + "| 동물타입 : " + animalType + "| 신청날짜 : " + aplyDate);

			}
		}
	}
}
