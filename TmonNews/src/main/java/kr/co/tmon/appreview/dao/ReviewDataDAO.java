package kr.co.tmon.appreview.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author YoungKyo Lee 
 * 리뷰 데이터 추출 DAO 클래스
 *  :티몬, 쿠팡, 위메프 평균 평점
 */

@Repository
public class ReviewDataDAO {

	@Autowired
	private SqlSession sqlSession;

	public float SelectTmonAvgGrade() {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		return appReviewMapper.SelectTmonReviewAvgGrade();
	}
	
	public float SelectCoupangAvgGrade() {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		return  appReviewMapper.SelectCoupangReviewAvgGrade();
	}
	
	public float SelectWemapAvgGrade() {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		return appReviewMapper.SelectWemapReviewAvgGrade();
	}
	
	public float SelectTmonPlusAvgGrade() {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		return appReviewMapper.SelectTmonPlusReviewAvgGrade();
	}
}
