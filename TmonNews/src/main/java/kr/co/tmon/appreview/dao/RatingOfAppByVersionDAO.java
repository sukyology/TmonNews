package kr.co.tmon.appreview.dao;

import java.util.List;

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
public class RatingOfAppByVersionDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertRatingOfAppByVersion(RatingOfAppByVersionModel ratingOfAppByVersion) {
		RatingOfAppByVersionMapper ratingOfAppByVersionMapper = sqlSession.getMapper(RatingOfAppByVersionMapper.class);
		ratingOfAppByVersionMapper.insertRatingOfAppByVersion(ratingOfAppByVersion);
	}

	public List<RatingOfAppByVersionModel> selectLastestFiveRatingOfApp(String appName) {
		RatingOfAppByVersionMapper ratingOfAppByVersionMapper = sqlSession.getMapper(RatingOfAppByVersionMapper.class);
		return ratingOfAppByVersionMapper.selectLastestFiveVersionRating(appName);
	}
}
