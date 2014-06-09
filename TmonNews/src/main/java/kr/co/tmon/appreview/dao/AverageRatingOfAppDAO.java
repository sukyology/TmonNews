package kr.co.tmon.appreview.dao;

import java.io.IOException;
import java.util.List;

import kr.co.tmon.appreview.bo.GetAverageRatingBO;
import kr.co.tmon.appreview.model.AverageRatingOfAppModel;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 */

@Repository
public class AverageRatingOfAppDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertAverageRating(AverageRatingOfAppModel averageRatingOfApp) throws IOException, ParseException {
		AverageRatingOfAppMapper averageRatingOfAppMapper = sqlSession.getMapper(AverageRatingOfAppMapper.class);
		averageRatingOfAppMapper.insertAverageRating(averageRatingOfApp);
	}

}
