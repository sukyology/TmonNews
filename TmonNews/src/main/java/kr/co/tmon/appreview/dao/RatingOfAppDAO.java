package kr.co.tmon.appreview.dao;

import kr.co.tmon.appreview.model.RatingOfAppModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 *
 */

@Repository
public class RatingOfAppDAO {
	@Autowired
	private SqlSession sqlSession;

	public RatingOfAppModel selectRatingOfApp() {
		RatingOfAppMapper ratingOfAppMapper = sqlSession.getMapper(RatingOfAppMapper.class);
		return ratingOfAppMapper.selectRatingOfApp();
	}
}
