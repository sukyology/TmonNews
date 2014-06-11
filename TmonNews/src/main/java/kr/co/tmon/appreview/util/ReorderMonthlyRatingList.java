package kr.co.tmon.appreview.util;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.appreview.model.MonthlyAppRatingModel;

public class ReorderMonthlyRatingList {

	public List<MonthlyAppRatingModel> reorderList(List<MonthlyAppRatingModel> monthlyAppRatingList) {
		List<MonthlyAppRatingModel> reorderedList = new ArrayList<>();

		for (int index = monthlyAppRatingList.size() - 1; index >= 0; index--)
			reorderedList.add(monthlyAppRatingList.get(index));

		return reorderedList;
	}

}