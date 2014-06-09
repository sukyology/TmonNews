package kr.co.tmon.appreview.dao;

import java.util.List;

import kr.co.tmon.appreview.model.AverageRatingOfAppModel;

/**
 * 
 * @author 김종환
 *
 */

public interface AverageRatingOfAppMapper {
	void insertAverageRating(AverageRatingOfAppModel averageRatingOfApp);
	List<AverageRatingOfAppModel> selectAverageRating();
}
