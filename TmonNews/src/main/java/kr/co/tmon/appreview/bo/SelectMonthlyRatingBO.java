package kr.co.tmon.appreview.bo;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tmon.appreview.dao.MonthlyAppRatingDAO;
import kr.co.tmon.appreview.model.MonthlyAppRatingModel;
import kr.co.tmon.appreview.util.SubstringForYearPlusMonth;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 김종환
 * 
 */

@Service
public class SelectMonthlyRatingBO {
	@Autowired
	private MonthlyAppRatingDAO monthlyAppRatingDAO;
	@Autowired
	private InsertMonthlyRatingBO insertMonthlyRatingBO;

	public List<MonthlyAppRatingModel> getYearlyReviewRating() throws ParseException {
		SubstringForYearPlusMonth substringForYearPlusMonth = new SubstringForYearPlusMonth();
		List<MonthlyAppRatingModel> yearlyData = new ArrayList<>();

		Date currentDate = new Date(System.currentTimeMillis());

		String currentDateString = substringForYearPlusMonth.substringOfDate(currentDate);
		String comparingString = generateComparingString(currentDate);

		while (true) {
			insertMonthlyRatingBO.insertMonthlyRatings(comparingString);
			yearlyData.add(monthlyAppRatingDAO.selectMonthlyRating(comparingString));

			if (comparingString.compareTo(currentDateString) == 0)
				break;

			comparingString = addAMonth(comparingString);
		}

		return yearlyData;
	}

	private String addAMonth(String comparingString) {
		String[] dividedDateString = comparingString.split("-");
		int[] dividedDateInt = new int[2];
		dividedDateInt[0] = Integer.parseInt(dividedDateString[0]);
		dividedDateInt[1] = Integer.parseInt(dividedDateString[1]);

		if (dividedDateInt[1] == 12) {
			dividedDateInt[0] = dividedDateInt[0] + 1;
			dividedDateInt[1] = 1;
		}

		else
			dividedDateInt[1] = dividedDateInt[1] + 1;

		String date = String.format("%02d", dividedDateInt[1]);
		return dividedDateInt[0] + "-" + date;
	}

	private String generateComparingString(Date currentDate) {
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		String comparingString = typeChangeBetweenDateAndString.exchangeToStringType(currentDate);
		String[] dividedDate = comparingString.split("-");
		int[] dividedDateForInt = new int[2];
		dividedDateForInt[0] = Integer.parseInt(dividedDate[0]);
		dividedDateForInt[1] = Integer.parseInt(dividedDate[1]);
		dividedDateForInt[0] = dividedDateForInt[0] - 1;
		dividedDateForInt[1] = dividedDateForInt[1] + 1;
		String date = String.format("%02d", dividedDateForInt[1]);
		comparingString = dividedDateForInt[0] + "-" + date;
		return comparingString;
	}

	public void setMonthlyAppRatingDAO(MonthlyAppRatingDAO monthlyAppRatingDAO) {
		this.monthlyAppRatingDAO = monthlyAppRatingDAO;
	}

	public void setInsertMonthlyRatingBO(InsertMonthlyRatingBO insertMonthlyRatingBO) {
		this.insertMonthlyRatingBO = insertMonthlyRatingBO;
	}

}
