package kr.co.tmon.appreview.model;

import java.util.List;

/**
 * 
 * @author 김종환
 *
 *	월별 평점리스트를 위한 model
 *
 */

public class MonthlyRatingFlowModel {
	private int ratingOne;
	private int ratingTwo;
	private int ratingThree;
	private int ratingFour;
	private int ratingFive;
	private List<RatingFlowGraphModel> reviewList;
	private float averageRating;
	private String appName;
	private String corpCode;
	private String reviewedMonth;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getReviewedMonth() {
		return reviewedMonth;
	}

	public void setReviewedMonth(String reviewedMonth) {
		this.reviewedMonth = reviewedMonth;
	}

	public int getRatingOne() {
		return ratingOne;
	}

	public void setRatingOne(int ratingOne) {
		this.ratingOne = ratingOne;
	}

	public int getRatingTwo() {
		return ratingTwo;
	}

	public void setRatingTwo(int ratingTwo) {
		this.ratingTwo = ratingTwo;
	}

	public int getRatingThree() {
		return ratingThree;
	}

	public void setRatingThree(int ratingThree) {
		this.ratingThree = ratingThree;
	}

	public int getRatingFour() {
		return ratingFour;
	}

	public void setRatingFour(int ratingFour) {
		this.ratingFour = ratingFour;
	}

	public int getRatingFive() {
		return ratingFive;
	}

	public void setRatingFive(int ratingFive) {
		this.ratingFive = ratingFive;
	}

	public List<RatingFlowGraphModel> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<RatingFlowGraphModel> reviewList) {
		this.reviewList = reviewList;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
}
