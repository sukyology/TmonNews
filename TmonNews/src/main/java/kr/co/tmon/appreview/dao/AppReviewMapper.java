package kr.co.tmon.appreview.dao;

import kr.co.tmon.appreview.model.AppReviewModel;

/**
 * 
 * @author 김종환, YoungKyo LEE
 *
 * AppReview의 Mapper
 *
 */

public interface AppReviewMapper {
	void insertAppReviewToUserTable(AppReviewModel appReview);
	void insertAppReviewToReviewTable(AppReviewModel appReview);
	float SelectTmonReviewAvgGrade();
	float SelectCoupangReviewAvgGrade();
	float SelectWemapReviewAvgGrade();

}