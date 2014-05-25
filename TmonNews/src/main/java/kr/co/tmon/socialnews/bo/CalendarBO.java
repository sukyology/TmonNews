package kr.co.tmon.socialnews.bo;

import java.sql.Date;
import java.util.List;

import kr.co.tmon.socialnews.model.News;

/**
 * 
 * @author 김종환
 *
 */

/*
 * 날짜가 바뀔때 이 조건에 맞는 데이터를 요청하는 BO
 */

public class CalendarBO extends GetNews {
	public List<News> getNewsByChangingDate(Date changedDate) {
		super.setNewsDate(changedDate);
		return getNewsList();
	}
}
