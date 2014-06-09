package kr.co.tmon.appreview.dao;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.appreview.model.AppReviewModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 */

@Repository
public class SelectAppReviewDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<AppReviewModel> getMonthlyAppReviewList(String appName, Date startDate, Date endDate) {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		return appReviewMapper.selectAppReviewAsMonth(appName, startDate, endDate);
	}

	public int getNumberOfAppReview(String appName) {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		return appReviewMapper.getNumberOfAppReview(appName);
	}
}
