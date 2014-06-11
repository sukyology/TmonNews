package kr.co.tmon.appreview.bo;

import java.util.List;

import kr.co.tmon.appreview.dao.AppReviewDAO;
import kr.co.tmon.appreview.dao.RatingOfAppByVersionDAO;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;
import kr.co.tmon.appreview.util.SubDecimal;

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

	public List<RatingOfAppByVersionModel> selectLastestFiveVersionRating(String appName) {
		return ratingOfAppByVersionDAO.selectLastestFiveRatingOfApp(appName);
	}

	public void setRatingOfAppByVersionDAO(RatingOfAppByVersionDAO ratingOfAppByVersionDAO) {
		this.ratingOfAppByVersionDAO = ratingOfAppByVersionDAO;
	}

	public void setAppReviewDAO(AppReviewDAO appReviewDAO) {
		this.appReviewDAO = appReviewDAO;
	}
}
