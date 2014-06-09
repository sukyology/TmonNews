package kr.co.tmon.appreview.bo;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import kr.co.tmon.appreview.dao.SelectAppReviewDAO;
import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.appreview.util.MonthStringToSpecificDate;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 *
 */

@Service
public class GetMonthlyAppReviewBO {
	@Autowired
	private SelectAppReviewDAO selectAppReviewDAO;

	public List<AppReviewModel> getMonthlyAppReview(String appName, String monthString) throws ParseException {
		MonthStringToSpecificDate monthStringToSpecificDate = new MonthStringToSpecificDate();
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();

		Date startDate = typeChangeBetweenDateAndString.exchangeToDateType(monthStringToSpecificDate.getFirstDayOfMonth(monthString));
		Date endDate = typeChangeBetweenDateAndString.exchangeToDateType(monthStringToSpecificDate.getLastDayOfMonth(monthString));

		return selectAppReviewDAO.getMonthlyAppReviewList(appName, startDate, endDate);
	}

	public void setSelectAppReviewDAO(SelectAppReviewDAO selectAppReviewDAO) {
		this.selectAppReviewDAO = selectAppReviewDAO;
	}
}
