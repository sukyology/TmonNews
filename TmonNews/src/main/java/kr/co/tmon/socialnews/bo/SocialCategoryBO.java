package kr.co.tmon.socialnews.bo;

import java.util.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

public class SocialCategoryBO {
	private List<News> newsList;
	private String socialCorpCode;
	private Date newsDate;

	public List<News> getNewsList() {
		return null;
	}

	public void setSocialCorpCode(String socialCorpCode) {
		this.socialCorpCode = socialCorpCode;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
	
	
}
