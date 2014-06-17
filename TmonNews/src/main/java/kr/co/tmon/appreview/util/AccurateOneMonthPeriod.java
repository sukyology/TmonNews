package kr.co.tmon.appreview.util;

import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

/**
 * 
 * @author 김종환
 *
 */

public class AccurateOneMonthPeriod {
	public Date returnCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	public Date returnOneMonthAgoDate() {
		Calendar calendar = Calendar.getInstance(Locale.KOREA);
		calendar.add(Calendar.MONTH, -1);
		java.util.Date oneMonthAgoDate = calendar.getTime();

		return new java.sql.Date(oneMonthAgoDate.getTime());
	}
}
