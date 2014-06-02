package kr.co.tmon.socialnews.util;

import java.util.List;

import kr.co.tmon.socialnews.model.News;

/**
 * 
 * @author 김종환
 * 
 *         하나의 기사에 여럿의 소셜회사가 연관될 경우, 이를 다중매핑시키기 위해 CorpCode를 분리하는 클래스
 * 
 */

public class CorpDataConverter {
	private static final String ALTERED_ALL_SOCIAL_CORP_CODE = "티켓몬스터,위메프,쿠팡";
	private static final String CATEGORY_NAME_OF_ALL_SOCIAL_COMMERCE_CORP = "소셜커머스";

	public List<News> divideByCorps(List<News> originalNewsList) {
		List<News> alteredNewsList = originalNewsList;

		for (int index = 0; index < originalNewsList.size(); index++) {
			if (originalNewsList.get(index).getNewsSocialCorpCode().contains(",")) {
				dividingCorpCode(originalNewsList, alteredNewsList, index);
				index--;
			}

			if (originalNewsList.get(index).getNewsSocialCorpCode().compareTo(CATEGORY_NAME_OF_ALL_SOCIAL_COMMERCE_CORP) == 0) {
				originalNewsList.get(index).setNewsSocialCorpCode(ALTERED_ALL_SOCIAL_CORP_CODE);
				alteredNewsList.get(index).setNewsSocialCorpCode(ALTERED_ALL_SOCIAL_CORP_CODE);
				index--;
			}
		}

		return alteredNewsList;
	}

	private void dividingCorpCode(List<News> originalNewsList, List<News> alteredNewsList, int index) {
		String[] dividedCorpCode = originalNewsList.get(index).getNewsSocialCorpCode().split(",");

		for (int indexOfClone = 0; indexOfClone < dividedCorpCode.length; indexOfClone++) {
			News news = cloningNews(originalNewsList.get(index));
			alteredNewsList.add(news);
			alteredNewsList.get(alteredNewsList.size() - 1).setNewsSocialCorpCode(dividedCorpCode[indexOfClone]);
		}

		alteredNewsList.remove(index);
	}

	private News cloningNews(News news) {
		News clonedNews = new News();

		clonedNews.setNewsCount(news.getNewsCount());
		clonedNews.setNewsDate(news.getNewsDate());
		clonedNews.setNewsID(news.getNewsID());
		clonedNews.setNewsImage(news.getNewsImage());
		clonedNews.setNewsLink(news.getNewsLink());
		clonedNews.setNewsPreview(news.getNewsPreview());
		clonedNews.setNewsProvider(news.getNewsProvider());
		clonedNews.setNewsTitle(news.getNewsTitle());

		return clonedNews;
	}
}