package kr.co.tmon.socialnews.bo;

import kr.co.tmon.socialnews.dao.NewsCountDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsCountBO {
	@Autowired
	private NewsCountDAO newsCountDAO;

	public void updateNewsCount(int newsId) {
		newsCountDAO.updateNewsCount(newsId);
	}

}
