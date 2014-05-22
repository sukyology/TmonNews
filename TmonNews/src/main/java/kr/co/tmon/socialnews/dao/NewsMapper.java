package kr.co.tmon.socialnews.dao;

import java.util.List;

import kr.co.tmon.socialnews.model.News;

/**
 * 
 * @author 김종환
 *
 */

/*
 * News클래스에 대한 매핑 클래스
 */

public interface NewsMapper {
	List<News> getNewsList(String corpCode, String newsDate);
	List<News> getNewsListByAllCorp(String newsDate);
	void insertNews(News news);
}
