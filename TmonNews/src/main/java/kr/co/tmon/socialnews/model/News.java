package kr.co.tmon.socialnews.model;

/**
 * @author GoYoungGyeong
 * 
 */
import java.util.Date;
import java.util.List;

public class News {
	private int newsID;
	private List<String> newsSocialCorpCodeList;
	private String newsTitle;
	private String newsPreview;
	private Date newsDate;
	private String newsImage;
	private String newsLink;
	private String newsProvider;
	private int newsCount;

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}

	public List<String> getNewsSocialCorpList() {
		return newsSocialCorpCodeList;
	}

	public void setNewsSocialCorpList(List<String> newsSocialCorpList) {
		this.newsSocialCorpCodeList = newsSocialCorpList;
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

	public int getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}

}
