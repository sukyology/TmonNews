package kr.co.tmon.appreview.dao;

import kr.co.tmon.appreview.model.NumberOfAppReviewModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 */

@Repository
public class NumberOfAppReviewDAO {
	@Autowired
	private SqlSession sqlSession;

	public NumberOfAppReviewModel getNumberOfAppReview() {
		NumberOfAppReviewMapper numberOfAppReviewMapper = sqlSession.getMapper(NumberOfAppReviewMapper.class);
		return numberOfAppReviewMapper.selectNumberOfAppReview();
	}

	public void updateNumberOfAppReview(NumberOfAppReviewModel numberOfAppReview) {
		NumberOfAppReviewMapper numberOfAppReviewMapper = sqlSession.getMapper(NumberOfAppReviewMapper.class);
		numberOfAppReviewMapper.updateNumberOfAppReview(numberOfAppReview);
	}
}
