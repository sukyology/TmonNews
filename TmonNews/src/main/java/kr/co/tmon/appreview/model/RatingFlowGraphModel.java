package kr.co.tmon.appreview.model;

import java.sql.Date;

/**
 * 
 * @author 김종환
 *
 *	앱리뷰 리스트를 받아오는데 있어서, 추이변화 그래프에 특화된 모델 클래스
 *
 */

public class RatingFlowGraphModel {
	private String reviewTitle;
	private String reviewContent;
	private Date writtenDate;
	private String appName;
	private String appVersion;
	private String reviewLink;
	private String corpCode;
	private int rating;
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getReviewLink() {
		return reviewLink;
	}
	public void setReviewLink(String reviewLink) {
		this.reviewLink = reviewLink;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
}
