package kr.co.tmon.appreview.dao;

import java.util.List;

import kr.co.tmon.appreview.model.AppRankingModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 */

@Repository
public class AppRankingDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<AppRankingModel> selectAppRanking() {
		AppRankingMapper appRankingMapper = sqlSession.getMapper(AppRankingMapper.class);
		return appRankingMapper.selectAppRanking();
	}

}
