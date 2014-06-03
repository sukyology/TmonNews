package kr.co.tmon.appreview.dao;

import java.util.List;

import kr.co.tmon.appreview.model.AppReviewModel;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 김종환
 * 
 *         JSON을 파싱한 데이터를 DB에 집어넣는 DAO
 * 
 */

@Repository
public class InsertAppReviewDAO {
	private static final int STARTING_INSERT_INDEX = 1;
	@Autowired
	private SqlSession sqlSession;

	public void insertAppReviewList(List<AppReviewModel> appReviewList) {
		AppReviewMapper appReviewMapper = sqlSession.getMapper(AppReviewMapper.class);
		insertAppReview(appReviewMapper, appReviewList.get(0));

		for (int index = STARTING_INSERT_INDEX; index < appReviewList.size(); index++)
			insertAppReview(appReviewMapper, appReviewList.get(index));
	}

	private void insertAppReview(AppReviewMapper appReviewMapper, AppReviewModel appReview) {
		appReviewMapper.insertAppReviewToUserTable(appReview);
		appReviewMapper.insertAppReviewToReviewTable(appReview);

	}
}
