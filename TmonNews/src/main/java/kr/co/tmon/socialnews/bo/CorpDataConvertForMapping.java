package kr.co.tmon.socialnews.bo;

import java.util.List;

import kr.co.tmon.socialnews.model.News;

/**
 * 
 * @author 김종환
 * 
 */

/*
 * 하나의 기사에 여럿의 소셜회사가 연관될 경우, 이를 다중매핑시키기 위해 CorpCode를 분리하는 클래스
 */

public class CorpDataConvertForMapping {
	public List<News> divideByCorps(List<News> originalNewsList) {
		List<News> alteredNewsList = originalNewsList;

		for (int index = 0; index < originalNewsList.size(); index++) {
			if (originalNewsList.get(index).getNewsSocialCorpCode().contains(",")) {
				String[] dividedCorpCode = originalNewsList.get(index).getNewsSocialCorpCode().split(",");

				for (int indexOfClone = 0; indexOfClone < dividedCorpCode.length; indexOfClone++) {
					News news = cloningNews(originalNewsList.get(index));
					alteredNewsList.add(news);
					alteredNewsList.get(alteredNewsList.size() - 1).setNewsSocialCorpCode(dividedCorpCode[indexOfClone]);
				}

				alteredNewsList.remove(index);
				index--;
			}
		}

		return alteredNewsList;
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