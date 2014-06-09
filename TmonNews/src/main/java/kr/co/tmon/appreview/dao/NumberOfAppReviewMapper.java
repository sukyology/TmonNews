package kr.co.tmon.appreview.dao;

import kr.co.tmon.appreview.model.NumberOfAppReviewModel;

/**
 * 
 * @author 김종환
 *
 */

public interface NumberOfAppReviewMapper {
	public void updateNumberOfAppReview(NumberOfAppReviewModel numberOfAppReview);

	public NumberOfAppReviewModel selectNumberOfAppReview();
}
