package com.min.edu.model.User;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.edu.dto.User_Dto;

@Service
public interface User_IService {

		// 회원 삭제 및 탈퇴
		public boolean DeleteUser(String u_id);
		// 회원 조회(리스트)
		public List<User_Dto> SelectAlluser();
		// 회원 단일 조회
		public User_Dto SelectOneuser(String u_id);
		// 권한 수정
		public boolean AuthChange(Map<String, String> map);
		// 회원 수정
		public boolean UserModify(User_Dto dto);
		// 마이페이지
		public User_Dto Mypage();
}
