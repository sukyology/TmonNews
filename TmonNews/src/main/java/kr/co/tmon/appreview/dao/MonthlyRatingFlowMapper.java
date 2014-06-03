package kr.co.tmon.appreview.dao;

import org.apache.ibatis.annotations.Param;

import kr.co.tmon.appreview.model.MonthlyRatingFlowModel;

/**
 * 
 * @author 김종환
 *
 * 월별 리뷰데이터의 별점 현황을 데이터베이스와 연동해 저장하게 위해 만든 mapper 클래스
 *
 */

public interface MonthlyRatingFlowMapper {
	void insertMonthlyRatingData(MonthlyRatingFlowModel monthRating);
	MonthlyRatingFlowModel selectMonthlyRatingData(@Param("corpCode") String corpCode, @Param("reviewedMonth") String reviewedMonth);
}
