package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.dao.LocalGetNumberOfNewsDAO;
import kr.co.tmon.socialnews.dao.LocalGetNewsDAO;
import kr.co.tmon.socialnews.model.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 *
 * 날짜의 변화에 따라서 뉴스리스트를 리턴하는 클래스
 *
 */

@Service
public class CalendarBO {
	@Autowired
	private LocalGetNewsDAO getNewsDAO;
	@Autowired
	private LocalGetNumberOfNewsDAO localDailyNewsCountDAO;

	private int numberOfNews;

	public List<News> getNewsList(String newsDate, String socialCorpCode, int page) {
		numberOfNews = localDailyNewsCountDAO.getNumberOfNews(newsDate, socialCorpCode);
		return getNewsDAO.getNewsList(newsDate, socialCorpCode, page);
	}

	public int getNumberOfNews() {
		return numberOfNews;
	}
}