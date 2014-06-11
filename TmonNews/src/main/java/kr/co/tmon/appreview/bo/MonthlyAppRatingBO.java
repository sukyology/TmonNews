package kr.co.tmon.appreview.bo;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import kr.co.tmon.appreview.dao.AppReviewDAO;
import kr.co.tmon.appreview.dao.MonthlyAppRatingDAO;
import kr.co.tmon.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.appreview.util.MonthStringToSpecificDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class MonthlyAppRatingBO {
	@Autowired
	private MonthlyAppRatingDAO monthlyAppRatingDAO;

	@Autowired
	private AppReviewDAO appReviewDAO;

	public void insertMonthlyAppRating(String monthString) throws ParseException {
		MonthStringToSpecificDate monthStringToSpecificDate = new MonthStringToSpecificDate();
		Date startDate = monthStringToSpecificDate.getFirstDayOfMonthForDateType(monthString);
		Date endDate = monthStringToSpecificDate.getLastDayOfMonthForDateType(monthString);

		MonthlyAppRatingModel monthlyAppRating = appReviewDAO.selectMonthlyAppRating(monthString, startDate, endDate);
		monthlyAppRatingDAO.insertMonthlyAppRating(monthlyAppRating);
	}

	public List<MonthlyAppRatingModel> selectMonthlyAppRating() {
		return monthlyAppRatingDAO.selectMonthlyAppRating();
	}

	public void setMonthlyAppRatingDAO(MonthlyAppRatingDAO monthlyAppRatingDAO) {
		this.monthlyAppRatingDAO = monthlyAppRatingDAO;
	}

	public void setAppReviewDAO(AppReviewDAO appReviewDAO) {
		this.appReviewDAO = appReviewDAO;
	}
}
