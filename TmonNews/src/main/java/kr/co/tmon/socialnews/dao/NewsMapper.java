package kr.co.tmon.socialnews.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	List<News> getNewsList(@Param("newsDate") String newsDate, @Param("corpCode") String corpCode, @Param("page") int page);

	List<News> getNewsListByAllCorp(@Param("newsDate") String newsDate, @Param("page") int page);

	List<News> getNewsListForDailyNumberOfNews(@Param("corpCode") String corpCode, @Param("date") String newsDate);
	
	List<News> getNewsListByAllCorpForDailyNumberOfNews(String newsDate);
	
	void insertNews(News news);

	void mappingSocialCode(News news);

	void readCountUpdate(int newsID);
}
