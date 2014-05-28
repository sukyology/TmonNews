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
public class LocalDailyNewsCountDAO {
	private static String DEFAULT_CATEGORY = "socials";

	@Autowired
	private SqlSession sqlSession;

	protected String socialCorpCode;
	protected Date newsDate;

	public int getNewsCount(Date date, String corpCode) {
		setNewsDate(date);
		setSocialCorpCode(corpCode);

		List<News> newsList = accessDbToGetNewsList();
		return newsList.size();
	}

	private List<News> accessDbToGetNewsList() {
		String newsDateString = setCurrentDateToSqlDateType();
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		if (socialCorpCode.compareTo(DEFAULT_CATEGORY) == 0)
			return newsMapper.getNewsListByAllCorpForDailyNewsCount(newsDateString);
		else
			return newsMapper.getNewsListForDailyNewsCount(socialCorpCode, newsDateString);
	}

	private String setCurrentDateToSqlDateType() {
		TypeChangeBetweenDateAndString dateToString = new TypeChangeBetweenDateAndString();
		String newsDateString = dateToString.exchangeToStringType(newsDate);
		return newsDateString;
	}

	public String getSocialCorpCode() {
		return socialCorpCode;
	}

	public void setSocialCorpCode(String socialCorpCode) {
		this.socialCorpCode = socialCorpCode;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
}
