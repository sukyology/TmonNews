package kr.co.tmon.appreview.dao;

import java.util.List;

import kr.co.tmon.appreview.model.MonthlyAppRatingModel;

/**
 * 
 * @author 김종환
 *
 */

public interface MonthlyAppRatingMapper {
	void insertMonthlyAppRating(MonthlyAppRatingModel monthlyAppRatingModel);

	List<MonthlyAppRatingModel> selectMonthlyAppRating();

}
