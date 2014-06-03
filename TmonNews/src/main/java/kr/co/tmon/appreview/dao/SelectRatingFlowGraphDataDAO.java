package kr.co.tmon.appreview.dao;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.appreview.model.RatingFlowGraphModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 *
 *	리뷰데이터의 리스트를 가져오게끔 데이터베이스에 접근하는 DAO
 *
 */

@Repository
public class SelectRatingFlowGraphDataDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<RatingFlowGraphModel> selectSpecifyCorpReviews(Date startDate, Date endDate, String corpCode) {
		RatingFlowGraphMapper ratingFlowGraphMapper = sqlSession.getMapper(RatingFlowGraphMapper.class);
		return ratingFlowGraphMapper.selectRatingFlowData(startDate, endDate, corpCode);
	}

	public List<RatingFlowGraphModel> selectAllCorpsReview(Date startDate, Date endDate) {
		RatingFlowGraphMapper ratingFlowGraphMapper = sqlSession.getMapper(RatingFlowGraphMapper.class);
		return ratingFlowGraphMapper.selectAllCorpRatingFlowDate(startDate, endDate);
	}
}
