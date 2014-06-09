package kr.co.tmon.appreview.bo;

import java.util.List;

import kr.co.tmon.appreview.dao.GetRatingOfAppByVersionDAO;
import kr.co.tmon.appreview.dao.InsertRatingOfAppByVersionDAO;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class InsertRatingOfAppByVersionBO {
	private static final String APP_NAME_OF_TMONPLUS = "티몬플러스";
	private static final String APP_NAME_OF_TMON = "티몬";
	private static final String APP_NAME_OF_WEMAP = "위메프";
	private static final String APP_NAME_OF_COUPANG = "쿠팡";

	@Autowired
	private InsertRatingOfAppByVersionDAO insertRatingOfAppByVersionDAO;

	@Autowired
	private GetRatingOfAppByVersionDAO getRatingOfAppByVersionDAO;

	public void renewAppRatingDataByVersion() {
		List<RatingOfAppByVersionModel> coupangRatingList = getRatingOfAppByVersionDAO.getRatingOfAppByVersion(APP_NAME_OF_COUPANG);
		List<RatingOfAppByVersionModel> wemapRatingList = getRatingOfAppByVersionDAO.getRatingOfAppByVersion(APP_NAME_OF_WEMAP);
		List<RatingOfAppByVersionModel> tmonRatingList = getRatingOfAppByVersionDAO.getRatingOfAppByVersion(APP_NAME_OF_TMON);
		List<RatingOfAppByVersionModel> tmonplusRatingList = getRatingOfAppByVersionDAO.getRatingOfAppByVersion(APP_NAME_OF_TMONPLUS);

		insertRatingList(coupangRatingList);
		insertRatingList(wemapRatingList);
		insertRatingList(tmonRatingList);
		insertRatingList(tmonplusRatingList);
	}

	private void insertRatingList(List<RatingOfAppByVersionModel> ratingList) {
		for (RatingOfAppByVersionModel ratingOfVersion : ratingList)
			insertRatingOfAppByVersionDAO.insertRatingOfAppByVersion(ratingOfVersion);
	}

	public void setInsertRatingOfAppByVersionDAO(InsertRatingOfAppByVersionDAO insertRatingOfAppByVersionDAO) {
		this.insertRatingOfAppByVersionDAO = insertRatingOfAppByVersionDAO;
	}

	public void setGetRatingOfAppByVersionDAO(GetRatingOfAppByVersionDAO getRatingOfAppByVersionDAO) {
		this.getRatingOfAppByVersionDAO = getRatingOfAppByVersionDAO;
	}

}
