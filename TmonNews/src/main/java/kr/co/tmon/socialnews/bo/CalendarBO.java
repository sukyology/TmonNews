package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

public class CalendarBO extends GetNews {
	public List<News> getNewsByChangingDate(Date changedDate) {
		super.setNewsDate(changedDate);
		return getNewsList();
	}
}
