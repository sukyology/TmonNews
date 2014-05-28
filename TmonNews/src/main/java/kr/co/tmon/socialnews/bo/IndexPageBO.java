package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.tmon.socialnews.dao.LocalDailyNewsCountDAO;
import kr.co.tmon.socialnews.dao.LocalGetNewsDAO;
import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

/**
 * 
 * @author 김종환
 * 
 */

/*
 * 처음 사이트에 접속했을때 출력해야하는 전체 카테고리-오늘날짜 뉴스테이터를 뽑아오는 클래스
 */

@Service
public class IndexPageBO {
	private static final int DEFALUT_PAGE_NUMBER = 1;
	private static final String DEFALUT_CORPCODE = "socials";

	private int newsCount;

	@Autowired
	private LocalGetNewsDAO getNewsDAO;
	@Autowired
	private LocalDailyNewsCountDAO localDailyNewsCountDAO;

	public List<News> getDailyIndexNewsList() {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String dateString = typeChangeBetweenDateAndString.exchangeToStringType(new Date(System.currentTimeMillis()));
		setNewsCount(localDailyNewsCountDAO.getNewsCount(dateString, DEFALUT_CORPCODE));
		return getNewsDAO.getNewsList(dateString, DEFALUT_CORPCODE, DEFALUT_PAGE_NUMBER);
	}

	public int getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}
}
