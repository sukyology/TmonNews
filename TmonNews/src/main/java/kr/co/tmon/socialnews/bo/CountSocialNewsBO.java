package kr.co.tmon.socialnews.bo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kr.co.tmon.socialnews.dao.CountSocialNewsDAO;
import kr.co.tmon.socialnews.model.CountSocialNews;
import kr.co.tmon.socialnews.model.NewsChartModel;
import kr.co.tmon.socialnews.util.DateCalculator;

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
	private CountSocialNewsDAO countSocialNewsDAO = new CountSocialNewsDAO();
	private static final int TWOWEEKS = 14;

	public List<NewsChartModel> getNewsCount() throws ParseException {
		List<NewsChartModel> newsChartList = new ArrayList<>();
		DateCalculator dateCalculator = new DateCalculator();

		for (int index = 0; index < TWOWEEKS; index++) {
			List<CountSocialNews> newsCountInformation = new ArrayList<>();
			newsCountInformation = countSocialNewsDAO.selectNewsCount(dateCalculator.calculateBeforeDate(dateCalculator.getToday(), index));

			newsChartList.add(changeFromCountSocialNewsToNewsChartModel(newsCountInformation, dateCalculator.calculateBeforeDate(dateCalculator.getToday(), index)));
		}

		reverseList(newsChartList);

		return newsChartList;
	}

	private void reverseList(List<NewsChartModel> newsChartList) {
		Collections.reverse(newsChartList);
	}

	private NewsChartModel changeFromCountSocialNewsToNewsChartModel(List<CountSocialNews> newsCountInformation, String date) {
		NewsChartModel tempNewsChartModel = new NewsChartModel();

		initTempNewsChartModel(date, tempNewsChartModel);

		for (CountSocialNews countSocialNews : newsCountInformation) {

			if (countSocialNews.getSocialCorpCode().equals("cp"))
				tempNewsChartModel.setCoupangNewsCount(countSocialNews.getNewsCount());
			else if (countSocialNews.getSocialCorpCode().equals("tm"))
				tempNewsChartModel.setTmonNewsCount(countSocialNews.getNewsCount());
			else if (countSocialNews.getSocialCorpCode().equals("wmp"))
				tempNewsChartModel.setWemapNewsCount(countSocialNews.getNewsCount());
		}

		return tempNewsChartModel;
	}

	private void initTempNewsChartModel(String date, NewsChartModel tempNewsChartModel) {
		tempNewsChartModel.setDate(date);
		tempNewsChartModel.setTmonNewsCount(0);
		tempNewsChartModel.setCoupangNewsCount(0);
		tempNewsChartModel.setWemapNewsCount(0);
	}

}
