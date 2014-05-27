package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tmon.socialnews.dao.GetNewsDAO;
import kr.co.tmon.socialnews.model.News;

/**
 * 
 * @author 김종환
 *
 */

/*
 * 처음 사이트에 접속했을때 출력해야하는 전체 카테고리-오늘날짜 뉴스테이터를 뽑아오는 클래스
 */

@Repository
public class IndexPageBO {
	private static final int DEFALUT_PAGE_NUMBER = 1;
	private static final String DEFALUT_CORPCODE = "socials";
	
	@Autowired
	private GetNewsDAO getNewsDAO;

	public List<News> getDailyIndexNewsList() {
		return getNewsDAO.getNewsList(new Date(System.currentTimeMillis()), DEFALUT_CORPCODE, DEFALUT_PAGE_NUMBER);
	}
}
