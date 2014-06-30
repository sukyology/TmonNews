package kr.co.tmon.appreview.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.appreview.model.RatingOfAppModel;

import org.junit.Before;
import org.junit.Test;

public class ReorderMonthlyRatingListTest {
	private ReorderMonthlyRatingList reorderMonthlyRatingList;

	@Before
	public void setup() {
		reorderMonthlyRatingList = new ReorderMonthlyRatingList();
	}

	@Test
	public void 리스트를_역순으로_재정렬하는것을_확인하는_테스트() {
		List<MonthlyAppRatingModel> monthlyAppRatingList = new ArrayList<>();

		MonthlyAppRatingModel monthlyAppRatingModel = generateSampleData();
		monthlyAppRatingList.add(monthlyAppRatingModel);
		monthlyAppRatingList.add(monthlyAppRatingModel);

		MonthlyAppRatingModel alteredMonthlyAppRatingModel = generateSampleData();
		alteredMonthlyAppRatingModel.setReviewedMonth("2014-07");

		monthlyAppRatingList.add(alteredMonthlyAppRatingModel);

		List<MonthlyAppRatingModel> reorederedList = reorderMonthlyRatingList.reorderList(monthlyAppRatingList);

		assertEquals(monthlyAppRatingList.get(0).getReviewedMonth().compareTo(reorederedList.get(2).getReviewedMonth()), 0);

		for (int index = 0; index < 3; index++)
			System.out.println(reorederedList.get(index).getReviewedMonth());
	}

	@Test
	public void 앱랭킹리스트에서_시간을_제대로_파싱해서_가져오는지_테스트() {
		assertTrue("15:00".compareTo(reorderMonthlyRatingList.subStringOfTime("2014-06-26, 15:00")) == 0);
	}

	private MonthlyAppRatingModel generateSampleData() {
		MonthlyAppRatingModel monthlyAppRatingModel = new MonthlyAppRatingModel();

		monthlyAppRatingModel.setCoupangRating(0);
		monthlyAppRatingModel.setReviewedMonth("2014-05");
		monthlyAppRatingModel.setTmonRating((float) 1.0);
		monthlyAppRatingModel.setWemapRating((float) 2.4);

		return monthlyAppRatingModel;
	}
}
