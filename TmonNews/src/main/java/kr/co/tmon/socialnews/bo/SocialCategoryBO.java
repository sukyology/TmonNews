package kr.co.tmon.socialnews.bo;

import java.util.List;

import kr.co.tmon.socialnews.dao.LocalGetNewsDAO;
import kr.co.tmon.socialnews.dao.LocalGetNumberOfNewsDAO;
import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.ConvertCorpNameToCode;
import kr.co.tmon.socialnews.util.DateCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 *         카데고리와 Date에 맞게 데이터를 Select하기위한 로직이 들어있는 클래스
 * 
 * @author 고영경
 * 
 */

@Service
public class SocialCategoryBO {
	@Autowired
	private LocalGetNewsDAO getNewsDAO;
	@Autowired
	private LocalGetNumberOfNewsDAO localDailyNewsCountDAO;

	private static final String NONDATE = "--";
	private int numberOfNews;

	public List<News> getNewsList(String newsDate, String socialCorpCode, int numberOfPage) {
		numberOfNews = 0;
		ConvertCorpNameToCode convertCorpNameToCode = new ConvertCorpNameToCode();
		String corpCode = convertCorpNameToCode.corpNameToCode(socialCorpCode);

		if (newsDate.equals(NONDATE))
			newsDate = getToday();

		List<News> newsList = getNewsDAO.getNewsList(newsDate, corpCode, numberOfPage);
		numberOfNews = localDailyNewsCountDAO.getNumberOfNews(newsDate, corpCode);

		return newsList;
	}

	public String getToday() {
		DateCalculator dateCalculator = new DateCalculator();
		return dateCalculator.getToday();
	}

	public int getNumberOfNews() {
		return numberOfNews;
	}

}
