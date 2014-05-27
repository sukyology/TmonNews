package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.dao.GetNewsDAO;
import kr.co.tmon.socialnews.model.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 *
 */

/*
 * 날짜의 변화에 따라서 뉴스리스트를 리턴하는 클래스
 */

@Repository
public class CalendarBO {
	@Autowired
	private GetNewsDAO getNewsDAO;

	private Date newsDate;
	private String socialCorpCode;
	private int page;

	public List<News> getNewsList(int page) {
		this.page = page;
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

}
