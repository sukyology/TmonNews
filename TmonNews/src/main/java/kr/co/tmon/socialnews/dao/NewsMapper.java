package kr.co.tmon.socialnews.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.tmon.socialnews.model.CountSocialNews;
import kr.co.tmon.socialnews.model.News;

/**
 * 
 * @author 김종환
 * @author 고영경
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
	
	int selectTodayNewsCountForInsert(@Param("socialCorpCode") String social_corpCode, @Param("today") String today);
	
	List<CountSocialNews> selectNewsCount(@Param("date") String today);
	
	void insertNewsCount(CountSocialNews countSocialNews);
}
