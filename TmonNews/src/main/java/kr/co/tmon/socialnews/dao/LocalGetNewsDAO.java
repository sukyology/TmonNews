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
 */

/*
 * 뉴스데이터를 가져오는 클래스. 날짜, 혹은 카테고리가 바뀔경우에는 이 클래스를 상속받은 CalenderDAO와
 * SocialCategoryDAO에서 작업을 처리한다.
 */

@Repository
public class LocalGetNewsDAO {
	private static final int NEWS_PER_PAGE = 5;
	private static final String DEFAULT_CATEGORY = "socials";

	private int numberOfPage;
	protected String socialCorpCode;
	protected String newsDate;

	@Autowired
	private SqlSession sqlSession;

	public List<News> getNewsList(String date, String corpCode, int page) {
		setNewsDate(date);
		setSocialCorpCode(corpCode);
		setNumberOfPage(page);

		return accessDbToGetNewsList();
	}

	private List<News> accessDbToGetNewsList() {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		if (socialCorpCode.compareTo(DEFAULT_CATEGORY) == 0)
			return (List<News>) newsMapper.getNewsListByAllCorp(newsDate, convertPageNumberToNewsIndex(getNumberOfPage()));
		else
			return (List<News>) newsMapper.getNewsList(socialCorpCode, newsDate, convertPageNumberToNewsIndex(getNumberOfPage()));
	}

	public void setSocialCorpCode(String socialCorpCode) {
		this.socialCorpCode = socialCorpCode;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public int convertPageNumberToNewsIndex(int page) {
		return (page - 1) * NEWS_PER_PAGE;
	}
}
