package kr.co.tmon.appreview.dao;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import kr.co.tmon.appreview.model.AppReviewModel;
import kr.co.tmon.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.appreview.model.NumberOfAppReviewModel;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;
import kr.co.tmon.appreview.util.MonthStringToSpecificDate;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 */

@Repository
public class AppReviewDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertAppReview(AppReviewModel appReview) {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		appReviewMapper.insertAppReviewToUserTable(appReview);
		appReviewMapper.insertAppReviewToReviewTable(appReview);
	}

	public List<AppReviewModel> selectAppReview(String appName, int numberOfLoad) {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);

		return appReviewMapper.selectAppReview(appName, numberOfLoad);
	}

	public List<RatingOfAppByVersionModel> selectAppRatingByVersion(String appName) {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);

		return appReviewMapper.selectReviewForRatingByVersion(appName);
	}

	public NumberOfAppReviewModel selectNumberOfAppReview(String monthString, Date startDate, Date endDate) throws ParseException {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);

		NumberOfAppReviewModel numberOfAppReview = appReviewMapper.selectNumberOfAppReview(startDate, endDate);
		numberOfAppReview.setMonthString(monthString);

		return numberOfAppReview;
	}

	public MonthlyAppRatingModel selectMonthlyAppRating(String monthString, Date startDate, Date endDate) throws ParseException {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);

		MonthlyAppRatingModel monthlyAppRating = appReviewMapper.selectMonthlyAppRating(startDate, endDate);
		monthlyAppRating.setReviewedMonth(monthString);

		return monthlyAppRating;
	}
}
