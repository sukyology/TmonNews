package kr.co.tmon.appreview.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.tmon.appreview.model.MonthlyAppRatingModel;

/**
 * 
 * @author 김종환
 *
 */

public interface MonthlyAppRatingMapper {
	public void insertMonthlyRatingData(MonthlyAppRatingModel monthlyAppRating);
	public MonthlyAppRatingModel selectMonthlyRatingData(@Param("reviewedMonth") String reviewedMonth);
}
