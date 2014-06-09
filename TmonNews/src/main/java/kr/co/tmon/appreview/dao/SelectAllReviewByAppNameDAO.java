package kr.co.tmon.appreview.dao;

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
public class SelectAllReviewByAppNameDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<AppReviewModel> selectAllReviewByAppName(String appName) {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		return appReviewMapper.selectAppReviewByApp(appName);
	}
}
