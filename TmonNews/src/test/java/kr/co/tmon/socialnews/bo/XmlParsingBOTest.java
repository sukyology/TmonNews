package kr.co.tmon.socialnews.bo;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import kr.co.tmon.socialnews.dao.LocalInsertNewsDAO;
import kr.co.tmon.socialnews.dao.RemoteGetNewsDAO;
import kr.co.tmon.socialnews.model.ParsedNews;
import kr.co.tmon.socialnews.model.SocialNewsDocument;
import kr.co.tmon.socialnews.util.NewsModelConvertAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class XmlParsingBOTest {
	@Autowired
	private XmlParsingBO xmlParsingBO;

	@Transactional
	@Test
	public void Xml을_파싱해서_DB에_넣는_작동에_대한_테스트() throws MalformedURLException, JAXBException, ParseException {
		List<ParsedNews> parsedNewsList = new ArrayList<>();
		SocialNewsDocument socialNewsDocument = mock(SocialNewsDocument.class);
		when(socialNewsDocument.getParsedNewsList()).thenReturn(parsedNewsList);

		RemoteGetNewsDAO remoteGetNewsDAO = mock(RemoteGetNewsDAO.class);
		when(remoteGetNewsDAO.getSocialNewsDocument()).thenReturn(socialNewsDocument);

		LocalInsertNewsDAO localInsertNewsDAO = mock(LocalInsertNewsDAO.class);

		xmlParsingBO.setLocalInsertNewsDAO(localInsertNewsDAO);
		xmlParsingBO.setRemoteGetNewsDAO(remoteGetNewsDAO);

		xmlParsingBO.insertParsingNewsData();

		verify(localInsertNewsDAO, times(1));
	}
}
