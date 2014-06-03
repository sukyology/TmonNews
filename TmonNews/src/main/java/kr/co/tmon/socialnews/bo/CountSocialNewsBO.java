package kr.co.tmon.socialnews.bo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.co.tmon.socialnews.dao.CountSocialNewsDAO;
import kr.co.tmon.socialnews.model.CountSocialNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 고영경
 * 
 */

@Service
public class CountSocialNewsBO {
	@Autowired
	private CountSocialNewsDAO countSocialNewsDAO;

	public void recordTodayNewsCount() {
		CountSocialNews countTmonNews = makeCountSocialNews("tm");
		CountSocialNews countCoupangNews = makeCountSocialNews("cp");
		CountSocialNews countWemapNews = makeCountSocialNews("wmp");

		countSocialNewsDAO.insertNews(countTmonNews);
		countSocialNewsDAO.insertNews(countCoupangNews);
		countSocialNewsDAO.insertNews(countWemapNews);
	}
	
	public List<CountSocialNews> getNewsCount () {
		List<CountSocialNews> newsCountInformation = countSocialNewsDAO.selectNewsCount();
		return newsCountInformation;
	}

	private CountSocialNews makeCountSocialNews(String socialCorpCode) {
		CountSocialNews countSocialNews = new CountSocialNews();

		countSocialNews.setDate(getToday());
		countSocialNews.setNewsCount(countSocialNewsDAO.selectTodayNewsCountForInsert(socialCorpCode, getToday()));
		countSocialNews.setSocialCorpCode(socialCorpCode);

		return countSocialNews;
	}

	private String getToday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date currentTime = new Date();
		return formatter.format(currentTime);
	}
}
