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

import com.min.edu.dto.HongBoard_Dto;
import com.min.edu.model.HongBoard.HB_IService;

@Controller
public class HBController {
     // 정보게시판 컨트롤러
	
	private Logger log = LoggerFactory.getLogger(HBController.class);

	@Autowired
	private HB_IService service;
	
	// 게시판 목록
	@RequestMapping(value = "/hongboard.do", method = RequestMethod.GET)
	public String hongBoard(Model model) {
		log.info("병원정보 게시판 hongboard.do", new Date());	
		List<HongBoard_Dto> lists = service.hallBoard();
		model.addAttribute("lists", lists);
	//	log.info("lists {}" , lists);
		return "hongboard";
	}
	
	// 상세보기
	@RequestMapping(value = "/hdetail.do", method = RequestMethod.GET)
	public String hdetail(Model model, String h_regi, String seq) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("h_regi", h_regi);                         
        map.put("seq", seq);
        log.info("map=={}", map);
        log.info("h_regi=={}", h_regi);
        log.info("seq=={}", seq);
        List<HongBoard_Dto> lists = service.hdetailBoard(map);
		log.info("lists=={}", lists);
		model.addAttribute("lists", lists);
		return "hdetail";
	}	

	// 단일 삭제
	@RequestMapping(value = "/hdel.do", method= RequestMethod.GET)
	public String hdelboard(String seq) {
		boolean isc = service.hdelBoard(seq);
		log.info("seq==>={}", seq);
		return isc?"redirect:/hongboard.do":"redirect:/hdetail.do";
	}
	
	
	// 상세보기 -> 답글 폼으로 이동
	@RequestMapping(value = "/hreplyForm.do", method = RequestMethod.GET)
	public String replyB(Model model, String seq, String h_regi) {
		log.info("답글 폼 hreplyForm.do : {}", seq);
		Map<String,String> map = new HashMap<String,String>();
		map.put("h_regi", h_regi);                         
        map.put("seq", seq);
		List<HongBoard_Dto> lists = service.hdetailBoard(map);
		model.addAttribute("lists", lists);
		return "hreplyForm";
	}
	
	// 답글 폼 -> 답글 등록
	@RequestMapping(value = "/hreply.do" , method = RequestMethod.POST)
	public String hreply(HongBoard_Dto dto) {
		log.info("답글 hreply.do : {}", dto);
		boolean isc = service.hreplyBoard(dto);
		return isc?"redirect:/hongboard.do":"redirect:/hreplyForm.do";
		
	}
	
	
	// 상세보기 -> 수정 폼
	@RequestMapping(value = "/hmodifyForm.do", method = RequestMethod.GET)
	public String modifyB(Model model, String seq,String h_regi) {
		log.info("수정 폼 hmodifyForm.do : {}", seq);
		Map<String,String> map = new HashMap<String,String>();
		map.put("h_regi", h_regi);                         
        map.put("seq", seq);
		List<HongBoard_Dto> lists = service.hdetailBoard(map);
		model.addAttribute("lists", lists);
		return "hmodifyForm";
	}
	
	// 수정 폼 -> 수정하기
	@RequestMapping(value = "/hmodify.do", method = RequestMethod.POST)
	public String hmodify(HongBoard_Dto dto) {
		log.info("수정 hmodify.do: {}", dto);
		boolean isc = service.hmodifyBoard(dto);
		return isc?"redirect:/hongboard.do":"redirect:/hmodifyForm.do";
	}
	
	// 전체글 보기 -> 글쓰기 폼
	@RequestMapping(value = "/hwrite.do", method = RequestMethod.GET)
    public String writeB(Model model) {
		  HongBoard_Dto dto = new HongBoard_Dto();
          model.addAttribute("mdto", dto);
          log.info("글작성  dto.do \t {}", dto);
          return "hwrite";
    }
	
	
	// 글쓰기 폼 -> 등록
	@RequestMapping(value = "/hwritef.do", method = RequestMethod.POST)
	public String writeHB(HongBoard_Dto dto, String seq,Model model, HttpSession session) {
		log.info("글작성  Nwrite.do \t {}", dto);
		HongBoard_Dto sdto = (HongBoard_Dto) session.getAttribute("user");
		dto.setU_id(sdto.getU_id());
		boolean isc = service.hinsertBoard(dto);
		return isc?"redirect:/hongboard.do":"redirect:/hwrite.do";

	}
	
	// 다중삭제
	@RequestMapping(value = "/hdelflag.do", method = RequestMethod.POST)
	public String delflag(Model model, String[] chkVal) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seq_", chkVal);
		log.info("map==> \t{}", map);
		boolean isc = service.hdelflagBoard(map);

		return isc?"redirect:/hongboard.do":"redirect:/init.do";
		
	}
	
	
	
}
	
	
	
	






