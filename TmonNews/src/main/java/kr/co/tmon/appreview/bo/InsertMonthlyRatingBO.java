package kr.co.tmon.appreview.bo;

import java.text.ParseException;
import java.util.List;

import kr.co.tmon.appreview.dao.MonthlyAppRatingDAO;
import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.appreview.model.MonthlyAppRatingModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class InsertMonthlyRatingBO {
	private static final String APP_NAME_OF_TMON = "티몬";
	private static final String APP_NAME_OF_WEMAP = "위메프";
	private static final String APP_NAME_OF_COUPANG = "쿠팡";

	@Autowired
	private MonthlyAppRatingDAO monthlyAppRatingDAO;

	@Autowired
	private GetMonthlyAppReviewBO getMonthlyAppReviewBO;

	public void insertMonthlyRatings(String monthString) throws ParseException {
		MonthlyAppRatingModel monthlyAppRating = generateMonthlyAppRating(monthString);

		monthlyAppRatingDAO.insertMonthlyRating(monthlyAppRating);
	}

	private MonthlyAppRatingModel generateMonthlyAppRating(String monthString) throws ParseException {
		MonthlyAppRatingModel monthlyAppRating = new MonthlyAppRatingModel();
		monthlyAppRating.setReviewedMonth(monthString);

		float coupangRating = calculateAverageRating(APP_NAME_OF_COUPANG, monthString);
		float tmonRating = calculateAverageRating(APP_NAME_OF_TMON, monthString);
		float wemapRating = calculateAverageRating(APP_NAME_OF_WEMAP, monthString);

		monthlyAppRating.setCoupangRating(coupangRating);
		monthlyAppRating.setTmonRating(tmonRating);
		monthlyAppRating.setWemapRating(wemapRating);
		return monthlyAppRating;
	}

	private float calculateAverageRating(String appName, String monthString) throws ParseException {
		List<AppReviewModel> AppReviewList = getMonthlyAppReviewBO.getMonthlyAppReview(appName, monthString);

		int sumOfRating = 0;

		for (AppReviewModel appReview : AppReviewList)
			sumOfRating += appReview.getRating();

		return ((float) sumOfRating / (float) AppReviewList.size());
	}

	public void setMonthlyAppRatingDAO(MonthlyAppRatingDAO monthlyAppRatingDAO) {
		this.monthlyAppRatingDAO = monthlyAppRatingDAO;
	}

	public void setGetMonthlyAppReviewBO(GetMonthlyAppReviewBO getMonthlyAppReviewBO) {
		this.getMonthlyAppReviewBO = getMonthlyAppReviewBO;
	}
}
