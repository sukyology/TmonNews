package kr.co.tmon.socialnews.dao;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.bo.TypeChangeBetweenDateAndString;
import kr.co.tmon.socialnews.model.News;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author 김종환
 * 
 */

/*
 * 뉴스데이터를 가져오는 클래스. 날짜, 혹은 카테고리가 바뀔경우에는 이 클래스를 상속받은 CalenderBO와
 * SocialCategoryBO에서 작업을 처리한다.
 */

public class GetNewsDAO {
	private static final String DEFAULT_CATEGORY = "all";
	private List<News> newsList;
	private String socialCorpCode;
	private Date newsDate;
	private NewsMapper newsMapper;
	private SqlSession sqlSession;
	private ApplicationContext applicationContext;

	public GetNewsDAO() {
		applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		setNewsDate(new Date(System.currentTimeMillis()));
		setSocialCorpCode(DEFAULT_CATEGORY);
	}

	public List<News> getNewsList() {
		sqlSession = (SqlSession) applicationContext.getBean("sqlSession");

		TypeChangeBetweenDateAndString dateToString = new TypeChangeBetweenDateAndString();
		String newsDateString = dateToString.exchangeToStringType(newsDate);

		newsMapper = sqlSession.getMapper(NewsMapper.class);

		if (socialCorpCode.compareTo(DEFAULT_CATEGORY) == 0)
			newsList = (List<News>) newsMapper.getNewsListByAllCorp(newsDateString);
		else
			newsList = (List<News>) newsMapper.getNewsList(socialCorpCode, newsDateString);
		
		return newsList;
	}

	public void setSocialCorpCode(String socialCorpCode) {
		this.socialCorpCode = socialCorpCode;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
}
