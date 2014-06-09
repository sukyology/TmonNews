package kr.co.tmon.socialnews.model;

public class NewsChartModel {
	private String date;
	private int tmonNewsCount;
	private int coupangNewsCount;
	private int wemapNewsCount;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTmonNewsCount() {
		return tmonNewsCount;
	}
	public void setTmonNewsCount(int tmonNewsCount) {
		this.tmonNewsCount = tmonNewsCount;
	}
	public int getCoupangNewsCount() {
		return coupangNewsCount;
	}
	public void setCoupangNewsCount(int coupangNewsCount) {
		this.coupangNewsCount = coupangNewsCount;
	}
	public int getWemapNewsCount() {
		return wemapNewsCount;
	}
	public void setWemapNewsCount(int wemapNewsCount) {
		this.wemapNewsCount = wemapNewsCount;
	}
}
