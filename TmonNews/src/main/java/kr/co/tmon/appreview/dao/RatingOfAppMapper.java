package kr.co.tmon.appreview.dao;

import kr.co.tmon.appreview.model.RatingOfAppModel;

/**
 * 
 * @author 김종환
 *
 */

public interface RatingOfAppMapper {
	void updateRatingOfApp(RatingOfAppModel ratingOfAppModel);
	RatingOfAppModel selectRatingOfApp();
}
