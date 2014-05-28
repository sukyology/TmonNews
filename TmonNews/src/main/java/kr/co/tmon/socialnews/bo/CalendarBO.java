package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.dao.LocalDailyNewsCountDAO;
import kr.co.tmon.socialnews.dao.LocalGetNewsDAO;
import kr.co.tmon.socialnews.model.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 *
 */

/*
 * 날짜의 변화에 따라서 뉴스리스트를 리턴하는 클래스
 */

@Service
public class CalendarBO {
	@Autowired
	private LocalGetNewsDAO getNewsDAO;
	@Autowired
	private LocalDailyNewsCountDAO localDailyNewsCountDAO;

	private String newsDate;
	private String socialCorpCode;
	private int page;
	
	private int newsCount;

	public List<News> getNewsList(int page) {
		this.page = page;
		setNewsCount(localDailyNewsCountDAO.getNewsCount(newsDate, socialCorpCode));
		return getNewsDAO.getNewsList(newsDate, socialCorpCode, page);
	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
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
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}

}
