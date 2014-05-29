package kr.co.tmon.socialnews.dao;



import java.util.List;

import kr.co.tmon.socialnews.model.News;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 * 뉴스데이터를 가져오는 클래스. 날짜, 혹은 카테고리가 바뀔경우에는 이 클래스를 상속받은 CalenderDAO와
 * SocialCategoryDAO에서 작업을 처리한다.
 * 
 */

@Repository
public class LocalGetNewsDAO {
	private static final int MINUS_FOR_ARRANGING_PAGE_NUMBER = 1;
	private static final int NEWS_PER_PAGE = 5;
	private static final String DEFAULT_CATEGORY = "socials";

	@Autowired
	private SqlSession sqlSession;

	public List<News> getNewsList(String date, String corpCode, int page) {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);

		if (corpCode.compareTo(DEFAULT_CATEGORY) == 0)
			return (List<News>) newsMapper.getNewsListByAllCorp(date, convertPageNumberToNewsIndex(page));
		else
			return (List<News>) newsMapper.getNewsList(date, corpCode, convertPageNumberToNewsIndex(page));
	}

	public int convertPageNumberToNewsIndex(int page) {
		return (page - MINUS_FOR_ARRANGING_PAGE_NUMBER) * NEWS_PER_PAGE;
	}
}
