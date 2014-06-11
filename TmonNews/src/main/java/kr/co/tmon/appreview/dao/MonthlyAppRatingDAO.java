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

	public void insertMonthlyAppRating(MonthlyAppRatingModel monthlyAppRating) {
		MonthlyAppRatingMapper monthlyAppRatingMapper = sqlSession.getMapper(MonthlyAppRatingMapper.class);
		monthlyAppRatingMapper.insertMonthlyAppRating(monthlyAppRating);
	}

	public List<MonthlyAppRatingModel> selectMonthlyAppRating() {
		MonthlyAppRatingMapper monthlyAppRatingMapper = sqlSession.getMapper(MonthlyAppRatingMapper.class);
		return monthlyAppRatingMapper.selectMonthlyAppRating();
	}
}
