package kr.co.tmon.socialnews.dao;

/**
 * @author 고영경
 */
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.socialnews.model.CountSocialNews;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountSocialNewsDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertNews(CountSocialNews countSocialNews) {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		newsMapper.insertNewsCount(countSocialNews);
	}
	public List<CountSocialNews> selectNewsCount() {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);
		 List<CountSocialNews> newCountList = new ArrayList<CountSocialNews>();	
		 newCountList = newsMapper.selectNewsCount();
		return newCountList;
	}

	public int selectTodayNewsCountForInsert(String Social_corpCode, String today) {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		return newsMapper.selectTodayNewsCountForInsert(Social_corpCode, today);
	}

}
