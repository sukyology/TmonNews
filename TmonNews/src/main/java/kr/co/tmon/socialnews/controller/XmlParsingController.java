package kr.co.tmon.socialnews.controller;
/*
 * @author 고영경
 * 
 * */
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;

import kr.co.tmon.socialnews.bo.XmlParsingBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class XmlParsingController {
	@Autowired
	private XmlParsingBO xmlParsingBO;

	@PostConstruct
	@Scheduled(fixedDelay = 10800000)
	public void runXmlParsing() throws MalformedURLException, ParseException, JAXBException {
		xmlParsingBO.insertParsingNewsData();
	}
}