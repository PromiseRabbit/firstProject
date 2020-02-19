package com.min.edu.ctrl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.dto.User_Dto;
import com.min.edu.model.User.User_IService;

@Controller
public class UserController {
	//유저관련 Controller
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private User_IService service;
	
	@RequestMapping(value = "/Mypage.do", method = RequestMethod.GET)
	public String Mypage() {
		log.info("Mypage 마이페이지 이동", new Date());
		return "Mypage";
	}
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String UserList(Model model) {
		log.info("UserList 회원 전체 조회 페이지 이동", new Date());
		List<User_Dto> lists = service.SelectAlluser();
		model.addAttribute("lists", lists);
		return "UserList";
	}
	@RequestMapping(value = "/mainOne.do", method = RequestMethod.GET)
	public String UserOneList(Model model, String u_id) {
		User_Dto dto = service.SelectOneuser(u_id);
		log.info("UserOneList 회원 상세 조회 페이지 이동 \t {}", dto);
		model.addAttribute("dto", dto);
		return "UserOneList";
	}
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String delete(HttpSession session) {
		log.info("delete 회원 삭제 / 탈퇴", new Date());
		User_Dto dto = (User_Dto) session.getAttribute("Dto");
		log.info("delete 회원 삭제 / 탈퇴 {}", dto);
		boolean isc = service.DeleteUser(dto.getU_id());
		return isc?"redirect:/index.do":"redirect:/delete.do";
	}
	@RequestMapping(value = "/modifyUser.do", method = RequestMethod.POST)
	public String modifyUser(HttpSession session, User_Dto dto) {
		log.info("modifyUser 회원 수정 완료", new Date());
		User_Dto mdto = (User_Dto) session.getAttribute("LDto");
		dto.setU_id(mdto.getU_id());
		boolean isc = service.UserModify(dto);
		return isc? "redirect:/mainOne.do":"redirect:/modifyUser.do?u_id="+dto.getU_id();
	}
	@RequestMapping(value = "/modifyUserForm.do", method = RequestMethod.GET)
	public String modifyUserForm(HttpSession session) {
		log.info("modifyUserForm 회원 수정 페이지 이동", new Date());
		return "HospiList";
	}
}