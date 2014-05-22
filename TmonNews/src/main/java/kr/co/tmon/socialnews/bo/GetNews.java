package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.dao.MybatisSqlSessionFactory;
import kr.co.tmon.socialnews.dao.NewsMapper;
import kr.co.tmon.socialnews.model.News;

import org.apache.ibatis.session.SqlSession;

public class GetNews {
	private List<News> newsList;
	private String socialCorpCode;
	private Date newsDate;
	private NewsMapper newsMapper;

	public List<News> getNewsList() {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		TypeChangeBetweenDateAndString dateToString = new TypeChangeBetweenDateAndString();
		String newsDateString = dateToString.exchangeToStringType(newsDate);

		try {
			newsMapper = sqlSession.getMapper(NewsMapper.class);

			if (socialCorpCode.compareTo("") == 0)
				newsList = (List<News>) newsMapper.getNewsListByAllCorp(newsDateString);
			else
				newsList = (List<News>) newsMapper.getNewsList(socialCorpCode, newsDateString);
		} finally {
			sqlSession.close();
		}

		return newsList;
	}

	public void setSocialCorpCode(String socialCorpCode) {
		this.socialCorpCode = socialCorpCode;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
}
