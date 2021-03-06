package kr.co.tmon.appreview.util;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.appreview.model.AppRankingModel;
import kr.co.tmon.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.appreview.model.RatingOfAppByVersionModel;

/**
 * 
 * @author 김종환
 * 
 */

public class ReorderMonthlyRatingList {

	public List<MonthlyAppRatingModel> reorderList(List<MonthlyAppRatingModel> monthlyAppRatingList) {
		List<MonthlyAppRatingModel> reorderedList = new ArrayList<>();

		for (int index = monthlyAppRatingList.size() - 1; index >= 0; index--)
			reorderedList.add(monthlyAppRatingList.get(index));

		return reorderedList;
	}

	public List<RatingOfAppByVersionModel> reorderListOfRatingOfAppVersionModel(List<RatingOfAppByVersionModel> monthlyAppRatingList) {
		List<RatingOfAppByVersionModel> reorderedList = new ArrayList<>();

		for (int index = monthlyAppRatingList.size() - 1; index >= 0; index--)
			reorderedList.add(monthlyAppRatingList.get(index));

		return reorderedList;
	}

	public List<AppRankingModel> reorderListOfAppRanking(List<AppRankingModel> appRankingList) {
		List<AppRankingModel> reorderedList = new ArrayList<>();

		for (int index = appRankingList.size() - 1; index >= 0; index--) {
			appRankingList.get(index).setDateString(subStringOfTime(appRankingList.get(index).getDateString()));
			reorderedList.add(appRankingList.get(index));
		}
		return reorderedList;
	}

	public String subStringOfTime(String dateString) {
		return dateString.substring(12);
	}

}
