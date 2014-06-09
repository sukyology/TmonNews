package kr.co.tmon.appreview.bo;

import kr.co.tmon.appreview.dao.NumberOfAppReviewDAO;
import kr.co.tmon.appreview.model.NumberOfAppReviewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class GetNumberOfAppReviewBO {
	@Autowired
	private NumberOfAppReviewDAO numberOfAppReviewDAO;

	@Autowired
	private UpdateNumberOfAppReviewBO updateNumberOfAppReviewBO;

	public NumberOfAppReviewModel getNumberOfAppReview() {
		updateNumberOfAppReviewBO.updateNumberOfAppReview();
		return numberOfAppReviewDAO.getNumberOfAppReview();
	}

	public void setNumberOfAppReviewDAO(NumberOfAppReviewDAO numberOfAppReviewDAO) {
		this.numberOfAppReviewDAO = numberOfAppReviewDAO;
	}

	public void setUpdateNumberOfAppReviewBO(UpdateNumberOfAppReviewBO updateNumberOfAppReviewBO) {
		this.updateNumberOfAppReviewBO = updateNumberOfAppReviewBO;
	}

}
