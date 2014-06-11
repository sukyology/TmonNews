package kr.co.tmon.socialnews.controller;
/**
 * @author 고영경
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.tmon.socialnews.bo.SocialCategoryBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SettingRequestController {
	@Autowired
	private SocialCategoryBO socialCategoryBO;
	
	public HttpServletRequest setRequestSessionAndAttribute(HttpServletRequest request, String socialCorpName){
		makeCorpToSessionAttribute(request, socialCorpName);
		makeTotalPageToAttribute(request);
		return request;
	}
	
	private void makeCorpToSessionAttribute(HttpServletRequest request, String socialCorpName) {
		HttpSession session = request.getSession();
		session.setAttribute("corp", socialCorpName);
	}

	private void makeTotalPageToAttribute(HttpServletRequest request) {
		request.setAttribute("totalPage", socialCategoryBO.getNumberOfNews());
	}

}
