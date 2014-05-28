package kr.co.tmon.socialnews.bo;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import javax.xml.bind.JAXBException;

import kr.co.tmon.socialnews.dao.LocalInsertNewsDAO;
import kr.co.tmon.socialnews.dao.RemoteGetNewsDAO;
import kr.co.tmon.socialnews.model.News;
import kr.co.tmon.socialnews.model.ParsedNews;
import kr.co.tmon.socialnews.util.NewsModelConvertAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author yeseul23
 * 
 */
@Service
public class XmlParsingBO {
	@Autowired
	private LocalInsertNewsDAO localInsertNewsDAO;
	@Autowired
	private RemoteGetNewsDAO remoteGetNewsDAO;
	
	public void insertParsingNewsData() throws ParseException, MalformedURLException, JAXBException {
		NewsModelConvertAdapter newsModelConvertAdapter = new NewsModelConvertAdapter();
		List<ParsedNews> parsedNewsList = remoteGetNewsDAO.getSocialNewsDocument().getParsedNewsList();
		List<News> newsList = newsModelConvertAdapter.convertToNewsListForDB(parsedNewsList);
		localInsertNewsDAO.insertNews(newsList);
	}
}
