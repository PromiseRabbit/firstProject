package com.min.edu.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.User_Dto;
@Service
public class User_IServiceImpl implements User_IService {

	Logger log = LoggerFactory.getLogger(User_IServiceImpl.class);
	
	@Autowired
	private User_IDao dao;
	
	@Override
	public boolean DeleteUser(String u_id) {
		log.info("DeleteUser 회원 삭제 및 탈퇴 \t {}", u_id);
		return dao.DeleteUser(u_id);
	}

	@Override
	public List<User_Dto> SelectAlluser() {
		log.info("SelectAlluser 회원 전체 리스트 출력 \t {}", new Date());
		return dao.SelectAlluser();
	}

	@Override
	public User_Dto SelectOneuser(String u_id) {
		log.info("SelectOneuser 회원 단일 정보 조회 \t {}", u_id);
		return dao.SelectOneuser(u_id);
	}

	@Override
	public boolean AuthChange(Map<String, String> map) {
		log.info("AuthChange 회원 권한 수정 \t {}", map);
		return dao.AuthChange(map);
	}

	@Override
	public boolean UserModify(User_Dto dto) {
		log.info("UserModify 회원 정보 수정 \t {}", dto);
		return dao.UserModify(dto);
	}

	@Override
	public User_Dto Mypage() {
		log.info("Mypage 회원 마이페이지 \t {}", new Date());
		return dao.Mypage();
	}


}
