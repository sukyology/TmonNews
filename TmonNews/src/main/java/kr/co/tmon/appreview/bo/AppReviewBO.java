package kr.co.tmon.appreview.bo;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.appreview.dao.AppReviewDAO;
import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.appreview.model.NumberOfAppReviewModel;
import kr.co.tmon.appreview.util.MonthStringToSpecificDate;
import kr.co.tmon.appreview.util.SubstringForYearPlusMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class AppReviewBO {
	@Autowired
	private AppReviewDAO appReviewDAO;

	public List<AppReviewModel> selectReviewList(String appName, int numberOfLoad) {
		return appReviewDAO.selectAppReview(appName, numberOfLoad);
	}

	public NumberOfAppReviewModel getNumberOfAppReview() throws java.text.ParseException {
		MonthStringToSpecificDate monthStringToSpecificDate = new MonthStringToSpecificDate();
		Date startDate = monthStringToSpecificDate.getFirstDayOfMonthForDateType(getCurrentMonthString());
		Date endDate = monthStringToSpecificDate.getLastDayOfMonthForDateType(getCurrentMonthString());
		return appReviewDAO.selectNumberOfAppReview(getCurrentMonthString(), startDate, endDate);
	}

	private String getCurrentMonthString() {
		Date currentDate = new Date(System.currentTimeMillis());
		SubstringForYearPlusMonth substringForYearPlusMonth = new SubstringForYearPlusMonth();

		return substringForYearPlusMonth.substringOfDate(currentDate);
	}

	public void setAppReviewDAO(AppReviewDAO appReviewDAO) {
		this.appReviewDAO = appReviewDAO;
	}

}
