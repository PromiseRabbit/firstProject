package com.min.edu.model.Login;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.User_Dto;


@Repository
public class Login_IDaoImpl implements Login_IDao {

	private final String NS = "sarang.hagae.";
	
	private Logger log = LoggerFactory.getLogger(Login_IDaoImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public User_Dto loginUser(Map<String, String> map) {
		log.info("*********[loginU] Dao 접근 시작 {}*********");
		return sqlSession.selectOne(NS+"loginUser", map);
	}

	@Override
	public boolean duplicateidCheck(String id) {
		log.info("*********[duplicateidCheck] Dao 접근 시작 {}*********{}",id);
		int cnt = sqlSession.selectOne(NS+"duplicated", id);
		return cnt==1?false:true;
	}

	@Override
	public boolean registUser(Map<String, String> map) {
		log.info("*********[registUser] Dao 접근 시작 {}*********",map);
		int cnt = sqlSession.insert(NS+"registUser", map);
		return cnt>0?true:false;
	}


}
