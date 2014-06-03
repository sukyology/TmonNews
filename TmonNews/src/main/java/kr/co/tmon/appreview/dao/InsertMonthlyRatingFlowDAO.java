package kr.co.tmon.appreview.dao;

import kr.co.tmon.appreview.model.MonthlyRatingFlowModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 *         월간 평점 데이터를 원활하기 넣기 위해서 만든 rating_flow테이블에 데이터를 집어넣기 위해 만든 insert DAO.
 * 
 */

@Repository
public class InsertMonthlyRatingFlowDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertMonthlyRatingToDb(MonthlyRatingFlowModel monthlyRatingData) {
		MonthlyRatingFlowMapper monthlyRatingFlowMapper = sqlSession.getMapper(MonthlyRatingFlowMapper.class);
		monthlyRatingFlowMapper.insertMonthlyRatingData(monthlyRatingData);
	}

	public MonthlyRatingFlowModel selectMonthlyRatingFromDb(String monthString, String corpName) {
		MonthlyRatingFlowMapper monthlyRatingFlowMapper = sqlSession.getMapper(MonthlyRatingFlowMapper.class);
		return monthlyRatingFlowMapper.selectMonthlyRatingData(corpName, monthString);
	}
}
