package kr.co.tmon.appreview.bo;

import kr.co.tmon.appreview.dao.ReviewDataDAO;
import kr.co.tmon.appreview.model.RatingOfAppModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author YoungKyo Lee 리뷰 데이터 추출 BO 클래스 :티몬, 쿠팡, 위메프 평균 평점
 * @author 김종환
 * 
 */
@Service
public class ReviewDataBO {
	@Autowired
	private ReviewDataDAO getReviewDataDAO;

	public RatingOfAppModel getAppsRating() {
		RatingOfAppModel ratingOfAppModel = new RatingOfAppModel();
		ratingOfAppModel.setCoupangRating(selectCoupangAvgGrade());
		ratingOfAppModel.setTmonplustRating(selectTmonPlusAvgGrade());
		ratingOfAppModel.setTmonRating(selectTmonAvgGrade());
		ratingOfAppModel.setWemapRating(selectWemapAvgGrade());

		return ratingOfAppModel;
	}

	private float selectTmonAvgGrade() {
		return getReviewDataDAO.SelectTmonAvgGrade();
	}

	private float selectCoupangAvgGrade() {
		return getReviewDataDAO.SelectCoupangAvgGrade();
	}

	private float selectWemapAvgGrade() {
		return getReviewDataDAO.SelectWemapAvgGrade();
	}

	private float selectTmonPlusAvgGrade() {
		return getReviewDataDAO.SelectTmonPlusAvgGrade();
	}
}
