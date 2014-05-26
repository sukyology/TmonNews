package kr.co.tmon.socialnews.bo;

import java.sql.Date;
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
 * 뉴스데이터를 가져오는 클래스. 날짜, 혹은 카테고리가 바뀔경우에는 이 클래스를 상속받은 CalenderBO와
 * SocialCategoryBO에서 작업을 처리한다.
 */

public class GetNews {
	private static final String DEFAULT_CATEGORY = "all";
	private List<News> newsList;
	private String socialCorpCode;
	private Date newsDate;
	private NewsMapper newsMapper;

	public GetNews() {
		setNewsDate(new Date(System.currentTimeMillis()));
		setSocialCorpCode("all");
	}

	public List<News> getNewsList() {
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		TypeChangeBetweenDateAndString dateToString = new TypeChangeBetweenDateAndString();
		String newsDateString = dateToString.exchangeToStringType(newsDate);

		try {
			newsMapper = sqlSession.getMapper(NewsMapper.class);

			if (socialCorpCode.compareTo(DEFAULT_CATEGORY) == 0)
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
