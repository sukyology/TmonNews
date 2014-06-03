package kr.co.tmon.appreview.bo;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import kr.co.tmon.appreview.dao.InsertMonthlyRatingFlowDAO;
import kr.co.tmon.appreview.model.MonthlyRatingFlowModel;
import kr.co.tmon.appreview.model.RatingFlowGraphModel;
import kr.co.tmon.appreview.util.FlowGraphModelChanger;
import kr.co.tmon.appreview.util.MonthStringToSpecificDate;
import kr.co.tmon.appreview.util.SubstringForYearPlusMonth;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 *         추이변화 그래프를 구현하기 위해 월간 데이터를 집어넣는 BO 클래스
 * 
 */

@Service
public class AccessRatingFlowDataDbBO {
	@Autowired
	private InsertMonthlyRatingFlowDAO insertMonthlyRatingFlowDAO;

	@Autowired
	private SelectRatingFlowGraphReviewListBO selectRatingFlowGraphReviewListBO;

	public MonthlyRatingFlowModel getMonthlyRatingAsCorp(String startDate, String endDate, String corpName) throws ParseException {
		SubstringForYearPlusMonth substringForYearPlusMonth = new SubstringForYearPlusMonth();
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		Date date = typeChangeBetweenDateAndString.exchangeToDateType(startDate);
		String monthString = substringForYearPlusMonth.substringOfDate(date);

		if (insertMonthlyRatingFlowDAO.selectMonthlyRatingFromDb(monthString, corpName) == null)
			return insertMonthlyRatingAsCorp(startDate, endDate, corpName);
		else
			return selectMonthlyRatingAsCorp(monthString, corpName);
	}

	MonthlyRatingFlowModel selectMonthlyRatingAsCorp(String monthString, String corpName) throws ParseException {
		MonthlyRatingFlowModel monthlyRating = insertMonthlyRatingFlowDAO.selectMonthlyRatingFromDb(monthString, corpName);
		MonthStringToSpecificDate monthStringToSpecificDate = new MonthStringToSpecificDate();
		monthlyRating.setReviewList(selectRatingFlowGraphReviewListBO.getSpecificCorpReviewList(monthStringToSpecificDate.getFirstDayOfMonth(monthString), monthStringToSpecificDate.getLastDayOfMonth(monthString), corpName));
		return monthlyRating;
	}

	MonthlyRatingFlowModel insertMonthlyRatingAsCorp(String startDate, String endDate, String corpName) throws ParseException {
		FlowGraphModelChanger flowGraphModelChanger = new FlowGraphModelChanger();
		List<RatingFlowGraphModel> reviewList = selectRatingFlowGraphReviewListBO.getSpecificCorpReviewList(startDate, endDate, corpName);
		MonthlyRatingFlowModel monthlyReviewData = flowGraphModelChanger.generateMetadataForSaveItToDb(reviewList);

		insertMonthlyRatingFlowDAO.insertMonthlyRatingToDb(monthlyReviewData);

		return monthlyReviewData;
	}
}
