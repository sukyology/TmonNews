package kr.co.tmon.social.sample.bo;

import kr.co.tmon.social.sample.dao.HelloSpringDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloSpringBO {
	@Autowired
	private HelloSpringDAO helloSpringDAO;
	
	public String getHelloComment() {
		return helloSpringDAO.selectHelloComment();
	}
}
