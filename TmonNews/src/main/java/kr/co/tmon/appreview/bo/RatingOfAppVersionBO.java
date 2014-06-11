package kr.co.tmon.appreview.bo;

import java.util.List;

import kr.co.tmon.appreview.dao.AppReviewDAO;
import kr.co.tmon.appreview.dao.RatingOfAppByVersionDAO;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class RatingOfAppVersionBO {
	private static final String APP_NAME_OF_TMONPLUS = "티몬플러스";
	private static final String APP_NAME_OF_TMON = "티몬";
	private static final String APP_NAME_OF_WEMAP = "위메프";
	private static final String APP_NAME_OF_COUPANG = "쿠팡";

	@Autowired
	private RatingOfAppByVersionDAO ratingOfAppByVersionDAO;

	@Autowired
	private AppReviewDAO appReviewDAO;

	public void insertAppRatingData() {
		List<RatingOfAppByVersionModel> coupangRatingList = appReviewDAO.selectAppRatingByVersion(APP_NAME_OF_COUPANG);
		List<RatingOfAppByVersionModel> wemapRatingList = appReviewDAO.selectAppRatingByVersion(APP_NAME_OF_WEMAP);
		List<RatingOfAppByVersionModel> tmonRatingList = appReviewDAO.selectAppRatingByVersion(APP_NAME_OF_TMON);
		List<RatingOfAppByVersionModel> tmonplusRatingList = appReviewDAO.selectAppRatingByVersion(APP_NAME_OF_TMONPLUS);

		insertRatingByVersion(coupangRatingList);
		insertRatingByVersion(wemapRatingList);
		insertRatingByVersion(tmonRatingList);
		insertRatingByVersion(tmonplusRatingList);
	}

	public List<RatingOfAppByVersionModel> selectLastestFiveVersionRating(String appName) {
		return ratingOfAppByVersionDAO.selectLastestFiveRatingOfApp(appName);
	}

	private void insertRatingByVersion(List<RatingOfAppByVersionModel> coupangRatingList) {
		for (RatingOfAppByVersionModel ratingOfAppByVersion : coupangRatingList) {
			alterCharacterOldVersion(ratingOfAppByVersion);
			ratingOfAppByVersionDAO.insertRatingOfAppByVersion(ratingOfAppByVersion);
		}
	}

	private void alterCharacterOldVersion(RatingOfAppByVersionModel ratingOfVersion) {
		if (ratingOfVersion.getAppVersion().contains("old_") == true) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("0ld_");
			String cutNumber = ratingOfVersion.getAppVersion().substring(4);
			if (cutNumber.length() == 1)
				cutNumber = "0".concat(cutNumber);

			stringBuilder.append(cutNumber);
			ratingOfVersion.setAppVersion(stringBuilder.toString());
		}
	}

	public void setRatingOfAppByVersionDAO(RatingOfAppByVersionDAO ratingOfAppByVersionDAO) {
		this.ratingOfAppByVersionDAO = ratingOfAppByVersionDAO;
	}

	public void setAppReviewDAO(AppReviewDAO appReviewDAO) {
		this.appReviewDAO = appReviewDAO;
	}
}
