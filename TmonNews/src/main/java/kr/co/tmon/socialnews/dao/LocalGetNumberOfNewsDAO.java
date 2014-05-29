package kr.co.tmon.socialnews.dao;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 *
 * 불러온 뉴스리스트의 전체 갯수를 세기 위해 만든 DAO 클래스
 *
 */
@Repository
public class LocalGetNumberOfNewsDAO {
	private static String DEFAULT_CATEGORY = "socials";

	@Autowired
	private SqlSession sqlSession;

	public int getNumberOfNews(String date, String corpCode) {
		List<News> newsList = accessDbToGetNewsList(date, corpCode);
		return newsList.size();
	}

	private List<News> accessDbToGetNewsList(String date, String corpCode) {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		if (corpCode.compareTo(DEFAULT_CATEGORY) == 0)
			return newsMapper.getNewsListByAllCorpForDailyNumberOfNews(date);
		else
			return newsMapper.getNewsListForDailyNumberOfNews(corpCode, date);
	}
}
