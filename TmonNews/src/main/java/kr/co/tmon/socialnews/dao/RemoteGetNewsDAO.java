package kr.co.tmon.socialnews.dao;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;

import kr.co.tmon.socialnews.model.SocialNewsDocument;
/**
 * 
 * @author yeseul23
 *
 */
@Repository
public class RemoteGetNewsDAO {
	private SocialNewsDocument socialNewsDocument;

	public SocialNewsDocument getSocialNewsDocument() throws MalformedURLException, JAXBException {
		URL url = new URL("http://10.5.220.81:8080/social/news.xml");
		JAXBContext context = JAXBContext.newInstance(SocialNewsDocument.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		socialNewsDocument = (SocialNewsDocument) unmarshaller.unmarshal(url);

		return socialNewsDocument;
	}
}
