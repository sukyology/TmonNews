package kr.co.tmon.socialnews.dao;

import java.util.List;

import kr.co.tmon.socialnews.model.News;

import org.apache.ibatis.session.SqlSession;

public class InsertDailyNewsData {
	private NewsMapper newsMapper;

	public void insertNews(List<News> parsedNewsList) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();

		try {
			newsMapper = sqlSession.getMapper(NewsMapper.class);
			for (News news : parsedNewsList)
				newsMapper.insertNews(news);

			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}
}
