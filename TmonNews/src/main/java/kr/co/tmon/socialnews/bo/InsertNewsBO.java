package kr.co.tmon.socialnews.bo;

import java.util.List;

import kr.co.tmon.socialnews.dao.MybatisSqlSessionFactory;
import kr.co.tmon.socialnews.dao.NewsMapper;
import kr.co.tmon.socialnews.model.News;

import org.apache.ibatis.session.SqlSession;

/**
 * 
 * @author 김종환
 * 
 */

/*
 * 1팀에서 넘어온 xml데이터를 DAO에서 파싱한 것을 DB에 삽입하는 것을 담당하는 Business Logic
 */

public class InsertNewsBO {
	private List<News> parsedNewsList;
	private NewsMapper newsMapper;

	public void insertNews() {
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

	public void getNewsFromXmlData(String urlForParsingNews) {
		
	}

	public List<News> getParsedNewsList() {
		return parsedNewsList;
	}

	public void setParsedNewsList(List<News> parsedNewsList) {
		this.parsedNewsList = parsedNewsList;
	}
}
