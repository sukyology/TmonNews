package kr.co.tmon.appreview.dao;

import java.util.List;

import kr.co.tmon.appreview.model.MonthlyAppRatingModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 *
 */

@Repository
public class MonthlyAppRatingDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertMonthlyRating(MonthlyAppRatingModel monthlyAppRatingModel) {
		MonthlyAppRatingMapper monthlyAppRatingMapper = sqlSession.getMapper(MonthlyAppRatingMapper.class);
		monthlyAppRatingMapper.insertMonthlyRatingData(monthlyAppRatingModel);
	}

	public MonthlyAppRatingModel selectMonthlyRating(String monthString) {
		MonthlyAppRatingMapper monthlyAppRatingMapper = sqlSession.getMapper(MonthlyAppRatingMapper.class);
		return monthlyAppRatingMapper.selectMonthlyRatingData(monthString);
	}
}
