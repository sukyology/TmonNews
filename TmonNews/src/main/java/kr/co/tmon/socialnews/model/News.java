package kr.co.tmon.socialnews.model;
/**
 * @author GoYoungGyeong
 * 
 */
import java.util.Date;

public class News {
	private int newsID;
	private String socialCorpEnglishName;
	private String socialCorpKoreanName;
	private String newsTitle;
	private String newsPreview;
	private Date newsDate;
	private String newsImage;
	private String newsLink;
	private String newsProvider;
	private String newsCount;
	
	public int getNewsID() {
		return newsID;
	}
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	public String getSocialCorpEnglishName() {
		return socialCorpEnglishName;
	}
	public void setSocialCorpEnglishName(String socialCorpEnglishName) {
		this.socialCorpEnglishName = socialCorpEnglishName;
	}
	public String getSocialCorpKoreanName() {
		return socialCorpKoreanName;
	}
	public void setSocialCorpKoreanName(String socialCorpKoreanName) {
		this.socialCorpKoreanName = socialCorpKoreanName;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsPreview() {
		return newsPreview;
	}
	public void setNewsPreview(String newsPreview) {
		this.newsPreview = newsPreview;
	}
	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewsImage() {
		return newsImage;
	}
	public void setNewsImage(String newsImage) {
		this.newsImage = newsImage;
	}
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public String getNewsProvider() {
		return newsProvider;
	}
	public void setNewsProvider(String newsProvider) {
		this.newsProvider = newsProvider;
	}
	public String getNewsCount() {
		return newsCount;
	}
	public void setNewsCount(String newsCount) {
		this.newsCount = newsCount;
	}
	
	
}