package kr.co.tmon.appreview.bo;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import kr.co.tmon.appreview.dao.SelectRatingFlowGraphDataDAO;
import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.appreview.model.RatingFlowGraphModel;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 *
 *	지정된 기간에 지정된 corp의 리뷰데이터를 리스트로 가져오는 BO
 *
 */

@Service
public class SelectRatingFlowGraphReviewListBO {
	private static final int LEVEL_OF_RATING = 5;

	@Autowired
	private SelectRatingFlowGraphDataDAO selectRatingFlowGraphDataDAO;

	public List<RatingFlowGraphModel> getSpecificCorpReviewList(String startDateString, String endDateString, String corpCode) throws ParseException {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		Date startDate = typeChangeBetweenDateAndString.exchangeToDateType(startDateString);
		Date endDate = typeChangeBetweenDateAndString.exchangeToDateType(endDateString);
		List<RatingFlowGraphModel> reviewList = selectRatingFlowGraphDataDAO.selectSpecifyCorpReviews(startDate, endDate, corpCode);

		return reviewList;
	}

	
}
