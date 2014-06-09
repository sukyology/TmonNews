package kr.co.tmon.appreview.dao;

import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 *
 */

@Repository
public class InsertRatingOfAppByVersionDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertRatingOfAppByVersion(RatingOfAppByVersionModel ratingOfAppByVersion) {
		RatingOfAppByVersionMapper ratingOfAppByVersionMapper = sqlSession.getMapper(RatingOfAppByVersionMapper.class);
		ratingOfAppByVersionMapper.insertRatingOfAppByVersion(ratingOfAppByVersion);
	}

}
