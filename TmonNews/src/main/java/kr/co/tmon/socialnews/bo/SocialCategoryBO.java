package kr.co.tmon.socialnews.bo;

import java.util.List;

import kr.co.tmon.socialnews.dao.GetNewsDAO;
import kr.co.tmon.socialnews.model.News;

/**
 * 
 * @author 김종환
 * 
 */

/*
 * 카데고리와 Date에 맞게 데이터를 Select하기위한 로직이 들어있는 클래스
 */

public class SocialCategoryBO extends GetNewsDAO {
	public List<News> getNewsByCategory(String changedCategoty) {
		super.setSocialCorpCode(changedCategoty);
		return getNewsList();
	}
}
