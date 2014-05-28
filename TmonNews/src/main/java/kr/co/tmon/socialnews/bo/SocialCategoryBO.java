package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.tmon.socialnews.dao.LocalGetNumberOfNewsDAO;
import kr.co.tmon.socialnews.dao.LocalGetNewsDAO;
import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

/**
 * 
 * @author 김종환
 * 
 * 카데고리와 Date에 맞게 데이터를 Select하기위한 로직이 들어있는 클래스
 * 
 */

@Service
public class SocialCategoryBO {
	@Autowired
	private LocalGetNewsDAO getNewsDAO;
	@Autowired
	private LocalGetNumberOfNewsDAO localDailyNewsCountDAO;

	private Date newsDate;
	private String socialCorpCode;
	private int page;
	private int numberOfNews;

	public List<News> getNewsList(int numberOfPage) {
		this.page = numberOfPage;
		String dateString = generateDateString();
		setNewsCount(localDailyNewsCountDAO.getNumberOfNews(dateString, socialCorpCode));
		return getNewsDAO.getNewsList(dateString, socialCorpCode, page);
	}

	private String generateDateString() {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = typeChangeBetweenDateAndString.exchangeToStringType(newsDate);
		return dateString;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public String getSocialCorpCode() {
		return socialCorpCode;
	}

	public void setSocialCorpCode(String socialCorpCode) {
		this.socialCorpCode = socialCorpCode;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNewsCount() {
		return numberOfNews;
	}

	public void setNewsCount(int newsCount) {
		this.numberOfNews = newsCount;
	}

}
