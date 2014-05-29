package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.co.tmon.socialnews.dao.LocalGetNumberOfNewsDAO;
import kr.co.tmon.socialnews.dao.LocalGetNewsDAO;
import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.util.ConvertCorpNameToCode;
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

	private int numberOfNews;

	public List<News> getNewsList(String newsDate, String socialCorpCode, int numberOfPage) {
		ConvertCorpNameToCode convertCorpNameToCode = new ConvertCorpNameToCode();
		numberOfNews = localDailyNewsCountDAO.getNumberOfNews(newsDate, convertCorpNameToCode.corpNameToCode(socialCorpCode));
		return getNewsDAO.getNewsList(newsDate, socialCorpCode, numberOfPage);
	}

	public int getNumberOfNews() {
		return numberOfNews;
	}

}
