package kr.co.tmon.socialnews.bo;

import java.util.List;

import kr.co.tmon.socialnews.model.News;

public class ConvertKoreanCorpNameToCode {
	public List<News> exchangNameToCode(List<News> newsList) {
		for (News news : newsList) {
			news.setNewsSocialCorpCode(koreanCorpNameToCode(news.getNewsSocialCorpCode()));
		}
		
		return newsList;
	}

	private String koreanCorpNameToCode(String koreanCorpName) {
		if (koreanCorpName.compareTo("티켓몬스터") == 0)
			return "tm";

		else if (koreanCorpName.compareTo("쿠팡") == 0)
			return "cp";

		else if (koreanCorpName.compareTo("위메프") == 0)
			return "wmp";

		else
			return "etc";
	}
}
