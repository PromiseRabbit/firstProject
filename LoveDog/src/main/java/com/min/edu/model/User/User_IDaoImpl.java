package com.min.edu.model.User;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.User_Dto;
@Repository
public class User_IDaoImpl implements User_IDao {
	
	private final String NS = "sarang.hagae.";
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public boolean DeleteUser(String u_id) {
		int n = session.update(NS+"DeleteUser", u_id);
		return (n > 0)? true:false;
	}

	@Override
	public List<User_Dto> SelectAlluser() {
		return session.selectList(NS+"SelectAlluser");
	}

	@Override
	public User_Dto SelectOneuser(String u_id) {
		return session.selectOne(NS+"SelectOneuser",u_id);
	}

	@Override
	public boolean AuthChange(Map<String, String> map) {
		int n =session.update(NS+"AuthChange", map);
		return (n > 0)?true : false;
	}

	@Override
	public boolean UserModify(User_Dto dto) {
		int n = session.update(NS+"UserModify", dto);
		return (n>0)?true:false;
	}

	@Override
	public User_Dto Mypage() {
		return session.selectOne(NS+"Mypage");
	}

}
