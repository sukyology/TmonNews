package kr.co.tmon.socialnews.dao;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;

import kr.co.tmon.socialnews.model.SocialNewsDocument;
import kr.co.tmon.socialnews.util.TypeChangeBetweenDateAndString;

/**
 * 
 * @author yeseul23
 * 
 */
@Repository
public class RemoteGetNewsDAO {
	private static final String BASIC_URL_FOR_GETTING_XML = "http://10.5.220.81:8080/social/news.tmon?date=";
	
	public SocialNewsDocument getSocialNewsDocument() throws MalformedURLException, JAXBException {
		URL url = new URL(generateTodayUrl());
		JAXBContext context = JAXBContext.newInstance(SocialNewsDocument.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (SocialNewsDocument) unmarshaller.unmarshal(url);
	}

	String generateTodayUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(BASIC_URL_FOR_GETTING_XML);
		Date date = new Date(System.currentTimeMillis());
		TypeChangeBetweenDateAndString typeChangeBetweenDateAndString = new TypeChangeBetweenDateAndString();
		stringBuilder.append(typeChangeBetweenDateAndString.exchangeToStringType(date));

		return stringBuilder.toString();
	}
}
