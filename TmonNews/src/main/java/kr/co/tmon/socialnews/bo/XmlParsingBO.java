package kr.co.tmon.socialnews.bo;

import java.net.MalformedURLException;
import java.util.List;

import javax.xml.bind.JAXBException;

import kr.co.tmon.socialnews.dao.RemoteGetNewsDAO;
import kr.co.tmon.socialnews.model.ParsedNews;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author yeseul23
 *
 */
public class XmlParsingBO {
	@Autowired
	private RemoteGetNewsDAO remoteGetNewsDAO;
	
	public List<ParsedNews> getRemoteNewsList() throws MalformedURLException, JAXBException{
		return remoteGetNewsDAO.getSocialNewsDocument().getParsedNewsList();
	}
	
	//디비에 넣는dao
}
