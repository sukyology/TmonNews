package kr.co.tmon.appreview.model;

/**
 * 
 * @author 김종환
 *
 */

public class AverageRatingOfAppModel {
	private String appName;
	private String corpCode;
	private float rating;

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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
