package kr.co.tmon.socialnews.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class NewsCountDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void updateNewsCount(int newsId){
		NewsMapper newsMapper = sqlSession.getMapper(NewsMapper.class);
		newsMapper.readCountUpdate(newsId);
	}
	
}
