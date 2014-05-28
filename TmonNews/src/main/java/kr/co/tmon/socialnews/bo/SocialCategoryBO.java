package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.tmon.socialnews.dao.LocalDailyNewsCountDAO;
import kr.co.tmon.socialnews.dao.LocalGetNewsDAO;
import kr.co.tmon.socialnews.model.News;

/**
 * 
 * @author 김종환
 * 
 */

/*
 * 카데고리와 Date에 맞게 데이터를 Select하기위한 로직이 들어있는 클래스
 */

@Service
public class SocialCategoryBO {
	@Autowired
	private LocalGetNewsDAO getNewsDAO;
	@Autowired
	private LocalDailyNewsCountDAO localDailyNewsCountDAO;

	private Date newsDate;
	private String socialCorpCode;
	private int page;
	private int newsCount;

	public List<News> getNewsList(int numberOfPage) {
		this.page = numberOfPage;
		setNewsCount(localDailyNewsCountDAO.getNewsCount(newsDate, socialCorpCode));
		return getNewsDAO.getNewsList(newsDate, socialCorpCode, page);
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
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}

}
