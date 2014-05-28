package kr.co.tmon.socialnews.bo;

import kr.co.tmon.socialnews.dao.NewsCountDAO;

import org.springframework.beans.factory.annotation.Autowired;

public class NewsCountBO {
	private int newsCount;

	@Autowired
	private NewsCountDAO newsCountDAO;

	public void updateNewsCount(int newsId) {
		newsCountDAO.updateNewsCount(newsId);
	}

}
