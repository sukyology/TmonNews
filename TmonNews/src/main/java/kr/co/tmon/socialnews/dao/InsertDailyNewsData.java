package kr.co.tmon.socialnews.dao;

import java.util.List;

import kr.co.tmon.socialnews.bo.CorpDataConvertForMapping;
import kr.co.tmon.socialnews.model.News;

import org.apache.ibatis.session.SqlSession;

/**
 * 
 * @author 김종환
 *
 */

/*
 * 파싱된 뉴스데이터를 DB에 집어넣는 클래스
 */

public class InsertDailyNewsData {
	private NewsMapper newsMapper;

	public void insertNews(List<News> parsedNewsList) {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();

		try {
			newsMapper = sqlSession.getMapper(NewsMapper.class);
			CorpDataConvertForMapping corpDataConvertForMapping = new CorpDataConvertForMapping();
			parsedNewsList = corpDataConvertForMapping.divideByCorps(parsedNewsList);
			
			newsMapper.insertNews(parsedNewsList.get(0));
			
			insertNewsAsUnique(parsedNewsList);
				
			sqlSession.commit();

			for (News news : parsedNewsList)
				newsMapper.mappingSocialCode(news);

			sqlSession.commit();

		} finally {
			sqlSession.close();
		}
	}

	private void insertNewsAsUnique(List<News> parsedNewsList) {
		for (int index = 1; index < parsedNewsList.size(); index++){
			News news = parsedNewsList.get(index);
			if(news.getNewsID() != parsedNewsList.get(index-1).getNewsID())
				newsMapper.insertNews(news);
		}
	}
	
}
