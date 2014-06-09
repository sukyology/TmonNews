package kr.co.tmon.appreview.bo;

import kr.co.tmon.appreview.dao.NumberOfAppReviewDAO;
import kr.co.tmon.appreview.dao.SelectAppReviewDAO;
import kr.co.tmon.appreview.model.NumberOfAppReviewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class UpdateNumberOfAppReviewBO {
	@Autowired
	private NumberOfAppReviewDAO numberOfAppReviewDAO;

	@Autowired
	private SelectAppReviewDAO selectAppReviewDAO;

	public void updateNumberOfAppReview() {
		NumberOfAppReviewModel numberOfAppReview = getCurrentNumberOfAppReview();
		numberOfAppReviewDAO.updateNumberOfAppReview(numberOfAppReview);
	}

	private NumberOfAppReviewModel getCurrentNumberOfAppReview() {
		NumberOfAppReviewModel numberOfAppReview = new NumberOfAppReviewModel();
		numberOfAppReview.setNumberOfTmonAppReview(selectAppReviewDAO.getNumberOfAppReview("티몬"));
		numberOfAppReview.setNumberOfTmonplusAppReview(selectAppReviewDAO.getNumberOfAppReview("티몬플러스"));
		numberOfAppReview.setNumberOfCoupangAppReview(selectAppReviewDAO.getNumberOfAppReview("쿠팡"));
		numberOfAppReview.setNumberOfWemapAppReview(selectAppReviewDAO.getNumberOfAppReview("위메프"));
		return numberOfAppReview;
	}

	public void setNumberOfAppReviewDAO(NumberOfAppReviewDAO numberOfAppReviewDAO) {
		this.numberOfAppReviewDAO = numberOfAppReviewDAO;
	}

	public void setSelectAppReviewDAO(SelectAppReviewDAO selectAppReviewDAO) {
		this.selectAppReviewDAO = selectAppReviewDAO;
	}
}
