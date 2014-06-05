package kr.co.tmon.appreview.bo;

import kr.co.tmon.appreview.dao.ReviewDataDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author YoungKyo Lee
 * 리뷰 데이터 추출 BO 클래스
 * :티몬, 쿠팡, 위메프 평균 평점
 */
@Service
public class ReviewDataBO {
	
	@Autowired
	private ReviewDataDAO GetReviewDataDAO;
	
	public float selectTmonAvgGrade(){
		return GetReviewDataDAO.SelectTmonAvgGrade();
	}
	
	public float selectCoupangAvgGrade(){
		return GetReviewDataDAO.SelectCoupangAvgGrade();
	}
	
	public float selectWemapAvgGrade(){
		return GetReviewDataDAO.SelectWemapAvgGrade();
	}
	
	public float selectTmonPlusAvgGrade(){
		return GetReviewDataDAO.SelectTmonPlusAvgGrade();
	}
}
