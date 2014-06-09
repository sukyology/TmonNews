package kr.co.tmon.appreview.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;

/**
 * 
 * @author 김종환
 * @author youngkyoLee
 * 
 *         AppReview의 Mapper
 * 
 */

public interface AppReviewMapper {
	void insertAppReviewToUserTable(AppReviewModel appReview);
	void insertAppReviewToReviewTable(AppReviewModel appReview);
	List<AppReviewModel> selectAppReviewAsMonth(@Param("appName") String appName, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	int getNumberOfAppReview(@Param("appName") String appName);
	List<AppReviewModel> selectAppReviewByApp(@Param("appName") String appName);
	List<RatingOfAppByVersionModel> selectReviewForRatingByVersion(@Param("appName") String appName);
	float SelectTmonReviewAvgGrade();
	float SelectCoupangReviewAvgGrade();
	float SelectWemapReviewAvgGrade();
	float SelectTmonPlusReviewAvgGrade();
}