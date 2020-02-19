package com.min.edu.model.Login;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dto.User_Dto;

@Service
public class Login_IServiceImpl implements Login_IService{

	private Logger log = LoggerFactory.getLogger(Login_IServiceImpl.class);
	
	@Autowired
	private Login_IDao dao;
	
	@Override
	@Transactional(readOnly = true)
	public User_Dto loginUser(Map<String, String> map) {
		log.info("*********[loginU] Service 접근 시작 {}*********", map);
		return dao.loginUser(map);
	}


	@Override
	@Transactional
	public boolean duplicateidCheck(String id) {
		log.info("*********[duplicatedidCheck] Service 접근 시작 {}*********", id);
		return dao.duplicateidCheck(id);
	}


	@Override
	@Transactional
	public boolean registUser(Map<String, String> map) {
		log.info("*********[registUser] Service 접근 시작 {}*********\"", map);
		return dao.registUser(map);
	}

}
