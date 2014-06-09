package kr.co.tmon.socialnews.dao;

/**
 * @author 고영경
 */
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.socialnews.model.CountSocialNews;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountSocialNewsDAO {
	@Autowired
	private SqlSession sqlSession;

	public List<CountSocialNews> selectNewsCount(String date) {
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);
		List<CountSocialNews> newCountList = new ArrayList<CountSocialNews>();

		newCountList = newsMapper.selectNewsCount(date);

		return newCountList;
	}

}
