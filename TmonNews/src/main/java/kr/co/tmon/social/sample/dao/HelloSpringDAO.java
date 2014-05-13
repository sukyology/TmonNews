package kr.co.tmon.social.sample.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloSpringDAO {
	
	public String selectHelloComment() {
		return "하이 안녕. 나 접속함";
	}
}
